import { Course } from "./Course";
import { User } from "./User";

// export class Session {
//   userId: number;
//   studentId: number;
//   courseId: number;
//   startTime: number;
//   endTime: number;
//   studentNotes: string;
//   tutorNotes: string;

//   constructor(userId: number, studentId: number, courseId: number, startTime: number, endTime: number, studentNotes: string, tutorNotes: string){
//     this.userId = userId;
//     this.studentId = studentId;
//     this.courseId = courseId;
//     this.startTime = startTime;
//     this.endTime = endTime;
//     this.studentNotes = studentNotes;
//     this.tutorNotes = tutorNotes;

//   }
// }

export class Session {
  id: number;
  tutor: User;
  student: User;
  course: Course;
  startTime: number;
  endTime: number;
  studentNotes: string;
  tutorNotes: string;

  /**
   * include a tutor: User or tutorID: number
   * include a student: User or studentID: number
   * include a course: Course or courseID: number
   */
  constructor(options: {startTime: number, endTime: number, id?: number, 
          tutorID?: number, studentID?: number, courseID?: number,
          tutor?: User, student?: User, course?: Course,
          studentNotes?: string, tutorNotes?: string}) {
    this.id = options.id || -1;
    this.tutor = options.tutor || new User({id:options.tutorID});
    this.student = options.student || new User({id:options.studentID});
    this.course = options.course || new Course({id:options.courseID});
    this.startTime = options.startTime;
    this.endTime = options.endTime;
    this.studentNotes = options.studentNotes || '';
    this.tutorNotes = options.tutorNotes || '';
  }
}