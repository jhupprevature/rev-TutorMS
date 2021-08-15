export class SessionIDs {
    tutorId: number;
    studentId: number;
    courseId: number;
    startTime: number;
    endTime: number;
    studentNotes: string;
    tutorNotes: string;
  
    constructor(tutorId: number, studentId: number,courseId: number, startTime: number, endTime: number, studentNotes: string, tutorNotes: string){
      this.tutorId = tutorId;
      this.studentId = studentId;
      this.courseId = courseId
      this.startTime = startTime;
      this.endTime = endTime;
      this.studentNotes = studentNotes;
      this.tutorNotes = tutorNotes;
    }
}