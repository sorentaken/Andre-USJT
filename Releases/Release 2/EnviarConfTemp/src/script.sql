create database Empresa;

drop table empresa;

use Empresa;

create table empresa(
empresaNome char(30) not null,
empresaCNPJ char(30) not null,
empresaRazaoSocial char(30) not null,
empresaConjunto int(5) not null,
empresaAbertura varchar(10) not null,
empresaEncerramento varchar(10) not null,
empresaTemperaturaMin int(7) not null,
empresaTemperaturaMax int(7) not null,
horarioArLigado varchar(10) not null,
horarioArDesligado varchar(10) not null)
;

insert into empresa(empresaNome,empresaCNPJ,empresaRazaoSocial,empresaConjunto,empresaAbertura,empresaEncerramento,
empresaTemperaturaMin,empresaTemperaturaMax,horarioArLigado,horarioArDesligado)
values("Empresa" , "NDKW" , "Wpk" , '2002' , "08:30" , "17:30" , 15,16 , "08:30"  ,"17:30");


select * from empresa;