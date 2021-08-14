import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { guestUser } from 'src/app/models/User';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  constructor(private loginServ: LoginService) { }

  ngOnInit(): void {
  }

  loggedIn: boolean = false;

  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }

  getUsername() {
    return this.loginServ.currentUser.schoolEmail;
  }

  logout() {
    this.loginServ.currentUser = guestUser;
    this.loggedIn = false;
  }
}
