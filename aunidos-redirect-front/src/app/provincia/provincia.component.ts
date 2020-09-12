import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProvinciaService } from '../services/provincia-service/provincia.service';
import { Provincia } from '../dto/Provincia';
import { ProvinciaRequest } from '../services/provincia-service/ProvinciaRequest';

@Component({
  selector: 'app-provincia',
  templateUrl: './provincia.component.html',
  styleUrls: ['./provincia.component.css']
})
export class ProvinciaComponent implements OnInit {
  name: string;
  socialMedia: string;
  provincia: Provincia;
  messageText: string;
  messageClass: string;
  constructor( private provinciaService: ProvinciaService, private route: ActivatedRoute ){

  }
  ngOnInit() {
    this.route.params.subscribe(params => {
        this.name = params.name;
        this.socialMedia = params.socialMedia;
        this.messageClass = 'alert alert-warning';
        this.messageText = `Intentando redirigir a ${this.socialMedia} de la provincia de ${this.name}`;
        const request: ProvinciaRequest = {socialMedia: {name: this.socialMedia, provincia: {name: this.name}}};
        this.provinciaService.getProvincia(request).toPromise().then(reponse => {
          if(reponse.socialMedia.url || reponse.socialMedia.url === null) {
            this.messageClass = 'alert alert-success';
            this.messageText = `Redirigiendo a ${this.socialMedia} de la provincia de ${this.name}`;
            window.location.href = reponse.socialMedia.url;
          } else {
            this.messageClass = 'alert alert-danger';
            this.messageText = `No se ha podido redirigir a ${this.socialMedia} de la provincia de ${this.name}`;
          }
        }).catch(reason => {
          this.messageClass = 'alert alert-danger';
          this.messageText = `No se ha podido redirigir a ${this.socialMedia} de la provincia de ${this.name}. Error: ${reason.message}. Id de transacción: ${reason.error.message}`;
        });
    });

  }
}
