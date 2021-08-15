import { Course } from "../Models/Course";
import { Tutor } from "../Models/tutor";
import { User } from "../Models/User";

export class Session {
    id: number;
    tutor: Tutor;
    student: User;
    course: Course;
    startTime: number;
    endTime: number;
    studentNotes: string;
    tutorNotes: string;
  
    constructor(id: number, tutor: Tutor, student: User,course: Course, startTime: number, endTime: number, studentNotes: string, tutorNotes: string){
      this.id = id;
      this.tutor = tutor;
      this.student = student;
      this.course = course
      this.startTime = startTime;
      this.endTime = endTime;
      this.studentNotes = studentNotes;
      this.tutorNotes = tutorNotes;
    }
}