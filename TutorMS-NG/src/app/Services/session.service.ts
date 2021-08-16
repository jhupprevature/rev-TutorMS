import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Session } from '../Models/session';
import { SessionIDs } from '../Models/SessionIDs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private http: HttpClient, private loginServ: LoginService) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getAllSessions(): Observable<Session[]> {
    return this.http.get<Session[]>('http://localhost:8080/Sessions');
  }

  addSession(session: SessionIDs): Observable<SessionIDs> {
    return this.http.post<SessionIDs>('http://localhost:8080/Sessions', session, { headers: this.postHeaders });
  }

  getAnalytics(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/Sessions/analytics');
  }
/*
  getSession(id): Observable<Session> {
    return this.http.get<Session>('http://localhost:8080/Sessions/' + id);
  }

  updateSession(Session: Session): Observable<Session> {
    return this.http.put<Session>('http://localhost:8080/Sessions/' + Session.id, Session, { headers: this.postHeaders });
  }*/

  //I switched Session to SessionIDs, Cao might want to check this.
  getUserSessions(): Observable<SessionIDs[]> {
    return this.http.get<SessionIDs[]>('http://localhost:8080/users/'+this.loginServ.currentUser.id.toString()+'/sessions')
  }

}