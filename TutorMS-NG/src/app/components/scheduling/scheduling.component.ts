import { TOUCH_BUFFER_MS } from '@angular/cdk/a11y/input-modality/input-modality-detector';
import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/Course';
import { Tutor } from 'src/app/models/tutor';
import { SessionService } from 'src/app/services/session.service';
import { TutorsService } from 'src/app/services/tutors.service';
import { LoginService } from 'src/app/services/login.service';
import { SessionIDs } from 'src/app/models/SessionIDs';

@Component({
  selector: 'app-scheduling',
  templateUrl: './scheduling.component.html',
  styleUrls: ['./scheduling.component.css']
})
export class SchedulingComponent implements OnInit {

  searchBox!: string;
  sessionList: SessionIDs[] = [];
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

    this.sessionData.addSession(new SessionIDs(this.selectedTutor!.id , this.userData.getCurrentUser().id , this.selectedCourse!.id, 1612890000000 ,  1612895200000, "", "")).subscribe(
      (data) => {
        console.log(data);
        this.sessionList.push(data);
      },
      (data) => {
        console.log(data);
        console.log("Failed to add session.");
      });
  }

  isGuest() :boolean {
    if (this.userData.currentUser.firstName == 'Guest') {
      return true;
    } else return false;

  }

}

