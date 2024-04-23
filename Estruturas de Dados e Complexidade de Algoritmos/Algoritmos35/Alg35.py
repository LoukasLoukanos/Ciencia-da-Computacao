'''
♦ Algoritmo 35: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore Rubro-Negra.
'''


class No:
    def __init__(self, valor):
        self.valor = valor
        self.esquerda = None
        self.direita = None
        self.vermelho = True  # Por padrão, os nós são vermelhos quando adicionados à árvore

class ArvoreRubroNegra:
    def __init__(self):
        self.raiz = None
        self.VERMELHO = True
        self.PRETO = False

    # Verifica se um nó é vermelho
    def isVermelho(self, no):
        if no is None:
            return False
        return no.vermelho == self.VERMELHO

    # Realiza uma rotação para a esquerda em torno do nó dado
    def rotacaoEsquerda(self, no):
        temp = no.direita
        no.direita = temp.esquerda
        temp.esquerda = no
        temp.vermelho = no.vermelho
        no.vermelho = self.VERMELHO
        return temp

    # Realiza uma rotação para a direita em torno do nó dado
    def rotacaoDireita(self, no):
        temp = no.esquerda
        no.esquerda = temp.direita
        temp.direita = no
        temp.vermelho = no.vermelho
        no.vermelho = self.VERMELHO
        return temp

    # Inverte as cores do nó e de seus filhos
    def inverterCores(self, no):
        no.vermelho = not no.vermelho
        no.esquerda.vermelho = not no.esquerda.vermelho
        no.direita.vermelho = not no.direita.vermelho

    # Insere um novo nó na árvore Rubro-Negra
    def inserir(self, valor):
        self.raiz = self.inserirRecursivo(self.raiz, valor)
        self.raiz.vermelho = self.PRETO  # A raiz sempre será preta

    # Método auxiliar recursivo para inserção
    def inserirRecursivo(self, no, valor):
        if no is None:
            return No(valor)

        # Inserção normal como em uma árvore de busca binária
        if valor < no.valor:
            no.esquerda = self.inserirRecursivo(no.esquerda, valor)
        elif valor > no.valor:
            no.direita = self.inserirRecursivo(no.direita, valor)
        else:
            return no  # Valor já existe na árvore

        # Correção da propriedade de cor após a inserção
        if self.isVermelho(no.direita) and not self.isVermelho(no.esquerda):
            no = self.rotacaoEsquerda(no)
        if self.isVermelho(no.esquerda) and self.isVermelho(no.esquerda.esquerda):
            no = self.rotacaoDireita(no)
        if self.isVermelho(no.esquerda) and self.isVermelho(no.direita):
            self.inverterCores(no)

        return no

    # Método para imprimir a árvore em ordem
    def imprimirEmOrdem(self):
        self.imprimirEmOrdemRecursivo(self.raiz)

    # Método auxiliar recursivo para impressão em ordem
    def imprimirEmOrdemRecursivo(self, no):
        if no is not None:
            self.imprimirEmOrdemRecursivo(no.esquerda)
            print(no.valor, end=" ")
            self.imprimirEmOrdemRecursivo(no.direita)

    # Método para verificar se a árvore Rubro-Negra está vazia
    def estaVazia(self):
        return self.raiz is None

# Teste
arvore = ArvoreRubroNegra()
arvore.inserir(10)
arvore.inserir(5)
arvore.inserir(20)
arvore.inserir(3)
arvore.inserir(8)
arvore.inserir(15)

print("Em Ordem:", end=" ")
arvore.imprimirEmOrdem()
