from typing import Deque, Any, Iterator
from collections import deque

#algoritimo para fila com estrutura encadeada: inserções ocorrem no final e remoções ocorrem no começo. 
class Nodo:
    """Esta classe representa um nodo de uma estrutura duplamente encadeada."""
    def __init__(self, dado=0, proximo_nodo=None):
        self.dado = dado
        self.proximo = proximo_nodo

    def __repr__(self):
        return '%s -> %s' % (self.dado, self.proximo)


class Fila:
    """Esta classe representa uma fila usando uma estrutura encadeada."""

    def __init__(self):
        self.primeiro = None
        self.ultimo   = None


    def __repr__(self):
        return "[" + str(self.primeiro) + "]"


#O código a seguir mostra a implementação de uma função que insere um elemento em uma fila.
def insere(self, novo_dado):
    """Insere um elemento no final da fila."""

    # Cria um novo nodo com o dado a ser armazenado.
    novo_nodo = Nodo(novo_dado)

    # Insere em uma fila vazia.
    if self.primeiro == None:
        self.primeiro = novo_nodo
        self.ultimo = novo_nodo
    else:
        # Faz com que o novo nodo seja o último da fila.
        self.ultimo.proximo = novo_nodo

        # Faz com que o último da fila referencie o novo nodo.
        self.ultimo = novo_nodo


#O seguinte códimo mostra a implementação de uma função que remove um elemento de uma fila.
def remove(self):
    """Remove o último elemento da fila."""

    assert self.primeiro != None, "Impossível remover elemento de fila vazia."

    self.primeiro = self.primeiro.proximo

    if self.primeiro == None:
        self.ultimo = None


#Vejamos agora como usar nossa implementação de fila.

# Cria uma fila vazia.
fila = Fila()
print("Fila vazia: ", fila)

# Insere elementos na fila.
for i in range(5):
    fila.insere(i)
    print("Insere o valor {0} final da fila: {1}".format(i, fila))

# Remove elementos da fila.
while fila.primeiro != None:
    fila.remove()
    print("Removendo elemento que está no começo da fila: ", fila)
'''output:
Fila vazia:  [None]
Insere o valor 0 final da fila: [0 -> None]
Insere o valor 1 final da fila: [0 -> 1 -> None]
Insere o valor 2 final da fila: [0 -> 1 -> 2 -> None]
Insere o valor 3 final da fila: [0 -> 1 -> 2 -> 3 -> None]
Insere o valor 4 final da fila: [0 -> 1 -> 2 -> 3 -> 4 -> None]
Removendo elemento que está no começo da fila:  [1 -> 2 -> 3 -> 4 -> None]
Removendo elemento que está no começo da fila:  [2 -> 3 -> 4 -> None]
Removendo elemento que está no começo da fila:  [3 -> 4 -> None]
Removendo elemento que está no começo da fila:  [4 -> None]
Removendo elemento que está no começo da fila:  [None]
'''


'''------------------------------------------------------------------------------------------------
Encapsulando deque em uma classe para manter o controle sobre os métodos que deverão ser utilizados 
para manter o comportamento FIFO das filas. Afinal, deque permite as regras de acesso FIFO e LIFO.
'''
class Queue:
    """Uma classe representando uma fila"""

    def __init__(self, maxlen=None) -> None:
        # Deque permite enviar maxlen
        # para criar um tamanho máximo para
        # a fila
        self.__items: Deque[Any] = deque(maxlen=maxlen)

    def enqueue(self, *items: Any) -> None:
        """Enqueue (enfileirar) é o mesmo que append"""
        for item in items:
            self.__items.append(item)

    def dequeue(self) -> Any:
        """Dequeue (desenfileirar) é o mesmo que popleft"""
        if not self:
            raise IndexError('pop from empty queue')

        return self.__items.popleft()

    def __repr__(self) -> str:
        return str(self.__items)

    def __bool__(self) -> bool:
        return bool(self.__items)

    def __len__(self) -> int:
        return len(self.__items)

    def __iter__(self) -> Iterator:
        return self.__items.__iter__()

    def __getitem__(self, index: int) -> Any:
        return self.__items[index]


#Exemplo de uso:
if __name__ == "__main__":
    # Instanciando
    fila = Queue()

    # Enfileirando A, B, C e D
    fila.enqueue('A', 'B', 'C', 'D')

    # Obtendo o elemento com índice 1 (B)
    print('Item com índice 1:', fila[1], end='\n\n')

    # Iterando com for em nossa fila
    for item in fila:
        print('Iteração:', item)

    """
    Resultado:

    Item com índice 1: B

    Iteração: A
    Iteração: B
    Iteração: C
    Iteração: D
    """