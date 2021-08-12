import { AriaDescriber } from '@angular/cdk/a11y';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CalendarOptions } from '@fullcalendar/angular';
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

  clickedDate: any
  dateEvents: dateEvent[] = [];

  addEventForm!: FormGroup;
  submitted = false;

  //Add user form actions
  get f() { return this.addEventForm.controls; }

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

    this.displayAlldateEvents();

    this.calendarOptions = {
    initialView: 'dayGridMonth',

    headerToolbar:{
      left:'prev,next today',
      center: 'title',
      right: 'dayGridMonth,dayGridWeek,dayGridDay'
    },
    dayMaxEvents: true,

    dateClick: this.handleDateClick.bind(this), // bind is important!
    events: this.dateEvents
    
  };

    this.addEventForm = this.formBuilder.group({
    title: ['', [Validators.required]]
    });
  }

  handleDateClick(arg: { dateStr: string; }) { 
    //Show Modal with Form on dayClick  Event
  $("#myModal").modal("show");
  $(".modal-title, .eventstarttitle").text("");
  $(".modal-title").text("Add Event at : "+arg.dateStr);
  $(".eventstarttitle").text(arg.dateStr);
  $('.modal-backdrop').remove();

  this.clickedDate = arg.dateStr;
  }

  displayAlldateEvents(){
    this.dateEventData.getAllDateEvent().subscribe(
      (response) => {
        console.log(response);
        this.dateEvents = response;
      }
    );
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