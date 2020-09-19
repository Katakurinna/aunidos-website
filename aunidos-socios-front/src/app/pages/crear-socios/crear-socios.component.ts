import { Component, OnInit } from '@angular/core';
import { SocioRequest } from 'src/app/service/request/SocioRequest';
import { SocioService } from 'src/app/service/service/SocioService';

@Component({
  selector: 'app-crear-socios',
  templateUrl: './crear-socios.component.html',
  styleUrls: ['./crear-socios.component.css']
})
export class CrearSociosComponent implements OnInit {

  constructor(private sociosService: SocioService) { }

  ngOnInit(): void {
    const request: SocioRequest = {
      socios: [{
        dni: '12345678C',
        apellidos: 'Test',
        codPostal: '1234',
        domicilio: 'Calle la larga',
        email: 'alesagustin@gmail.com',
        gremio: 'Programador',
        nombre: 'Alejandro',
        poblacion: 'Cádiz',
        provincia: 1,
        telFax: '99999111',
        telMovil: '99999111'
      }],
      transaccion: {idTransaccion: 'test12'}
    }
    this.sociosService.crearSocio(request).toPromise().then(response => {
      window.alert('Socio creado');
    }).catch(error => {
      window.alert('Error.');
    });
  }

}
