import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  /** Based on the screen size, switch from standard to one column per row */
  
  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title: 'Upcoming Schedule', cols: 1, rows: 1 },
          { title: 'Total Hours', cols: 1, rows: 1 },
          { title: 'Edit Profile', cols: 1, rows: 1 },
          { title: 'Add/Delete Hours', cols: 1, rows: 1 }
        ];
      }

      return [
        { title: 'Upcoming Schedule', cols: 2, rows: 1 },
        { title: 'Total Hours', cols: 1, rows: 1 },
        { title: 'Edit Profile', cols: 1, rows: 2 },
        { title: 'Add/Delete Hours', cols: 1, rows: 1 }
      ];
    })
  );

  constructor(private breakpointObserver: BreakpointObserver) {}

  ngOnInit(): void {
    // this.displayHours();
    this.fakeIn.setHours(10);
    this.fakeOut.setHours(18);
    // console.log("in:", this.fakeIn);
    // console.log("out:", this.fakeOut);
    // console.log("elapsed:", this.fakeOut.getHours() - this.fakeIn.getHours());
  }


 // dashboard.component.js






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
  public hours: any[] = [{
    hours: '',
    day: ''
  
  }];

  addHours() {
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
  }
  // var textTime = new Date(sunriseMills + offsetCityMills + offsetDeviceMills).toLocaleTimeString('en-US', { hour: 'numeric', minute: 'numeric' });

  // displayHours() {
  //   this.fakeHoursList.forEach(
  //     function (value) {
  //       console.log(value.day, "In:", value.inTime, "Out:", value.outTime);
  //     }
  //   )
  // }
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



}
