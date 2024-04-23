/* ————————— Exemplos de uso de Cursor da PL/SQL(Program Language SQL) ————————— */


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
    OPEN emp_cursor; /*Abre o cursor IS que foi declarado, ou seja, busca as linhas retornadas pelas consultas*/
        LOOP /*Inicia um loop*/
            FETCH emp_cursor INTO v_empno, v_lane; /*Pesquisar as linhas de cada coluna*/
            EXIT WHEN emp_cursor%NOTFOUND; /*para a pesquisa quando nada mais for encontrado nas colunas*/
            DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_lane) /*escreve as linhas de cada coluna no buffer*/
        END LOOP; /*finaliza o loop*/
    CLOSE emp_cursor; /*Fecha o cursor IS*/
END; /*(obrigatório)*/
