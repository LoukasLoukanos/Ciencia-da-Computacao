/* ————————— Exemplos de uso dos comandos DECLARE, BEGIN e EXCEPTION  da PL/SQL(Program Language SQL) ————————— */


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
