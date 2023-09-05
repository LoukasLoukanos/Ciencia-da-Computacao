''' 
 Algoritmo da Estrutura de dados linear estática (não dinâmica) genérica de 
 uma pilha (de regra de acesso LIFO) utilizando um array unidimensional (vetor)
 
Métodos:
 isEmpty - verificar se a pilha está vazia; 
 isFull - verificar se a pilha está cheia;
 push - inserir elementos no topo da pilha;
 pop - remover elementos do dopo da pilha;
 size - obter o tamanho atual da pilha;
 front - acessar o elemento do topo da pilha sem removê-lo;
 showStack - mostar elementos da pilha (do topo para base).
'''

class Alg03:
    def __init__(self, tamanhoMaximo):
        self.tamanhoMaximo = tamanhoMaximo
        self.topo = -1
        self.elementos = [None] * tamanhoMaximo

    def isEmpty(self):
        return self.topo == -1

    def isFull(self):
        return self.topo == self.tamanhoMaximo - 1

    def push(self, elemento):
        if self.isFull():
            print("A pilha está cheia. Não é possível empilhar o elemento.")
            return
        self.topo += 1
        self.elementos[self.topo] = elemento

    def pop(self):
        if self.isEmpty():
            print("A pilha está vazia. Não é possível desempilhar um elemento.")
            return None
        elemento = self.elementos[self.topo]
        self.topo -= 1
        return elemento

    def front(self):
        if self.isEmpty():
            print("A pilha está vazia. Não há elemento no topo.")
            return None
        return self.elementos[self.topo]

    def size(self):
        return self.topo + 1

    def showStack(self):
        if self.isEmpty():
            print("A pilha está vazia.")
            return
        print("Elementos da pilha (do topo para base):")
        for i in range(self.topo, -1, -1):
            print(self.elementos[i])

pilha = Alg03(5)

pilha.push(10)
pilha.push(20)
pilha.push(30)

print("Tamanho da pilha:", pilha.size())
print("Elemento no topo:", pilha.front())

pilha.pop()

print("Tamanho da pilha:", pilha.size())
print("Elemento no topo:", pilha.front())

pilha.showStack()
