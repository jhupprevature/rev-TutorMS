import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HoursSummaryComponent } from './hours-summary.component';

describe('HoursSummaryComponent', () => {
  let component: HoursSummaryComponent;
  let fixture: ComponentFixture<HoursSummaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HoursSummaryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HoursSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
