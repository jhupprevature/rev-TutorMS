export class Course {
    id: number;
    name: string;
    subject: string;
    level: number;
    hours: number;

     
    constructor(options?:{id?: number, name?: string, subject?: string, 
      level?: number, hours?: number}){
      this.id = options!.id || -1;
      this.name = options!.name || '';
      this.subject = options!.subject || '';
      this.level = options!.level || -1;
      this.hours = options!.hours || -1;
  
    }
  }