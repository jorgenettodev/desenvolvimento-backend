CREATE DATABASE db_escola_tech;

use db_escola_tech;

CREATE TABLE tb_endereco (
	id INT AUTO_INCREMENT PRIMARY KEY, logradouro VARCHAR(255),
    bairro VARCHAR(255), numero INT, uf CHAR(2), pais VARCHAR(255));
    
describe tb_endereco;

CREATE TABLE tb_filial (
	id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255), cnpj CHAR(14), 
    id_endereco INT
);

ALTER TABLE tb_filial
	ADD CONSTRAINT FK_id_endereco
    FOREIGN KEY (id_endereco) REFERENCES tb_endereco(id);
    
describe tb_filial;

INSERT INTO tb_endereco VALUES (default, 'Rua A', 'Bairro B', 127, 'AL', 'Brasil');
select * from tb_endereco;
select * from tb_filial;

INSERT INTO tb_filial VALUES (
	default, 'Filial 1', '123456789014', 1
);
