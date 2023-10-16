/*
♦ Algoritmo 22: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária - Árvore AVL.
→ Operações:
    • Rotações para Rebalanceamento;
    • Inserção e Remoção com Rebalanceamento.
*/

#include <iostream>

template <typename T>
struct Node {
    T data;
    Node* left;
    Node* right;
    int height;

    Node(T data) : data(data), left(nullptr), right(nullptr), height(1) {}
};

template <typename T>
class AVLTree {
private:
    Node<T>* root;

    int height(Node<T>* node) {
        if (node == nullptr)
            return 0;
        return node->height;
    }

    int balanceFactor(Node<T>* node) {
        if (node == nullptr)
            return 0;
        return height(node->left) - height(node->right);
    }

    Node<T>* rotateRight(Node<T>* y) {
        Node<T>* x = y->left;
        Node<T>* T2 = x->right;

        x->right = y;
        y->left = T2;

        y->height = std::max(height(y->left), height(y->right)) + 1;
        x->height = std::max(height(x->left), height(x->right)) + 1;

        return x;
    }

    Node<T>* rotateLeft(Node<T>* x) {
        Node<T>* y = x->right;
        Node<T>* T2 = y->left;

        y->left = x;
        x->right = T2;

        x->height = std::max(height(x->left), height(x->right)) + 1;
        y->height = std::max(height(y->left), height(y->right)) + 1;

        return y;
    }

    Node<T>* insert(Node<T>* node, T data) {
        if (node == nullptr)
            return new Node<T>(data);

        if (data < node->data)
            node->left = insert(node->left, data);
        else if (data > node->data)
            node->right = insert(node->right, data);
        else
            return node; // Duplicatas não são permitidas

        node->height = 1 + std::max(height(node->left), height(node->right));

        int balance = balanceFactor(node);

        // Casos de desequilíbrio
        if (balance > 1) {
            if (data < node->left->data) {
                // Rotação simples à direita
                return rotateRight(node);
            } else {
                // Rotação dupla à esquerda-direita
                node->left = rotateLeft(node->left);
                return rotateRight(node);
            }
        }

        if (balance < -1) {
            if (data > node->right->data) {
                // Rotação simples à esquerda
                return rotateLeft(node);
            } else {
                // Rotação dupla à direita-esquerda
                node->right = rotateRight(node->right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    Node<T>* remove(Node<T>* node, T data) {
        if (node == nullptr)
            return node;

        if (data < node->data)
            node->left = remove(node->left, data);
        else if (data > node->data)
            node->right = remove(node->right, data);
        else {
            if (node->left == nullptr || node->right == nullptr) {
                Node<T>* temp = (node->left != nullptr) ? node->left : node->right;

                if (temp == nullptr) {
                    temp = node;
                    node = nullptr;
                } else {
                    node = temp;
                }
            } else {
                Node<T>* temp = findMin(node->right);
                node->data = temp->data;
                node->right = remove(node->right, temp->data);
            }
        }

        if (node == nullptr)
            return node;

        node->height = 1 + std::max(height(node->left), height(node->right));

        int balance = balanceFactor(node);

        // Casos de desequilíbrio
        if (balance > 1) {
            if (balanceFactor(node->left) >= 0) {
                // Rotação simples à direita
                return rotateRight(node);
            } else {
                // Rotação dupla à esquerda-direita
                node->left = rotateLeft(node->left);
                return rotateRight(node);
            }
        }

        if (balance < -1) {
            if (balanceFactor(node->right) <= 0) {
                // Rotação simples à esquerda
                return rotateLeft(node);
            } else {
                // Rotação dupla à direita-esquerda
                node->right = rotateRight(node->right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    Node<T>* findMin(Node<T>* node) {
        while (node->left != nullptr)
            node = node->left;
        return node;
    }

    void inorder(Node<T>* node) {
        if (node != nullptr) {
            inorder(node->left);
            std::cout << node->data << " ";
            inorder(node->right);
        }
    }

public:
    AVLTree() : root(nullptr) {}

    void insert(T data) {
        root = insert(root, data);
    }

    void remove(T data) {
        root = remove(root, data);
    }

    void inorder() {
        inorder(root);
        std::cout << std::endl;
    }
};

int main() {
    AVLTree<int> tree;

    tree.insert(10);
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(50);

    std::cout << "Árvore AVL In-Order:" << std::endl;
    tree.inorder();

    tree.remove(30);
    tree.remove(40);

    std::cout << "Árvore AVL In-Order após a remoção de 30 e 40:" << std::endl;
    tree.inorder();

    return 0;
}
