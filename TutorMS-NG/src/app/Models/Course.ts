export class Course {
    id: number;
    name: string;
    subject: string;
    level: number;
    hours: number;

  
    constructor(id: number, name: string, subject: string, level: number, hours: number){
      this.id = id;
      this.name = name;
      this.subject = subject;
      this.level = level;
      this.hours = hours;
  
    }
  }