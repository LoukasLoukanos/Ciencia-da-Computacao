/* ————————— Exemplos de uso de Exception da PL/SQL(Program Language SQL) ————————— */


/*Ex: Utilizando uma exceção pré-defiinida do Oracle:*/
SET SERVEROUTPUT ON
BEGIN
    BEGIN TRAN /*(DTL)INICIA UMA TRANSAÇÃO DE INFORMAÇÃO*/
        INSERT INTO Pais VALUES(&codigo,'&nome');
    COMMIT; /*(DTL)TERMINA A TRANSAÇÃO GRAVANDO AS ALTERAÇÕES FEITAS*/
    Dbms_output.put_line('Comando executado com sucesso');
    EXCEPTION /*Caso o COMMIT não tenha sido realizado com sucesso...*/
        WHEN DUP_VAL_ON_INDEX THEN /*(Exceção pré-definida do Oracle): Quando um programa tenta armazenar valores duplicados em uma coluna de banco de dados.*/
            Dbms_output.put_line ('ERRO!!! Código de país já existente'); 
        WHEN OTHERS THEN
            Dbms_output.put_line ('Erro ao cadastrar o país');
END;


/*Ex: Tratamento de exceção criado pelo usuário:*/
SET SERVEROUTPUT ON
SET VERIFY OFF
DECLARE
    codigo cliente.cd_cliente%type;
    nome   cliente.nm_cliente%type;
    fisica cliente.ie_fisica_juridica%type;
    sexo   cliente.ie_sexo%type;
    est_civ cliente.est_civ%type;
    VALIDA_CAMPOS exception;
BEGIN
    codigo:=&codigo;
    nome:='&nome';
    fisica:='&fisica';
    sexo:='&sexo';
    est_civ:='&est_civ';
    IF (fisica='F' and (sexo is null or est_civ is null)) then 
        RAISE VALIDA_CAMPOS; /*RAISE invoca a exceção criada*/
    ElSEIF (fisica= 'J' and (sexo is not null or est_civ is not null)) then 
        RAISE VALIDA_CAMPOS; /*RAISE invoca a exceção criada*/
    ElSE
        BEGIN TRAN /*(DTL)INICIA UMA TRANSAÇÃO DE INFORMAÇÃO*/
            Insert into cliente (cd_cliente, nm_cliente, ie_fisica_juridica, ie_sexo, est_civ)
            values (codigo,nome, fisica, sexo, est_civ);
        COMMIT; /*(DTL)TERMINA A TRANSAÇÃO GRAVANDO AS ALTERAÇÕES FEITAS*/
        dbms_output.put_line ('Cliente cadastrado com sucesso');
    END IF;
    EXCEPTION /*Especificando as exceções*/
        When VALIDA_CAMPOS then /*Exceção criada*/
            dbms_output.put_line ('Verificar campos sexo ou estado civil preenchido incorretamente');
        when DUP_VAL_ON_INDEX then /*(Exceção pré-definida do Oracle): Quando um programa tenta armazenar valores duplicados em uma coluna de banco de dados.*/
            dbms_output.put_line ('ERRO!!! Código já cadastrado, favor cadastrar novo código diferente de ' || codigo);
END;
