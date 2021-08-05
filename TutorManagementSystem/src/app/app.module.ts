import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FullCalendarModule } from '@fullcalendar/angular'; // must go before plugins
import dayGridPlugin from '@fullcalendar/daygrid'; 
import interactionPlugin from '@fullcalendar/interaction'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { ProfileComponent } from './components/profile/profile.component';
import { HoursSummaryComponent } from './components/summary/hours-summary/hours-summary.component';
import { CalendarComponent } from './components/calendar/calendar.component';
import { ProfileSettingsComponent } from './components/profileSettings/profileSettings.component';
import { SchedulingComponent } from './components/scheduling/scheduling.component';
import { FormsModule } from '@angular/forms';

FullCalendarModule.registerPlugins([ // register FullCalendar plugins
  dayGridPlugin,
  interactionPlugin
]);

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    SidenavComponent,
    DashboardComponent,
    CalendarComponent,
    ProfileSettingsComponent,
    SchedulingComponent,
    ProfileComponent,
    HoursSummaryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FullCalendarModule,
    FormsModule,
    // * MATERIAL IMPORTS
    MatSidenavModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
