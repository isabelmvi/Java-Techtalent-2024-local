import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
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
