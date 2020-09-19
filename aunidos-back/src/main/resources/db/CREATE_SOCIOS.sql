CREATE TABLE socio (
    dni VARCHAR(20) primary key,
    apellidos VARCHAR(60),
    nombre VARCHAR(40),
    tel_movil VARCHAR(15) unique,
    tel_fax VARCHAR(15) unique,
    email VARCHAR(80) unique,
    domicilio VARCHAR(150),
    poblacion VARCHAR(60),
    cod_postal VARCHAR(10),
    provincia INT,
    gremio VARCHAR(40),
    fec_alta date,
    fec_baja date,
    fec_ult_modificacion date,
    verificado boolean,
    email_confirmado boolean
);