/* Neste arquivo são apresentados exemplos de uso dos comandos CREATE, ALTER e DROP do subconjunto DDL(Linguagem de Definição de Dados) da SQL.


    Tipos de Dados:
    CHAR(n)        Campo fixo com tamanho máximo de 2000 bytes.
    DATE           Permite data entre 1 de janeiro de 4712 AC até 31 de dezembro de 4712 DC
    LONG           Caractere variável com tamanho de até 2 Gb
    VARCHAR2(n)    Campo do tipo caractere com tamanho variável e limitado a 4000 bytes.
    NUMBER(n,d)    Onde n é o número de dígitos e d o número de casas decimais.


__(COMANDO CREATE)________________________________________________________________________________________________________

    RESTRIÇÕES - CONSTRAINT_:
    As restrições são regras básicas estabelecidas para o preenchimento de uma ou mais colunas
    da tabela e são definidas ao final da especificação de cada coluna ou ao final do comando.

____CONSTRAINT PRIMARY KEY:________________________________________________________________________
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


/*____CONSTRAINT PRIMARY KEY COMPOSTA:_____________________________________________________________
    PK (Primary Key) composta por 2 atributos: cd_cliente e dt_compra*/
CREATE TABLE Histórico
(
cd_cliente number (4),
dt_compra date,
vl_compra number (12,2),
CONSTRAINT Historico_PK PRIMARY KEY (cd_cliente, dt_Compra)
/*Constraint nometabela_tipo da constraint (nomecampo, nomecampo)*/
)


/*____CONSTRAINT UNIQUE____________________________________________________________________________
    Define uma ou mais colunas que não podem ter valor repetido em mais de uma linha da tabela.*/
CREATE TABLE Estado
(
Sg_Estado char(2) primary key,
Nm_Estado varchar2 (35),
constraint Estado_nm_Estado_UN UNIQUE (nm_Estado)
/*Constraint nometabela_nomecampo_tipo da constraint(nomecampo)*/
)


/*____CONSTRAINT FOREIGN KEY_______________________________________________________________________
    Referencia um atributo que é chave primária de outra tabela com o propósito de implementar 
    o relacionamento entre tabelas.

    Regras:
    •Caso o tipo de dados da coluna na tabela inicial e na tabela referenciada sejam diferentes, 
     será apresentado um erro;
    •Caso a tabela referenciada não possua chave primária (a foreign key será estabelecida sobre 
     a chave primária da tabela referenciada);
    •O uso de chaves estrangeiras garante que não existirão linhas órfãs nas tabelas-filhas (tabelas 
     que possuem dados que devem estar cadastrados previamente em outra tabela, denominada 
     tabela mãe)*/

CREATE TABLE Cliente
(
cd_cliente   number (4),
nm_cliente  varchar2 (50),
ds_endereco  varchar2 (70),
cd_municipio  number (5),
sg_estado  char (2),
nr_cep  varchar2 (8),
nr_ddd  number (3),
nr_fone  number(7),
ie_sexo        char(1),
constraint cliente_sg_estado_fk foreign key (sg_estado) references Estado(sg_estado)
/*Constraint  tabela_campo_tipo constraint(coluna) referenciando tabela(coluna-dareferenciada)*/
)


/*____CONSTRAINT CHECK_____________________________________________________________________________
    Define  um  conjunto  de  valores  permitidos  ou  condição  para  inserção  de  valores  em  uma  
    determinada coluna.*/

CREATE TABLE Cliente
(
cd_cliente   number (4),
nm_cliente  varchar2 (50),
ds_endereco  varchar2 (70),
cd_municipio  number (5),
sg_estado  char (2),
nr_cep  varchar2 (8),
nr_ddd  number (3),
nr_fone  number(7),
ie_sexo  char(1),
constraint cliente_ie_sexo_ck check(ie_sexo in ('F','M'))
/*Constraint  tabela_coluna_tipo constraint(coluna (valores permitidos))*/
)


/*____CONSTRAINT NOT NULL_________________________________________________________________________
    Indica que é obrigatória a inserção de algum valor nessa coluna. Somente pode ser declarado 
    junto à coluna e não recebe nome da restrição.*/

CREATE TABLE Cliente
(
cd_cliente   number (4),
nm_cliente  varchar2 (50) not null,
ds_endereco  varchar2 (70) not null,
cd_municipio  number (5),
sg_estado  char (2),
nr_cep  varchar2 (8),
nr_ddd  number (3),
nr_fone  number(7),
ie_sexo  char(1)
)


/* (COMANDO ALTER e DROP + COMANDO RENAME)________________________________________________________________________________
    Alterações no tipo, na obrigatoriedade, no tamanho e nas restrições dos dados
    de tabelas são feitas com o comando ALTER da DDL-Linguagem de Definição de Dados.
    Para inserir, alterar e deletar dados em uma tabela usa-se os comandos INSERT, 
    UPDATE e DELETE da DML-Linguagem de Manipulação de Dados.


 (COMANDO ALTER) :
Operações ADD (para incluir), DROP (para excluir), 
MODIFY (para modificar), DISABLE (para desabilitar)*/

/*Acrescentar campos em uma tabela*/
ALTER TABLE CLIENTE
ADD( IE_FISICA_JURIDICA CHAR(1))

/*Alterando obrigatoriedade de atributos em uma tabela.*/
ALTER TABLE CLIENTE 
MODIFY (nm_cliente not null);

/*Modificando o tipo de atributos em uma tabela.*/
ALTER TABLE CLIENTE
MODIFY (DS_ENDERECO NUMBER(3));

/*Modificando o tamanho dos atributos em uma tabela.*/
ALTER TABLE CLIENTE
MODIFY (NR_CEP VARCHAR2(12)); 

/*Acrescentar restrições a uma tabela.*/
ALTER TABLE CLIENTE
ADD(CONSTRAINT CLIENTE_IE_FISICA_JURIDICA_CK
CHECK(IE_FISICA_JURIDICA IN('F','J')));

/*Desabilitar uma restrição de uma tabela.*/
ALTER TABLE CLIENTE
DISABLE CONSTRAINT  CLIENTE_IE_FISICA_JURIDICA_CK; 

/*Excluir uma restrição de uma tabela.*/
ALTER TABLE CLIENTE
DROP CONSTRAINT CLIENTE_IE_FISICA_JURIDICA_CK


/* (COMANDO DROP)
Exclusão de Tabela:
 Após a criação da estrutura de uma tabela ou alteração da 
sua estrutura, podemos excluí-la através do comando DROP.
 Ao excluir uma tabela, todas as constraints e os dados 
inseridos são deletados fisicamente.*/
DROP TABLE CLIENTE.


/* (COMANDO RENAME) 
Alteração de nome das tabelas:*/
RENAME Pais TO Tb_Pais
