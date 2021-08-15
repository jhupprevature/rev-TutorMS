export class Course {
    name: string;
    subject: string;
    level: number;
    hours: number;

  
    constructor(name: string, subject: string, level: number, hours: number){
      this.name = name;
      this.subject = subject;
      this.level = level;
      this.hours = hours;
  
    }
  }