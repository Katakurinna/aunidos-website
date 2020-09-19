import { HttpStatus } from './HttpStatus';

export interface ErrorTransaccion {
    error?: HttpStatus;
    mensaje?: string;
}