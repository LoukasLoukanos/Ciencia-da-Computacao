/*
♦ Algoritmo 21: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária - Busca Binária (Binary Search Tree - BST) de tipo de dados genérico.
→ Operações:
    • Inserção e Remoção de Elementos;
    • Busca (pesquisa) de Elementos;
    • Encontrar o Mínimo e o Máximo;
    • Travessias (in-order, pre-order, post-order);
    • Verificar se é uma BST válida.
*/

#include <iostream>

template <typename T>
class BinarySearchTree {
    struct TreeNode {
        T data;
        TreeNode* left;
        TreeNode* right;

        TreeNode(T data) : data(data), left(nullptr), right(nullptr) {}
    };

    TreeNode* root;

public:
    BinarySearchTree() : root(nullptr) {}

    // Inserção de elementos
    void insert(const T& data) {
        root = insertRec(root, data);
    }

    TreeNode* insertRec(TreeNode* root, const T& data) {
        if (root == nullptr) {
            return new TreeNode(data);
        }

        if (data < root->data) {
            root->left = insertRec(root->left, data);
        } else if (data > root->data) {
            root->right = insertRec(root->right, data);
        }

        return root;
    }

    // Remoção de elementos
    void remove(const T& data) {
        root = removeRec(root, data);
    }

    TreeNode* removeRec(TreeNode* root, const T& data) {
        if (root == nullptr) {
            return root;
        }

        if (data < root->data) {
            root->left = removeRec(root->left, data);
        } else if (data > root->data) {
            root->right = removeRec(root->right, data);
        } else {
            if (root->left == nullptr) {
                TreeNode* temp = root->right;
                delete root;
                return temp;
            } else if (root->right == nullptr) {
                TreeNode* temp = root->left;
                delete root;
                return temp;
            }

            root->data = minValue(root->right);

            root->right = removeRec(root->right, root->data);
        }

        return root;
    }

    T minValue(TreeNode* root) {
        T minValue = root->data;
        while (root->left != nullptr) {
            minValue = root->left->data;
            root = root->left;
        }
        return minValue;
    }

    // Busca de elementos
    bool search(const T& data) {
        return searchRec(root, data);
    }

    bool searchRec(TreeNode* root, const T& data) {
        if (root == nullptr) {
            return false;
        }

        if (root->data == data) {
            return true;
        }

        if (data < root->data) {
            return searchRec(root->left, data);
        }

        return searchRec(root->right, data);
    }

    // Encontrar o Mínimo e o Máximo
    T findMin() {
        if (root == nullptr) {
            return T(); // Retorna um valor padrão para indicar que a árvore está vazia
        }

        TreeNode* current = root;
        while (current->left != nullptr) {
            current = current->left;
        }

        return current->data;
    }

    T findMax() {
        if (root == nullptr) {
            return T(); // Retorna um valor padrão para indicar que a árvore está vazia
        }

        TreeNode* current = root;
        while (current->right != nullptr) {
            current = current->right;
        }

        return current->data;
    }

    // Travessias (in-order, pre-order, post-order)
    void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(TreeNode* root) {
        if (root != nullptr) {
            inOrderRec(root->left);
            std::cout << root->data << " ";
            inOrderRec(root->right);
        }
    }

    void preOrder() {
        preOrderRec(root);
    }

    void preOrderRec(TreeNode* root) {
        if (root != nullptr) {
            std::cout << root->data << " ";
            preOrderRec(root->left);
            preOrderRec(root->right);
        }
    }

    void postOrder() {
        postOrderRec(root);
    }

    void postOrderRec(TreeNode* root) {
        if (root != nullptr) {
            postOrderRec(root->left);
            postOrderRec(root->right);
            std::cout << root->data << " ";
        }
    }

    // Verificar se é uma BST válida
    bool isValidBST() {
        return isValidBSTRec(root, nullptr, nullptr);
    }

    bool isValidBSTRec(TreeNode* root, const T* min, const T* max) {
        if (root == nullptr) {
            return true;
        }

        if ((min != nullptr && root->data <= *min) || (max != nullptr && root->data >= *max)) {
            return false;
        }

        return isValidBSTRec(root->left, min, &(root->data)) && isValidBSTRec(root->right, &(root->data), max);
    }

    ~BinarySearchTree() {
        destroyTree(root);
    }

private:
    void destroyTree(TreeNode* root) {
        if (root != nullptr) {
            destroyTree(root->left);
            destroyTree(root->right);
            delete root;
        }
    }
};

int main() {
    BinarySearchTree<int> tree;
    tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);

    std::cout << "In-order traversal:" << std::endl;
    tree.inOrder();
    std::cout << std::endl;

    std::cout << "Pre-order traversal:" << std::endl;
    tree.preOrder();
    std::cout << std::endl;

    std::cout << "Post-order traversal:" << std::endl;
    tree.postOrder();
    std::cout << std::endl;

    std::cout << "Minimum value: " << tree.findMin() << std::endl;
    std::cout << "Maximum value: " << tree.findMax() << std::endl;

    int searchValue = 40;
    std::cout << "Search for " << searchValue << ": " << tree.search(searchValue) << std::endl;

    tree.remove(40);
    std::cout << "After deleting " << searchValue << ":" << std::endl;
    tree.inOrder();

    std::cout << "\nIs valid BST? " << tree.isValidBST() << std::endl;

    return 0;
}
