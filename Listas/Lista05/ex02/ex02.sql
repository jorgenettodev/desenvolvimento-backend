create database db_floricultura;

use db_floricultura;

create table tb_flores(id int primary key, especie varchar(255), preco decimal(6,2));

insert into tb_flores values(1, "Rosa", 155);
insert into tb_flores values(2, "Girassol", 200);

select * from tb_flores;