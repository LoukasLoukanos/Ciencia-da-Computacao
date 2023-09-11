'''
♦ Algoritmo 12: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada) de tipo de dados genérico.
→ Operações:
    • addList: inserção em uma Lista Ligada Simples;
    • removeList: remoção em uma Lista Ligada Simples;
    • size - obter o tamanho atual da Lista Ligada Simples;
    • showList: exibição dos elementos da Lista Ligada Simples.
'''

class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.proximo = None

class ListaLigada:
    def __init__(self):
        self.primeiro = None
        self.tamanho = 0

    def addList(self, valor):
        novoNodo = Nodo(valor)
        novoNodo.proximo = self.primeiro
        self.primeiro = novoNodo
        self.tamanho += 1

    def removeList(self, valor):
        if self.primeiro is None:
            return

        if self.primeiro.valor == valor:
            self.primeiro = self.primeiro.proximo
            self.tamanho -= 1
            return

        nodoAtual = self.primeiro
        while nodoAtual.proximo is not None:
            if nodoAtual.proximo.valor == valor:
                nodoAtual.proximo = nodoAtual.proximo.proximo
                self.tamanho -= 1
                return
            nodoAtual = nodoAtual.proximo

    def size(self):
        return self.tamanho

    def showList(self):
        nodoAtual = self.primeiro
        while nodoAtual is not None:
            print(nodoAtual.valor, end=" ")
            nodoAtual = nodoAtual.proximo
        print()

lista = ListaLigada()
lista.addList(10)
lista.addList(20)
lista.addList(30)

print("Tamanho da lista:", lista.size())
print("Elementos da lista:", end=" ")
lista.showList()

lista.removeList(20)

print("Tamanho da lista após remoção:", lista.size())
print("Elementos da lista após remoção:", end=" ")
lista.showList()
