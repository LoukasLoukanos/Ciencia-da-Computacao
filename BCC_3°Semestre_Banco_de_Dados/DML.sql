/* Neste arquivo são apresentados exemplos de uso dos comandos INSERT, UPDATE e 
   DELETE da linguagem de operação DML(Linguagem de Manipulação de Dados) da SQL.*/


/* (COMANDO INSERT)______________________________________
Usado para inserir dados nas tabelas.

Sintaxe:*/
INSERT INTO nome_da_tabela (nome_da_coluna,nome_da_coluna)
VALUES(valor_da_coluna,valor_da_coluna)

/*Ex 1:*/
INSERT INTO pais (cd_pais, nm_pais)
VALUES (1,'Brasil')

/*Ex 2:*/
INSERT INTO pais (cd_pais, nm_pais, ds_nacionalidade)
VALUES (2, 'Argentina',null);

/*Ex 3:*/
INSERT INTO pais
VALUES (4, 'Chile', 'Chilena');

/*Ex 4:*/
INSERT INTO pais (nm_pais, ds_nacionalidade, cd_pais)
VALUES ('EUA', 'Americana' ,3);

/* (COMANDO UPDATE)______________________________________
Usado para modificar a(s) linha(s) existentes das tabelas

Sintaxe:*/
UPDATE Tabela
SET COLUNA = Valor
UPDATE  Condição

/*Ex 1:*/
UPDATE Pais
SET Nm_pais='Portugal', Ds_nacionalidade='Portug'
UPDATE  Cd_pais = 3;

/*Ex 2:*/
UPDATE Pais
SET Ds_nacionalidade='Portuguesa'
UPDATE Cd_pais = 3;


/* (COMANDO DELETE)______________________________________
Usado para remover a(s) linha(s) existente(s) de tabelas.

Observações:
• Verifique os nomes das colunas com o comando DESCRIBE.
• Confirme  a  operação  de  atualização  pela  visualização  
  das  linhas  a  serem  atualizadas com o comando SELECT.
• Nunca omita a cláusula WHERE. No caso da omissão, todos os 
  registros da tabela serão eliminados.

Sintaxe:*/
DELETE FROM Tabela
WHERE Condição

/*Exemplo:*/
DELETE FROM Pais 
WHERE Cd_pais = 3;
