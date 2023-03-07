create schema restaurante;

use restaurante;

DROP TABLE cliente;
DROP TABLE comanda;
DROP TABLE produtos;
DROP TABLE produto_comanda;
DROP TABLE endereco;

CREATE TABLE cliente (
    ID bigint auto_increment,
    NOME varchar(80),
    EMAIL varchar(80),
    PRIMARY KEY (ID)
);


CREATE TABLE comanda (
    ID bigint auto_increment,
    ID_CLIENTE bigint,
    STATUS_COMANDA varchar(1),
    PRIMARY KEY (ID)
);

CREATE TABLE produtos (
    ID bigint auto_increment,
    NOME varchar(40),
    PRECO decimal(20,2),
    PRIMARY KEY (ID)
);

CREATE TABLE produto_comanda (
    ID bigint auto_increment,
    ID_PRODUTO bigint,
    ID_COMANDA bigint,
    QUANTIDADE bigint,
    PRIMARY KEY (ID)
);

CREATE TABLE endereco (
    ID bigint auto_increment,
    ID_CLIENTE bigint,
    CEP varchar(100),
    ADDRESS varchar(100),
    STATE varchar(100),
    CITY varchar(100),
    PRIMARY KEY (ID)
);

SELECT * FROM cliente;

SELECT * FROM comanda;

SELECT * FROM produtos;

SELECT * FROM produto_comanda;

SELECT * FROM ENDERECO;