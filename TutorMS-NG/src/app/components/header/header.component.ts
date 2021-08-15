import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { guestUser, User } from 'src/app/Models/User';
import { LoginService } from 'src/app/Services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  user: User;

  constructor(private loginServ: LoginService) {
    this.user = this.loginServ.getCurrentUser();
   }

  ngOnInit(): void {
  }

  loggedIn: boolean = false;

  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }

  getUsername() {
    if (this.loginServ.currentUser.firstName != "Guest") {
      this.loggedIn = true;
    } else {
      this.loggedIn = false;
    }
    return this.loginServ.currentUser.schoolEmail;
  }

  logout() {
    this.loginServ.currentUser = guestUser;
    this.loggedIn = false;
  }

  setAccountType() {
    switch (this.loginServ.currentUser.accountType.type) {
      case "Tutor Manager":
        return "Tutor Manager";
      case "Tutor":
        return"Tutor";
      case "Student":
        return "Student";
      default:
        return ""
    }
  }
 
}
