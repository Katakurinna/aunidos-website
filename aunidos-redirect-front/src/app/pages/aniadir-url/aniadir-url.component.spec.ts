import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AniadirURLComponent } from './aniadir-url.component';

describe('AniadirURLComponent', () => {
  let component: AniadirURLComponent;
  let fixture: ComponentFixture<AniadirURLComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AniadirURLComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AniadirURLComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
