'''
♦ Algoritmo 21: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária - Busca Binária (Binary Search Tree - BST) de tipo de dados genérico.
→ Operações:
    • Inserção e Remoção de Elementos;
    • Busca (pesquisa) de Elementos;
    • Encontrar o Mínimo e o Máximo;
    • Travessias (in-order, pre-order, post-order);
    • Verificar se é uma BST válida.
'''

class BinarySearchTree:
    class TreeNode:
        def __init__(self, data):
            self.data = data
            self.left = None
            self.right = None

    def __init__(self):
        self.root = None

    # Inserção de elementos
    def insert(self, data):
        self.root = self.insertRec(self.root, data)

    def insertRec(self, root, data):
        if root is None:
            return self.TreeNode(data)

        if data < root.data:
            root.left = self.insertRec(root.left, data)
        elif data > root.data:
            root.right = self.insertRec(root.right, data)

        return root

    # Remoção de elementos
    def delete(self, data):
        self.root = self.deleteRec(self.root, data)

    def deleteRec(self, root, data):
        if root is None:
            return root

        if data < root.data:
            root.left = self.deleteRec(root.left, data)
        elif data > root.data:
            root.right = self.deleteRec(root.right, data)
        else:
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left

            root.data = self.minValue(root.right)

            root.right = self.deleteRec(root.right, root.data)

        return root

    def minValue(self, root):
        min_value = root.data
        while root.left is not None:
            min_value = root.left.data
            root = root.left
        return min_value

    # Busca de elementos
    def search(self, data):
        return self.searchRec(self.root, data)

    def searchRec(self, root, data):
        if root is None:
            return False

        if root.data == data:
            return True

        if data < root.data:
            return self.searchRec(root.left, data)

        return self.searchRec(root.right, data)

    # Encontrar o Mínimo e o Máximo
    def findMin(self):
        if self.root is None:
            return None

        current = self.root
        while current.left is not None:
            current = current.left

        return current.data

    def findMax(self):
        if self.root is None:
            return None

        current = self.root
        while current.right is not None:
            current = current.right

        return current.data

    # Travessias (in-order, pre-order, post-order)
    def inOrder(self):
        self.inOrderRec(self.root)

    def inOrderRec(self, root):
        if root is not None:
            self.inOrderRec(root.left)
            print(root.data, end=" ")
            self.inOrderRec(root.right)

    def preOrder(self):
        self.preOrderRec(self.root)

    def preOrderRec(self, root):
        if root is not None:
            print(root.data, end=" ")
            self.preOrderRec(root.left)
            self.preOrderRec(root.right)

    def postOrder(self):
        self.postOrderRec(self.root)

    def postOrderRec(self, root):
        if root is not None:
            self.postOrderRec(root.left)
            self.postOrderRec(root.right)
            print(root.data, end=" ")

    # Verificar se é uma BST válida
    def isValidBST(self):
        return self.isValidBSTRec(self.root, None, None)

    def isValidBSTRec(self, root, min_value, max_value):
        if root is None:
            return True

        if (min_value is not None and root.data <= min_value) or (max_value is not None and root.data >= max_value):
            return False

        return self.isValidBSTRec(root.left, min_value, root.data) and self.isValidBSTRec(root.right, root.data, max_value)


tree = BinarySearchTree()
tree.insert(50)
tree.insert(30)
tree.insert(20)
tree.insert(40)
tree.insert(70)
tree.insert(60)
tree.insert(80)

print("In-order traversal:")
tree.inOrder()
print()

print("Pre-order traversal:")
tree.preOrder()
print()

print("Post-order traversal:")
tree.postOrder()
print()

print("Minimum value:", tree.findMin())
print("Maximum value:", tree.findMax())

searchValue = 40
print("Search for", searchValue, ":", tree.search(searchValue))

tree.delete(searchValue)
print("After deleting", searchValue, ":")
tree.inOrder()

print("\nIs valid BST?", tree.isValidBST())
