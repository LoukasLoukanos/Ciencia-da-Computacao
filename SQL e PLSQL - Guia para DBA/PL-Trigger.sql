/* ————————— Exemplos de uso de Trigger da PL/SQL(Program Language SQL) ————————— */


/* Exemplo 1:_________________________________________________________________________
    Trigger criado para gravar o valor antigo e o novo valor em uma tabela chamada 
    de NewProduto, quando se alterar um valor da tabela Produto. Ao executar o comando 
    Update produto set vl_custo_medio =2.93 where cd_produto=4, a tabela NewProduto é 
    alimentada automaticamente:
    
    Tabela Produto:                         Tabela NewProduto:
    cd_produto      vl_custo_medio          cd_produto       vl_anterior     vl_novo
        1               1.5                     4               3.12          2.93
        2               2.3
        3               0.65
        4               3.12
        5               1.5   

Criando (DDL) a tabela Produto: */
CREATE TABLE Produto (
    cd_produto      NUMBER,     
    vl_custo_medio  NUMBER);

/*Inserindo (DML) dados na tabela Produto:*/
INSERT INTO Produto (cd_produto, vl_custo_medio)
VALUES (1, 1.5);
INSERT INTO Produto (cd_produto, vl_custo_medio)
VALUES (2, 2.3);
INSERT INTO Produto (cd_produto, vl_custo_medio)
VALUES (3, 0.65);
INSERT INTO Produto (cd_produto, vl_custo_medio)
VALUES (4, 3.12);
INSERT INTO Produto (cd_produto, vl_custo_medio)
VALUES (5, 1.5);

/*Criando (DDL) a tabela NewProduto: */
CREATE TABLE NewProduto (
    cd_produto  NUMBER,
    vl_anterior NUMBER,     
    vl_novo     NUMBER);

/*Criando o trigger do exemplo 1*/
CREATE OR REPLACE TRIGGER exemplo_1
    BEFORE  /*O evento será disparado antes*/
        INSERT
        OR                                     
        UPDATE OF vl_custo_medio  /*A coluna vl_custo_medio será atualizada*/
    ON Produto  /*Tabela na qual o trigger será executado, relacionada em BEGIN*/
    FOR EACH ROW  /*Para cada linha dessa coluna*/
    BEGIN  /*PL/SQL-DML*/ 
        INSERT INTO NewProduto 
        VALUES (:old.cd_produto, :old.vl_custo_medio, :new.vl_custo_medio); /*registros  especiais  :NEW  e  :OLD*/
        /*Atualizar Produto.vl_custo_medio: */
        UPDATE Produto
        SET vl_custo_medio = 2.93
        WHERE cd_produto = 4;
        /*Mostrar tabela NewProduto: */
        SELECT * FROM NewProduto;
END;
        /*OUTPUT SELECT (Tabela NewProduto):
            cd_produto       vl_anterior     vl_novo
                4               3.12          2.93

        1 row selected.


/*Exemplo 2:____________________________________________________________________________
    Criar um gatilho que insira uma linha na tabela
    Emp_log sempre que EMPLOYEES.SALARY for atualizada:

Criando a tabela Emp_log:*/
DROP TABLE Emp_log;
CREATE TABLE Emp_log (
    Emp_id     NUMBER,
    Log_date   DATE,
    New_salary NUMBER,
    Action     VARCHAR2(20));

/*Criando o trigger do exemplo 2*/
CREATE OR REPLACE TRIGGER exemplo_2
    AFTER 
        UPDATE OF salary 
    ON employees
    FOR EACH ROW
    BEGIN
        INSERT INTO Emp_log (Emp_id, Log_date, New_salary, Action)
        VALUES (:NEW.employee_id, SYSDATE, :NEW.salary, 'New Salary');
        /*Atualizar EMPLOYEES.SALARY: */
        UPDATE employees
        SET salary = salary + 1000.0
        WHERE Department_id = 20;
        /*Mostrar tabela Emp_log:*/
        SELECT * FROM Emp_log;
END;
        /*OUTPUT SELECT (tabela Emp_log):
            EMP_ID LOG_DATE       NEW_SALARY ACTION
            201 28-APR-10       15049.13 New Salary
            202 28-APR-10       6945.75 New Salary
 
        2 rows selected.


/*Exemplo 3:____________________________________________________________________________
    Criando um trigger que emite mensagens de alerta toda vez que um evento 
    ocorrer nas colunas salary e department_id da tabela salary: */

CREATE OR REPLACE TRIGGER exemplo_3
    BEFORE
        INSERT 
        OR
        UPDATE OF salary, department_id 
        OR
        DELETE
    ON employees
    BEGIN
        CASE
            WHEN INSERTING THEN
                DBMS_OUTPUT.PUT_LINE('Inserting');
            WHEN DELETING THEN
                DBMS_OUTPUT.PUT_LINE('Deleting');

            WHEN UPDATING('salary') THEN
                DBMS_OUTPUT.PUT_LINE('Updating salary');
            WHEN UPDATING('department_id') THEN
                DBMS_OUTPUT.PUT_LINE('Updating department ID');
        END CASE;
END;
