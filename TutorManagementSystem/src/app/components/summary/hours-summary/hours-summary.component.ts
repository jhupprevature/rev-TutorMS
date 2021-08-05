import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hours-summary',
  templateUrl: './hours-summary.component.html',
  styleUrls: ['./hours-summary.component.css']
})
export class HoursSummaryComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    // this.displayHours();
    this.fakeIn.setHours(10);
    this.fakeOut.setHours(18);
    console.log("in:", this.fakeIn);
    console.log("out:", this.fakeOut);
    console.log("elapsed:", this.fakeOut.getHours() - this.fakeIn.getHours());
  }

  fakeIn : Date = new Date(0);
  
  fakeOut : Date = new Date(0);

  fakeHoursList: Array<any> = [
    { "day": "Sunday",    "inTime": "---",              "outTime": "---"},
    { "day": "Monday",    "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Tuesday",   "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Wednesday", "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Thursday",  "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Friday",    "inTime": this.fakeIn, "outTime": this.fakeOut},
    { "day": "Saturday",  "inTime": "---",              "outTime": "---"}
  ]

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
