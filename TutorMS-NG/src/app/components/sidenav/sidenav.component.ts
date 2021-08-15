import { Component, Input, OnDestroy} from '@angular/core';
import { User } from 'src/app/models/User';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent {
  user: User;

  constructor(private loginServ: LoginService) { 
    this.user = loginServ.currentUser;
  }

  isManager() :boolean {
    if (this.loginServ.currentUser.accountType.type == 'Tutor Manager') {
      return true;
    } else return false;
  }

  isGuest() :boolean {
    if (this.loginServ.currentUser.firstName == 'Guest') {
      return true;
    } else return false;

  }
}