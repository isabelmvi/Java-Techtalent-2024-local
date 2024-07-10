import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.css']
})
export class SliderComponent implements OnInit {
  currentSlide = 0;
  slides!: NodeListOf<HTMLElement>;

  ngOnInit() {
    this.slides = document.querySelectorAll('.slide') as NodeListOf<HTMLElement>;
    this.showSlide(this.currentSlide);
    setInterval(() => this.nextSlide(), 3000);
  }

  showSlide(index: number) {
    const slider = document.querySelector('.slider') as HTMLElement;
    slider.style.transform = `translateX(-${index * 100}%)`;
  }

  nextSlide() {
    this.currentSlide = (this.currentSlide + 1) % this.slides.length;
    this.showSlide(this.currentSlide);
  }
}