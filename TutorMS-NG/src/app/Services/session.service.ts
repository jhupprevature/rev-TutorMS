import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Session } from '../models/session';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private http: HttpClient, private loginServ: LoginService) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
/*
  getAllSession(): Observable<any> {
    return this.http.get<Session[]>('http://localhost:8080/Sessions');
  }
*/
  addSession(session: Session): Observable<Session> {
    return this.http.post<Session>('http://localhost:8080/Sessions', session, { headers: this.postHeaders });
  }
/*
  getSession(id): Observable<Session> {
    return this.http.get<Session>('http://localhost:8080/Sessions/' + id);
  }

  updateSession(Session: Session): Observable<Session> {
    return this.http.put<Session>('http://localhost:8080/Sessions/' + Session.id, Session, { headers: this.postHeaders });
  }*/

  getUserSessions(): Observable<Session[]> {
    return this.http.get<Session[]>('http://localhost:8080/users/'+this.loginServ.currentUser.id.toString()+'/sessions')
  }

}