import { Injectable } from '@angular/core';
import { Provincia } from '../../dto/Provincia';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProvinciaRequest } from './ProvinciaRequest';
import { ProvinciaResponse } from './ProvinciaResponse';

// const backURL = `back.aunidos.es:8080`;
const backURL = `http://localhost:8080`;
const headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    
});
/*
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
    'Access-Control-Allow-Headers': 'X-Requested-With,content-type'
*/

@Injectable({
  providedIn: 'root'
})
export class ProvinciaService {

  getProvincia(request: ProvinciaRequest): Observable<ProvinciaResponse> {
    return this.http.post<ProvinciaResponse>(`${backURL}/getSocialMedia`, request, { headers });

  }

  constructor(private http: HttpClient) {}


}
