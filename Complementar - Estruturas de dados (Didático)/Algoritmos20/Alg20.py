'''
♦ Algoritmo 20: Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 13: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada de tipo de dados genérico].
→ Operações:
    • Busca de um valor em uma Lista Duplamente Ligada;
    • Identificar o menor valor em uma Lista Duplamente Ligada;
    • Identificar o maior valor em uma Lista Duplamente Ligada;
    • Retornar o sucessor de um valor em uma Lista Duplamente Ligada;
    • Retornar o predecessor de um valor em uma Lista Duplamente Ligada.
'''

class Node:
    def __init__(self, value):
        self.value = value
        self.previous = None
        self.next = None

class DoublyLinkedList:
    def __init__(self):
        self.first = None

    def search_list(self, value):
        current_node = self.first
        while current_node is not None:
            if current_node.value == value:
                return True
            current_node = current_node.next
        return False

    def find_minimum(self):
        if self.first is None:
            return None

        current_node = self.first
        min_value = current_node.value

        while current_node is not None:
            if current_node.value < min_value:
                min_value = current_node.value
            current_node = current_node.next
        return min_value

    def find_maximum(self):
        if self.first is None:
            return None

        current_node = self.first
        max_value = current_node.value

        while current_node is not None:
            if current_node.value > max_value:
                max_value = current_node.value
            current_node = current_node.next
        return max_value

    def get_successor(self, value):
        current_node = self.first
        while current_node is not None:
            if current_node.value == value:
                if current_node.next is not None:
                    return current_node.next.value
                break
            current_node = current_node.next
        return None

    def get_predecessor(self, value):
        if self.first is None or self.first.value == value:
            return None

        current_node = self.first
        while current_node is not None and current_node.next is not None:
            if current_node.next.value == value:
                return current_node.value
            current_node = current_node.next
        return None

# Exemplo de uso:
linked_list = DoublyLinkedList()
linked_list.search_list(10)
linked_list.find_minimum()
linked_list.find_maximum()
linked_list.get_successor(10)
linked_list.get_predecessor(10)
