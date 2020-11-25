import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMoviesEditComponent } from './admin-movies-edit.component';

describe('AdminMoviesEditComponent', () => {
  let component: AdminMoviesEditComponent;
  let fixture: ComponentFixture<AdminMoviesEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminMoviesEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMoviesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
