# **LINGUAGENS DE OPERAÇÕES DA SQL**

**DDL - LINGUAGEM DE DEFINIÇÃO DE DADOS**</br>
*Comandos:*

- CREATE:
  - Criar tabelas (TABLE):
    - Definir colunas, seus tipos de dados e restrições — CONSTRAINTS —</br>
- ALTER:
  - Alterar tipo, obrigatoriedade, tamanho e restrições dos dados de tabelas:
    - Para incluir — ADD —
    - Para excluir — DROP —
    - Para modificar — MODIFY —
    - Para desabilitar — DISABLE — </br>
- DROP:
  - Excluir tabela (TABLE) — para alterar o nome utiliza-se RENAME —</br>
</br>

**DML - LINGUAGEM DE MANIPULAÇÃO DE DADOS**</br>
*Comandos:*

- INSERT:
  - Inserir dados — VALUES —, em uma tabela — INTO —
- UPDATE:
  - Atualizar linhas de colunas — SET —
- DELETE:
  - Excluir linhas de colunas — FROM —
</br>

**DQL - LINGUAGEM DE CONSULTA DE DADOS**</br>
*Comando:*

- SELECT:  
  - Visualizar linhas de SUBQUERY/INNERQUERY (sub pesquisa) e QUERYPRINCIPAL/OUTERQUERY (pesquisa principal):
    - Com condições — CLÁUSULA WHERE —
    - Com ordenanças — CLÁUSULA ORDER BY —
    - Com distinções — CLÁUSULA DISTINCT —
  - Manipular informações:
    - Fazer cópias de tabelas — CREATE TABLE AS SELECT —
    - Gerar colunas de consultas — EXPRESSÃO DECODE e EXPRESSÃO CASE —
    - Produzir grupos de dados gerando sumários — CLÁUSULA GROUP BY —
    - Estabelecer condições para listar grupos de dados — CLÁUSULA HAVING —</br>
</br>

**DTL - LINGUAGEM DE TRANSAÇÃO DE DADOS**</br>
*Comandos:*

- BEGIN:
  - Iniciar transação de informação
- COMMIT:
  - Terminar transação gravando as alterações realizadas
- ROLLBACK:
  - Terminar transação revertendo as alterações realizadas
</br>

**DCL - LINGUAGEM DE CONTROLE DE DADOS**</br>
*Comandos:*

- GRANT:
  - Adicionar novas permissões a um usuário ao banco de dados
- REVOKE:
  - Remover o acesso de um usuário ao banco de dados
- DENY:
  - Impedir que um usuário receba uma permissão específica</br>
</br>
