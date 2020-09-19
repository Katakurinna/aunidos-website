import { Socio } from 'src/app/dto/Socio';
import { GenericRequest } from './GenericRequest';

export interface SocioRequest extends GenericRequest {
    socios: Array<Socio>
}