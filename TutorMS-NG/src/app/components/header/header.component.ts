import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { LoginService } from 'src/app/Services/login.service';

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
    if (this.loginServ.currentUser?.schoolEmail) {
        this.loggedIn = true;
    }
    return this.loginServ.currentUser?.schoolEmail ?? "Guest"
  }
}
