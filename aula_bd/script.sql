CREATE DATABASE IF NOT EXISTS aula_bd;
USE aula_bd;

CREATE TABLE IF NOT EXISTS contato (
    id_contato INT AUTO_INCREMENT PRIMARY KEY,
    nome_contato VARCHAR(100) NOT NULL,
    cel_contato VARCHAR(20),
    email_contato VARCHAR(100),
    data_nasc_contato DATE
);

CREATE TABLE IF NOT EXISTS produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    quantidade_estoque INT NOT NULL
);

CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100)
);
