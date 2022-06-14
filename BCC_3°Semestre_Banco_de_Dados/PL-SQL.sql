/*Neste arquivo são apresentados exemplos de uso dos comandos DECLARE, BEGIN e EXCEPTION  da PL/SQL(Program Language SQL).
 
    PL/SQL é a linguagem de programação da Oracle que permite efetuar transações, como a DTL, porém com muitas funcionalidades:
        - Criar variáveis herdando o tipo e tamanho de outras variáveis ou objetos do banco de dados tais como tabelas;
        - Utilizar comandos de repetição e comparação;
        - Tratar operações de erros;
        - Criar cursores para tratamento de resultados de pesquisas e criar registros para armazenar resultados de cursores:
            (Usa-se um cursor para buscar linhas retornadas por uma consulta, uma por vez:
                Cursores Implícitos (IS)    →   declarado e gerenciado pelo oracle
                Cursores Explícitos (AS)    →   declarado e gerenciado pelo programador)

    Sintaxe:
    DECLARE   → Declarações (opcional)
        • Variáveis, cursores, constantes, tabelas, estruturas, exceptions.

    BEGIN   → Operações SQL e PL/SQL (obrigatório)
        • SQL operações
        • PL/SQL operações

    EXCEPTION   → tratamento de exceções (opcional)
        • Ações que deverão ser executadas quando ocorrer erros

    END; (obrigatório)*/


/*Ex: Imprimindo uma transação de informação no bufer (página de 8kb na memória), passada do banco de dados para o bufer.*/
ACCEPT empno PROMPT 'Digite o código do empregado: ' /*PROMPT exibe uma mensagem na tela; ACCEPT armazena o retorno do prompt*/
SET serveroutput ON/*PL/SQL imprima(ON) ou não (OFF) no buffer(página de 8kb na memória) o parâmetro passado ao pack'dbms_output' pelo método '.put_line'*/
DECLARE /*Declarações (opcional)*/
    v_empno      NUMBER(6):= &empno; /*& associa v_empno à empno, da entrada do usuário*/
    v_emp_salary number (8,2);
    Myname VARCHAR2(20); /*aqui declara-se para definir-se o valor*/
BEGIN /*Operações SQL e PL/SQL (obrigatório)*/
    Myname := 'John'; /*aqui define-se o valor do que foi declarado*/
    SELECT salary 
    INTO v_emp_salary 
    FROM employees 
    WHERE employee_id = v_empno;
    DBMS_OUTPUT.PUT_LINE('O salário do funcionário '|| v_empno|| ' é de '||v_emp_salary); 
    /*'DBMS_OUTPUT' pack para imprimir ou gravar no buffer, '.PUT_LINE ' grava o parâmetro no buffer*/
END; /*(obrigatório)*/


/*Ex: Uso de %TYPE – Herança de tipo e tamanho: É usado para declarar uma variável com base em um campo de uma tabela de outra variável já declarada*/
SET serveroutput ON /*PL/SQL imprima(ON) ou não (OFF) no buffer(página de 8kb na memória) o parâmetro passado ao pack'dbms_output' pelo método '.put_line'*/
DECLARE /*Declarações (opcional)*/
    v_emp_hiredate   employees.hire_date%TYPE; /* %TYPE – Herança de tipo e tamanho*/
    v_emp_salary     employees.salary%TYPE;
BEGIN /*Operações SQL e PL/SQL (obrigatório)*/
    SELECT   hire_date, salary
    INTO     v_emp_hiredate, v_emp_salary
    FROM     employees
    WHERE    employee_id = 100;  
    DBMS_OUTPUT.PUT_LINE(v_emp_salary|| ' ' || v_emp_hiredate); 
 /*'DBMS_OUTPUT' pack para imprimir ou gravar no buffer, '.PUT_LINE ' grava o parâmetro no buffer*/
END; /*(obrigatório)*/


/*Ex: Incluindo dados na tabela de empregados.*/
BEGIN /*Operações SQL e PL/SQL (obrigatório)*/
    INSERT INTO employees
    (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    VALUES
    (employees_seq.NEXTVAL, 'Ruth', 'Cores', 'RCORES', sysdate, 'AD_ASST', 4000);
END; /*(obrigatório)*/


/*Ex: Atualizando o salário para 800 para todos que possuem o cargo = ST_CLERK*/
DECLARE /*Declarações (opcional)*/     
    sal_increase   employees.salary%TYPE := 800;   
BEGIN /*Operações SQL e PL/SQL (obrigatório)*/
    UPDATE  employees
    SET  salary = salary + sal_increase
    WHERE job_id = 'ST_CLERK';
END; /*(obrigatório)*/


/*Ex: Apagar todos os funcionários do departamento 10.*/
DECLARE /*Declarações (opcional)*/
    deptno   employees.department_id%TYPE := 10; 
BEGIN /*Operações SQL e PL/SQL (obrigatório)*/       
    DELETE FROM   employees
    WHERE  department_id = deptno;
END; /*(obrigatório)*/


/*Ex: Usando condicionais*/
DECLARE /*Declarações (opcional)*/
    myage number:=31;
BEGIN /*Operações SQL e PL/SQL (obrigatório)*/
    IF myage < 11
        THEN
            DBMS_OUTPUT.PUT_LINE('Sou criança');
    ELSIF myage < 20 
        THEN 
            DBMS_OUTPUT.PUT_LINE('Sou jovem');
    ELSIF myage < 30
        THEN
            DBMS_OUTPUT.PUT_LINE('Estou na casa dos vinte..');
    ELSIF myage < 40
        THEN
            DBMS_OUTPUT.PUT_LINE('Estou na casa dos trinta');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Serei sempre jovem...');
    END IF;
END; /*(obrigatório)*/


/* (CURSORES)_________________________________________________________________________________________________________________________________________________
    Sintaxe:
    DECLARE                         →    Declarações (opcional)
        CURSOR CURSOR_EXEMPLO IS    →    Declara um cursor implícito (IS) — declarado e gerenciado pelo oracle —.
                                    →    (↑ISouAS↓)
        CURSOR CURSOR_EXEMPLO AS    →    Declara um cursor Explícito (AS) — declarado e gerenciado pelo programador —.
    BEGIN                           →    Operações SQL e PL/SQL (obrigatório)
        OPEN CURSOR_EXEMPLO;        →    Abre o cursor IS/AS, ou seja, busca as linhas retornadas pelas consultas
                                    →    Aqui define-se as operções do cursor que foi declarado
        CLOSE CURSOR_EXEMPLO;       →    Fecha cursor IS/AS
    END; (obrigatório) */


/*Ex: Usando um cursor*/
SET SERVEROUTPUT ON
DECLARE /*Declarações (opcional)*/
    CURSOR emp_cursor IS /*Declara um cursor implícito (IS) — declarado e gerenciado pelo oracle —.*/
    SELECT employee_id, last_name 
    FROM employees
    WHERE department_id = 30
    v_empno employees.employee_id%TYPE;
    v_lane employees.Last_name%type;
BEGIN /*Operações SQL e PL/SQL (obrigatório)*/
    OPEN emp_cursor; /*Abre o cursor IS/AS, ou seja, busca as linhas retornadas pelas consultas*/
        LOOP /*Inicia um loop*/
            FETCH emp_cursor INTO v_empno, v_lane; /*Pesquisar as linhas de cada coluna*/
            EXIT WHEN emp_cursor%NOTFOUND; /*para a pesquisa quando nada mais for encontrado nas colunas*/
            DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_lane) /*escreve as linhas de cada coluna no buffer*/
        END LOOP; /*finaliza o loop*/
    CLOSE emp_cursor; /*Fecha cursor IS/AS*/
END; /*(obrigatório)*/


/* (STORAGE PROCEDURE)________________________________________________________________________________________________________________________________________
*/