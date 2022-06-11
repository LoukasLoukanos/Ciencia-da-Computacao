/* Neste arquivo são apresentados exemplos de uso do comando SELECT da 
   linguagem de operação DQL (Linguagem de Consulta de Dados) da SQL.*/


/* (COMANDO SELECT)________________________________________________
Permite a seleção e a manipulação para visualização das informações 
armazenadas no banco de dados.*/


/*CREATE TABLE AS SELECT
Cria uma tabela (estrutura E dados) com base no comando SELECT*/
CREATE TABLE espelhoteste AS SELECT * 
FROM employees


/*LINHAS DUPLICADAS
A exibição default de consultas são todas as linhas, incluindo as 
linhas duplicadas. Para eliminar valores duplicados no resultado, 
incluímos o qualificador DISTINCT no comando SELECT.*/
SELECT DISTINCT department_id 
FROM employees


/*Selecionar todas as colunas*/
SELECT *
FROM departments


/*Selecionar colunas específicas*/
SELECT FIRST_NAME, EMAIL, HIRE_DATE 
FROM employees;


/*Selecionar usando expressões Aritméticas*/
SELECT FIRST_NAME, EMAIL, salary, salary*12 
FROM employees;


/*Selecionar colunas com Apelidos(alias)*/
SELECT FIRST_NAME, EMAIL, salary "Salário", salary*12 “SalarioAnual” 
FROM employees;


/*Selecionar colunas concatenadas*/
SELECT FIRST_NAME, EMAIL, 'Salário: ' || salary "Salário", salary*12 "SalarioAnual" 
FROM employees;


/* (CLÁUSULA WHERE)_____________________________________________________
Indica condição para um SELECT trabalhando com operadores.

    Operadores comuns:
        =               Igual 
        <>              Diferente 
        >               Maior 
        <               Menor 
        >=              Maior ou igual 
        <=              Menor ou igual 
    Operadores lógicos:
        AND             Esperará que ambas as condições sejam verdadeiras
        OR              Esperará que uma das condições seja verdadeira
    Operadores SQL:
        BETWEEN ... AND ...     Compara dois valores (inclusive) 
        IN (lista)              Compara uma lista de valores 
        LIKE                    Verifica um parâmetro alfanumérico 
        IS NULL                 Verifica quais campos estão com valores nulos
    Operadores de comparação para múltiplas linhas (para subqueries):
        IN              Igual a qualquer membro da lista 
        ANY             Compara o valor com cada valor retornado pela subquerie.
        ALL             Compara o valor com todos os valores retornados pela subqueire.
        EXISTS          Testa se um valor existe

Obs: Parênteses podem ser usados para especificar a ordem na qual os operadores devem ser avaliados (prioridade).
     Sempre que haver dúvida sobre qual operador será avaliado primeiro, pode-se usar parênteses para definir a prioridade das expressões.
Obs: Alfanuméricos e Datas devem estar entre aspas simples.*/


/*Operadores comuns com operadores lógicos 
Ex: Para selecionar nome, salário e id do serviço dos funcionários de salários acima de 8k (E) 
    cujo id seja 'ST_CLERK' (OU) qualquer faixa salarial cujo id do serviço seja 'ST_MAN' */
SELECT First_name, Last_name, Salary, Job_ID
FROM Employees
WHERE Salary > 8000 AND Job_id = 'ST_CLERK' OR Job_id = 'ST_MAN'


/*Operador SQL BETWEEN
Ex: Para ver aqueles empregados cujos salários estejam entre 1000 e 2000:*/
SELECT First_name, Last_name, Salary
FROM Employees
WHERE Salary BETWEEN 10000 AND 20000;


/*Operador SQL IN
Ex: Para encontrar empregados que tenham um dos três números de Manager, utilize o seguinte comando:*/
SELECT First_name, Last_name, Salary, Manager_id
FROM Employees
WHERE Manager_id IN (101, 145, 149);


/*Operador SQL LIKE
    Regras de acesso:
        LIKE '%cadeia'      Localiza valores que terminem com a cadeia de caracteres.
        LIKE 'cadeia%'      Localiza valores que comecem com a cadeia de caracteres.
        LIKE '%cadeia%'     Localiza valores que tenham a cadeia de caracteres em qualquer parte do campo.
Ex: Para listar todos os empregados que tenham o nome que comecem com a letra S:*/
SELECT First_name, Last_name, Salary
FROM Employees
WHERE First_name LIKE 'S%';


/*Operador SQL IS NULL
Ex: Para encontrar todos os empregados que não tenham gerente, você testará um valor nulo: */
SELECT First_name, Last_name, Salary, Manager_id
FROM  Employees
WHERE  Manager_id IS NULL;


/*Expressões Negativas NOT para operadores
Ex: Para selecionar o nome e salário dos empregados que NÃO estejam entre e inclusive a faixa salarial de 10k a 20k:*/
SELECT First_name, Last_name, Salary
FROM Employees
WHERE Salary NOT BETWEEN 10000 AND 20000; 


/* (CLÁUSULA ORDER BY)___________________________________________________________  
A cláusula ORDER BY pode ser usada para ordenar as linhas. 
    
    A ordenação é ascendente(do menor para o maior) mas pode ser invertida para descendente:
        • valores numéricos infinitos primeiro;
        • valores de data primeiro;
        • valores alfanuméricos.

Obs: ORDER BY deve ser sempre a última cláusula da declaração SELECT.
Nota: Para ordenar por uma coluna, ela não precisa estar declarada no SELECT.
Nota: Esse comando não altera a ordem dos dados que estão armazenados no Banco de Dados.


Ex: Para ordenar por duas colunas e mostrar ordem decrescente do salário e ordem crescente do sobrenome faça:*/
SELECT First_name, Last_name, Salary
FROM Employees
WHERE Salary BETWEEN 10000 AND 20000
ORDER BY Salary DESC, Last_name;


/* (SUBQUERY ou INNERQUERY (sub pesquisa) e QUERYPRINCIPAL ou OUTERQUERY (pesquisa principal))_________
SUBQUERY é um comando SELECT dentro de um outro comando SELECT. Uma declaração SELECT-SUBQUERY 
(ou INNERQUERY) é aninhada com uma declaração SELECT-QUERYPRINCIPAL (ou OUTERQUERY), a qual 
retorna resultados a fim de satisfazer uma cláusula WHERE.


Ex: Para selecionar os funcionários que possuem um salário maior que o de Abel:*/
SELECT last_name, salary/*QUERYPRINCIPAL ou OUTERQUERY (pesquisa principal)*/
FROM HR."EMPLOYEES"
Where salary > (SELECT salary /*SUBQUERY ou INNERQUERY (sub pesquisa)*/
                FROM HR."EMPLOYEES"
                WHERE last_name = 'Abel')


/*Ex: Para mostrar o sobrenome (last_name) e o cargo (job_id) dos funcionários 
que possuem o mesmo cargo do funcionário de número 141:*/
SELECT last_name, job_id
FROM HR."EMPLOYEES"
Where job_id = (SELECT job_id
                FROM HR.”EMPLOYEES”
                WHERE employee_id =141);


/*Ex: Para encontrar todos os empregados do mesmo departamento do David Lee*/
SELECT FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID =  (SELECT DEPARTMENT_ID
                        FROM EMPLOYEES
                        WHERE FIRST_NAME = 'David' and LAST_NAME ='Lee')
ORDER BY FIRST_NAME


/*Ex: Para pesquisar os empregados que ganham acima da média salarial:*/
SELECT FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEES)
ORDER BY FIRST_NAME


/*Ex: Para pesquisar os empregados que trabalham nos departamentos de Marketing e Administração*/
SELECT FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID, SALARY
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME IN ('Marketing','Administration'))
ORDER BY FIRST_NAME


/*Ex: Para mostrar o primeiro e o último nome, cargo, código do departamento e salário 
dos empregados cujo salário é maior que o maior salário no departamento ‘SALES’.*/
SELECT FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT MAX(SALARY)
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID  = (SELECT DEPARTMENT_ID
                                        FROM DEPARTMENTS
                                        WHERE DEPARTMENT_NAME = 'Sales'))
ORDER BY FIRST_NAME


/* (EXPRESSÃO DECODE e EXPRESSÃO CASE)_______________________________________________________________
A EXPRESSÃO DECODE e a EXPRESSÃO CASE geram colunas para consultas SELECT. 
• DECODE substitui um valor específico por outro valor específico ou valor padrão, 
  dependendo do resultado de uma condição de igualdade.
• CASE permite o processamento condicional que exija o tratamento de várias hipóteses.

EXPRESSÃO DECODE - Sintaxe:  
DECODE (COLUNA/EXPRESSÃO,                   → o nome da coluna ou expressão a ser avaliado
        "PROCURADO1", 'RESULTADO1',         → valor para ser testado e valor para ser retornado
        "PROCURADO2", 'RESULTADO2',         → valor para ser testado e valor para ser retornado
                    ...                     → o processo de teste e retorno pode ser reperido
        'SEM_RESULTADO'                     → valor retornado as pesquisas não forem satisfeitas
        ) DECODE_COLUNA_GERADA              → coluna gerada para a consulta select
obs:
    - PROCURADO deve ser um dado do tipo coluna ou expressão.
    - DECODE deve ter, no mínimo, 3 parâmetros ou argumentos
      ("PROCURADO1", 'RESULTADO1' e 'SEM_RESULTADO')

EXPRESSÃO CASE - Sintaxe:
CASE
    WHEN("quando")  COLUNA  OPERADOR(=, >...)  VALOR(int, 'string'...)  THEN("então")  'MENSAGEM'
                                                . . .
ELSE  'MENSAGEM'
END  CASE_COLUNA_GERADA


DECODE-Exemplo: Seleciona o Nome e profissão e gera uma coluna de nome DECODE_CARGO
    relacionada a algumas profissões de acordo com o DECODE criado:*/
SELECT FIRST_NAME, JOB_ID,
DECODE (JOB_ID, 
        "IT_PROG",'PROGRAMADOR',
        "FI_ACCOUNT",'CONTADOR',
        'INDEFINIDO'
        ) DECODE_COLUNA_GERADA
FROM EMPLOYEES;


/*DECODE-Exemplo: Para retornar o salário incrementado de acordo com o tipo de cargo*/
SELECT FIRST_NAME, JOB_ID, SALARY, 
DECODE (JOB_ID,
        "IT_PROG", SALARY * 1.1,
        "FI_ACCOUNT", SALARY * 1.2, 
        "AD_VP", SALARY * 0.95, 
        SALARY
        ) DECODE_COLUNA_GERADA
FROM EMPLOYEES;


/*CASE-Exemplo: Para avaliar duas expressões lógicas e ainda oferecer uma terceira 
                possibilidade, quando as duas anteriores resultarem falsas:*/
SELECT FIRST_NAME, JOB_ID, SALARY, 
CASE
    WHEN SALARY < 5000 THEN 'AUMENTO'
    WHEN SALARY > 10000 THEN 'VERIFICAR'
ELSE 'NÃO AUMENTAR'
END CASE_COLUNA_GERADA
FROM EMPLOYEES;
