import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AniadirURLComponent } from './pages/aniadir-url/aniadir-url.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { ProvinciaComponent } from './pages/provincia/provincia.component';


const routes: Routes = [
  { path: "provincia/:name/:socialMedia", component: ProvinciaComponent },
  { path: "", component: InicioComponent },
  { path: "aniadirURL", component: AniadirURLComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
