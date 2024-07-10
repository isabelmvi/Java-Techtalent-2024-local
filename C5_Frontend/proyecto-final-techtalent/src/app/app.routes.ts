import { Routes } from '@angular/router';
import { ServicesComponent } from './services/services.component';
import { HomeComponent } from './home/home.component';
import { SobreNosotrosComponent } from './pages/sobre-nosotros/sobre-nosotros.component';

export const routes: Routes = [
    {path: 'servicios-digitales', component: ServicesComponent },
    {path: 'home', component: HomeComponent },
    {path: 'sobre-nosotros', component: SobreNosotrosComponent }

];
