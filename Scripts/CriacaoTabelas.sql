create table curso (
id_curso SERIAL primary key,
plataforma VARCHAR(255) not null,
sigla_curso VARCHAR(6) unique not null,
formacao VARCHAR(255) not null,
nome_curso VARCHAR(20) not null,
data_cadastramento TIMESTAMP not null
);

create table grupo (
id_grupo SERIAL primary key,
nome_grupo VARCHAR(20) unique not null,
sigla_grupo VARCHAR(5) unique not null,
data_criacao TIMESTAMP not null,
data_encerramento TIMESTAMP not null
);

create table participante (
participante_id SERIAL primary key,
tipo VARCHAR(20) not null,
sigla_tipo VARCHAR(255),
identificador VARCHAR(5) unique not null,
nome VARCHAR(40) not null,
email VARCHAR(255) unique not null,
data_cadastro TIMESTAMP not null
);

create table inscricao (
id_inscricao serial primary key,
sequencia varchar(255),
data_registro timestamp,
data_inicio_curso timestamp,
data_encerramento_curso timestamp,
ultimo_acesso timestamp,
horas_estudo integer,
situacao varchar(60),
data_situacao timestamp,
motivo varchar(255),
nota_final float,
estado varchar(60) ,
data_conclusao timestamp,
sigla_do_curso varchar(20) not null,
sigla_do_grupo varchar(20),
identificador_participante varchar(20) not null,
foreign key (sigla_do_curso) references curso(sigla_curso),
foreign key (sigla_do_grupo) references grupo(sigla_grupo),
foreign key (identificador_participante) references participante(identificador)
);


create table usuario (
id_usuario serial primary key,
nome varchar(60),
email varchar(60),
senha varchar(255)
);

create table perfil (
id_perfil serial primary key,
nome varchar(40)
);

create table usuario_perfil (
id_usuario int references usuario (id_usuario),
id_perfil int references perfil(id_perfil),
data_criacao date,
constraint pk_usuario_perfil primary key (id_usuario,
id_perfil)
);

insert
into
perfil (id_perfil,
nome)
values
(1,
'ADMIN'),
(2,
'USER');