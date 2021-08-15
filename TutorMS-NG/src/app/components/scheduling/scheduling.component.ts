import { Component, OnInit } from '@angular/core';
import { Session } from 'src/app/models/session';
import { Tutor } from 'src/app/models/tutor';
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

  constructor(private database: TutorsService, private sessionData: SessionService) { }

  ngOnInit(){
    this.database.getAllTutors().subscribe(data => {console.warn(data); this.tutorsData = data;});
  }

  onSelect(tutor: Tutor): void {
    this.selectedTutor = tutor;
  }

  addSession(){

    this.sessionData.addSession(new Session(1 , 1 , 1 , 0 , 12, "", "")).subscribe(
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


