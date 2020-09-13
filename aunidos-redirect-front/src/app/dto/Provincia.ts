export enum ProvinciaEnum {
    ALBACETE = 'albacete',
    ALICANTE = 'alicante',
    ALMERIA = 'almeria',
    ALAVA = 'alava',
    ASTURIAS = 'asturias',
    AVILA = 'avila',
    BADAJOZ = 'badajoz',
    BALEARES = 'baleares',
    BARCELONA = 'barcelona',
    BIZKAIA = 'bizkaia',
    BURGOS = 'burgos',
    CACERES = 'caceres',
    CADIZ = 'cadiz',
    CANTABRIA = 'cantabria',
    CASTELLON = 'castellon',
    CIUDADREAL = 'ciudadreal',
    CORDOBA = 'cordoba',
    ACORUNA = 'acoruna',
    CUENCA = 'cuenca',
    GIPUZKOA = 'gipuzkoa',
    GIRONA = 'girona',
    GRANADA = 'granada',
    GUADALAJARA = 'guadalajara',
    HUELVA = 'huelva',
    HUESCA = 'huesca',
    JAEN = 'jaen',
    LEON = 'leon',
    LLEIDA = 'lleida',
    LUGO = 'lugo',
    MADRID = 'madrid',
    MALAGA = 'malaga',
    MURCIA = 'murcia',
    NAVARRA = 'navarra',
    OURENSE = 'ourense',
    PALENCIA = 'palencia',
    LASPALMAS = 'laspalmas',
    PONTEVEDRA = 'pontevedra',
    LARIOJA = 'larioja',
    SALAMANCA = 'salamanca',
    TENERIFE = 'tenerife',
    SEGOVIA = 'segovia',
    SEVILLA = 'sevilla',
    SORIA = 'soria',
    TARRAGONA = 'tarragona',
    TERUEL = 'teruel',
    TOLEDO = 'toledo',
    VALENCIA = 'valencia',
    VALLADOLID = 'valladolid',
    ZAMORA = 'zamora',
    ZARAGOZA = 'zaragoza',
    CEUTA = 'ceuta',
    MELILLA = 'melilla'
}

export class Provincia {
    /**
     * Get by enum
     */
    public static getByEnum(enumString: ProvinciaEnum): Provincia {
        return Provincia.lista.find(t => t.enumString === enumString);
    }

    public static getByName(name: String): Provincia {
        return Provincia.lista.find(t => t.name === name);
    }

    public static getByReducedName(reduced_name: String): Provincia {
        return Provincia.lista.find(t => t.reduced_name === reduced_name);
    }

    /**
     * Get by id
     */
    public static getById(id: number): Provincia {
        return Provincia.lista.find(t => t.id === id);
    }

    public static readonly lista: Provincia[] = [
        { enumString: ProvinciaEnum.ALBACETE, id: 2, name: 'Albacete', reduced_name: 'albacete' },
        { enumString: ProvinciaEnum.ALICANTE, id: 3, name: 'Alicante/Alacant', reduced_name: 'alicante' },
        { enumString: ProvinciaEnum.ALMERIA, id: 4, name: 'Almería', reduced_name: 'almeria' },
        { enumString: ProvinciaEnum.ALAVA, id: 1, name: 'Araba/Álava', reduced_name: 'alava' },
        { enumString: ProvinciaEnum.ASTURIAS, id: 33, name: 'Asturias', reduced_name: 'asturias' },
        { enumString: ProvinciaEnum.AVILA, id: 5, name: 'Ávila', reduced_name: 'avila' },
        { enumString: ProvinciaEnum.BADAJOZ, id: 6, name: 'Badajoz', reduced_name: 'badajoz' },
        { enumString: ProvinciaEnum.BALEARES, id: 7, name: 'Balears, Illes', reduced_name: 'baleares' },
        { enumString: ProvinciaEnum.BARCELONA, id: 8, name: 'Barcelona', reduced_name: 'barcelona' },
        { enumString: ProvinciaEnum.BIZKAIA, id: 48, name: 'Bizkaia', reduced_name: 'bizkaia' },
        { enumString: ProvinciaEnum.BURGOS, id: 9, name: 'Burgos', reduced_name: 'burgos' },
        { enumString: ProvinciaEnum.CACERES, id: 10, name: 'Cáceres', reduced_name: 'caceres' },
        { enumString: ProvinciaEnum.CADIZ, id: 11, name: 'Cádiz', reduced_name: 'cadiz' },
        { enumString: ProvinciaEnum.CANTABRIA, id: 39, name: 'Cantabria', reduced_name: 'cantabria' },
        { enumString: ProvinciaEnum.CASTELLON, id: 12, name: 'Castellón/Castelló', reduced_name: 'castellon' },
        { enumString: ProvinciaEnum.CIUDADREAL, id: 13, name: 'Ciudad Real', reduced_name: 'ciudadreal' },
        { enumString: ProvinciaEnum.CORDOBA, id: 14, name: 'Córdoba', reduced_name: 'cordoba' },
        { enumString: ProvinciaEnum.ACORUNA, id: 15, name: 'Coruña, A', reduced_name: 'acoruna' },
        { enumString: ProvinciaEnum.CUENCA, id: 16, name: 'Cuenca', reduced_name: 'cuenca' },
        { enumString: ProvinciaEnum.GIPUZKOA, id: 20, name: 'Gipuzkoa', reduced_name: 'gipuzkoa' },
        { enumString: ProvinciaEnum.GIRONA, id: 17, name: 'Girona', reduced_name: 'girona' },
        { enumString: ProvinciaEnum.GRANADA, id: 18, name: 'Granada', reduced_name: 'granada' },
        { enumString: ProvinciaEnum.GUADALAJARA, id: 19, name: 'Guadalajara', reduced_name: 'guadalajara' },
        { enumString: ProvinciaEnum.HUELVA, id: 21, name: 'Huelva', reduced_name: 'huelva' },
        { enumString: ProvinciaEnum.HUESCA, id: 22, name: 'Huesca', reduced_name: 'huesca' },
        { enumString: ProvinciaEnum.JAEN, id: 23, name: 'Jaén', reduced_name: 'jaen' },
        { enumString: ProvinciaEnum.LEON, id: 24, name: 'León', reduced_name: 'leon' },
        { enumString: ProvinciaEnum.LLEIDA, id: 25, name: 'Lleida', reduced_name: 'lleida' },
        { enumString: ProvinciaEnum.LUGO, id: 27, name: 'Lugo', reduced_name: 'lugo' },
        { enumString: ProvinciaEnum.MADRID, id: 28, name: 'Madrid', reduced_name: 'madrid' },
        { enumString: ProvinciaEnum.MALAGA, id: 29, name: 'Málaga', reduced_name: 'malaga' },
        { enumString: ProvinciaEnum.MURCIA, id: 30, name: 'Murcia', reduced_name: 'murcia' },
        { enumString: ProvinciaEnum.NAVARRA, id: 31, name: 'Navarra', reduced_name: 'navarra' },
        { enumString: ProvinciaEnum.OURENSE, id: 32, name: 'Ourense', reduced_name: 'ourense' },
        { enumString: ProvinciaEnum.PALENCIA, id: 34, name: 'Palencia', reduced_name: 'palencia' },
        { enumString: ProvinciaEnum.LASPALMAS, id: 35, name: 'Palmas, Las', reduced_name: 'laspalmas' },
        { enumString: ProvinciaEnum.PONTEVEDRA, id: 36, name: 'Pontevedra', reduced_name: 'pontevedra' },
        { enumString: ProvinciaEnum.LARIOJA, id: 26, name: 'Rioja, La', reduced_name: 'larioja' },
        { enumString: ProvinciaEnum.SALAMANCA, id: 37, name: 'Salamanca', reduced_name: 'salamanca' },
        { enumString: ProvinciaEnum.TENERIFE, id: 38, name: 'Santa Cruz de Tenerife', reduced_name: 'tenerife' },
        { enumString: ProvinciaEnum.SEGOVIA, id: 40, name: 'Segovia', reduced_name: 'segovia' },
        { enumString: ProvinciaEnum.SEVILLA, id: 41, name: 'Sevilla', reduced_name: 'sevilla' },
        { enumString: ProvinciaEnum.SORIA, id: 42, name: 'Soria', reduced_name: 'soria' },
        { enumString: ProvinciaEnum.TARRAGONA, id: 43, name: 'Tarragona', reduced_name: 'tarragona' },
        { enumString: ProvinciaEnum.TERUEL, id: 44, name: 'Teruel', reduced_name: 'teruel' },
        { enumString: ProvinciaEnum.TOLEDO, id: 45, name: 'Toledo', reduced_name: 'toledo' },
        { enumString: ProvinciaEnum.VALENCIA, id: 46, name: 'Valencia/València', reduced_name: 'valencia' },
        { enumString: ProvinciaEnum.VALLADOLID, id: 47, name: 'Valladolid', reduced_name: 'valladolid' },
        { enumString: ProvinciaEnum.ZAMORA, id: 49, name: 'Zamora', reduced_name: 'zamora' },
        { enumString: ProvinciaEnum.ZARAGOZA, id: 50, name: 'Zaragoza', reduced_name: 'zaragoza' },
        { enumString: ProvinciaEnum.CEUTA, id: 51, name: 'Ceuta', reduced_name: 'ceuta' },
        { enumString: ProvinciaEnum.MELILLA, id: 52, name: 'Melilla', reduced_name: 'melilla' }
    ];

    constructor(public enumString: ProvinciaEnum, public id: number, public name: string, public reduced_name: string) { }
}
