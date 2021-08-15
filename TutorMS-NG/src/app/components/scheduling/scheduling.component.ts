import { TOUCH_BUFFER_MS } from '@angular/cdk/a11y/input-modality/input-modality-detector';
import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/Course';
import { Session } from 'src/app/models/Session';
import { Tutor } from 'src/app/models/tutor';
import { User } from 'src/app/models/User';
import { SessionService } from 'src/app/services/session.service';
import { TutorsService } from 'src/app/services/tutors.service';

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
  userData: any;
  selectedCourse: Course | undefined;

  constructor(private database: TutorsService, private sessionData: SessionService) { }

  ngOnInit(){
    this.database.getAllTutors().subscribe(data => {console.warn(data); this.tutorsData = data;});
  }


  //edits in this class are only to make Jordan's branch compile. Defer to conflicts, except with
  //respect to how to format the new Session(args).
  onSelect(tutor: Tutor): void {
    this.selectedTutor = tutor;
  }

  addSession(){

    // this.sessionData.addSession(new Session({tutor:this.selectedTutor , studentID:this.userData.getCurrentUser() , course:this.selectedCourse , 
    //         startTime:1612890000000 , endTime:1612895200000})).subscribe(
    //   (data) => {
    //     console.log(data);
    //     this.sessionList.push(data);
    //   },
    //   (data) => {
    //     console.log(data);
    //     console.log("Failed to add session.");
    //   });
  }

}

