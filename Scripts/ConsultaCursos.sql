-- esse foi o código usado para fazer o teste da query 
select c.sigla_curso as sigla_do_curso,
       g.sigla_grupo as sigla_do_grupo,
       p.nome as nome_participante,
       i.data_inicio_curso,
       i.ultimo_acesso,
       i.horas_estudo,
       i.situacao,
       i.data_situacao,
       i.motivo,
       i.nota_final,
       i.estado,
       i.data_conclusao      
       
FROM Inscricao i
join curso c ON i.sigla_do_curso = c.sigla_curso
join grupo g on i.sigla_do_grupo = g.sigla_grupo 
join participante p on i.identificador_participante = p.identificador

WHERE c.sigla_curso = 'AAAAA2'; --sigla do curso passada como teste "AAAAA2"
