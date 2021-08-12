import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../Models/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  private headers = new HttpHeaders({'Content-Type':'application/json'});

  currentUser: User | undefined;

  login(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/login', user, { headers: this.headers })
  }

}
