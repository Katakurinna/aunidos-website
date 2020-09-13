import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClient, HttpHandler, HttpClientModule } from '@angular/common/http';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProvinciaComponent } from './pages/provincia/provincia.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { AniadirURLComponent } from './pages/aniadir-url/aniadir-url.component';
import { ProvinciaService } from './commons/services/provincia-service/provincia.service';

@NgModule({
  declarations: [
    AppComponent,
    ProvinciaComponent,
    InicioComponent,
    AniadirURLComponent
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
