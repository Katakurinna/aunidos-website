import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearSociosComponent } from './pages/crear-socios/crear-socios.component';


const routes: Routes = [
  { path: "testSocio", component: CrearSociosComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
