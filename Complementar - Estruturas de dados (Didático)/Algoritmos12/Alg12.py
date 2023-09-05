'''
 Algoritmo da Estrutura de dados linear dinâmica (não estática) 
 ListaLigada de Lista Ligada, também conhecida como Lista Encadeada 
'''

class ListaLigada:
    class No:
        def __init__(self, dado):
            self.dado = dado
            self.proximo = None

    def __init__(self):
        self.cabeca = None

    # Adicionar um elemento no final da lista
    def addList(self, dado):
        novoNo = self.No(dado)
        if self.cabeca is None:
            self.cabeca = novoNo
        else:
            atual = self.cabeca
            while atual.proximo is not None:
                atual = atual.proximo
            atual.proximo = novoNo

    # Remover um elemento da lista
    def removeList(self, dado):
        if self.cabeca is None:
            return

        if self.cabeca.dado == dado:
            self.cabeca = self.cabeca.proximo
            return

        atual = self.cabeca
        anterior = None
        while atual is not None and atual.dado != dado:
            anterior = atual
            atual = atual.proximo

        if atual is None:
            return

        anterior.proximo = atual.proximo

    # Imprimir a lista
    def showList(self):
        atual = self.cabeca
        while atual is not None:
            print(atual.dado, end=" ")
            atual = atual.proximo
        print()

if __name__ == "__main__":
    lista = ListaLigada()
    lista.addList(1)
    lista.addList(2)
    lista.addList(3)
    lista.showList()

    lista.removeList(2)
    lista.showList()
