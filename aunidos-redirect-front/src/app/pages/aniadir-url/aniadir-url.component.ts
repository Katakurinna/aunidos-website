import { Component, OnInit } from '@angular/core';
import { HttpStatus, HttpStatusEnum } from 'src/app/commons/dto/HttpStatus';
import { Provincia, ProvinciaEnum } from 'src/app/commons/dto/Provincia';
import { SocialMedia, SocialMediaEnum } from 'src/app/commons/dto/SocialMedia';
import { ProvinciaService } from 'src/app/commons/services/provincia-service/provincia.service';
import { ProvinciaRequest } from 'src/app/commons/services/provincia-service/ProvinciaRequest';
import { ProvinciaResponse } from 'src/app/commons/services/provincia-service/ProvinciaResponse';
import { md5 } from 'src/app/commons/utils/Md5';

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
  constructor(private provinciaService: ProvinciaService) {
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

  public setearURL(url) {
    this.enlace = url;
  }

  public setearPalabraSegura(palabraSegura) {
    this.palabraSegura = md5(palabraSegura);
  }

  public confirmarEliminacion(confirmar) {
    this.reemplazar = confirmar;
  }

  public onSubmit() {
    if (!this.reemplazar) {
      this.messageClass = 'alert alert-danger';
      this.messageText = `Debes marcar el boton de reemplazar anterior`;
      return;
    }
    this.messageClass = '';
    this.messageText = ``;
    const request: ProvinciaRequest = {
      provincia: this.provinciaSeleccionada.id,
      socialMedia: this.socialMediaSeleccionada.id,
      palabraSeguridad: this.palabraSegura,
      url: this.enlace
    };

    this.provinciaService.anadirURL(request).toPromise().then(response => {
      if (response.status === "OK") {
        this.mensajeCreadaURL();
      } else if (response.status === HttpStatus.getByEnum(HttpStatusEnum.UNAUTHORIZED).name) {
        this.errorPalabraClaveInvalida(response);
      } else {
        this.errorDesconocido(response);
      }
    }).catch(reason => {
      this.errorThrow(reason);
    });

  }


  private mensajeCreadaURL() {
    this.messageClass = 'alert alert-success';
    this.messageText = `Se ha asignado la url "${this.enlace}" en la red social ${this.socialMediaSeleccionada.name} de la provincia de ${this.provinciaSeleccionada.name}`;
  }

  private errorDesconocido(response: ProvinciaResponse) {
    this.messageClass = 'alert alert-danger';
    this.messageText = `Ha ocurrido un error desconocido. Id transacción: ${response.idTransaccion}`;
  }

  private errorPalabraClaveInvalida(response: ProvinciaResponse) {
    this.messageClass = 'alert alert-danger';
    this.messageText = `La palabra secreta introducida no es correcta. Id transacción: ${response.idTransaccion}`;
  }

  private errorThrow(reason) {
    this.messageClass = 'alert alert-danger';
    this.messageText = `Ha habido un problema interno en el servidor. Error: ${reason.message}. Id de transacción: ${reason.error.message}`;
  }
}
