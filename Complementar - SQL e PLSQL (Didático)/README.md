# **LINGUAGENS DE OPERAÇÕES DA SQL** 
  
 ### **DDL - LINGUAGEM DE DEFINIÇÃO DE DADOS** 
  
 ***Comandos:***  
 ```sql 
 CREATE /*Criar tabelas (TABLE):*/ 
     CONSTRAINTS /*Definir colunas, seus tipos de dados e restrições*/ 
      
 ALTER /*Alterar tipo, obrigatoriedade, tamanho e restrições dos dados de tabelas:*/ 
     ADD /*Para incluir*/ 
     DROP /*Para excluir*/ 
     MODIFY /*Para modificar*/ 
     DISABLE /*Para desabilitar*/ 
  
 DROP /*Excluir tabela (TABLE)*/ 
     RENAME /*para alterar o nome*/ 
 ``` 
  
 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DDL.sql">Exemplos DDL</a> | 
 |:-:| 
  
 </br> 
  
 ### **DML - LINGUAGEM DE MANIPULAÇÃO DE DADOS** 
  
 ***Comandos:*** 
 ```sql 
 INSERT 
     /*Inserir dados — VALUES —, em uma tabela — INTO —*/ 
  
 UPDATE 
     /*Atualizar linhas de colunas — SET —*/ 
  
 DELETE 
     /*Excluir linhas de colunas — FROM —*/ 
 ``` 
  
 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DML.sql">Exemplos DML</a> | 
 |:-:| 
  
 </br> 
  
 ### **DQL - LINGUAGEM DE CONSULTA DE DADOS** 
  
 ***Comandos:*** 
 ```sql 
 SELECT  
   /*1. Visualizar linhas de SUBQUERY/INNERQUERY (sub pesquisa) e QUERYPRINCIPAL/OUTERQUERY (pesquisa principal):*/ 
    WHERE /*Cláusula para condições*/ 
    ORDER BY /*Cláusula para ordenanças*/ 
    DISTINCT /*Cláusula para distinções*/ 
  
   /*2. Manipular informações:*/ 
     CREATE TABLE AS SELECT /*Fazer cópias de tabelas*/ 
     DECODE e CASE /*Expressões para gerar colunas de consultas*/ 
     GROUP BY /*Cláusula para produzir grupos de dados gerando sumários*/ 
     HAVING /*Cláusula para estabelecer condições para listar grupos de dados*/ 
 ``` 
  
 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DQL.sql">Exemplos DQL</a> | 
 |:-:| 
  
 </br> 
  
 ### **DTL - LINGUAGEM DE TRANSAÇÃO DE DADOS** 
  
 ***Comandos:*** 
 ```sql 
 BEGIN  
     /*Iniciar transação de informação*/ 
  
 COMMIT  
     /*Terminar transação gravando as alterações realizadas*/ 
  
 ROLLBACK  
     /*Terminar transação revertendo as alterações realizadas*/ 
 ``` 
  
 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DTL.sql">Exemplos DTL</a> | 
 |:-:| 
  
 </br> 
  
 ### **DCL - LINGUAGEM DE CONTROLE DE DADOS** 
  
 ***Comandos:*** 
 ```sql 
 GRANT 
     /*Adicionar novas permissões a um usuário ao banco de dados*/ 
  
 REVOKE 
     /*Remover o acesso de um usuário ao banco de dados*/ 
  
 DENY 
     /*Impedir que um usuário receba uma permissão específica*/ 
 ``` 
  
 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DCL.sql">Exemplos DCL</a> | 
 |:-:|

</br> 

# **PL/SQL (Program Language SQL)**
*PL/SQL é a linguagem de programação da Oracle que permite efetuar transações, como a DTL, porém com muitas funcionalidades:*
 - Criar variáveis herdando o tipo e tamanho de outras variáveis ou objetos do banco de dados tais como tabelas;
 - Utilizar comandos de repetição e comparação;
 - Tratar operações de erros;
 - Criar cursores para tratamento de resultados de pesquisas e criar registros para armazenar resultados de cursores:
   (Usa-se um cursor para buscar linhas retornadas por uma consulta, uma por vez:
    - Cursores Implícitos (IS)    →   declarado e gerenciado pelo oracle
    - Cursores Explícitos (AS)    →   declarado e gerenciado pelo programador)
    
### **SINTAXE GERAL**
```sql
DECLARE /* Declarações (opcional)*/
    /* Variáveis, cursores, constantes, tabelas, estruturas, exceptions. */

BEGIN /* Operações SQL e PL/SQL (obrigatório) */
    /* SQL operações */
    /* PL/SQL operações */
    EXCEPTION /* tratamento de exceções (opcional) */
        /* Ações que deverão ser executadas quando ocorrer erros */

END; /* (obrigatório) */

```

 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/PL-SQL.sql">Exemplos PL/SQL</a> | 
 |:-:| 
  
 </br> 
  

### **CURSOR**
*Um cursor é uma estrutura de dados que permite percorrer e manipular os resultados de uma consulta SQL de forma sequencial. Um cursor pode ser visto como um ponteiro para um conjunto de registros retornados por uma consulta.*
#### **Sintaxe:**
```sql
DECLARE /* Declarações (opcional) */
    CURSOR CURSOR_EXEMPLO IS /* um cursor implícito (IS) declarado e gerenciado pelo oracle */
                             /* (↑IS ou AS↓) */
    CURSOR CURSOR_EXEMPLO AS /* declara um cursor Explícito (AS) — declarado e gerenciado pelo programador */
BEGIN /* Operações SQL e PL/SQL (obrigatório) */
    OPEN CURSOR_EXEMPLO; /* abre o cursor IS/AS, ou seja, busca as linhas retornadas pelas consultas */
    /* Aqui define-se as operções do cursor que foi declarado */
    CLOSE CURSOR_EXEMPLO; /* Fecha cursor IS/AS */
END; /* (obrigatório) */
```

 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/PL-Cursor.sql">Exemplos CURSOR</a> | 
 |:-:| 
  
 </br> 
  

### **STORED PROCEDURE**
*Procedimento armazenado ou Stored Procedure é uma Sub-Rotina do tipo procedimento (sem retorno) que contém uma coleção de comandos em SQL, que podem ser executadas em um Banco de dados de uma só vez. Os Storeds Procedures encapsulam tarefas repetitivas como:*
 - aceitar parâmetros de entrada;
 - aceitar o emprego dos comandos como IF e ELSE, WHILE, LOOP, REPEAT e CASE;
 - poder chamar outros Storeds Procedures;
 - poder imprimir um valor de status.

*Os parâmetros passados para a Sub-Rotina-procedimento (Stored Procedure) ou MODOS podem ser de 3 tipos:*
 - IN: (padrão) passa um valor do escopo principal (fora da Sub-Rotina) para a Sub-Rotina e  esse valor não pode ser alterado dentro da Sub-Rotina.

 - OUT: passa um valor da Sub-Rotina para o escopo principal (fora da Sub-Rotina).

 - IN OUT: passa um valor do escopo principal(fora da Sub-Rotina) para a Sub-Rotina. Esse valor pode ser alterado dentro da Sub-Rotina e imprimido com o valor atualizado para o escopo principal (fora da Sub-Rotina).

#### **Sintaxe:**
```sql
CREATE OR REPLACE PROCEDURE
    Nome_Proc (Argumento1 MODO Tipo_de_Dados, Argumento2 MODO Tipo_de_Dados, ...)
        /* IS ou AS */
        /* Variáveis locais, constantes,... */
        BEGIN
            /* Bloco Pl/SQL */
            /* EXCEPTION */
    End nome_da_procedure;

SET SERVEROUTPUT ON
Nome_Proc(agr1, agr2, ...); /*chamando o procedimento*/
DECLARE
    /*code*/
BEGIN
    /*code*/
END;
```

 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/PL-StoredProcedure.sql">Exemplos STORED PROCEDURE</a> | 
 |:-:| 
  
 </br> 
  

### **STORED FUNCTION**
*Função armazenada(também chamada de função do usuário ou função definida pelo usuário) ou Stored Function é uma Sub-Rotina do tipo função, o seja, tem por objetivo retornar algum resultado ou retornar algum valor.*

*Obs: não se usa Stored Function nos seguintes casos:*
 - Em uma cláusula de restrição CHECK de um CREATE TABLE ou ALTER TABLE; 
 - Em uma cláusula DEFAULT de uma instrução CREATE TABLE ou ALTER TABLE.
 - Em uma consulta-DQL ou instrução-DML, a função não pode ter OUT ou IN OUT como parâmetros

#### **Sintaxe:**
```sql
/*Sintaxe (parecida com a da Stored Procedure, com exceção do RETURNO que apenas as functions possuem):*/
CREATE OR REPLACE FUNCTION 
    Nome_Funçao (Argumento1 modo Tipo_de_Dados, Argumento2 modo Tipo_de_Dados, ...)
        RETURN Tipo_de_Dado
        /* IS ou AS */
        /* Variáveis locais, constantes,... */
        BEGIN
            /* Bloco Pl/SQL */
            /* EXCEPTION */
            RETURN(dado)
    END nome_da_função;
Nome_Funçao (agr1, agr2, ...)/*chamando a função*/
DECLARE
    /*code*/
BEGIN
    /*code*/
END;
```
 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/PL-StoredFunction.sql">Exemplos STORED FUNCTION</a> | 
 |:-:| 
  
 </br> 
  

### **EXCEPTION**
*Exceções são tratamentos de erros e imprevistos, que podem ocorrer durante a execução de um bloco PL/SQL, através de manipuladores de exceção. Ao invés de verificar se existe um erro em um determinado ponto, adicionaremos um manipulador de exceção para o bloco PL/SQL. Se a exceção é sempre executada nesse bloco (ou qualquer sub-bloco), teremos certeza que será tratada.*

### *Exceções pré-definidas no Oracle:*
| EXCEÇÃO | Oracle Erro | SQLCODE Valor | OCASIÃO |
|:-:|:-:|:-:|:-:|
| ACCESS_INTO_NULL | ORA-06530 | -6530  | Um programa tenta atribuir valores aos atributos de um objeto não inicializado. |
| CASE_NOT_FOUND | ORA-06592 | -6592 | Nenhuma das opções nas cláusulas WHEN de uma declaração CASE é selecionada, e não há cláusula ELSE. |
| COLLECTION_IS_NULL | ORA-06531 | -6531 | Um programa tenta aplicar métodos de coleta que não existam a um tabela aninhada não inicializada ou varray, ou o programa tenta atribuir valores aos elementos de uma tabela aninhada inicializada ou varray. |
| CURSOR_ALREADY_OPEN | ORA-06511 | -6511 | Um programa tenta abrir um cursor já aberto. Um cursor deve ser fechado antes que possa ser reaberto. Um cursor em FOR loop é aberto automaticamente, de modo que o seu programa não pode reabrir esse cursor dentro o loop. |
| DUP_VAL_ON_INDEX | ORA-00001 | -1 | Um programa tenta armazenar valores duplicados em uma coluna de banco de dados. |
| INVALID_CURSOR | ORA-01001 | -1001 | Um programa tenta uma operação de cursor que não é permitida, como o fechamento de um cursor não aberto. |
| INVALID_NUMBER | ORA-01722 | -1722 | Em uma declaração SQL, a conversão de uma sequência de caracteres em um número falha porque a sequência não representa um número válido. (Em procedimento declarações, VALUE_ERROR é levantada.) Essa exceção também é levantada quando a expressão cláusula LIMIT em uma declaração FETCH em massa não avalia um número positivo. |
| LOGIN_DENIED | ORA-01017 | -1017 | Um programa tenta fazer logon no Oracle com um nome de usuário ou senha inválido. |
| NO_DATA_FOUND | ORA-01403 | 100 | Uma instrução SELECT INTO não retorna linhas ou seu programa faz referência a um elemento excluído em uma tabela. |
| NOT_LOGGED_ON | ORA-01012 | -1012 | Um programa emite uma chamada de banco de dados sem estar conectado à Oracle. |
| PROGRAM_ERROR | ORA-06501 | -6501 | O PL/SQL tem um problema interno. |
| ROWTYPE_MISMATCH | ORA-06504 | -6504 | Variável cursor hospedeiro e variável cursor PL/SQL envolvido em uma atribuição tem tipos de retorno incompatíveis. |
| SELF_IS_NULL | ORA-30625 | -30625 | Um programa tenta chamar um método MEMBRO, mas a instância do o tipo de objeto não foi inicializado. |
| STORAGE_ERROR | ORA-06500 | -6500 | PL/SQL fica sem memória ou memória foi corrompida. |
| SUBSCRIPT_BEYOND_COUNT | ORA-06533 | -6533 | Um programa faz referência a uma tabela ou elemento usando um índice de número maior do que o número de elementos na coleção. |
| SUBSCRIPT_OUTSIDE_LIMIT | ORA-06532 | -6532 | Um programa faz referência a uma tabela ou elemento usando um índice número (-1, por exemplo) que está fora da faixa permitida. |
| SYS_INVALID_ROWID | ORA-01410 | -1410 | A conversão de uma sequência de caracteres em um rowid (identificador de cada registro no banco de dados Oracle) falha porque a sequência de caracteres não representa um rowid válido. |
| TIMEOUT_ON_RESOURCE | ORA-00051 | -51 | Um intervalo ocorre enquanto o Oracle aguarda um recurso. |
| TOO_MANY_ROWS | ORA-01422 | -1422 | Uma instrução SELECT INTO retorna mais de uma linha. |
| VALUE_ERROR | ORA-06502 | -6502 | Ocorre um erro aritmético, de conversão, truncação ou restrição de tamanho. |
| ZERO_DIVIDE | ORA-01476 | -1476 | Um programa tenta dividir um número por zero. |

#### **Sintaxe:**
```sql
DECLARE
    /*code*/
BEGIN
    EXCEPTION
        WHEN nome_da_exceção THEN
            /* comandos */
        WHEN nome_da_exceção THEN
            /* comandos */
END;

/*Também é possível criar exceções, a exceção criada deverá ser invocada pelo comando RAISE:*/
DECLARE
    Nome_da_exceção EXCEPTION;
BEGIN
    /* comandos */ 
    IF (/* comandos */) Then
        RAISE Nome_da_exceção; /*RAISE invoca a exceção criada*/
    END IF;
    EXCEPTION
        WHEN nome_da_exceção THEN
            /* comandos */
END;
```

 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/PL-Exception.sql">Exemplos EXCEPTION</a> | 
 |:-:| 
  
 </br> 
  

### **TRIGGERS**
*Triggers ou gatilhos são blocos PL/SQL disparados automaticamente e implicitamente sempre que ocorrer um evento associado a uma determinada tabela (DML-UPDATE, INSERT ou DELETE).*

*Um Trigger pode ser utilizado para:*
 - Manutenção de tabelas de auditoria;
 - Manutenção de tabelas duplicadas;
 - Implementação de níveis de segurança mais complexos;
 - Geração de valores de colunas, por exemplo, gerar o valor total da nota fiscal a cada inclusão, exclusão ou alteração de itens da nota.

*Obs: Os  registros  especiais  :NEW  e  :OLD  armazenam  temporariamente  os  valores  do  último registro manipulado pelo SGBD:*

| DML | :OLD | :NEW |
|:-:|:-:|:-:|
| INSERT | - | VALORES NOVOS |
| DELETE | VALORES ANTIGOS | - |
| UPDATE | VALORES ANTIGOS | VALORES NOVOS |
    
*Para desabilitar e Habilitar um Trigger Específico:*
```sql
ALTER TRIGGER nome_da_trigger DISABLE;
ALTER TRIGGER nome_da_trigger ENABLE;
```

*Para desabilitar e Habilitar todos os Triggers de uma tabela:*
 ```sql  
ALTER TABLE nome_tabela DISABLE ALL TRIGGERS;
ALTER TABLE nome_tabela ENABLE ALL TRIGGERS;
```

*Para eliminar Triggers e Procedimentos:*
```sql
DROP TRIGGER nome_trigger;
DROP PROCEDURE nome_procedure;
```

*Para inspecionar o dicionário de dados:*
```sql
SELECT object_name, object_type FROM user_objects WHERE object_type =’TRIGGER’;
```

*Para obter detalhes dos Triggers:*
```sql
DESC USER_TRIGGERS
```

#### **Sintaxe:**
```sql
DECLARE /*pesquisar identacao chatgpt*/
    CREATE OR REPLACE TRIGGER NOME_TRIGGER /* declarar o trigger */
    BEFORE /* tempo em que será disparado o evento (BEFORE OU AFTER) */
        INSERT OF NOME_COLUNA /* DML para a coluna que será alterada */
        OR                                
        UPDATE OF NOME_COLUNA /* DML para a coluna que será alterada */
        OR
        DELETE OF NOME_COLUNA /* DML para a coluna que será alterada */ ON NOME_TABELA /* tabela na qual o trigger será executado, relacionada em BEGIN */
        FOR EACH ROW /* PARA CADA LINHA */
BEGIN
   /* COMANDOS PL/SQL, :NEW e :OLD (Registros  especiais) */
END;                   
```
 | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/PL-Trigger.sql">Exemplos TRIGGER</a> | 
 |:-:| 
