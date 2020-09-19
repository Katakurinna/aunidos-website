import { Socio } from 'src/app/dto/Socio';
import { GenericResponse } from './GenericResponse';

export interface SocioResponse extends GenericResponse {
    socios: Array<Socio>
}