import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/Models/Course';
import { Session } from 'src/app/Models/session';
import { Tutor } from 'src/app/Models/tutor';
import { SessionService } from 'src/app/Services/session.service';
import { TutorsService } from 'src/app/Services/tutors.service';
import { LoginService } from 'src/app/Services/login.service';

@Component({
  selector: 'app-scheduling',
  templateUrl: './scheduling.component.html',
  styleUrls: ['./scheduling.component.css']
})
export class SchedulingComponent implements OnInit {

  searchBox!: string;
  sessionList: Session[] = [];
  tutorsData: Tutor[] = [];
  selectedTutor?: Tutor;
  selectedCourse?: Course;

  constructor(private database: TutorsService, private sessionData: SessionService, private userData: LoginService) { }

  ngOnInit(){
    this.database.getAllTutors().subscribe(data => {console.warn(data); this.tutorsData = data;});
  }

  onSelect(tutor: Tutor): void {
    this.selectedTutor = tutor;
  }

  courseSelect(course: Course){
    this.selectedCourse = course;
  }

  addSession(){

    this.sessionData.addSession(new Session(0 , this.selectedTutor! , this.userData.getCurrentUser() , this.selectedCourse!, 1612890000000 ,  1612895200000, "", "")).subscribe(
      (data) => {
        console.log(data);
        this.sessionList.push(data);
      },
      (data) => {
        console.log(data);
        console.log("Failed to add session.");
      });
  }

}

