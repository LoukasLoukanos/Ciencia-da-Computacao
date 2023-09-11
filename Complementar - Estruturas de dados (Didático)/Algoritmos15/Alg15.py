'''
♦ Algoritmo 15: Estrutura de Dados Linear Dinâmica (não Estática) de Pilha (regra de acesso LIFO) de tipo de dados genérico.
→ Operações:
    • isEmpty - verificar se a pilha está vazia;
    • push - inserir elementos no topo da pilha;
    • pop - remover elementos do dopo da pilha;
    • size - obter o tamanho atual da pilha;
    • front - acessar o elemento do topo da pilha sem removê-lo;
    • showStack - mostar elementos da pilha (do topo para base).
'''

class PilhaDinamica:
    def __init__(self):
        self.pilha = []

    def is_empty(self):
        return len(self.pilha) == 0

    def push(self, elemento):
        self.pilha.insert(0, elemento)

    def pop(self):
        if self.is_empty():
            raise Exception("A pilha está vazia")
        self.pilha.pop(0)

    def size(self):
        return len(self.pilha)

    def front(self):
        if self.is_empty():
            raise Exception("A pilha está vazia")
        return self.pilha[0]

    def show_stack(self):
        print(" ".join(map(str, self.pilha)))

pilha = PilhaDinamica()

pilha.push(1)
pilha.push(2)
pilha.push(3)

pilha.show_stack()

print("Tamanho da pilha:", pilha.size())
print("Topo da pilha:", pilha.front())

pilha.pop()
pilha.show_stack()
