import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {

  constructor(private loginServ: LoginService) { }

  ngOnInit(): void {
  }

  isManager() : boolean {
    // console.log(this.loginServ.currentUser);
    let userType = this.loginServ.currentUser.accountType?.type;

    if (userType == 'Manager') {
      return true;
    } else {return false;}
  }

}