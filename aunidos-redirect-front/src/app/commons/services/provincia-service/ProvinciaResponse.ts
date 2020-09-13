import {
    ReasonPhrases,
    StatusCodes,
    getReasonPhrase,
    getStatusCode,
} from 'http-status-codes';
import { HttpStatusEnum } from '../../dto/HttpStatus';

export class ProvinciaResponse {
    url: string;
    status: HttpStatusEnum;
    idTransaccion: String;

}