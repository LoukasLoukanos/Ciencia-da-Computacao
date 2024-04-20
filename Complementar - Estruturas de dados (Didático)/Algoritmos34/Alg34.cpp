/*
♦ Algoritmo 34: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore AVL.
*/


#include <iostream>
#include <algorithm>

template <typename T>
struct No {
    T valor;
    No<T>* esquerda;
    No<T>* direita;
    int altura;

    No(T valor) : valor(valor), esquerda(nullptr), direita(nullptr), altura(1) {}
};

template <typename T>
class ArvoreAVL {
private:
    No<T>* raiz;

    int altura(No<T>* no) {
        if (no == nullptr)
            return 0;
        return no->altura;
    }

    int balanceamento(No<T>* no) {
        if (no == nullptr)
            return 0;
        return altura(no->esquerda) - altura(no->direita);
    }

    No<T>* rotacaoDireita(No<T>* y) {
        No<T>* x = y->esquerda;
        No<T>* T2 = x->direita;

        x->direita = y;
        y->esquerda = T2;

        y->altura = std::max(altura(y->esquerda), altura(y->direita)) + 1;
        x->altura = std::max(altura(x->esquerda), altura(x->direita)) + 1;

        return x;
    }

    No<T>* rotacaoEsquerda(No<T>* x) {
        No<T>* y = x->direita;
        No<T>* T2 = y->esquerda;

        y->esquerda = x;
        x->direita = T2;

        x->altura = std::max(altura(x->esquerda), altura(x->direita)) + 1;
        y->altura = std::max(altura(y->esquerda), altura(y->direita)) + 1;

        return y;
    }

public:
    ArvoreAVL() : raiz(nullptr) {}

    void inserir(T valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    No<T>* inserirRecursivo(No<T>* no, T valor) {
        if (no == nullptr)
            return new No<T>(valor);

        if (valor < no->valor)
            no->esquerda = inserirRecursivo(no->esquerda, valor);
        else if (valor > no->valor)
            no->direita = inserirRecursivo(no->direita, valor);
        else
            return no;

        no->altura = 1 + std::max(altura(no->esquerda), altura(no->direita));

        int balance = balanceamento(no);

        if (balance > 1 && valor < no->esquerda->valor)
            return rotacaoDireita(no);

        if (balance < -1 && valor > no->direita->valor)
            return rotacaoEsquerda(no);

        if (balance > 1 && valor > no->esquerda->valor) {
            no->esquerda = rotacaoEsquerda(no->esquerda);
            return rotacaoDireita(no);
        }

        if (balance < -1 && valor < no->direita->valor) {
            no->direita = rotacaoDireita(no->direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    void imprimirEmOrdemRecursivo(No<T>* no) {
        if (no != nullptr) {
            imprimirEmOrdemRecursivo(no->esquerda);
            std::cout << no->valor << " ";
            imprimirEmOrdemRecursivo(no->direita);
        }
    }

    void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }
};

int main() {
    ArvoreAVL<int> arvore;
    arvore.inserir(10);
    arvore.inserir(5);
    arvore.inserir(20);
    arvore.inserir(3);
    arvore.inserir(8);
    arvore.inserir(15);

    std::cout << "Em Ordem:" << std::endl;
    arvore.imprimirEmOrdem();

    return 0;
}
