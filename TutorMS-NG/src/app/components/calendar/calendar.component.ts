import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CalendarOptions } from '@fullcalendar/angular';
import { FormsModule } from '@angular/forms';
import dayGridPlugin from '@fullcalendar/daygrid'; 
import interactionPlugin from '@fullcalendar/interaction'; 
import { dateEvent } from 'src/app/Models/dateEvent';
import { DateEventsService } from 'src/app/Services/date-events.service';
declare let $: any;


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private dateEventData:DateEventsService){}

  deleteTitle: string = '';

  clickedDate: any;

  dateEvents: dateEvent[] = [];

  addEventForm!: FormGroup;
  submitted = false;

  //Add user form actions
  get f() { return this.addEventForm.controls; }

onDelete(){
  console.log(this.deleteTitle);
  this.dateEventData.deleteDateEvent(this.deleteTitle).subscribe();

}

hideForm(){
  this.addEventForm.patchValue({ title : ""});
  $("#myModal").modal("hide");
}

 onSubmit(this: any) {
  
  this.submitted = true;

  // stop here if form is invalid and reset the validations
  this.addEventForm.get('title').setValidators([Validators.required]);
  this.addEventForm.get('title').updateValueAndValidity();
  if (this.addEventForm.invalid) {
      return;
  }

  if(this.submitted){

    this.addDateEvent();

  }
}

  title = '';
  events = [];
  calendarOptions!: CalendarOptions;
  ngOnInit() {

    this.calendarOptions = {
    plugins: [ interactionPlugin, dayGridPlugin ],
    initialView: 'dayGridMonth',

      editable: true,
      eventResizableFromStart: true,

    headerToolbar:{
      left:'prev,next today',
      center: 'title',
      right: 'dayGridMonth,dayGridWeek,dayGridDay'
    },
    dayMaxEvents: true,

    dateClick: this.handleDateClick.bind(this), // bind is important!

    eventSources: [{url: "http://localhost:8080/dateEvents"}],
    
  };

    this.addEventForm = this.formBuilder.group({
    title: ['', [Validators.required]]
    });

  }

  handleDateClick(arg: { dateStr: string;}) { 
    //Show Modal with Form on dayClick  Event
  $("#myModal").modal("show");
  $(".modal-title, .eventstarttitle").text("");
  $(".modal-title").text("Add Event at : "+arg.dateStr);
  $(".eventstarttitle").text(arg.dateStr);
  $('.modal-backdrop').hide();

  this.clickedDate = arg.dateStr;
  }
  
  addDateEvent(){
    this.dateEventData.addDateEvent(new dateEvent(this.addEventForm.value.title, this.clickedDate)).subscribe(
      (data) => {
        console.log(data);
        this.dateEvents.push(data);
      },
      (data) => {
        console.log(data);
        console.log("Failed to add date event.");
      });

    }
  }