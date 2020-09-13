import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProvinciaComponent } from './provincia/provincia.component';
import { ProvinciaService } from './services/provincia-service/provincia.service';
import { HttpClient, HttpHandler, HttpClientModule } from '@angular/common/http';
import { InicioComponent } from './inicio/inicio.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ProvinciaComponent,
    InicioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ProvinciaService, HttpClient, FormBuilder],
  bootstrap: [AppComponent]
})
export class AppModule { }
