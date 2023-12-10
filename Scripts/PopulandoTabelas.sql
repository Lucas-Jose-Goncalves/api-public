 
insert into curso (plataforma, sigla_curso, formacao, nome_curso, data_cadastramento) values
  ('MOODLE', 'AAAAA4', 'FORMACAO_BASICA', 'Projeto Final', '2023-11-28 00:00:00.000'),
  ('MOODLE', 'AAAA2', 'FORMACAO_BASICA', 'Projeto Final', '2023-11-28 00:00:00.000'),
  ('MOODLE', 'AAAAA6', 'FORMACAO_BASICA', 'Desenvolvimento', '2023-11-29 00:00:00.000'),
  ('RISE', 'BBBBB1', 'FORMACAO_AVANCADA', 'Inteligência ', '2023-11-29 00:00:00.000'),
  ('RISE', 'BBBBB2', 'FORMACAO_AVANCADA', 'Ciência ', '2023-11-30 00:00:00.000'),
  ('MOODLE', 'CCCCC1', 'FORMACAO_BASICA', 'Machine ', '2023-11-30 00:00:00.000'),
  ('MOODLE', 'CCCCC2', 'FORMACAO_AVANCADA', 'Segurança ', '2023-12-01 00:00:00.000'),
  ('RISE', 'DDDDD1', 'FORMACAO_BASICA', 'HTML e CSS', '2023-12-01 00:00:00.000'),
  ('MOODLE', 'DDDDD2', 'FORMACAO_BASICA', 'JavaScript', '2023-12-02 00:00:00.000'),
  ('RISE', 'DDDDD3', 'FORMACAO_AVANCADA', 'Desenvolvimento', '2023-12-02 00:00:00.000');
 
 insert into grupo (nome_grupo, sigla_grupo, data_criacao, data_encerramento) values
  ('Grupo5', 'AAAA5', '2023-11-28 00:00:00.000', '2023-12-31 00:00:00.000'),
  ('Grupo12', 'AAAA1', '2023-11-28 00:00:00.000', '2023-12-31 00:00:00.000'),  
  ('Grupo6', 'AAAA6', '2023-11-29 00:00:00.000', '2023-12-31 00:00:00.000'),
  ('Grupo7', 'BBBB1', '2023-11-29 00:00:00.000', '2023-12-31 00:00:00.000'),
  ('Grupo8', 'BBBB2', '2023-11-30 00:00:00.000', '2023-12-31 00:00:00.000'),
  ('Grupo9', 'CCCC1', '2023-11-30 00:00:00.000', '2023-12-31 00:00:00.000'),
  ('Grupo10', 'CCCC2', '2023-12-01 00:00:00.000', '2023-12-31 00:00:00.000'),
  ('Grupo11', 'DDDD1', '2023-12-01 00:00:00.000', '2023-12-31 00:00:00.000'),
  ('Grupo13', 'DDDD2', '2023-12-02 00:00:00.000', '2023-12-31 00:00:00.000'),
  ('Grupo14', 'DDDD3', '2023-12-02 00:00:00.000', '2023-12-31 00:00:00.000'); 
 
 insert into participante (tipo, sigla_tipo, identificador, nome, email, data_cadastro) values
  ('COLABORADOR', 'COL', 'a2', 'Fulano Colaborador', 'fulano.colaborador@gmail.com', '2023-12-08 00:00:00.000'),
  ('ESTAGIARIO', 'EST', 'b2', 'Beltrano Estagiário', 'beltrano.estagiario@gmail.com', '2023-12-08 00:00:00.000'),
  ('TRAINEE', 'TRA', 'c3', 'Ciclano Trainee', 'ciclano.trainee@gmail.com', '2023-12-08 00:00:00.000'),
  ('EXTERNO', 'EXT', 'd4', 'Deltano Externo', 'deltano.externo@gmail.com', '2023-12-08 00:00:00.000'),
  ('SERRATEC', 'SER', 'e5', 'Eletrano Serratec', 'eletrano.serratec@gmail.com', '2023-12-08 00:00:00.000'),
  ('COLABORADOR', 'COL', 'f6', 'Fernanda Colaboradora', 'fernanda.colaboradora@gmail.com', '2023-12-08 00:00:00.000'),
  ('ESTAGIARIO', 'EST', 'g7', 'Gabriel Estagiário', 'gabriel.estagiario@gmail.com', '2023-12-08 00:00:00.000'),
  ('TRAINEE', 'TRA', 'h8', 'Helena Trainee', 'helena.trainee@gmail.com', '2023-12-08 00:00:00.000'),
  ('EXTERNO', 'EXT', 'i9', 'Isabel Externa', 'isabel.externa@gmail.com', '2023-12-08 00:00:00.000'),
  ('SERRATEC', 'SER', 'j10', 'José Serratec', 'jose.serratec@gmail.com', '2023-12-08 00:00:00.000'),
  ('COLABORADOR', 'COL', 'k11', 'Karina Colaboradora', 'karina.colaboradora@gmail.com', '2023-12-08 00:00:00.000');
 
 
insert into inscricao (sequencia, data_registro, data_inicio_curso, data_encerramento_curso, ultimo_acesso, horas_estudo,
situacao, data_situacao, motivo, nota_final, estado, data_conclusao, sigla_do_curso, sigla_do_grupo, identificador_participante) values
  (1, '2023-11-28 00:00:00.000', '2023-11-28 00:00:00.000', '2023-12-31 00:00:00.000', '2023-11-28 00:00:00.000', '10', 'N', null, null, null, null, null, 'AAAAA4', 'AAAA5', 'a2'),
  (2, '2023-11-28 00:00:00.000', '2023-11-28 00:00:00.000', '2023-12-31 00:00:00.000', '2023-11-28 00:00:00.000', '15', 'N', null, null, null, null, null, 'AAAA2', 'AAAA1', 'a2'),
  (3, '2023-11-29 00:00:00.000', '2023-11-29 00:00:00.000', '2023-12-31 00:00:00.000', '2023-11-29 00:00:00.000', '20', 'N', null, null, null, null, null, 'AAAAA6', 'AAAA6', 'b2'),
  (4, '2023-11-29 00:00:00.000', '2023-11-29 00:00:00.000', '2023-12-31 00:00:00.000', '2023-11-29 00:00:00.000', '25', 'N', null, null, null, null, null, 'BBBBB1', 'BBBB1', 'c3'),
  (5, '2023-11-30 00:00:00.000', '2023-11-30 00:00:00.000', '2023-12-31 00:00:00.000', '2023-11-30 00:00:00.000', '30', 'N', null, null, null, null, null, 'BBBBB2', 'BBBB2', 'd4'),
  (6, '2023-11-30 00:00:00.000', '2023-11-30 00:00:00.000', '2023-12-31 00:00:00.000', '2023-11-30 00:00:00.000', '35', 'N', null, null, null, null, null, 'CCCCC1', 'CCCC1', 'e5'),
  (7, '2023-12-01 00:00:00.000', '2023-12-01 00:00:00.000', '2023-12-31 00:00:00.000', '2023-12-01 00:00:00.000', '40', 'N', null, null, null, null, null, 'CCCCC2', 'CCCC2', 'f6'),
  (8, '2023-12-01 00:00:00.000', '2023-12-01 00:00:00.000', '2023-12-31 00:00:00.000', '2023-12-01 00:00:00.000', '45', 'N', null, null, null, null, null, 'DDDDD1', 'DDDD1', 'g7'),
  (9, '2023-12-02 00:00:00.000', '2023-12-02 00:00:00.000', '2023-12-31 00:00:00.000', '2023-12-02 00:00:00.000', '50', 'N', null, null, null, null, null, 'DDDDD2', 'DDDD2', 'h8'),
  (10, '2023-12-02 00:00:00.000', '2023-12-02 00:00:00.000', '2023-12-31 00:00:00.000', '2023-12-02 00:00:00.000', '55', 'N', null, null, null, null, null, 'DDDDD3', 'DDDD3', 'i9');
