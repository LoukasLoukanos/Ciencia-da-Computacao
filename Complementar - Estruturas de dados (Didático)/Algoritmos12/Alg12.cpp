/* Algoritmo da Estrutura de dados linear dinâmica (não estática) ListaLigada de Lista Ligada, também conhecida como Lista Encadeada */

#include <iostream>

class ListaLigada {
private:
    struct No {
        int dado;
        No* proximo;

        No(int dado) : dado(dado), proximo(nullptr) {}
    };

    No* cabeca;

public:
    ListaLigada() : cabeca(nullptr) {}

    // Adicionar um elemento no final da lista
    void addList(int dado) {
        No* novoNo = new No(dado);
        if (cabeca == nullptr) {
            cabeca = novoNo;
        } else {
            No* atual = cabeca;
            while (atual->proximo != nullptr) {
                atual = atual->proximo;
            }
            atual->proximo = novoNo;
        }
    }

    // Remover um elemento da lista
    void removeList(int dado) {
        if (cabeca == nullptr) {
            return;
        }

        if (cabeca->dado == dado) {
            No* temp = cabeca;
            cabeca = cabeca->proximo;
            delete temp;
            return;
        }

        No* atual = cabeca;
        No* anterior = nullptr;
        while (atual != nullptr && atual->dado != dado) {
            anterior = atual;
            atual = atual->proximo;
        }

        if (atual == nullptr) {
            return;
        }

        anterior->proximo = atual->proximo;
        delete atual;
    }

    // Imprimir a lista
    void showList() {
        No* atual = cabeca;
        while (atual != nullptr) {
            std::cout << atual->dado << " ";
            atual = atual->proximo;
        }
        std::cout << std::endl;
    }

    ~ListaLigada() {
        while (cabeca != nullptr) {
            No* temp = cabeca;
            cabeca = cabeca->proximo;
            delete temp;
        }
    }
};

int main() {
    ListaLigada lista;
    lista.addList(1);
    lista.addList(2);
    lista.addList(3);
    lista.showList();

    lista.removeList(2);
    lista.showList();

    return 0;
}
