/* ————————— Exemplos de uso de Stored Procedure da PL/SQL(Program Language SQL) ————————— */


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
