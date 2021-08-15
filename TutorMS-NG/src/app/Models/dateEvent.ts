export class dateEvent {
    id: number;
    title: string;
    start: string;
    color: string;
  
    constructor(id: number, title: string, start: string, color: string){
      this.id = id;
      this.title = title;
      this.start = start;
      this.color = color;
    }
  }