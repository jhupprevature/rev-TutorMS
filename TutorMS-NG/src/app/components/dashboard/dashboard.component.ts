 // dashboard.component.js
 import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { FormControl } from '@angular/forms';
import { FormArray } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { LoginService } from 'src/app/Services/login.service';
import { Session } from 'src/app/Models/session';
import { SessionService } from 'src/app/Services/session.service';
import { SessionIDs } from 'src/app/Models/SessionIDs';
import { User } from 'src/app/Models/User';
import { UserUpdate } from 'src/app/Models/UserUpdate';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})


export class DashboardComponent implements OnInit {
  /** Based on the screen size, switch from standard to one column per row */
  hours = new FormControl('');
  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title: 'Sessions', cols: 1, rows: 1 },
          { title: 'My Schedule', cols: 1, rows: 1 },
          { title: 'Edit Profile', cols: 1, rows: 1 },
          // { title: 'Add/Delete Hours', cols: 1, rows: 1 }
        ];
      }

      return [
        { title: 'Sessions', cols: 2, rows: 1 },
        { title: 'My Schedule', cols: 1, rows: 1 },
        { title: 'Edit Profile', cols: 1, rows: 1 },
        // { title: 'Add/Delete Hours', cols: 1, rows: 1 }
      ];
    })
  );


  updateHoursForm = this.fb.group({
    ID: ['', Validators.required],
    change: this.fb.group({
      day: [''],
      numberofhours: [''],
    }),

   
    
  });

  user: User;

  updateFirstName!: string;
  updateLastName!: string;
  updateEmail!: string;
  
  constructor(private breakpointObserver: BreakpointObserver,private fb: FormBuilder, private sessionServ: SessionService, private loginServ: LoginService) {
    this.user = this.loginServ.currentUser;
    this.updateFirstName = this.user.firstName;
    this.updateLastName = this.user.lastName!;
    this.updateEmail = this.user.schoolEmail
  }

  updateHours() {
    this.updateHoursForm.patchValue({
      ID: '23244',
      change: {
        day: 'Monday',
      numberofhours: '20'
        
      }
    });
  }

  profileForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: [''],
    address: this.fb.group({
      street: [''],
      city: [''],
      state: [''],
      zip: ['']
    }),
    aliases: this.fb.array([
      this.fb.control('')
    ])
  });

  get aliases() {
    return this.profileForm.get('aliases') as FormArray;
  }

  updateProfile() {
    this.profileForm.patchValue({
      firstName: 'Nancy',
      address: {
        street: '123 Drew Street'
      }
    });
  }

  addAlias() {
    this.aliases.push(this.fb.control(''));
  }

  onSubmit1() {
    // TODO: Use EventEmitter with form value
    console.warn(this.profileForm.value);
  }

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.updateHoursForm.value);
  }
  ngOnInit(): void {
    // this.displayHours();
    this.fakeIn.setHours(10);
    this.fakeOut.setHours(18);
    // console.log("in:", this.fakeIn);
    // console.log("out:", this.fakeOut);
    // console.log("elapsed:", this.fakeOut.getHours() - this.fakeIn.getHours());
    this.getSessions();
  }
 



  fakeIn : Date = new Date(0);
  
  fakeOut : Date = new Date(0);

  fakeHoursList: Array<any> = [
    { "day": "Sunday",    "inTime": "---",       "outTime": "---"},
    { "day": "Monday",    "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Tuesday",   "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Wednesday", "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Thursday",  "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Friday",    "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Saturday",  "inTime": "---",       "outTime": "---"}
  ]

 
Schedule : Array<any> = [
    { "day": "Sunday"},
    { "day": "Monday"},
    { "day": "Tuesday" },
    { "day": "Wednesday" },
    { "day": "Thursday" },
    { "day": "Friday"},
    { "day": "Saturday"}
  ]



 
  formatHours(time: Date) : string {
    time = new Date(time);
    if (isNaN(time.getTime())) {
      return "--:--";
    }

    let hh : number = time.getHours();
    let mm : number = time.getMinutes();

    // console.log(time.getDay);
    return `${hh}:${mm}`;
  }

  subtractHours(workday : any) : Date {
    let start = new Date(workday.inTime);
    let end = new Date(workday.outTime);

    let elapsedHours = end.getHours() - start.getHours();
    let elapsedMinutes = end.getMinutes() - start.getMinutes();

    let result = new Date(0);
    result.setHours(elapsedHours);
    result.setMinutes(elapsedMinutes);
    return result;
  }
/*  public hours: any[] = [{
    hours: '',
    day: ''
  
  }];
 */
/*   addHours() {
    this.hours.push({
      id: this.hours.length + 1,
      hours: '',
      day: ''
    });
  }

  removeHours(i: number) {
    this.hours.splice(i, 1);
  }


  logValue() {
    console.log(this.hours);
  } */
  // var textTime = new Date(sunriseMills + offsetCityMills + offsetDeviceMills).toLocaleTimeString('en-US', { hour: 'numeric', minute: 'numeric' });

 displayHours() {
 this.fakeHoursList.forEach(
  function (value) {
  //   console.log(value.day, "In:", value.inTime, "Out:", value.outTime);
     }
    )
  } 

  sessionList: Array<SessionIDs> = [];

  getSessions() {
    this.sessionServ.getUserSessions().subscribe (
      (response) => {
        this.sessionList = response;
        console.log(this.sessionList);
        return true;
      }
    )
  }

  showSession() {
    if (this.sessionList == []) {
      return false
    } else return true;
  }

  

  updatedUser?: UserUpdate;

  updateComplete: boolean = false;


  updateAccount() {
    this.updatedUser = new UserUpdate(this.user.id.toString(), this.updateFirstName, this.updateLastName, this.updateEmail);

    console.log(this.updatedUser);
    this.loginServ.updateUser(this.updatedUser).subscribe(
      (response) => {
        this.loginServ.currentUser = response;
        this.updateComplete = true;
      }
    )

  }

}
