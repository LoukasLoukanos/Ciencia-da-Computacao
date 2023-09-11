'''
♦ Algoritmo 14: Estrutura de Dados Linear Dinâmica (não Estática) de Fila (regra de acesso FIFO) de tipo de dados genérico.
→ Operações:
    • isEmpty - verificar se a fila está vazia;
    • enqueue - adicionar elementos;
    • dequeue - remover o elemento da frente da fila;
    • size - obter o tamanho atual da fila;
    • front - acessar o elemento da frente da fila sem removê-lo;
    • showQueue - mostar elementos da fila.
'''

from collections import deque

class FilaDinamica:
    def __init__(self):
        self.fila = deque()

    def isEmpty(self):
        return len(self.fila) == 0

    def enqueue(self, elemento):
        self.fila.append(elemento)

    def dequeue(self):
        if self.isEmpty():
            raise ValueError("A fila está vazia")
        self.fila.popleft()

    def size(self):
        return len(self.fila)

    def front(self):
        if self.isEmpty():
            raise ValueError("A fila está vazia")
        return self.fila[0]

    def showQueue(self):
        print(" ".join(map(str, self.fila)))

fila = FilaDinamica()

fila.enqueue(1)
fila.enqueue(2)
fila.enqueue(3)

fila.showQueue()

print("Tamanho da fila:", fila.size())
print("Frente da fila:", fila.front())

fila.dequeue()
fila.showQueue()
