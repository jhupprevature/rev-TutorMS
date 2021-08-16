import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Session } from 'src/app/models/Session';
import { Observable } from 'rxjs';
import { SessionService } from 'src/app/services/session.service';
import { User } from 'src/app/models/User'

@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.css']
})
export class AnalyticsComponent {
  sessions!: Session[];
  showingTutorDemand: boolean = false;
  showingCourseDemand: boolean = false;
  showingStudentVisits: boolean = false;
  analysis!: Map<string, number>;

  constructor(private sessServ: SessionService) { 
    sessServ.getAllSessions().subscribe(
      (response: Session[]) => {
        this.sessions = response;
        console.log(response);
      }
    );
  }

  showTutorDemand() {
    this.showingTutorDemand  = true;
    this.showingCourseDemand = false;
    this.showingStudentVisits   = false;

    //sort sessions for tutor demand.
    console.log("showing tutor demand...");
    let tutorDemand = new Map<string, number>();

    for (let sess of this.sessions) {
      let tutor = sess.tutor;

      console.log(tutorDemand.has(tutor.schoolEmail));
      console.log(tutor.schoolEmail);
      console.log(tutorDemand.keys());

      let demand = tutorDemand.get(tutor.schoolEmail);
      if (demand !== undefined) {
        demand+=1;
        tutorDemand.set(tutor.schoolEmail,demand);
      } else {
        tutorDemand.set(tutor.schoolEmail,1);
      }
    }
    console.log(tutorDemand);
    this.analysis = tutorDemand;
  }

  showCourseDemand() {
    this.showingTutorDemand  = false;
    this.showingCourseDemand = true;
    this.showingStudentVisits   = false;

    //sort sessions for course demand.
    console.log("showing course demand...");
    let courseDemand = new Map<string, number>();

    for (let sess of this.sessions) {
      let course = sess.course;

      console.log(courseDemand.has(course.name));
      console.log(course.name);
      console.log(courseDemand.keys());

      let demand = courseDemand.get(course.name);
      if (demand !== undefined) {
        demand+=1;
        courseDemand.set(course.name,demand);
      } else {
        courseDemand.set(course.name,1);
      }
    }
    console.log(courseDemand);
    this.analysis = courseDemand;
  }

  showStudentVisits() {
    this.showingTutorDemand  = false;
    this.showingCourseDemand = false;
    this.showingStudentVisits   = true;

    //sort sessions for time demand.
    console.log("showing time demand...");
    let studentVisits = new Map<string, number>();

    for (let sess of this.sessions) {
      let student = sess.student;

      console.log(studentVisits.has(student.schoolEmail));
      console.log(student.schoolEmail);
      console.log(studentVisits.keys());

      let demand = studentVisits.get(student.schoolEmail);
      if (demand !== undefined) {
        demand+=1;
        studentVisits.set(student.schoolEmail,demand);
      } else {
        studentVisits.set(student.schoolEmail,1);
      }
    }
    console.log(studentVisits);
    this.analysis = studentVisits;
  }

  getAnalysis() : Map<string, number> {
    return this.analysis;
  }
}
