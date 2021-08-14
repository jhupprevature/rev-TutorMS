import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/Models/User';
import { LoginService } from 'src/app/Services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginServ: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  username: String = "";
  password: String = "";
  invalidLogin: boolean = false;

  login() {
    console.log(this.username)
    console.log(this.password)

    this.invalidLogin = false;
    let user = new User(0, this.username, this.password);
    this.loginServ.login(user).subscribe(
      (r) => {
        if (r) {
          console.log("going in here!")
          this.loginServ.currentUser = r;
          this.router.navigateByUrl("/home");
        } else {
          this.invalidLogin = true;
        }
      },
      (error) => {
        this.invalidLogin = true;
      }
    )
  }

}
