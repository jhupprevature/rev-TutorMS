import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CalendarOptions } from '@fullcalendar/angular';
import { HttpClient, HttpHeaders } from '@angular/common/http';
declare let $: any;


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private http: HttpClient){}

  dateEvent = ["title", "date"];

  //addTutor(dateEvent: dateEvent): Observable<dateEvent> {
   // return this.http.post('http://localhost:8080/dateEvents', myFormData, { headers: new HttpHeaders({'Content-Type': 'application/json'}) }).subscribe((data: Object) => { this.events = data; $("#myModal").modal("hide");});
  //}

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
    var myFormData = new FormData();

    myFormData.append('title', this.addEventForm.value.title);
    myFormData.append('startdate', this.eventdate);

  }
}

  title = 'TutorMS-NG';
  events = [];
  calendarOptions!: CalendarOptions;
  ngOnInit() {

<<<<<<< HEAD
    //this was a return?
    this.http.get('http://localhost:4200/events').subscribe(
      data => { this.events.push();}); //data passed to push


=======
>>>>>>> origin/main
    this.calendarOptions = {
    initialView: 'dayGridMonth',

    headerToolbar:{
      left:'prev,next today',
      center: 'title',
      right: 'dayGridMonth,dayGridWeek,dayGridDay'
    },
    dayMaxEvents: true,

    dateClick: this.handleDateClick.bind(this), // bind is important!
    events: [
      this.events,
      { title: 'event 1', date: '2021-08-01' },
      { title: 'event 2', date: '2021-08-02' },
    ]
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
  if($("#myModal").modal("show")){
    $('.modal-backdrop').remove();
  }
  }
}