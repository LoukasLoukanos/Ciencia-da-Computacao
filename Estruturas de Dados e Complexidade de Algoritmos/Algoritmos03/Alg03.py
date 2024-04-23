'''
♦ Algoritmo 03: Estrutura de Dados Linear Estática (não Dinâmica) de Pilha: Stack (Pilha).
'''

class Pilha:
    def __init__(self, capacidade):
        self.capacidade = capacidade
        self.elementos = [None] * capacidade
        self.topo = -1

    # Verificar se a pilha está vazia
    def isEmpty(self):
        return self.topo == -1

    # Verificar se a pilha está cheia
    def isFull(self):
        return self.topo == self.capacidade - 1

    # Inserir elementos no topo da pilha
    def push(self, elemento):
        if self.isFull():
            raise Exception("A pilha está cheia")

        self.topo += 1
        self.elementos[self.topo] = elemento

    # Remover elementos do topo da pilha
    def pop(self):
        if self.isEmpty():
            raise Exception("A pilha está vazia")

        elemento_removido = self.elementos[self.topo]
        self.elementos[self.topo] = None
        self.topo -= 1

        return elemento_removido

    # Obter o tamanho atual da pilha
    def size(self):
        return self.topo + 1

    # Acessar o elemento do topo da pilha sem removê-lo
    def front(self):
        if self.isEmpty():
            raise Exception("A pilha está vazia")

        return self.elementos[self.topo]

    # Mostrar elementos da pilha (do topo para base)
    def showStack(self):
        for i in range(self.topo, -1, -1):
            print(self.elementos[i], end=" ")
        print()

pilha = Pilha(5)
pilha.push(1)
pilha.push(2)
pilha.push(3)

pilha.showStack()

print("Topo da pilha:", pilha.front())
print("Tamanho da pilha:", pilha.size())

pilha.pop()
pilha.showStack()
