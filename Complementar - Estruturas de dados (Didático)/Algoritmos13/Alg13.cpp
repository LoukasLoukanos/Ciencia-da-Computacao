/* Algoritmo da Estrutura de dados linear dinâmica (não estática) ListaDuplamenteLigada 
de Lista Duplamente Ligada, também conhecida como Lista Duplamente Encadeada */

#include <iostream>

class ListaDuplamenteLigada {
private:
    struct Nodo {
        int dado;
        Nodo* proximo;
        Nodo* anterior;

        Nodo(int dado) : dado(dado), proximo(nullptr), anterior(nullptr) {}
    };

    Nodo* cabeca;
    Nodo* cauda;
    int tamanho;

public:
    ListaDuplamenteLigada() : cabeca(nullptr), cauda(nullptr), tamanho(0) {}

    // Inserir um elemento no final da lista
    void addList(int dado) {
        Nodo* novoNodo = new Nodo(dado);
        if (cabeca == nullptr) {
            cabeca = novoNodo;
            cauda = novoNodo;
        } else {
            novoNodo->anterior = cauda;
            cauda->proximo = novoNodo;
            cauda = novoNodo;
        }
        tamanho++;
    }

    // Remover um elemento da lista
    void removeList(int dado) {
        Nodo* atual = cabeca;
        while (atual != nullptr) {
            if (atual->dado == dado) {
                if (atual == cabeca) {
                    cabeca = atual->proximo;
                    if (cabeca != nullptr) {
                        cabeca->anterior = nullptr;
                    }
                } else if (atual == cauda) {
                    cauda = atual->anterior;
                    if (cauda != nullptr) {
                        cauda->proximo = nullptr;
                    }
                } else {
                    atual->anterior->proximo = atual->proximo;
                    atual->proximo->anterior = atual->anterior;
                }
                delete atual;
                tamanho--;
                return;
            }
            atual = atual->proximo;
        }
    }

    // Exibir os elementos da lista
    void showList() {
        Nodo* atual = cabeca;
        while (atual != nullptr) {
            std::cout << atual->dado << " ";
            atual = atual->proximo;
        }
        std::cout << std::endl;
    }

    ~ListaDuplamenteLigada() {
        while (cabeca != nullptr) {
            Nodo* temp = cabeca;
            cabeca = cabeca->proximo;
            delete temp;
        }
    }
};

int main() {
    ListaDuplamenteLigada lista;
    lista.addList(1);
    lista.addList(2);
    lista.addList(3);
    lista.showList();

    lista.removeList(2);
    lista.showList();

    return 0;
}
