'''
 Algoritmo da Estrutura de dados linear dinâmica (não estática) 
 Alg14 de Fila (regra de acesso FIFO) Dinâmica
'''

class FilaDinamica:
    class Nodo:
        def __init__(self, dado):
            self.dado = dado
            self.proximo = None

    def __init__(self):
        self.cabeca = None
        self.cauda = None
        self.tamanho = 0

    # Verificar se a fila está vazia
    def isEmpty(self):
        return self.tamanho == 0

    # Adicionar elementos à fila (enqueue)
    def enqueue(self, dado):
        novoNodo = self.Nodo(dado)
        if self.isEmpty():
            self.cabeca = novoNodo
            self.cauda = novoNodo
        else:
            self.cauda.proximo = novoNodo
            self.cauda = novoNodo
        self.tamanho += 1

    # Remover o elemento da frente da fila (dequeue)
    def dequeue(self):
        if self.isEmpty():
            raise ValueError("A fila está vazia")

        dadoRemovido = self.cabeca.dado
        self.cabeca = self.cabeca.proximo
        self.tamanho -= 1

        if self.isEmpty():
            self.cauda = None

        return dadoRemovido

    # Obter o tamanho atual da fila
    def size(self):
        return self.tamanho

    # Acessar o elemento da frente da fila sem removê-lo
    def front(self):
        if self.isEmpty():
            raise ValueError("A fila está vazia")

        return self.cabeca.dado

    # Mostrar elementos da fila
    def showQueue(self):
        atual = self.cabeca
        while atual is not None:
            print(atual.dado, end=" ")
            atual = atual.proximo
        print()

# Exemplo de uso
fila = FilaDinamica()
fila.enqueue(1)
fila.enqueue(2)
fila.enqueue(3)

fila.showQueue()

print("Frente da fila:", fila.front())
print("Tamanho da fila:", fila.size())

fila.dequeue()
fila.showQueue()
