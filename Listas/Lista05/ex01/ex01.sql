create database db_empresa_eventos;
use db_empresa_eventos;

create table tb_eventos(id int primary key, nome varchar(255), localizacao varchar(255), preco_ingresso decimal (6,2));

insert into tb_eventos values(1,"hackaton", "arapiraca - al", 0);
insert into tb_eventos values(2, "DevFest", "Arapiraca - AL", 40);