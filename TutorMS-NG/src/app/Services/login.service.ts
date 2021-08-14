import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { guestUser, User } from '../models/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  currentUser = guestUser;

  constructor(private http: HttpClient) { }

  private headers = new HttpHeaders({'Content-Type':'application/json'});

  login(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/login', user, { headers: this.headers })
  }

}
