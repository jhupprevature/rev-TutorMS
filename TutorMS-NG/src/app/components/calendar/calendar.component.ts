import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CalendarOptions } from '@fullcalendar/angular';
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

  colorChoice: string = '';
  checkbox: any;
  updateDate: any;
  clickedDate: any;
  dateEvents: dateEvent[] = [];
  addEventForm!: FormGroup;
  submitted = false;
  title = '';

  //Add user form actions
  get f() { return this.addEventForm.controls; }

hideForm(){
  this.title = '';
  this.addEventForm.get('title')!.clearValidators();
  this.addEventForm.get('title')!.updateValueAndValidity();
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

  ngOnInit() {

    this.formingCalender();

  }

  events = [];
  calendarOptions!: CalendarOptions;
  
  formingCalender(){
    this.calendarOptions = {
      plugins: [ interactionPlugin, dayGridPlugin ],
      initialView: 'dayGridMonth',
  
        editable: true,
        eventResizableFromStart: true,
        droppable: true,
        eventClick: this.deleteEvent.bind(this),
        eventDrop: this.updateDateEvent.bind(this),
        dateClick: this.handleDateClick.bind(this), // bind is important!
        displayEventTime: false,

      headerToolbar:{
        left:'prev,next today',
        center: 'title',
        right: 'dayGridMonth,dayGridWeek,dayGridDay'
      },
      dayMaxEvents: true,
  
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
    this.dateEventData.addDateEvent(new dateEvent( 0,this.addEventForm.value.title, this.clickedDate, this.colorChoice)).subscribe(
      (data) => {
        console.log(data);
        this.dateEvents.push(data);
      },
      (data) => {
        console.log(data);
        console.log("Failed to add date event.");
      });

    }

    updateDateEvent(info: any){
      const newDate = {id: info.event.id, title: info.event.title, start: info.event.startStr, color: info.event.backgroundColor}
      this.dateEventData.updateDateEvent(newDate).subscribe();
    }

    deleteEvent(info:any){
      if(this.checkbox){
        console.log('Success');
        let dateId = info.event.id;
        this.dateEventData.deleteDateEvent(dateId).subscribe();
      }else{
        console.log("checkbox not checked!");
        console.log(this.checkbox);
      }

    }

    checkingDeleteButton($event: any){
      if($event.srcElement.checked){
        this.checkbox = true;
      }else{
        this.checkbox = false;
    }
  }
}