/*
♦ Algoritmo 35: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore Rubro-Negra.
*/


#include <iostream>

template<typename T>
class No {
public:
    T valor;
    No<T>* esquerda;
    No<T>* direita;
    bool vermelho;

    No(T valor) : valor(valor), esquerda(nullptr), direita(nullptr), vermelho(true) {}
};

template<typename T>
class ArvoreRubroNegra {
private:
    No<T>* raiz;
    static const bool VERMELHO = true;
    static const bool PRETO = false;

    bool isVermelho(No<T>* no) {
        if (no == nullptr) return false;
        return no->vermelho == VERMELHO;
    }

    No<T>* rotacaoEsquerda(No<T>* no) {
        No<T>* temp = no->direita;
        no->direita = temp->esquerda;
        temp->esquerda = no;
        temp->vermelho = no->vermelho;
        no->vermelho = VERMELHO;
        return temp;
    }

    No<T>* rotacaoDireita(No<T>* no) {
        No<T>* temp = no->esquerda;
        no->esquerda = temp->direita;
        temp->direita = no;
        temp->vermelho = no->vermelho;
        no->vermelho = VERMELHO;
        return temp;
    }

    void inverterCores(No<T>* no) {
        no->vermelho = !no->vermelho;
        no->esquerda->vermelho = !no->esquerda->vermelho;
        no->direita->vermelho = !no->direita->vermelho;
    }

    No<T>* inserirRecursivo(No<T>* no, T valor) {
        if (no == nullptr) return new No<T>(valor);

        if (valor < no->valor)
            no->esquerda = inserirRecursivo(no->esquerda, valor);
        else if (valor > no->valor)
            no->direita = inserirRecursivo(no->direita, valor);
        else
            return no;

        if (isVermelho(no->direita) && !isVermelho(no->esquerda))
            no = rotacaoEsquerda(no);
        if (isVermelho(no->esquerda) && isVermelho(no->esquerda->esquerda))
            no = rotacaoDireita(no);
        if (isVermelho(no->esquerda) && isVermelho(no->direita))
            inverterCores(no);

        return no;
    }

    void imprimirEmOrdemRecursivo(No<T>* no) {
        if (no != nullptr) {
            imprimirEmOrdemRecursivo(no->esquerda);
            std::cout << no->valor << " ";
            imprimirEmOrdemRecursivo(no->direita);
        }
    }

public:
    ArvoreRubroNegra() : raiz(nullptr) {}

    void inserir(T valor) {
        raiz = inserirRecursivo(raiz, valor);
        if (raiz != nullptr) raiz->vermelho = PRETO;
    }

    void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }

    bool estaVazia() {
        return raiz == nullptr;
    }
};

int main() {
    ArvoreRubroNegra<int> arvore;
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
