import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CrearSociosComponent } from './pages/crear-socios/crear-socios.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SocioService } from './service/service/SocioService';

@NgModule({
  declarations: [
    AppComponent,
    CrearSociosComponent
  ],
  imports: [BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [SocioService, HttpClient, FormBuilder],
  bootstrap: [AppComponent]
})
export class AppModule { }
