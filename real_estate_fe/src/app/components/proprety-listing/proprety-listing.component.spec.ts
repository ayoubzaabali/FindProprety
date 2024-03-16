import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropretyListingComponent } from './proprety-listing.component';

describe('PropretyListingComponent', () => {
  let component: PropretyListingComponent;
  let fixture: ComponentFixture<PropretyListingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PropretyListingComponent]
    });
    fixture = TestBed.createComponent(PropretyListingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
