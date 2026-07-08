CREATE DATABASE IF NOT EXISTS estoque_db;
USE estoque_db;

CREATE TABLE IF NOT EXISTS users (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    username     VARCHAR(100) NOT NULL UNIQUE,
    psw          VARCHAR(255) NOT NULL,
    nome         VARCHAR(50)  NOT NULL,
    sobrenome    VARCHAR(50)  NOT NULL,
    matricula    VARCHAR(100) NOT NULL UNIQUE,
    cpf          VARCHAR(14)  NOT NULL UNIQUE,
    sexo         VARCHAR(20)  NOT NULL,
    data_nasc    DATE         NOT NULL,
    email        VARCHAR(100) NOT NULL,
    telefone     VARCHAR(100) NOT NULL,
    funcao       VARCHAR(50)  NOT NULL,
    cep          VARCHAR(20)  NOT NULL,
    estado       VARCHAR(50)  NOT NULL,
    cidade       VARCHAR(50)  NOT NULL,
    endereco     VARCHAR(100) NOT NULL,
    bairro       VARCHAR(50)  NOT NULL,
    numero       VARCHAR(50)  NOT NULL,
    complemento  VARCHAR(50)
);

INSERT IGNORE INTO users (
    username,
    psw,
    nome,
    sobrenome,
    matricula,
    cpf,
    sexo,
    data_nasc,
    email,
    telefone,
    funcao,
    cep,
    estado,
    cidade,
    endereco,
    bairro,
    numero,
    complemento
)
VALUES (
    'admin',
    '$2a$10$3IQDugIm9lk4oqoZ6IPCpuGSLLVo/HNEk8PpZsXmIwSInEtoRofnC',
    'Hugo',
    'Pamponet',
    '20260708001',
    '529.982.247-25',
    '1',
    '1994-06-09',
    'hugopomponet@gmail.com',
    '(71) 98765-4321',
    'ADMIN',
    '40140-110',
    'BA',
    'Salvador',
    'Avenida Sete de Setembro',
    'Barra',
    '34',
    'de 3579 ao fim - lado impar'
);

CREATE TABLE IF NOT EXISTS produtos (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    codigo_barras   VARCHAR(100)    NOT NULL,
    nome_produto    VARCHAR(255)    NOT NULL,
    fabricante      VARCHAR(255)    NOT NULL,
    marca           VARCHAR(255)    NOT NULL,
    data_fabricacao DATE,
    data_vencimento DATE,
    quantidade      BIGINT,
    valor           DECIMAL(10, 2),
    total           DECIMAL(10, 2),
    status          VARCHAR(100)
);
