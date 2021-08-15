import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginServ: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  username: string = "";
  password: string = "";
  invalidLogin: boolean = false;

  login() {
    console.log(this.username);
    console.log(this.password);

    this.invalidLogin = false;
    let user = new User({id:-1, firstName:'Guest', username:this.username, password:this.password});
    this.loginServ.login(user).subscribe(
      (r) => {
        if (r) {
          console.log("going in here!");
          console.log(r);
          this.loginServ.currentUser = r;
          console.log(this.loginServ.currentUser);
          this.router.navigateByUrl("/dashboard");
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
