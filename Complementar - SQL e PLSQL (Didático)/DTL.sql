/* Neste arquivo são apresentados exemplos de uso dos comandos BEGIN, COMMIT e ROLLBACK da linguagem de operação DTL (Linguagem de Transação de Dados) da SQL.
   →(Utiliza-se os comandos da DML(MANIPULAÇÃO) e da DQL(CONSULTA) com os comandos da DTL(TRANSAÇÃO))←


  (COMANDOS DTL-LINGUAGEM DE TRANSAÇÃO DE DADOS)_________________________________________________________________________

    BEGIN TRAN OU BEGIN TRANSACTION    →    INICIA UMA TRANSAÇÃO DE INFORMAÇÃO
    COMMIT                             →    TERMINA A TRANSAÇÃO GRAVANDO AS ALTERAÇÕES FEITAS
    ROLLBACK                           →    TERMINA A TRANSAÇÃO REVERTENDO AS ALTERAÇÕES FEITAS


Ex: GRAVAR ALTERAÇÕES*/
BEGIN TRAN /*(DTL)INICIA UMA TRANSAÇÃO DE INFORMAÇÃO*/
    insert into Vendedor(nome, sobrenome) values ('Teste1','Teste1') /*DML-LINGUAGEM DE MANIPULAÇÃO DE DADOS*/
COMMIT /*(DTL)TERMINA A TRANSAÇÃO GRAVANDO AS ALTERAÇÕES FEITAS*/


/*Ex: GRAVAR ALTERAÇÕES*/
BEGIN TRAN /*(DTL)INICIA UMA TRANSAÇÃO DE INFORMAÇÃO*/
    delete vendedor /*DML-LINGUAGEM DE MANIPULAÇÃO DE DADOS*/
    where codigo = 12; /*DQL-LINGUAGEM DE CONSULTA DE DADOS*/
    select * from vendedor; /*DQL-LINGUAGEM DE CONSULTA DE DADOS*/
COMMIT /*(DTL)TERMINA A TRANSAÇÃO GRAVANDO AS ALTERAÇÕES FEITAS


/*Ex: REVERTER ALTERAÇÕES*/
BEGIN TRAN /*(DTL)INICIA UMA TRANSAÇÃO DE INFORMAÇÃO*/
    update vendedor /*DML-LINGUAGEM DE MANIPULAÇÃO DE DADOS*/
    set nome = 'Nome da Pessoa', sobrenome = 'Sobrenome da pessoa' /*DML-LINGUAGEM DE MANIPULAÇÃO DE DADOS*/
    where codigo = 12; /*DQL-LINGUAGEM DE CONSULTA DE DADOS*/
ROLLBACK /*(DTL)TERMINA A TRANSAÇÃO REVERTENDO AS ALTERAÇÕES FEITAS*/
