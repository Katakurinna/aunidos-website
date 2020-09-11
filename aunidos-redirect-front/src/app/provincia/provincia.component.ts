import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProvinciaService } from '../provincia.service';
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

  constructor( private provinciaService: ProvinciaService, private route: ActivatedRoute ){

  }
  ngOnInit() {
    this.route.params.subscribe(params => {
        this.name = params.name;
        this.socialMedia = params.socialMedia;
        const request: ProvinciaRequest = {provincia: {name: this.name, socialMedia: this.socialMedia}};
        this.provinciaService.getProvincia(request).subscribe( provincia => {
        this.provincia = provincia.provincia;
        window.location.href = this.provincia.url;
        });
    });

  }
}
