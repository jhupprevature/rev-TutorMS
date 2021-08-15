import { isNull } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { tutorUser, studentUser } from 'src/app/models/test-data';
import { User } from 'src/app/models/User';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User;
  schedule : Workday[];


  constructor(private loginServ: LoginService) {
    // this.user = tutorUser;
    // this.schedule = this.formatSchedule();

    this.user = loginServ.currentUser;
    this.schedule = this.formatSchedule(loginServ.currentUser.schedule);
   }

  ngOnInit(): void {
    // console.log("initialising...");
  }

  formatSchedule(raw_sched: any) : Array<Workday> {
    // let raw_sched = {
    //   id: 42,
    //   sunday_start:   null,
    //   sunday_end:     null,
    //   monday_start:   '10:00',
    //   monday_end:     '18:00',
    //   tuesday_start:  '10:00',
    //   tuesday_end:    '18:00',
    //   wednesday_start:'10:00',
    //   wednesday_end:  '18:00',
    //   thursday_start: '10:00',
    //   thursday_end:   '18:00',
    //   friday_start:   '10:00',
    //   friday_end:     '18:00',
    //   saturday_start: null,
    //   saturday_end:   null,
    //   pending_approval_since: null
    // };

    //TODO: Control for pending approvals. Planned goal.
    // if (!raw_sched.pending_approval_since) return [];

    let days = [ "Sun", "Mon", "Tues",
      "Wed", "Thur", "Fri", "Sat" ];

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

  isEmployee() : boolean {
    // console.log("Verifying is employee...");
    let accType = this.user.accountType.type;
    
    let employeeTypes = ["Tutor", "Tutor Manager"];
    // console.log(employeeTypes.indexOf(this.user.accountType.type) > -1);
    if (employeeTypes.indexOf(accType) > -1) {
      return true;
    } else return false;
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


