import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Session } from '../Models/session';
import { SessionIDs } from '../Models/SessionIDs';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private http: HttpClient) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
/*
  getAllSession(): Observable<any> {
    return this.http.get<Session[]>('http://localhost:8080/Sessions');
  }
*/
  addSession(session: SessionIDs): Observable<SessionIDs> {
    return this.http.post<SessionIDs>('http://localhost:8080/Sessions', session, { headers: this.postHeaders });
  }
/*
  getSession(id): Observable<Session> {
    return this.http.get<Session>('http://localhost:8080/Sessions/' + id);
  }

  updateSession(Session: Session): Observable<Session> {
    return this.http.put<Session>('http://localhost:8080/Sessions/' + Session.id, Session, { headers: this.postHeaders });
  }*/
}