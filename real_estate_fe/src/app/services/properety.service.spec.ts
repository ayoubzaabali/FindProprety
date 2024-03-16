import { TestBed } from '@angular/core/testing';

import { ProperetyService } from './properety.service';

describe('ProperetyService', () => {
  let service: ProperetyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProperetyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
