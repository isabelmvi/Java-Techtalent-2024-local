import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  // currentSlide:number = 0;
  // const slides: any = document.querySelectorAll('.slide');
  // const totalSlides = this.slides.length;

  // showSlide(index: number) {
  //     const slider: any = document.querySelector('.slider');
  //     slider.style.transform = `translateX(-${index * 100}%)`;
  // }

  // nextSlide() {
  //     this.currentSlide = (this.currentSlide + 1) % this.totalSlides;
  //     this.showSlide(this.currentSlide);
  // }

  // document.addEventListener('DOMContentLoaded', () => {
  //     showSlide(currentSlide);
  //     setInterval(nextSlide, 3000); // Moves to the next slide every 3 seconds
  // });

  // // Add this script to handle the navbar contraction
  // const navbar = document.querySelector('.navbar');
  // const navLinks = document.querySelector('.nav-links');
  // const authButtons = document.querySelector('.auth-buttons');

  // window.addEventListener('scroll', () => {
  //     if (window.scrollY > 50) {
  //         navLinks.classList.add('hidden');
  //         authButtons.classList.add('hidden');
  //         navbar.classList.add('shrink');
  //     } else {
  //         navLinks.classList.remove('hidden');
  //         authButtons.classList.remove('hidden');
  //         navbar.classList.remove('shrink');
  //     }
  // });
}
