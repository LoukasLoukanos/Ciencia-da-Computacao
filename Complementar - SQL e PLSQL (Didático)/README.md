# **LINGUAGENS DE OPERAÇÕES DA SQL**

### **DDL - LINGUAGEM DE DEFINIÇÃO DE DADOS**
| <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DDL.sql">Exemplos DDL</a> |
|:-:|

***Comandos:*** 
```sql
CREATE /*Criar tabelas (TABLE):*/
    CONSTRAINTS /*Definir colunas, seus tipos de dados e restrições*/
    
ALTER /*Alterar tipo, obrigatoriedade, tamanho e restrições dos dados de tabelas:*/
    ADD /*Para incluir*/
    DROP /*Para excluir*/
    MODIFY /*Para modificar*/
    DISABLE /*Para desabilitar*/

DROP /*Excluir tabela (TABLE)*/
    RENAME /*para alterar o nome*/
```
</br>

### **DML - LINGUAGEM DE MANIPULAÇÃO DE DADOS**
| <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DML.sql">Exemplos DML</a> |
|:-:|

***Comandos:*** 
```sql
INSERT
    /*Inserir dados — VALUES —, em uma tabela — INTO —*/

UPDATE
    /*Atualizar linhas de colunas — SET —*/

DELETE
    /*Excluir linhas de colunas — FROM —*/
```
</br>

### **DQL - LINGUAGEM DE CONSULTA DE DADOS**
| <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DQL.sql">Exemplos DQL</a> |
|:-:|

***Comandos:*** 
```sql
SELECT 
  /*1. Visualizar linhas de SUBQUERY/INNERQUERY (sub pesquisa) e QUERYPRINCIPAL/OUTERQUERY (pesquisa principal):*/
   WHERE /*Cláusula para condições*/
   ORDER BY /*Cláusula para ordenanças*/
   DISTINCT /*Cláusula para distinções*/

  /*2. Manipular informações:*/
    CREATE TABLE AS SELECT /*Fazer cópias de tabelas*/
    DECODE e CASE /*Expressões para gerar colunas de consultas*/
    GROUP BY /*Cláusula para produzir grupos de dados gerando sumários*/
    HAVING /*Cláusula para estabelecer condições para listar grupos de dados*/
```
</br>

### **DTL - LINGUAGEM DE TRANSAÇÃO DE DADOS**
| <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DTL.sql">Exemplos DTL</a> |
|:-:|

***Comandos:*** 
```sql
BEGIN 
    /*Iniciar transação de informação*/

COMMIT 
    /*Terminar transação gravando as alterações realizadas*/

ROLLBACK 
    /*Terminar transação revertendo as alterações realizadas*/
```
</br>

### **DCL - LINGUAGEM DE CONTROLE DE DADOS**
| <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20SQL%20e%20PLSQL%20(Did%C3%A1tico)/DCL.sql">Exemplos DCL</a> |
|:-:|

***Comandos:*** 
```sql
GRANT
    /*Adicionar novas permissões a um usuário ao banco de dados*/

REVOKE
    /*Remover o acesso de um usuário ao banco de dados*/

DENY
    /*Impedir que um usuário receba uma permissão específica*/
```
