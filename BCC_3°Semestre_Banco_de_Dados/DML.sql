
/*Neste arquivo são apresentados exemplos de uso dos comandos CREATE, ALTER 
e DROP do subconjunto DDL(Linguagem de Definição de Dados) da SQL.*/


/*############################### RESTRIÇÕES - CONSTRAINT ################################
As restrições são regras básicas estabelecidas para o preenchimento de uma ou mais colunas
da tabela e são definidas ao final da especificação de cada coluna ou ao final do comando.*/


/*____CONSTRAINT PRIMARY KEY:_______________________________________________
Especifica uma ou mais colunas que compõem a chave primária de uma tabela.*/
CREATE TABLE Cliente
(
/*nome_coluna tipo_dado*/
cd_cliente number (4),
nm_cliente varchar2 (50),
ds_endereco varchar2 (70),
cd_municipio number (5),
sg_estado char (2),
nr_cep varchar2 (8),
nr_ddd number (3),
nr_fone number (7),
ie_sexo char (1),
constraint cliente_cd_cliente_pk primary key (cd_cliente)
/*Constraint nometabela_nomecampo_tipo da constraint(nomecampo)*/
)


/*____CONSTRAINT PRIMARY KEY COMPOSTA:_____________________________
PK (Primary Key) composta por 2 atributos: cd_cliente e dt_compra*/
CREATE TABLE Histórico
(
cd_cliente number (4),
dt_compra date,
vl_compra number (12,2),
CONSTRAINT Historico_PK PRIMARY KEY (cd_cliente, dt_Compra)
/*Constraint nometabela_tipo da constraint (nomecampo, nomecampo)*/
)


/*____CONSTRAINT UNIQUE______________________________________________________________________
Define uma ou mais colunas que não podem ter valor repetido em mais de uma linha da tabela.*/
CREATE TABLE Estado
(
Sg_Estado char(2) primary key,
Nm_Estado varchar2 (35),
constraint Estado_nm_Estado_UN UNIQUE (nm_Estado)
/*Constraint nometabela_nomecampo_tipo da constraint(nomecampo)*/
)
