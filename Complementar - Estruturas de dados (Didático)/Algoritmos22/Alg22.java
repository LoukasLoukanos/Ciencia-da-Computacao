/*
♦ Algoritmo 22: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária: Árvore AVL.
*/

class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;
    int height;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

public class Alg22<T extends Comparable<T>> {
    private Node<T> root;

    public Alg22() {
        root = null;
    }

    private int height(Node<T> node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int balanceFactor(Node<T> node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null)
            return new Node<>(data);

        if (data.compareTo(node.data) < 0)
            node.left = insert(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = insert(node.right, data);
        else
            return node; // Duplicatas não são permitidas

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        // Casos de desequilíbrio
        if (balance > 1) {
            if (data.compareTo(node.left.data) < 0) {
                // Rotação simples à direita
                return rotateRight(node);
            } else {
                // Rotação dupla à esquerda-direita
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (balance < -1) {
            if (data.compareTo(node.right.data) > 0) {
                // Rotação simples à esquerda
                return rotateLeft(node);
            } else {
                // Rotação dupla à direita-esquerda
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    public void remove(T data) {
        root = remove(root, data);
    }

    private Node<T> remove(Node<T> node, T data) {
        if (node == null)
            return node;

        if (data.compareTo(node.data) < 0)
            node.left = remove(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = remove(node.right, data);
        else {
            if (node.left == null || node.right == null) {
                Node<T> temp = (node.left != null) ? node.left : node.right;

                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node<T> temp = findMin(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
        }

        if (node == null)
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        // Casos de desequilíbrio
        if (balance > 1) {
            if (balanceFactor(node.left) >= 0) {
                // Rotação simples à direita
                return rotateRight(node);
            } else {
                // Rotação dupla à esquerda-direita
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (balance < -1) {
            if (balanceFactor(node.right) <= 0) {
                // Rotação simples à esquerda
                return rotateLeft(node);
            } else {
                // Rotação dupla à direita-esquerda
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        Alg22<Integer> tree = new Alg22<>();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.println("Árvore AVL In-Order:");
        tree.inorder();

        tree.remove(30);
        tree.remove(40);

        System.out.println("Árvore AVL In-Order após a remoção de 30 e 40:");
        tree.inorder();
    }
}
