'''
♦ Algoritmo 34: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore AVL.
'''


class No:
    def __init__(self, valor):
        self.valor = valor
        self.esquerda = None
        self.direita = None
        self.altura = 1

class ArvoreAVL:
    def __init__(self):
        self.raiz = None

    def altura(self, no):
        if no is None:
            return 0
        return no.altura

    def balanceamento(self, no):
        if no is None:
            return 0
        return self.altura(no.esquerda) - self.altura(no.direita)

    def rotacao_direita(self, y):
        x = y.esquerda
        T2 = x.direita

        x.direita = y
        y.esquerda = T2

        y.altura = max(self.altura(y.esquerda), self.altura(y.direita)) + 1
        x.altura = max(self.altura(x.esquerda), self.altura(x.direita)) + 1

        return x

    def rotacao_esquerda(self, x):
        y = x.direita
        T2 = y.esquerda

        y.esquerda = x
        x.direita = T2

        x.altura = max(self.altura(x.esquerda), self.altura(x.direita)) + 1
        y.altura = max(self.altura(y.esquerda), self.altura(y.direita)) + 1

        return y

    def inserir(self, valor):
        self.raiz = self.inserir_recursivo(self.raiz, valor)

    def inserir_recursivo(self, no, valor):
        if no is None:
            return No(valor)

        if valor < no.valor:
            no.esquerda = self.inserir_recursivo(no.esquerda, valor)
        elif valor > no.valor:
            no.direita = self.inserir_recursivo(no.direita, valor)
        else:
            return no

        no.altura = 1 + max(self.altura(no.esquerda), self.altura(no.direita))

        balanceamento = self.balanceamento(no)

        if balanceamento > 1 and valor < no.esquerda.valor:
            return self.rotacao_direita(no)

        if balanceamento < -1 and valor > no.direita.valor:
            return self.rotacao_esquerda(no)

        if balanceamento > 1 and valor > no.esquerda.valor:
            no.esquerda = self.rotacao_esquerda(no.esquerda)
            return self.rotacao_direita(no)

        if balanceamento < -1 and valor < no.direita.valor:
            no.direita = self.rotacao_direita(no.direita)
            return self.rotacao_esquerda(no)

        return no

    def imprimir_em_ordem_recursivo(self, no):
        if no is not None:
            self.imprimir_em_ordem_recursivo(no.esquerda)
            print(no.valor, end=" ")
            self.imprimir_em_ordem_recursivo(no.direita)

    def imprimir_em_ordem(self):
        self.imprimir_em_ordem_recursivo(self.raiz)


# Teste
arvore = ArvoreAVL()
arvore.inserir(10)
arvore.inserir(5)
arvore.inserir(20)
arvore.inserir(3)
arvore.inserir(8)
arvore.inserir(15)

print("Em Ordem:")
arvore.imprimir_em_ordem()
