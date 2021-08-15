import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';
import { Observable } from 'rxjs';
import { UserRegister } from '../models/UserRegister';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  currentUser = new User();

  constructor(private http: HttpClient) { }

  private headers = new HttpHeaders({'Content-Type':'application/json'});

  login(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/login', user, { headers: this.headers })
  }

  register(user: UserRegister): Observable<User> {
    return this.http.post<User>('http://localhost:8080/users', user, { headers: this.headers })
  }

  getCurrentUser(): User {
    return this.currentUser;
  }

}
