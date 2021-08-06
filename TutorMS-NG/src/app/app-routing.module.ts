import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HoursSummaryComponent } from './components/summary/hours-summary/hours-summary.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileSettingsComponent } from './components/profileSettings/profileSettings.component';
import { CalendarComponent } from './components/calendar/calendar.component'
import { SchedulingComponent } from './components/scheduling/scheduling.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'calendar', component: CalendarComponent },
  { path: 'profileSettings', component: ProfileSettingsComponent },
  { path: 'scheduling', component: SchedulingComponent },
  { path: 'summary', component: HoursSummaryComponent},
  { path: 'login', component: LoginComponent},
  { path: 'registration', component: RegistrationComponent},
  { path: 'profile', component: ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
