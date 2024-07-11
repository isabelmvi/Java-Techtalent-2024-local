import { Component, AfterViewInit, HostListener } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {
  currentSlide: number = 0;
  slides: NodeListOf<HTMLElement> = document.querySelectorAll('.slide');
  totalSlides: number = this.slides.length;

  ngAfterViewInit() {
    this.showSlide(this.currentSlide);
    setInterval(() => this.nextSlide(), 3000); // Moves to the next slide every 3 seconds
  }

  showSlide(index: number) {
    const slider: HTMLElement | null = document.querySelector('.slider');
    if (slider) {
      slider.style.transform = `translateX(-${index * 100}%)`;
    }
  }

  nextSlide() {
    this.currentSlide = (this.currentSlide + 1) % this.totalSlides;
    this.showSlide(this.currentSlide);
  }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    const navbar = document.querySelector('.navbar');
    const navLinks = document.querySelector('.nav-links');
    const authButtons = document.querySelector('.auth-buttons');
    
    if (navbar && navLinks && authButtons) {
      if (window.scrollY > 50) {
        navLinks.classList.add('hidden');
        authButtons.classList.add('hidden');
        navbar.classList.add('shrink');
      } else {
        navLinks.classList.remove('hidden');
        authButtons.classList.remove('hidden');
        navbar.classList.remove('shrink');
      }
    }
  }
}
