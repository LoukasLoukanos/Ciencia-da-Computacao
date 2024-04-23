'''
♦ Algoritmo 33: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).
'''


class No:
    def __init__(self, valor):
        self.valor = valor
        self.esquerda = None
        self.direita = None

class ArvoreBinaria:
    def __init__(self):
        self.raiz = None

    def inserir(self, valor):
        self.raiz = self.inserir_recursivo(self.raiz, valor)

    def inserir_recursivo(self, no, valor):
        if no is None:
            return No(valor)

        if valor < no.valor:
            no.esquerda = self.inserir_recursivo(no.esquerda, valor)
        elif valor > no.valor:
            no.direita = self.inserir_recursivo(no.direita, valor)

        return no

    def buscar(self, valor):
        return self.buscar_recursivo(self.raiz, valor)

    def buscar_recursivo(self, no, valor):
        if no is None:
            return False

        if valor == no.valor:
            return True

        return self.buscar_recursivo(no.esquerda, valor) if valor < no.valor else self.buscar_recursivo(no.direita, valor)

    def imprimir_em_ordem(self):
        self.imprimir_em_ordem_recursivo(self.raiz)

    def imprimir_em_ordem_recursivo(self, no):
        if no is not None:
            self.imprimir_em_ordem_recursivo(no.esquerda)
            print(no.valor, end=" ")
            self.imprimir_em_ordem_recursivo(no.direita)

arvore = ArvoreBinaria()
arvore.inserir(10)
arvore.inserir(5)
arvore.inserir(20)
arvore.inserir(3)
arvore.inserir(8)
arvore.inserir(15)

print("Em Ordem:")
arvore.imprimir_em_ordem()

print("\n\nBuscar 8:", arvore.buscar(8))
print("Buscar 12:", arvore.buscar(12))
