import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hours-summary',
  templateUrl: './hours-summary.component.html',
  styleUrls: ['./hours-summary.component.css']
})
export class HoursSummaryComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.displayHours();
  }

  fakeHoursList: Array<any> = [
    { "day": "Sunday", "inTime": "---", "outTime": "---"},
    { "day": "Monday", "inTime": "10:00 AM", "outTime": "6:00 PM"},
    { "day": "Tuesday", "inTime": "10:00 AM", "outTime": "6:00 PM"},
    { "day": "Wednesday", "inTime": "10:00 AM", "outTime": "6:00 PM"},
    { "day": "Thursday", "inTime": "10:00 AM", "outTime": "6:00 PM"},
    { "day": "Friday", "inTime": "10:00 AM", "outTime": "6:00 PM"},
    { "day": "Saturday", "inTime": "---", "outTime": "---"}
  ]

  displayHours() {
    this.fakeHoursList.forEach(
      function (value) {
        console.log(value.day, "In:", value.inTime, "Out:", value.outTime);
      }
    )
  }
}
