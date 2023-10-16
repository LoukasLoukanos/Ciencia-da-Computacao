'''
♦ Algoritmo 22: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária - Árvore AVL.
→ Operações:
    • Rotações para Rebalanceamento;
    • Inserção e Remoção com Rebalanceamento.
'''

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.height = 1

class AVLTree:
    def __init__(self):
        self.root = None

    def height(self, node):
        if node is None:
            return 0
        return node.height

    def balanceFactor(self, node):
        if node is None:
            return 0
        return self.height(node.left) - self.height(node.right)

    def rotateRight(self, y):
        x = y.left
        T2 = x.right

        x.right = y
        y.left = T2

        y.height = max(self.height(y.left), self.height(y.right)) + 1
        x.height = max(self.height(x.left), self.height(x.right)) + 1

        return x

    def rotateLeft(self, x):
        y = x.right
        T2 = y.left

        y.left = x
        x.right = T2

        x.height = max(self.height(x.left), self.height(x.right)) + 1
        y.height = max(self.height(y.left), self.height(y.right)) + 1

        return y

    def insert(self, data):
        self.root = self.insertNode(self.root, data)

    def insertNode(self, node, data):
        if node is None:
            return Node(data)

        if data < node.data:
            node.left = self.insertNode(node.left, data)
        elif data > node.data:
            node.right = self.insertNode(node.right, data)
        else:
            return node  # Duplicatas não são permitidas

        node.height = 1 + max(self.height(node.left), self.height(node.right))

        balance = self.balanceFactor(node)

        # Casos de desequilíbrio
        if balance > 1:
            if data < node.left.data:
                # Rotação simples à direita
                return self.rotateRight(node)
            else:
                # Rotação dupla à esquerda-direita
                node.left = self.rotateLeft(node.left)
                return self.rotateRight(node)

        if balance < -1:
            if data > node.right.data:
                # Rotação simples à esquerda
                return self.rotateLeft(node)
            else:
                # Rotação dupla à direita-esquerda
                node.right = self.rotateRight(node.right)
                return self.rotateLeft(node)

        return node

    def remove(self, data):
        self.root = self.removeNode(self.root, data)

    def removeNode(self, node, data):
        if node is None:
            return node

        if data < node.data:
            node.left = self.removeNode(node.left, data)
        elif data > node.data:
            node.right = self.removeNode(node.right, data)
        else:
            if node.left is None or node.right is None:
                temp = node.left if node.left is not None else node.right

                if temp is None:
                    temp = node
                    node = None
                else:
                    node = temp
            else:
                temp = self.findMin(node.right)
                node.data = temp.data
                node.right = self.removeNode(node.right, temp.data)

        if node is None:
            return node

        node.height = 1 + max(self.height(node.left), self.height(node.right))

        balance = self.balanceFactor(node)

        # Casos de desequilíbrio
        if balance > 1:
            if self.balanceFactor(node.left) >= 0:
                # Rotação simples à direita
                return self.rotateRight(node)
            else:
                # Rotação dupla à esquerda-direita
                node.left = self.rotateLeft(node.left)
                return self.rotateRight(node)

        if balance < -1:
            if self.balanceFactor(node.right) <= 0:
                # Rotação simples à esquerda
                return self.rotateLeft(node)
            else:
                # Rotação dupla à direita-esquerda
                node.right = self.rotateRight(node.right)
                return self.rotateLeft(node)

        return node

    def findMin(self, node):
        while node.left is not None:
            node = node.left
        return node

    def inorder(self):
        self.inorderTraversal(self.root)
        print()

    def inorderTraversal(self, node):
        if node is not None:
            self.inorderTraversal(node.left)
            print(node.data, end=" ")
            self.inorderTraversal(node.right)

if __name__ == "__main__":
    tree = AVLTree()

    tree.insert(10)
    tree.insert(20)
    tree.insert(30)
    tree.insert(40)
    tree.insert(50)

    print("Árvore AVL In-Order:")
    tree.inorder()

    tree.remove(30)
    tree.remove(40)

    print("Árvore AVL In-Order após a remoção de 30 e 40:")
    tree.inorder()

