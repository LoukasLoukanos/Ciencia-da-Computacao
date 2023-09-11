'''
♦ Estrutura de Dados Linear Estática de Fila Circular e Não-Circular (regra de acesso FIFO) de tipo de dados genérico: Algoritmo 02.
→ Operações:
    • isEmpty - verificar se a fila está vazia;
    • isFull - verificar se a fila está cheia;
    • enqueue - adicionar elementos;
    • dequeue - remover o elemento da frente da fila;
    • size - obter o tamanho atual da fila;
    • front - acessar o elemento da frente da fila sem removê-lo;
    • showQueue - mostar elementos da fila.

obs: Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços 
    livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.

obs: Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços 
    livres, caso haja, no início da fila.
'''

class FilaCircular:
    def __init__(self, capacidade):
        self.capacidade = capacidade
        self.elementos = [None] * capacidade
        self.tamanho = 0
        self.frente = 0
        self.traseira = -1

    # Verificar se a fila está vazia
    def isEmpty(self):
        return self.tamanho == 0

    # Verificar se a fila está cheia
    def isFull(self):
        return self.tamanho == self.capacidade

    # Adicionar elementos à fila (enqueue)
    def enqueue(self, elemento):
        if self.isFull():
            raise ValueError("A fila está cheia")

        self.traseira = (self.traseira + 1) % self.capacidade
        self.elementos[self.traseira] = elemento
        self.tamanho += 1

    # Remover o elemento da frente da fila (dequeue)
    def dequeue(self):
        if self.isEmpty():
            raise ValueError("A fila está vazia")

        elementoRemovido = self.elementos[self.frente]
        self.elementos[self.frente] = None
        self.frente = (self.frente + 1) % self.capacidade
        self.tamanho -= 1

        return elementoRemovido

    # Obter o tamanho atual da fila
    def size(self):
        return self.tamanho

    # Acessar o elemento da frente da fila sem removê-lo
    def front(self):
        if self.isEmpty():
            raise ValueError("A fila está vazia")

        return self.elementos[self.frente]

    # Mostrar elementos da fila
    def showQueue(self):
        index = self.frente
        for i in range(self.tamanho):
            print(self.elementos[index], end=" ")
            index = (index + 1) % self.capacidade
        print()

# Exemplo de uso
fila = FilaCircular(5)
fila.enqueue(1)
fila.enqueue(2)
fila.enqueue(3)

fila.showQueue()

print("Frente da fila:", fila.front())
print("Tamanho da fila:", fila.size())

fila.dequeue()
fila.showQueue()
