/*
♦ Algoritmo 22: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária - Árvore AVL.
→ Operações:
    • Rotações para Rebalanceamento;
    • Inserção e Remoção com Rebalanceamento.
*/

class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

class AVLTree {
    constructor() {
        this.root = null;
    }

    height(node) {
        if (node === null)
            return 0;
        return node.height;
    }

    balanceFactor(node) {
        if (node === null)
            return 0;
        return this.height(node.left) - this.height(node.right);
    }

    rotateRight(y) {
        const x = y.left;
        const T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(this.height(y.left), this.height(y.right)) + 1;
        x.height = Math.max(this.height(x.left), this.height(x.right)) + 1;

        return x;
    }

    rotateLeft(x) {
        const y = x.right;
        const T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(this.height(x.left), this.height(x.right)) + 1;
        y.height = Math.max(this.height(y.left), this.height(y.right)) + 1;

        return y;
    }

    insert(data) {
        this.root = this.insertNode(this.root, data);
    }

    insertNode(node, data) {
        if (node === null)
            return new Node(data);

        if (data < node.data)
            node.left = this.insertNode(node.left, data);
        else if (data > node.data)
            node.right = this.insertNode(node.right, data);
        else
            return node; // Duplicatas não são permitidas

        node.height = 1 + Math.max(this.height(node.left), this.height(node.right));

        const balance = this.balanceFactor(node);

        // Casos de desequilíbrio
        if (balance > 1) {
            if (data < node.left.data) {
                // Rotação simples à direita
                return this.rotateRight(node);
            } else {
                // Rotação dupla à esquerda-direita
                node.left = this.rotateLeft(node.left);
                return this.rotateRight(node);
            }
        }

        if (balance < -1) {
            if (data > node.right.data) {
                // Rotação simples à esquerda
                return this.rotateLeft(node);
            } else {
                // Rotação dupla à direita-esquerda
                node.right = this.rotateRight(node.right);
                return this.rotateLeft(node);
            }
        }

        return node;
    }

    remove(data) {
        this.root = this.removeNode(this.root, data);
    }

    removeNode(node, data) {
        if (node === null)
            return node;

        if (data < node.data)
            node.left = this.removeNode(node.left, data);
        else if (data > node.data)
            node.right = this.removeNode(node.right, data);
        else {
            if (node.left === null || node.right === null) {
                const temp = (node.left !== null) ? node.left : node.right;

                if (temp === null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                const temp = this.findMin(node.right);
                node.data = temp.data;
                node.right = this.removeNode(node.right, temp.data);
            }
        }

        if (node === null)
            return node;

        node.height = 1 + Math.max(this.height(node.left), this.height(node.right));

        const balance = this.balanceFactor(node);

        // Casos de desequilíbrio
        if (balance > 1) {
            if (this.balanceFactor(node.left) >= 0) {
                // Rotação simples à direita
                return this.rotateRight(node);
            } else {
                // Rotação dupla à esquerda-direita
                node.left = this.rotateLeft(node.left);
                return this.rotateRight(node);
            }
        }

        if (balance < -1) {
            if (this.balanceFactor(node.right) <= 0) {
                // Rotação simples à esquerda
                return this.rotateLeft(node);
            } else {
                // Rotação dupla à direita-esquerda
                node.right = this.rotateRight(node.right);
                return this.rotateLeft(node);
            }
        }

        return node;
    }

    findMin(node) {
        while (node.left !== null)
            node = node.left;
        return node;
    }

    inorder() {
        this.inorderTraversal(this.root);
        console.log();
    }

    inorderTraversal(node) {
        if (node !== null) {
            this.inorderTraversal(node.left);
            process.stdout.write(node.data + " ");
            this.inorderTraversal(node.right);
        }
    }
}

const tree = new AVLTree();

tree.insert(10);
tree.insert(20);
tree.insert(30);
tree.insert(40);
tree.insert(50);

console.log("Árvore AVL In-Order:");
tree.inorder();

tree.remove(30);
tree.remove(40);

console.log("Árvore AVL In-Order após a remoção de 30 e 40:");
tree.inorder();
