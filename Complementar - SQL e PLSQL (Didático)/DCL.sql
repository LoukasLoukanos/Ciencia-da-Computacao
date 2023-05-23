/*  Neste arquivo são apresentados exemplos de uso do comandos GRANT, REVOKE e DENY da linguagem de operação DCL (Linguagem de Controle de Dados) da SQL.
    Esse conjunto de comandos fornece a possibilidade de definir e remover permissões de banco de dados.

• GRANT: Adiciona novas permissões a um usuário do banco de dados._______________________________________________________________________________________________
    Sintaxe:
        GRANT [privilege]   - Privilégio: pode ser a palavra-chave ALL (para conceder uma ampla variedade de permissões) ou uma permissão de banco de dados 
                              específico ou conjunto de permissões. Os exemplos incluem CREATE DATABASE, SELECT, INSERT, UPDATE, DELETE, EXECUTE e CREATE VIEW.
        
        ON [object]         - Objeto: pode ser qualquer objeto de banco de dados. As opções de privilégio válidas variam com base no tipo de objeto de banco 
                              de dados que você inclui nesta cláusula. Normalmente, o objeto será um banco de dados, função, procedimento armazenado, tabela 
                              ou visualização.

        TO [user]           - Usuário: pode ser qualquer usuário do banco de dados. Você também pode substituir uma função para o usuário nesta cláusula se 
                              desejar fazer uso da segurança de banco de dados baseada em função.

        [WITH GRANT OPTION] - Cláusula opcional WITH GRANT OPTION no final do comando GRANT: não apenas concederá ao usuário especificado as permissões definidas 
                              na instrução SQL, mas também dará ao usuário permissão para conceder essas mesmas permissões a outros usuários do banco de dados. 
                              Por esse motivo, use esta cláusula com cuidado.

Ex: Conceder ao usuário Joe a capacidade de recuperar informações da tabela de funcionários em um banco de dados chamado RH:*/
GRANT SELECT
ON HR.employees
TO Joe

/*
• REVOKE: Remove o acesso ao banco de dados de um usuário que tenha previamente concedido tal acesso.____________________________________________________________
    Sintaxe:                    
                                                - Permissão: especifica as permissões do banco de dados a serem removidas do usuário identificado. 
                                                  O comando revoga as afirmações GRANT e DENY feitas anteriormente para a permissão identificada.
        REVOKE [GRANT OPTION FOR] [permission]  - A cláusula GRANT OPTION FOR: remove a capacidade do usuário especificado de conceder a permissão 
                                                  especificada a outros usuários. Se você incluir a cláusula GRANT OPTION FOR em uma instrução REVOKE, 
                                                  a permissão primária não será revogada. Esta cláusula revoga apenas a capacidade de concessão.

        ON [object]                             - Objeto: pode ser qualquer objeto de banco de dados. As opções de privilégio válidas variam com 
                                                  base no tipo de objeto de banco de dados que você inclui nesta cláusula. Normalmente, o objeto 
                                                  será um banco de dados, função, procedimento armazenado, tabela ou visualização.
    
        FROM [user]                             - Usuário: pode ser qualquer usuário do banco de dados. Você também pode substituir uma função para 
                                                  o usuário nesta cláusula se desejar fazer uso da segurança de banco de dados baseada em função.
    
        [CASCADE]                               - CASCADE: também revoga a permissão especificada de todos os usuários aos quais o usuário 
                                                  especificado concedeu a permissão.

Ex: Revogar a permissão concedida a Joe no exemplo anterior:*/
REVOKE SELECT
ON HR.employees
FROM Joe

/*
• DENY: Impede explicitamente que um usuário receba uma permissão específica.____________________________________________________________________________________ 
    Sintaxe:
        DENY [permission]       - Mesmo parâmetro de GRANT
        
        ON [object]             - Mesmo parâmetro de GRANT
        
        TO [user]               - Mesmo parâmetro de GRANT

Ex: Garantir que Matthew nunca receba a capacidade de excluir informações da tabela de funcionários*/
DENY DELETE
ON HR.employees
TO Matthew
