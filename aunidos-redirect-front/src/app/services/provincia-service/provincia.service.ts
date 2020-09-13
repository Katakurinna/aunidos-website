import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProvinciaRequest } from './ProvinciaRequest';
import { ProvinciaResponse } from './ProvinciaResponse';

const backURL = `aunidos.es:8080`;
//  const backURL = `http://localhost:8080`;
const headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    
});

@Injectable({
  providedIn: 'root'
})
export class ProvinciaService {

  getProvincia(request: ProvinciaRequest): Observable<ProvinciaResponse> {
    return this.http.post<ProvinciaResponse>(`${backURL}/getSocialMedia`, request, { headers });
  }

  constructor(private http: HttpClient) {}

}