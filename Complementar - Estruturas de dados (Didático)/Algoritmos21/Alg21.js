/*
♦ Algoritmo 21: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária - Busca Binária (Binary Search Tree - BST) de tipo de dados genérico.
→ Operações:
    • Inserção e Remoção de Elementos;
    • Busca (pesquisa) de Elementos;
    • Encontrar o Mínimo e o Máximo;
    • Travessias (in-order, pre-order, post-order);
    • Verificar se é uma BST válida.
*/

class BinarySearchTree {
    constructor() {
        this.root = null;
    }

    // Inserção de elementos
    insert(data) {
        this.root = this.insertRec(this.root, data);
    }

    insertRec(root, data) {
        if (root === null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = this.insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = this.insertRec(root.right, data);
        }

        return root;
    }

    // Remoção de elementos
    delete(data) {
        this.root = this.deleteRec(this.root, data);
    }

    deleteRec(root, data) {
        if (root === null) {
            return root;
        }

        if (data < root.data) {
            root.left = this.deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = this.deleteRec(root.right, data);
        } else {
            if (root.left === null) {
                return root.right;
            } else if (root.right === null) {
                return root.left;
            }

            root.data = this.minValue(root.right);

            root.right = this.deleteRec(root.right, root.data);
        }

        return root;
    }

    minValue(root) {
        let minValue = root.data;
        while (root.left !== null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Busca de elementos
    search(data) {
        return this.searchRec(this.root, data);
    }

    searchRec(root, data) {
        if (root === null) {
            return false;
        }

        if (root.data === data) {
            return true;
        }

        if (data < root.data) {
            return this.searchRec(root.left, data);
        }

        return this.searchRec(root.right, data);
    }

    // Encontrar o Mínimo e o Máximo
    findMin() {
        if (this.root === null) {
            return null;
        }

        let current = this.root;
        while (current.left !== null) {
            current = current.left;
        }

        return current.data;
    }

    findMax() {
        if (this.root === null) {
            return null;
        }

        let current = this.root;
        while (current.right !== null) {
            current = current.right;
        }

        return current.data;
    }

    // Travessias (in-order, pre-order, post-order)
    inOrder() {
        this.inOrderRec(this.root);
    }

    inOrderRec(root) {
        if (root !== null) {
            this.inOrderRec(root.left);
            console.log(root.data + " ");
            this.inOrderRec(root.right);
        }
    }

    preOrder() {
        this.preOrderRec(this.root);
    }

    preOrderRec(root) {
        if (root !== null) {
            console.log(root.data + " ");
            this.preOrderRec(root.left);
            this.preOrderRec(root.right);
        }
    }

    postOrder() {
        this.postOrderRec(this.root);
    }

    postOrderRec(root) {
        if (root !== null) {
            this.postOrderRec(root.left);
            this.postOrderRec(root.right);
            console.log(root.data + " ");
        }
    }

    // Verificar se é uma BST válida
    isValidBST() {
        return this.isValidBSTRec(this.root, null, null);
    }

    isValidBSTRec(root, min, max) {
        if (root === null) {
            return true;
        }

        if ((min !== null && root.data <= min) || (max !== null && root.data >= max)) {
            return false;
        }

        return this.isValidBSTRec(root.left, min, root.data) && this.isValidBSTRec(root.right, root.data, max);
    }
}

class TreeNode {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

const tree = new BinarySearchTree();
tree.insert(50);
tree.insert(30);
tree.insert(20);
tree.insert(40);
tree.insert(70);
tree.insert(60);
tree.insert(80);

console.log("In-order traversal:");
tree.inOrder();
console.log();

console.log("Pre-order traversal:");
tree.preOrder();
console.log();

console.log("Post-order traversal:");
tree.postOrder();
console.log();

console.log("Minimum value: " + tree.findMin());
console.log("Maximum value: " + tree.findMax());

const searchValue = 40;
console.log("Search for " + searchValue + ": " + tree.search(searchValue));

tree.delete(40);
console.log("After deleting " + searchValue + ":");
tree.inOrder();

console.log("\nIs valid BST? " + tree.isValidBST());
