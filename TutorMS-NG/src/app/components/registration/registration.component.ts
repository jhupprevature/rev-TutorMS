import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountType } from 'src/app/Models/AccountType';
import { UserRegister } from 'src/app/Models/UserRegister';
import { LoginService } from 'src/app/Services/login.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private loginServ: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  inputFirstName!: string;
  inputLastName!: string;
  inputTelephone!: string;
  inputEmail!: string;
  inputPassword!: string;
  accountTypeId: number = 3;
  accountTypeString?: string;

  register() {
  
    switch (this.accountTypeId) {
      case 1:
        this.accountTypeString = "Tutor Manager";
        break;
      case 2:
        this.accountTypeString = "Tutor";
        break;
      case 3:
        this.accountTypeString = "Student";
        break;
      default:
        this.accountTypeString = "Student";

    }

    let accountType = new AccountType(this.accountTypeId, this.accountTypeString);

    let user = new UserRegister(this.inputFirstName, this.inputLastName, this.inputEmail, this.inputPassword, this.inputTelephone, accountType);

    this.loginServ.register(user).subscribe(
      (r) => {
        if (r) {
          console.log("going in here!")
          this.loginServ.currentUser = r;
          this.router.navigateByUrl("/dashboard");
        } 
      }
    )

  }


  
}
