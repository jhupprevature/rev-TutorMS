export class SessionIDs {
    id: number;
    tutorId: number;
    studentId: number;
    courseId: number;
    startTime: number;
    endTime: number;
    studentNotes: string;
    tutorNotes: string;
  
    constructor(id: number, tutorId: number, studentId: number,courseId: number, startTime: number, endTime: number, studentNotes: string, tutorNotes: string){
      this.id = id;
      this.tutorId = tutorId;
      this.studentId = studentId;
      this.courseId = courseId
      this.startTime = startTime;
      this.endTime = endTime;
      this.studentNotes = studentNotes;
      this.tutorNotes = tutorNotes;
    }
}