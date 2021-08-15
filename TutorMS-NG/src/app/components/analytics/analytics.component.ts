import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Session } from 'src/app/models/Session';
import { Observable } from 'rxjs';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.css']
})
export class AnalyticsComponent implements OnInit {
  sessions!: Session[];

  constructor(private sessServ: SessionService) { 
    sessServ.getAllSessions().subscribe(
      (response: Session[]) => {
        this.sessions = response;
        console.log(response);
      }
    );
  }

  ngOnInit(): void {
    //Get all sessions
  }

}
