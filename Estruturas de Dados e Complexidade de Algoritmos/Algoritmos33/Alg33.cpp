/*
♦ Algoritmo 33: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).
*/


#include <iostream>

template <typename T>
struct No {
    T valor;
    No<T>* esquerda;
    No<T>* direita;

    No(T valor) : valor(valor), esquerda(nullptr), direita(nullptr) {}
};

template <typename T>
class ArvoreBinaria {
private:
    No<T>* raiz;

    No<T>* inserirRecursivo(No<T>* no, T valor) {
        if (no == nullptr) {
            return new No<T>(valor);
        }

        if (valor < no->valor) {
            no->esquerda = inserirRecursivo(no->esquerda, valor);
        } else if (valor > no->valor) {
            no->direita = inserirRecursivo(no->direita, valor);
        }

        return no;
    }

    bool buscarRecursivo(No<T>* no, T valor) {
        if (no == nullptr) {
            return false;
        }

        if (valor == no->valor) {
            return true;
        }

        return valor < no->valor ? buscarRecursivo(no->esquerda, valor) : buscarRecursivo(no->direita, valor);
    }

    void imprimirEmOrdemRecursivo(No<T>* no) {
        if (no != nullptr) {
            imprimirEmOrdemRecursivo(no->esquerda);
            std::cout << no->valor << " ";
            imprimirEmOrdemRecursivo(no->direita);
        }
    }

public:
    ArvoreBinaria() : raiz(nullptr) {}

    void inserir(T valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    bool buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }

    void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }
};

int main() {
    ArvoreBinaria<int> arvore;
    arvore.inserir(10);
    arvore.inserir(5);
    arvore.inserir(20);
    arvore.inserir(3);
    arvore.inserir(8);
    arvore.inserir(15);

    std::cout << "Em Ordem:\n";
    arvore.imprimirEmOrdem();

    std::cout << "\nBuscar 8: " << std::boolalpha << arvore.buscar(8) << std::endl;
    std::cout << "Buscar 12: " << std::boolalpha << arvore.buscar(12) << std::endl;

    return 0;
}
