USE estoque_db;

CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    psw VARCHAR(100) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    matricula VARCHAR(100) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    sexo VARCHAR(20) NOT NULL,
    data_nasc DATE NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    funcao VARCHAR(50) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    numero VARCHAR(50) NOT NULL,
    complemento VARCHAR(50)
);

INSERT INTO users(
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
VALUES(
    'admin', 
    '1234', 
    'Roberto', 
    'Santos Ferreira', 
    '00011234', 
    '954.432.600-10', 
    'Masculino',
    '1990-05-15',
    'roberto_ferreira32@gmail.com', 
    '(71) 98876-5432', 
    'Analista Administrativo',
     '41830-020', 
    'BA',
    'Salvador',
    'Avenida Tancredo Neves', 
    'Caminho das Árvores', 
    '1500', 
    'Sala 1203, Torre Norte'
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo_barras VARCHAR(100) NOT NULL,
    nome_produto VARCHAR (255) NOT NULL,
    fabricante VARCHAR (255) NOT NULL,
    marca VARCHAR (255) NOT NULL,
    data_fabricante (225) DATE,
    data_vencimento (255) DATE,
    quantidade BIGINT,
    valor DECIMAL (10,2),
    total DECIMAL (10,2),
    status VARCHAR (100)
   
);