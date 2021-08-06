import { Component, OnInit } from '@angular/core';
import { Tutor } from 'src/app/tutor';
import { Tutors } from 'src/app/fake-tutors';

@Component({
  selector: 'app-scheduling',
  templateUrl: './scheduling.component.html',
  styleUrls: ['./scheduling.component.css']
})
export class SchedulingComponent implements OnInit {

  tutors = Tutors;
  selectedTutor?: Tutor;

  constructor() { }

  ngOnInit(): void {
  }

  onSelect(tutor: Tutor): void {
    this.selectedTutor = tutor;
  }

}
