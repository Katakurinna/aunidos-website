import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Provincia, ProvinciaEnum } from '../dto/Provincia';
import { SocialMedia, SocialMediaEnum } from '../dto/SocialMedia';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  provincias: Provincia[];
  socialMedias: SocialMedia[];
  provinciaSeleccionada: Provincia = Provincia.getByEnum(ProvinciaEnum.ALBACETE);
  socialMediaSeleccionada: SocialMedia = SocialMedia.getByEnum(SocialMediaEnum.WHATSAPP);
  constructor() {
   }
  

   public ngOnInit(): void {
    this.provincias = Provincia.lista;
    this.socialMedias = SocialMedia.lista;
  }

  public seleccionarProvincia(id) {
    this.provinciaSeleccionada = Provincia.getById(Number.parseInt(id)); 
  }
  
  public seleccionarSocialMedia(id) {
    this.socialMediaSeleccionada = SocialMedia.getById(Number.parseInt(id)); 
  }

  

  public onSubmit() {
    console.log(`/provincia/${this.provinciaSeleccionada.reduced_name}/${this.socialMediaSeleccionada.name}`);
    window.location.href = `/provincia/${this.provinciaSeleccionada.reduced_name}/${this.socialMediaSeleccionada.name}`;
  }
}
