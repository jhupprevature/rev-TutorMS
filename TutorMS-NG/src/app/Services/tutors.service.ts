import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tutor } from '../models/tutor';

@Injectable({
  providedIn: 'root'
})
export class TutorsService {

  constructor(private http: HttpClient) { }

  //private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getAllTutors(): Observable<any> {
    return this.http.get<Tutor[]>('http://localhost:8080/users/search?accountTypeId=2');
  }
/*
  addTutor(tutor: Tutor): Observable<Tutor> {
    return this.http.post<Tutor>('http://localhost:8080/tutors', tutor, { headers: this.postHeaders });
  }

  getTutor(id: string): Observable<Tutor> {
    return this.http.get<Tutor>('http://localhost:8080/tutors/' + id);
  }

  updateTutor(tutor: Tutor): Observable<Tutor> {
    return this.http.put<Tutor>('http://localhost:8080/tutors/' + tutor.id, tutor, { headers: this.postHeaders });
  }
*/
}
