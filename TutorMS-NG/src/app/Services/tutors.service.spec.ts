import { TestBed } from '@angular/core/testing';

import { TutorsService } from './tutors.service';

describe('TutorsService', () => {
  let service: TutorsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TutorsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
