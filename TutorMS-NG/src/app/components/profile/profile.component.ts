import { isNull } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { workedHours, tutorUser, studentUser } from 'src/app/Models/test-data';
import { User } from 'src/app/Models/User';
import { LoginService } from 'src/app/Services/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  workedHours: any[];
  user: User;
  schedule : Workday[];


  constructor(private loginServ: LoginService) {
    this.workedHours = workedHours;
    // this.user = tutorUser;
    this.schedule = this.formatSchedule();

    this.user = loginServ.currentUser;
   }

  ngOnInit(): void {
    // console.log("initialising...");
  }

  formatSchedule() : Array<Workday> {
    let raw_sched = {
      id: 42,
      sunday_start:   null,
      sunday_end:     null,
      monday_start:   '10:00',
      monday_end:     '18:00',
      tuesday_start:  '10:00',
      tuesday_end:    '18:00',
      wednesday_start:'10:00',
      wednesday_end:  '18:00',
      thursday_start: '10:00',
      thursday_end:   '18:00',
      friday_start:   '10:00',
      friday_end:     '18:00',
      saturday_start: null,
      saturday_end:   null,
      pending_approval_since: null
    };

    //TODO: Control for pending approvals. Planned goal.
    // if (!raw_sched.pending_approval_since) return [];

    let days = [
      "Sun", 
      "Mon", 
      "Tues",
      "Wed", 
      "Thur",
      "Fri", 
      "Sat"
    ];

    let sched_arr = Object.entries(raw_sched);
    // console.log(sched_arr);
    let sched : Workday[] = [];

    for (let i = 1; i < sched_arr.length-1; i += 2) {
      sched.push(new Workday(days[Math.floor(i/2)], 
                        sched_arr[i][1], 
                        sched_arr[i+1][1]));
      // console.log(Math.floor(i/2));
      // console.log("day=",days[i]);
      // console.log("entry=",sched_arr[i]);
      // console.log("start=",sched_arr[i][1]);      
      // console.log("end=",sched_arr[i+1][1]);      
    }

    return sched;
  }
}

class Workday {
  day: string;
  inTime : any;
  outTime : any;

  constructor(d : string, i : any, o : any) {
    this.day = d;
    this.inTime = i;
    this.outTime = o;
  }
}
