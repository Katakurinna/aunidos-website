import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SocioRequest } from '../request/SocioRequest';
import { SocioResponse } from '../response/SocioResponse';

//const backURL = `https://back.aunidos.es`;
const backURL = `http://localhost:8080/socios`;
const headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    
});

@Injectable({
  providedIn: 'root'
})
export class SocioService {

  crearSocio(request: SocioRequest): Observable<SocioResponse> {
    return this.http.post<SocioResponse>(`${backURL}/crearSocio`, request, { headers });
  }

  constructor(private http: HttpClient) {}

}