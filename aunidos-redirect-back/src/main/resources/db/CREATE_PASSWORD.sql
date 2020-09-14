CREATE TABLE password
(
    provincia INT primary key,
    password  VARCHAR(150),
    FOREIGN KEY (provincia) REFERENCES provincia (id)
);