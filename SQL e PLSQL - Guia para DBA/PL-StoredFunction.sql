/* ————————— Exemplos de uso de Stored Function da PL/SQL(Program Language SQL) ————————— */


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

