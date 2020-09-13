package me.cerratolabs.aunidosredirect.enums;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public enum Provincia {
    ALBACETE(2, "Albacete", "albacete"),
    ALICANTE(3, "Alicante/Alacant", "alicante"),
    ALMERIA(4, "Almería", "almeria"),
    ALAVA(1, "Araba/Álava", "alava"),
    ASTURIAS(33, "Asturias", "asturias"),
    AVILA(5, "Ávila", "avila"),
    BADAJOZ(6, "Badajoz", "badajoz"),
    BALEARES(7, "Balears, Illes", "baleares"),
    BARCELONA(8, "Barcelona", "barcelona"),
    BIZKAIA(48, "Bizkaia", "bizkaia"),
    BURGOS(9, "Burgos", "burgos"),
    CACERES(10, "Cáceres", "caceres"),
    CADIZ(11, "Cádiz", "cadiz"),
    CANTABRIA(39, "Cantabria", "cantabria"),
    CASTELLON(12, "Castellón/Castelló", "castellon"),
    CIUDADREAL(13, "Ciudad Real", "ciudadreal"),
    CORDOBA(14, "Córdoba", "cordoba"),
    ACORUNA(15, "Coruña, A", "acoruna"),
    CUENCA(16, "Cuenca", "cuenca"),
    GIPUZKOA(20, "Gipuzkoa", "gipuzkoa"),
    GIRONA(17, "Girona", "girona"),
    GRANADA(18, "Granada", "granada"),
    GUADALAJARA(19, "Guadalajara", "guadalajara"),
    HUELVA(21, "Huelva", "huelva"),
    HUESCA(22, "Huesca", "huesca"),
    JAEN(23, "Jaén", "jaen"),
    LEON(24, "León", "leon"),
    LLEIDA(25, "Lleida", "lleida"),
    LUGO(27, "Lugo", "lugo"),
    MADRID(28, "Madrid", "madrid"),
    MALAGA(29, "Málaga", "malaga"),
    MURCIA(30, "Murcia", "murcia"),
    NAVARRA(31, "Navarra", "navarra"),
    OURENSE(32, "Ourense", "ourense"),
    PALENCIA(34, "Palencia", "palencia"),
    LASPALMAS(35, "Palmas, Las", "laspalmas"),
    PONTEVEDRA(36, "Pontevedra", "pontevedra"),
    LARIOJA(26, "Rioja, La", "larioja"),
    SALAMANCA(37, "Salamanca", "salamanca"),
    TENERIFE(38, "Santa Cruz de Tenerife", "tenerife"),
    SEGOVIA(40, "Segovia", "segovia"),
    SEVILLA(41, "Sevilla", "sevilla"),
    SORIA(42, "Soria", "soria"),
    TARRAGONA(43, "Tarragona", "tarragona"),
    TERUEL(44, "Teruel", "teruel"),
    TOLEDO(45, "Toledo", "toledo"),
    VALENCIA(46, "Valencia/València", "valencia"),
    VALLADOLID(47, "Valladolid", "valladolid"),
    ZAMORA(49, "Zamora", "zamora"),
    ZARAGOZA(50, "Zaragoza", "zaragoza"),
    CEUTA(51, "Ceuta", "ceuta"),
    MELILLA(52, "Melilla", "melilla");
    private Integer id;
    private String name;
    private String reduced_name;
    private Map<Integer, Provincia> MAP_CACHE_ID;
    private Map<String, Provincia> MAP_CACHE_NAME;
    private Map<String, Provincia> MAP_CACHE_REDUCED_NAME;

    {
        MAP_CACHE_ID = new HashMap<>();
        MAP_CACHE_NAME = new HashMap<>();
        MAP_CACHE_REDUCED_NAME = new HashMap<>();
        for (Provincia prov : Provincia.values()) {
            MAP_CACHE_ID.put(prov.id, prov);
            MAP_CACHE_NAME.put(prov.name, prov);
            MAP_CACHE_REDUCED_NAME.put(prov.reduced_name, prov);
        }


    }

    Provincia(Integer id, String name, String reduced_name) {
        this.id = id;
        this.name = name;
        this.reduced_name = reduced_name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Provincia getEnumById(Integer id) {
        return MAP_CACHE_ID.get(id);
    }

    public Provincia getEnumByName(String name) {
        return MAP_CACHE_NAME.get(name);
    }

    public Provincia getEnumByReducedName(String reduced_name) {
        return MAP_CACHE_REDUCED_NAME.get(reduced_name);
    }

}