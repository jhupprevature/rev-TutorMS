export class Session {
    id: number;
    studentId: number;
    courseId: number;
    startTime: number;
    endTime: number;
    studentNotes: string;
    tutorNotes: string;
  
    constructor(userId: number, studentId: number, courseId: number, startTime: number, endTime: number, studentNotes: string, tutorNotes: string){
      this.id = userId;
      this.studentId = studentId;
      this.courseId = courseId;
      this.startTime = startTime;
      this.endTime = endTime;
      this.studentNotes = studentNotes;
      this.tutorNotes = tutorNotes;
  
    }
  }