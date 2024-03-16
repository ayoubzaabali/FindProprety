import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProperetiesComponent } from './propereties.component';

describe('ProperetiesComponent', () => {
  let component: ProperetiesComponent;
  let fixture: ComponentFixture<ProperetiesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProperetiesComponent]
    });
    fixture = TestBed.createComponent(ProperetiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
