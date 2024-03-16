import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropretyItemComponent } from './proprety-item.component';

describe('PropretyItemComponent', () => {
  let component: PropretyItemComponent;
  let fixture: ComponentFixture<PropretyItemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PropretyItemComponent]
    });
    fixture = TestBed.createComponent(PropretyItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
