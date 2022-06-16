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


/* (CURSORES)__________________________________________________________________________________________________________________________________________________
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
    OPEN emp_cursor; /*Abre o cursor IS que foi declarado, ou seja, busca as linhas retornadas pelas consultas*/
        LOOP /*Inicia um loop*/
            FETCH emp_cursor INTO v_empno, v_lane; /*Pesquisar as linhas de cada coluna*/
            EXIT WHEN emp_cursor%NOTFOUND; /*para a pesquisa quando nada mais for encontrado nas colunas*/
            DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_lane) /*escreve as linhas de cada coluna no buffer*/
        END LOOP; /*finaliza o loop*/
    CLOSE emp_cursor; /*Fecha o cursor IS*/
END; /*(obrigatório)*/


/* (STORED PROCEDURE)__________________________________________________________________________________________________________________________________________
    Procedimento armazenado ou Stored Procedure é uma Sub-Rotina do tipo procedimento que contém uma coleção de comandos em SQL, que podem 
    ser executadas em um Banco de dados de uma só vez. Os Storeds Procedures encapsulam tarefas repetitivas, aceitam parâmetros de entrada, 
    são capazes de utilizar os comandos como IF e ELSE, WHILE, LOOP, REPEAT e CASE, além de poderem chamar outros Storeds Procedures e podem 
    imprimir um valor de status.
    
    Os parâmetros passados para a Sub-Rotina-procedimento (Stored Procedure) podem ser de 3 tipos:
        - IN:       (padrão) passa um valor do escopo principal (fora da Sub-Rotina) para a Sub-Rotina e 
                    esse valor não pode ser alterado dentro da Sub-Rotina.

        - OUT:      passa um valor da Sub-Rotina para o escopo principal (fora da Sub-Rotina).

        - IN OUT:   passa um valor do escopo principal(fora da Sub-Rotina) para a Sub-Rotina. Esse valor 
                    pode ser alterado dentro da Sub-Rotina e imprimido com o valor atualizado para o escopo 
                    principal (fora da Sub-Rotina).

    Sintaxe:
        CREATE OR REPLACE PROCEDURE 
            Nome_Proc (Argumento1 modo Tipo_de_Dados, Argumento2 modo Tipo_de_Dados, Argumento3 modo Tipo_de_Dados)
                IS ou AS
                Variáveis locais, constantes,...
                BEGIN
                    Bloco Pl/SQL
                    Exception
            End nome_da_procedure;*/


/*Ex: Sub-Rotina-Procedimento (Stored Procedure) — não há retorno —:*/
SET SERVEROUTPUT ON 
CREATE OR REPLACE PROCEDURE /*A Cláusula REPLACE faz com que uma função seja recriada se ela já existir.*/
    Nr_Fone (V_fone in varchar2)
        IS
        NV_Fone varchar2(10)
        BEGIN
            NV_Fone:= Substr(V_fone,1,4)||'-'||Substr(V_fone,5,4);
            Dbms_Output.Put_Line (NV_Fone);
    END Nr_Fone;
/*Executando a Stored Procedure*/
exec nr_fone(12345678);/*output: 1234-5678*/


/*Ex: Sub-Rotina-Procedimento (Stored Procedure) — não há retorno —:*/
CREATE OR REPLACE PROCEDURE /*A Cláusula REPLACE faz com que uma função seja recriada se ela já existir.*/
    Testa_Parametros (X IN number, Y OUT number, Z IN OUT number)
        IS
        BEGIN
            Y:=X*2;
            Y:= Y+Z;
            Z:=Y+X+Z;
    END Testa_Parametros;
/*Executando a Stored Procedure*/
Set serveroutput on 
DECLARE
    Var1 number;
    Var2 number;
    Var3 number;
BEGIN
    Var1:=30;
    Var2:=40;
    Var3:=50;
    Dbms_Output.Put_Line(Var1||'-'||Var2||'-'||Var3);/*(X=30, Y=40, Z=50)*/
    Testa_Parametros(Var1,Var2,Var3);/*Stored Procedure: entra(X=30, Y=40, Z=50)→ sai(X=30, Y=110, Z=190)*/
    Dbms_Outpu.Put_Line(Var1||'-'||Var2||'-'||Var3);/*(X=30, Y=110, Z=190)*/
END;


/* (STORED FUNCTION)___________________________________________________________________________________________________________________________________________
    Função armazenada(também chamada de função do usuário ou função definida pelo usuário) ou Stored Function é 
    uma Sub-Rotina do tipo função, o seja, tem por objetivo retornar algum resultado ou retornar algum valor. 

    Sintaxe (parecida com a da Stored Procedure, com exceção do RETURNO que apenas as functions possuem):
    CREATE OR REPLACE FUNCTION 
        Nome_Funçao (Argumento1 modo Tipo_de_Dados, Argumento2 modo Tipo_de_Dados, Argumento3 modo Tipo_de_Dados)
            RETURN Tipo_de_Dado
            IS ou AS
            Variáveis locais, constantes,...
            BEGIN
                Bloco Pl/SQL
                Exception
        END nome_da_função

    obs: Não se usa Stored Function nos seguintes casos:
    • Em uma cláusula de restrição CHECK de um CREATE TABLE ou ALTER TABLE; 
    • Em uma cláusula DEFAULT de uma instrução CREATE TABLE ou ALTER TABLE.
    • Em uma consulta-DQL ou instrução-DML, a função não pode ter OUT ou IN OUT como parâmetros
*/

/*Ex: Sub-Rotina-Função (Stored Function) — há retorno —:*/
CREATE OR REPLACE FUNCTION /*A Cláusula REPLACE faz com que uma função seja recriada se ela já existir.*/
    balanco (numcont IN NUMBER) 
        RETURN NUMBER /*declara o tipo do retorno*/
        IS 
        contabalanco NUMBER(11,2);
        BEGIN 
            SELECT saldo_conta 
            INTO contabalanco 
            FROM pedidos 
            WHERE pedido_conta = numcont; 
            RETURN(contabalanco); /*retorno da função(retorna o saldo da conta especificada)*/
    END balanco;
/*Executando a Stored Function*/
SELECT balanco(12345) from dual /*12345 é o número da conta escolhida para a busca de seu saldo.*/


/* (EXCEPTION)_________________________________________________________________________________________________________________________________________________
    Exceções são tratamentos de erros e imprevistos, que podem ocorrer durante a execução de um bloco PL/SQL, através de manipuladores de exceção.
    
     Ao invés de verificar se existe um erro em um determinado ponto, adicionaremos um manipulador de 
    exceção para o bloco PL/SQL. Se a exceção é sempre executada nesse bloco (ou qualquer sub-bloco), 
    teremos certeza que será tratada.
     Às vezes, o erro não é muito óbvio e não pode ser detectado tão facilmente. Com um único 
    tratamento de exceção podemos capturar cálculos com dados incorretos, erros de divisão por zero 
    e assim por diante. Se houver a necessidade de realizar um tratamento em um ponto específico, 
    podemos colocar uma única instrução ou um grupo de instruções dentro de seu próprio bloco BEGIN-END.

    Sintaxe:
        EXCEPTION
            WHEN nome_da_exceção THEN
                Relação_de_comandos 
            WHEN nome_da_exceção THEN
                Relação_de_comandos

    Exceções pré-definidas no Oracle:
            EXCEÇÃO                Oracle Erro          SQLCODE Valor       OCASIÃO
        ACCESS_INTO_NULL            ORA-06530               -6530           Um programa tenta atribuir valores aos 
                                                                            atributos de um objeto não Inicializado.

        CASE_NOT_FOUND              ORA-06592               -6592           Nenhuma das opções nas cláusulas WHEN de uma declaração 
                                                                            CASE é selecionada, e não há cláusula ELSE.
                                                                            
        COLLECTION_IS_NULL          ORA-06531               -6531           Um programa tenta aplicar métodos de coleta que não existam a um tabela 
                                                                            aninhada não nitializada ou varray, ou o programa tenta atribuir valores 
                                                                            aos elementos de uma mesa aninhada uninitializada ou varray.
                                                                            
        CURSOR_ALREADY_OPEN         ORA-06511               -6511           Um programa tenta abrir um cursor já aberto. Um cursor deve ser fechado antes 
                                                                            que possa ser reaberto. Um cursor FOR loop é aberto automaticamente o cursor ao 
                                                                            qual se refere, de modo que o seu programa não pode abrir esse cursor dentro o loop.

        DUP_VAL_ON_INDEX            ORA-00001               -1              Um programa tenta armazenar valores duplicados em uma coluna 
                                                                            de banco de dados que é constrangido por um índice único.

        INVALID_CURSOR              ORA-01001               -1001           Um programa tenta uma operação de cursor que não é 
                                                                            permitida, como o fechamento um cursor não aberto.
        
        INVALID_NUMBER              ORA-01722               -1722           Em uma declaração SQL, a conversão de uma sequência de caracteres em um número falha 
                                                                            porque a sequência não representa um número válido. (Em procedimento declarações, 
                                                                            VALUE_ERROR é levantada.) Essa exceção também é levantada quando a expressão cláusula 
                                                                            LIMIT em uma declaração FETCH em massa não avalia um número positivo.

        LOGIN_DENIED                ORA-01017               -1017           Um programa tenta fazer logon no Oracle com um nome de usuário ou senha inválido.
        
        NO_DATA_FOUND               ORA-01403                100            Uma instrução SELECT INTO não retorna linhas ou seu programa faz referência a elemento 
                                                                            excluído em uma tabela aninhada ou um elemento nãonitializado em um índice- por tabela. 
                                                                            Porque esta exceção é usada internamente por algumas funções SQL para sinal de que eles 
                                                                            estão acabados, você não deve confiar nesta exceção sendo propagado se você elevá-lo 
                                                                            dentro de uma função que é chamada como parte de uma consulta.
                                                                            
        NOT_LOGGED_ON               ORA-01012               -1012           Um programa emite uma chamada de banco de dados sem estar conectado à Oracle. 

        PROGRAM_ERROR               ORA-06501               -6501           O PL/SQL tem um problema interno.

        ROWTYPE_MISMATCH            ORA-06504               -6504           Variável cursor hospedeiro e variável cursor PL/SQL envolvido em um a atribuição tem 
                                                                            tipos de retorno incompatíveis. Por exemplo, quando um aberto variável cursor host é 
                                                                            passado para um subprograma armazenado, os tipos de retorno do parâmetros reais e 
                                                                            formais devem ser compatíveis.

        SELF_IS_NULL                ORA-30625               -30625          Um programa tenta chamar um método MEMBRO, mas a instância do o tipo de objeto não foi 
                                                                            inicializado. O parâmetro embutido SELF aponta para o objeto, e é sempre o primeiro 
                                                                            parâmetro passado para um método MEMBRO.

        STORAGE_ERROR               ORA-06500               -6500           PL/SQL fica sem memória ou memória foi corrompida

        SUBSCRIPT_BEYOND_COUNT      ORA-06533               -6533           Um programa faz referência a uma tabela aninhada ou elemento varray usando um índice 
                                                                            número maior do que o número de elementos na coleção.

        SUBSCRIPT_OUTSIDE_LIMIT     ORA-06532               -6532           Um programa faz referência a uma tabela aninhada ou elemento varray usando um índice 
                                                                            número (-1, por exemplo) que está fora da faixa legal

        SYS_INVALID_ROWID           ORA-01410               -1410           A conversão de uma sequência de caracteres em um rowid universal falha porque o 
                                                                            sequência de caracteres não representa um rowid válido.

        TIMEOUT_ON_RESOURCE         ORA-00051               -51             Um intervalo ocorre enquanto o Oracle aguarda um recurso.

        TOO_MANY_ROWS               ORA-01422               -1422           Uma instrução SELECT INTO retorna mais de uma linha.

        VALUE_ERROR                 ORA-06502               -6502           Ocorre um erro aritmético, de conversão, truncação ou restrição de tamanho. Durante 
                                                                            exemplo, quando seu programa seleciona um valor de coluna em um caractere variável, 
                                                                            se o valor for maior do que o comprimento declarado da variável, PL/ SQL aborta a 
                                                                            tarefa e levanta VALUE_ERROR. No processo declarações, VALUE_ERROR é levantada se a 
                                                                            conversão de uma sequência de caracteres em um número falha. (Nas declarações do SQL, 
                                                                            INVALID_NUMBER é levantada).
                                                                            
        ZERO_DIVIDE                 ORA-01476               -1476           Um programa tenta dividir um número por zero.
      */