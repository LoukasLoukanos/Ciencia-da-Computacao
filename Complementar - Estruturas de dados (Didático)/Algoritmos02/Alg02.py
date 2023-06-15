class Alg02:
    def __init__(self, capacidade):
        self.capacidade = capacidade
        self.elementos = [None] * capacidade
        self.tamanho = 0
        self.inicio = 0
        self.fim = -1

    def isEmpty(self):
        return self.tamanho == 0

    def isFull(self):
        return self.tamanho == self.capacidade

    def enqueue(self, elemento):
        if self.isFull():
            print("A fila está cheia. Não é possível adicionar mais elementos.")
            return

        self.fim = (self.fim + 1) % self.capacidade
        self.elementos[self.fim] = elemento
        self.tamanho += 1

    def dequeue(self):
        if self.isEmpty():
            print("A fila está vazia. Não é possível remover elementos.")
            return None

        elementoRemovido = self.elementos[self.inicio]
        self.elementos[self.inicio] = None
        self.inicio = (self.inicio + 1) % self.capacidade
        self.tamanho -= 1
        return elementoRemovido

    def front(self):
        if self.isEmpty():
            print("A fila está vazia. Não há elementos para retornar.")
            return None

        return self.elementos[self.inicio]

    def size(self):
        return self.tamanho

    def showQueue(self):
        if self.isEmpty():
            print("A fila está vazia.")
            return
        print("Elementos da fila:")
        for i in range(self.tamanho):
            print(self.elementos[i])

fila = Alg02(5)
fila.enqueue(10)
fila.enqueue(20)
fila.enqueue(30)
print("Tamanho da fila:", fila.size())
print("Elemento na frente da fila:", fila.front())
print("Removendo elemento da fila:", fila.dequeue())
print("Tamanho da fila após remoção:", fila.size())

fila.showQueue()
