import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { dateEvent } from '../Models/dateEvent';

@Injectable({
  providedIn: 'root'
})
export class DateEventsService {

  constructor(private http: HttpClient) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getAllDateEvent(): Observable<any> {
    return this.http.get<dateEvent[]>('http://localhost:8080/dateEvents');
  }

  addDateEvent(dateEvent: dateEvent): Observable<dateEvent> {
    return this.http.post<dateEvent>('http://localhost:8080/dateEvents', dateEvent, { headers: this.postHeaders });
  }

  deleteDateEvent(id: string): Observable<dateEvent>{
    return this.http.delete<dateEvent>('http://localhost:8080/dateEvents/' + id);
  }
/*
  getDateEvent(id): Observable<dateEvent> {
    return this.http.get<dateEvent>('http://localhost:8080/dateEvents/' + id);
  }

  updateDateEvent(dateEvent: dateEvent): Observable<dateEvent> {
    return this.http.put<dateEvent>('http://localhost:8080/dateEvents/' + dateEvent.id, dateEvent, { headers: this.postHeaders });
  }*/
}

