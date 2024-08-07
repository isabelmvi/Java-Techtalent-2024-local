import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SocialBoxComponent } from './social-box.component';

describe('SocialBoxComponent', () => {
  let component: SocialBoxComponent;
  let fixture: ComponentFixture<SocialBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SocialBoxComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SocialBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
