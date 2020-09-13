import {
    ReasonPhrases,
    StatusCodes,
    getReasonPhrase,
    getStatusCode,
} from 'http-status-codes';
import { HttpStatus, HttpStatusEnum } from 'src/app/dto/HttpStatus';

export class ProvinciaResponse {
    url: string;
    status: HttpStatusEnum;
    idTransaccion: String;

}