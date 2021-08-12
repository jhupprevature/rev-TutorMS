import { TestBed } from '@angular/core/testing';

import { DateEventsService } from './date-events.service';

describe('DateEventsService', () => {
  let service: DateEventsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DateEventsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
