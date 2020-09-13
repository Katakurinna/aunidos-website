import { Component, OnInit } from '@angular/core';
import { Provincia, ProvinciaEnum } from 'src/app/commons/dto/Provincia';
import { SocialMedia, SocialMediaEnum } from 'src/app/commons/dto/SocialMedia';

@Component({
  selector: 'app-aniadir-url',
  templateUrl: './aniadir-url.component.html',
  styleUrls: ['./aniadir-url.component.css']
})
export class AniadirURLComponent implements OnInit {

  provincias: Provincia[];
  socialMedias: SocialMedia[];
  provinciaSeleccionada: Provincia = Provincia.getByEnum(ProvinciaEnum.ALBACETE);
  socialMediaSeleccionada: SocialMedia = SocialMedia.getByEnum(SocialMediaEnum.WHATSAPP);
  private palabraSegura: string;
  private enlace: string;
  reemplazar: boolean = false;
  messageText: string;
  messageClass: string;
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

  public setearURL(url){
    this.enlace = url;
  }

  public setearPalabraSegura(palabraSegura) {
    this.palabraSegura = palabraSegura;
  }

  public confirmarEliminacion(confirmar) {
    this.reemplazar = confirmar;
  }
  
  public onSubmit() {
    if(this.reemplazar) {
      this.messageClass = '';
      this.messageText = ``;
    } else {
      this.messageClass = 'alert alert-danger';
      this.messageText = `Debes marcar el boton de reemplazar anterior`;
    }
    console.log(this.provinciaSeleccionada.name + ' '+ this.socialMediaSeleccionada.name + ' ' + this.enlace + ' ' + this.palabraSegura + ' ' + this.reemplazar)
  }

}
