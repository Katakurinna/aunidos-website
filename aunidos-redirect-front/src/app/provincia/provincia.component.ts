import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProvinciaService } from '../services/provincia-service/provincia.service';
import { Provincia } from '../dto/Provincia';
import { ProvinciaRequest } from '../services/provincia-service/ProvinciaRequest';
import { SocialMedia } from '../dto/SocialMedia';
import { StatusCodes } from 'http-status-codes';
import { HttpStatus, HttpStatusEnum } from '../dto/HttpStatus';
import { IfStmt } from '@angular/compiler';
import { ProvinciaResponse } from '../services/provincia-service/ProvinciaResponse';

@Component({
  selector: 'app-provincia',
  templateUrl: './provincia.component.html',
  styleUrls: ['./provincia.component.css']
})
export class ProvinciaComponent implements OnInit {
  provincia: number;
  socialMedia: number;
  messageText: string;
  messageClass: string;
  constructor(private provinciaService: ProvinciaService, private route: ActivatedRoute) {

  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.provincia = Provincia.getByReducedName(params.name) ? Provincia.getByReducedName(params.name).id : null;
      this.socialMedia = SocialMedia.getByName(params.socialMedia) ? SocialMedia.getByName(params.socialMedia).id : null;
      if (this.provincia && this.socialMedia) {
        this.messageClass = 'alert alert-warning';
        this.messageText = `Intentando redirigir a ${SocialMedia.getById(this.socialMedia).name} de la provincia de ${Provincia.getById(this.provincia).name}`;
        const request: ProvinciaRequest = { socialMedia: this.socialMedia, provincia: this.provincia };
        this.provinciaService.getProvincia(request).toPromise().then(response => {
          if (response.url && response.status === HttpStatusEnum.OK) {
            this.messageClass = 'alert alert-success';
            this.messageText = `Redirigiendo a ${SocialMedia.getById(this.socialMedia).name} de la provincia de ${Provincia.getById(this.provincia).name}`;
            window.location.href = response.url;
          } else if (response.status === HttpStatusEnum.NOT_FOUND) {
            this.errorUrlNoCreada(Provincia.getById(this.provincia).name, params.socialMedia);
          } else {
            this.errorDesconocido(response);
          }
        }).catch(reason => {
          this.messageClass = 'alert alert-danger';
          this.messageText = `No se ha podido redirigir a ${SocialMedia.getById(this.socialMedia).name} de la provincia de ${Provincia.getById(this.provincia).name}. Error: ${reason.message}. Id de transacción: ${reason.error.message}`;
        });

      } else {
        this.errorMessage(params.name, params.socialMedia);
      }
    });


  }

  private errorDesconocido(response: ProvinciaResponse){
    this.messageClass = 'alert alert-danger';
    this.messageText = `Ha ocurrido un error desconocido. Id transacción: ${response.idTransaccion}`;
  }
  private errorUrlNoCreada(province, socialMedia) {
    this.messageClass = 'alert alert-danger';
    this.messageText = `Vaya, parece que la red social ${this.sentenceCase(socialMedia)} de la provincia de ${province} aún no existe.`;
  }

  private errorMessage(province, socialMedia: string) {
    this.messageClass = 'alert alert-danger';
    this.messageText = `No se ha podido redirigir a ${this.sentenceCase(socialMedia)} de la provincia de ${province} ¿Está seguro de que la URL existe?`;
  }
  private sentenceCase(str): string {
    if ((str===null) || (str==='')) return null;
  
   return str.charAt(0).toUpperCase() + str.substr(1).toLowerCase();
  }
}
