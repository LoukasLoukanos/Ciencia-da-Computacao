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
