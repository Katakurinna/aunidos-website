import {
    ReasonPhrases,
    StatusCodes,
    getReasonPhrase,
    getStatusCode,
} from 'http-status-codes';
import { Provincia } from 'src/app/dto/Provincia';
import { SocialMedia } from 'src/app/dto/SocialMedia';

export class ProvinciaResponse {
    socialMedia: SocialMedia;
    status: StatusCodes;
    idTransaccion: String;

}