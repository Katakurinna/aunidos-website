CREATE TABLE cod_verificacion (
    id INT PRIMARY KEY auto_increment,
    dni VARCHAR(20),
    codigo VARCHAR(10),
    fec_cad DATE,
    FOREIGN KEY (dni) REFERENCES socio(dni)
);