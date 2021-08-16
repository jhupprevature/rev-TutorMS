import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../Models/User';
import { Observable } from 'rxjs';
import { UserRegister } from '../Models/UserRegister';
import { Subject } from 'rxjs';
import { Session } from '../Models/session';
import { UserUpdate } from '../Models/UserUpdate';


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

  updateUser(change: UserUpdate): Observable<User> {

    return this.http.put<User>('http://localhost:8080/users/'+this.currentUser.id.toString(), change, { headers: this.headers })
  }

}
