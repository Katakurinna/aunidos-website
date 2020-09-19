export enum HttpStatusEnum {
    OK = 'OK',
    NOT_FOUND = 'NOT_FOUND',
    INTERNAL_SERVER_ERROR = 'INTERNAL_SERVER_ERROR',
    UNAUTHORIZED = "UNAUTHORIZED"
}

export class HttpStatus {
    /**
     * Get by enum
     */
    public static getByEnum(enumString: HttpStatusEnum): HttpStatus {
        return HttpStatus.lista.find(t => t.enumString === enumString);
    }

    public static getByName(name: String): HttpStatus {
        return HttpStatus.lista.find(t => t.name === name);
    }

    /**
     * Get by id
     */
    public static getById(id: number): HttpStatus {
        return HttpStatus.lista.find(t => t.value === id);
    }

    public static readonly lista: HttpStatus[] = [
        {
            enumString: HttpStatusEnum.OK,
            value: 200,
            name: 'OK'
        },
        {
            enumString: HttpStatusEnum.NOT_FOUND,
            value: 404,
            name: 'NOT_FOUND'
        },
        {
            enumString: HttpStatusEnum.INTERNAL_SERVER_ERROR,
            value: 500,
            name: 'INTERNAL_SERVER_ERROR'
        }, 
        {
            enumString: HttpStatusEnum.UNAUTHORIZED,
            value: 401,
            name: 'UNAUTHORIZED'
        }
    ];

    constructor(public enumString: HttpStatusEnum, public value: number, public name: string) {}
}
