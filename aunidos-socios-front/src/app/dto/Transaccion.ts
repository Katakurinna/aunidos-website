import { ErrorTransaccion } from './ErrorTransaccion';

export interface Transaccion {
    error?: ErrorTransaccion;
    idTransaccion: string;
}