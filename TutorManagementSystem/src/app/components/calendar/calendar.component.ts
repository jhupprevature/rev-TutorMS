import { Component, OnInit } from '@angular/core';
import { CalendarOptions, constrainPoint } from '@fullcalendar/angular';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  private fieldArray: Array<any> = [];
  newAttribute: any = {};

  constructor() { }

  ngOnInit(): void {
  }

  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',

    headerToolbar:{
      left:'prev,next today',
      center: 'title',
      right: 'dayGridMonth,dayGridWeek,dayGridDay'
    },
    dayMaxEvents: true,

    dateClick: this.handleDateClick.bind(this), // bind is important!
    events: [
      { title: 'event 1', date: '2021-08-01' },
      { title: 'event 2', date: '2021-08-02' },
      Array(this.fieldArray)
    ]
  };

  handleDateClick(arg: { dateStr: string; }) {
    alert('date click! ' + arg.dateStr)
  }

  addFieldValue() {
      this.fieldArray.push(this.newAttribute)
      this.newAttribute = {};
      console.log(this.fieldArray)
  }

  deleteFieldValue(index: number) {
      this.fieldArray.splice(index, 1);
  }

}

