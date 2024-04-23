'''
♦ Algoritmo 19: Algoritmo de Pesquisa/Busca para a Estrutura de Dados Linear Dinâmica (não Estática) Lista Ligada (ou Encadeada) Simples: Busca em Lista Ligada.
'''

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.size = 0

    def insert(self, value):
        new_node = Node(value)
        new_node.next = self.head
        self.head = new_node
        self.size += 1

    def remove(self, value):
        if self.head is None:
            return

        if self.head.value == value:
            self.head = self.head.next
            self.size -= 1
            return

        current = self.head
        prev = None

        while current is not None:
            if current.value == value:
                prev.next = current.next
                self.size -= 1
                return
            prev = current
            current = current.next

    def size(self):
        return self.size

    def display(self):
        current = self.head
        while current is not None:
            print(current.value, end=" ")
            current = current.next
        print()

    def search(self, value):
        current = self.head
        while current is not None:
            if current.value == value:
                return True  # Valor encontrado
            current = current.next
        return False  # Valor não encontrado

    def find_minimum(self):
        if self.head is None:
            return None

        current = self.head
        min_value = current.value

        while current is not None:
            if current.value < min_value:
                min_value = current.value
            current = current.next
        return min_value

    def find_maximum(self):
        if self.head is None:
            return None

        current = self.head
        max_value = current.value

        while current is not None:
            if current.value > max_value:
                max_value = current.value
            current = current.next
        return max_value

    def get_successor(self, value):
        current = self.head
        while current is not None:
            if current.value == value:
                if current.next is not None:
                    return current.next.value
                break  # Último elemento, não há sucessor
            current = current.next
        return None  # Valor não encontrado ou é o último

    def get_predecessor(self, value):
        if self.head is None or self.head.value == value:
            return None  # Valor não encontrado ou é o primeiro

        current = self.head
        while current is not None and current.next is not None:
            if current.next.value == value:
                return current.value
            current = current.next
        return None  # Valor não encontrado

# Exemplo de uso
list = LinkedList()
list.insert(10)
list.insert(20)
list.insert(30)

print("Tamanho da lista:", list.size())
print("Elementos da lista:", end=" ")
list.display()

print("Buscar 20:", list.search(20))
print("Menor valor:", list.find_minimum())
print("Maior valor:", list.find_maximum())
print("Sucessor de 20:", list.get_successor(20))
print("Predecessor de 20:", list.get_predecessor(20))

list.remove(20)

print("Tamanho da lista após remoção:", list.size())
print("Elementos da lista após remoção:", end=" ")
list.display()
