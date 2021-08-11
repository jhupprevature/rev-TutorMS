import { Component, OnInit } from '@angular/core';
import { Tutor } from 'src/app/models/tutor';
import { TutorsService } from 'src/app/services/tutors.service';

@Component({
  selector: 'app-scheduling',
  templateUrl: './scheduling.component.html',
  styleUrls: ['./scheduling.component.css']
})
export class SchedulingComponent implements OnInit {

  searchBox!: string;

  tutorsData: Tutor[] = [];

  selectedTutor?: Tutor;

  constructor(private database: TutorsService) { }

  ngOnInit(){
    this.database.getAllTutors().subscribe(data => {console.warn(data); this.tutorsData = data;});
  }

  onSelect(tutor: Tutor): void {
    this.selectedTutor = tutor;
  }

  addSession(){

      var sessionData = new FormData();
  
     // sessionData.append('title', this.addEventForm.value.title);
      //sessionData.append('startdate', this.eventdate);
  
      //return this.http.post('http://localhost:8080/dateEvents', sessionData).subscribe((data: Object) => { this.events.push(data); $("#myModal").modal("hide");});
    }
}


