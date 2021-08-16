import { HttpClient } from '@angular/common/http';
import { Component, OnChanges, OnInit } from '@angular/core';
import { Session } from 'src/app/models/Session';
import { Observable } from 'rxjs';
import { SessionService } from 'src/app/services/session.service';
import { User } from 'src/app/models/User'

@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.css']
})
export class AnalyticsComponent implements OnInit, OnChanges {
  showingTutorDemand: boolean = false;
  showingCourseDemand: boolean = false;
  showingStudentVisits: boolean = false;
  tutorDemand!: any;
  courseDemand!: any;
  studentVisits!: any;

  constructor(private sessServ: SessionService) { 
    sessServ.getAnalytics().subscribe(
      (response) => {
        console.log(response);

        this.tutorDemand = response.tutorDemand;
        this.courseDemand = response.courseDemand;
        this.studentVisits = response.studentVisits;
      }
    );
  }

  ngOnInit() {}

  ngOnChanges() {}

  showTutorDemand() {
    this.showingTutorDemand  = true;
    this.showingCourseDemand = false;
    this.showingStudentVisits   = false;

    //sort sessions for tutor demand.
    console.log("showing tutor demand...");
    // let tutorDemand = new Map<string,number>();

    // for (let sess of this.sessions) {
    //   let tutor = sess.tutor;

    //   console.log(tutorDemand.has(tutor.schoolEmail));
    //   console.log(tutor.schoolEmail);
    //   console.log(tutorDemand.keys());

    //   let demand = tutorDemand.get(tutor.schoolEmail);
    //   if (demand !== undefined) {
    //     demand+=1;
    //     tutorDemand.set(tutor.schoolEmail,demand);
    //   } else {
    //     tutorDemand.set(tutor.schoolEmail,1);
    //   }
    // }
    
    // console.log(tutorDemand);
    // this.analysis = tutorDemand;
  }

  showCourseDemand() {
    this.showingTutorDemand   = false;
    this.showingCourseDemand  = true;
    this.showingStudentVisits = false;

  }

  showStudentVisits() {
    this.showingTutorDemand   = false;
    this.showingCourseDemand  = false;
    this.showingStudentVisits = true;
  }
}
