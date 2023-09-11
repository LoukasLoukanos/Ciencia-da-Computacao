'''
♦ Algoritmo 13: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada de tipo de dados genérico.
→ Operações:
    • addList: inserção em uma Lista Duplamente Ligada;
    • removeList: remoção em uma Lista Duplamente Ligada;
    • size - obter o tamanho atual da Lista Duplamente Ligada;
    • showList: exibição dos elementos da Lista Duplamente Ligada.
'''

class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.anterior = None
        self.proximo = None

class ListaDuplamenteLigada:
    def __init__(self):
        self.primeiro = None
        self.ultimo = None
        self.tamanho = 0

    def add_list(self, valor):
        novo_nodo = Nodo(valor)
        if self.primeiro is None:
            self.primeiro = novo_nodo
            self.ultimo = novo_nodo
        else:
            novo_nodo.anterior = self.ultimo
            self.ultimo.proximo = novo_nodo
            self.ultimo = novo_nodo
        self.tamanho += 1

    def remove_list(self, valor):
        nodo_atual = self.primeiro
        while nodo_atual is not None:
            if nodo_atual.valor == valor:
                if nodo_atual == self.primeiro:
                    self.primeiro = nodo_atual.proximo
                    if self.primeiro is not None:
                        self.primeiro.anterior = None
                elif nodo_atual == self.ultimo:
                    self.ultimo = nodo_atual.anterior
                    if self.ultimo is not None:
                        self.ultimo.proximo = None
                else:
                    anterior = nodo_atual.anterior
                    proximo = nodo_atual.proximo
                    anterior.proximo = proximo
                    proximo.anterior = anterior
                self.tamanho -= 1
                return
            nodo_atual = nodo_atual.proximo

    def size(self):
        return self.tamanho

    def show_list(self):
        nodo_atual = self.primeiro
        while nodo_atual is not None:
            print(nodo_atual.valor, end=" ")
            nodo_atual = nodo_atual.proximo
        print()

lista = ListaDuplamenteLigada()
lista.add_list(10)
lista.add_list(20)
lista.add_list(30)

print("Tamanho da lista:", lista.size())
print("Elementos da lista:", end=" ")
lista.show_list()

lista.remove_list(20)

print("Tamanho da lista após remoção:", lista.size())
print("Elementos da lista após remoção:", end=" ")
lista.show_list()
