'''
 Algoritmo da Estrutura de dados linear dinâmica (não estática) ListaDuplamenteLigada 
 de Lista Duplamente Ligada, também conhecida como Lista Duplamente Encadeada
'''

class ListaDuplamenteLigada:
    class Nodo:
        def __init__(self, dado):
            self.dado = dado
            self.proximo = None
            self.anterior = None

    def __init__(self):
        self.cabeca = None
        self.cauda = None
        self.tamanho = 0

    # Inserir um elemento no final da lista
    def addList(self, dado):
        novoNodo = self.Nodo(dado)
        if self.cabeca is None:
            self.cabeca = novoNodo
            self.cauda = novoNodo
        else:
            novoNodo.anterior = self.cauda
            self.cauda.proximo = novoNodo
            self.cauda = novoNodo
        self.tamanho += 1

    # Remover um elemento da lista
    def removeList(self, dado):
        atual = self.cabeca
        while atual is not None:
            if atual.dado == dado:
                if atual == self.cabeca:
                    self.cabeca = atual.proximo
                    if self.cabeca is not None:
                        self.cabeca.anterior = None
                elif atual == self.cauda:
                    self.cauda = atual.anterior
                    if self.cauda is not None:
                        self.cauda.proximo = None
                else:
                    atual.anterior.proximo = atual.proximo
                    atual.proximo.anterior = atual.anterior
                self.tamanho -= 1
                return
            atual = atual.proximo

    # Exibir os elementos da lista
    def showList(self):
        atual = self.cabeca
        while atual is not None:
            print(atual.dado, end=" ")
            atual = atual.proximo
        print()


if __name__ == "__main__":
    lista = ListaDuplamenteLigada()
    lista.addList(1)
    lista.addList(2)
    lista.addList(3)
    lista.showList()

    lista.removeList(2)
    lista.showList()
