/*
♦ Algoritmo 12: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada) de tipo de dados genérico.
→ Operações:
    • addList: inserção em uma Lista Ligada Simples;
    • removeList: remoção em uma Lista Ligada Simples;
    • size - obter o tamanho atual da Lista Ligada Simples;
    • showList: exibição dos elementos da Lista Ligada Simples.
*/

#include <iostream>

template <typename T>
class Nodo {
public:
    T valor;
    Nodo* proximo;

    Nodo(T valor) : valor(valor), proximo(nullptr) {}
};

template <typename T>
class ListaLigada {
private:
    Nodo<T>* primeiro;
    int tamanho;

public:
    ListaLigada() : primeiro(nullptr), tamanho(0) {}

    void addList(T valor) {
        Nodo<T>* novoNodo = new Nodo<T>(valor);
        novoNodo->proximo = primeiro;
        primeiro = novoNodo;
        tamanho++;
    }

    void removeList(T valor) {
        if (primeiro == nullptr) {
            return;
        }

        if (primeiro->valor == valor) {
            Nodo<T>* temp = primeiro;
            primeiro = primeiro->proximo;
            delete temp;
            tamanho--;
            return;
        }

        Nodo<T>* nodoAtual = primeiro;
        while (nodoAtual->proximo != nullptr) {
            if (nodoAtual->proximo->valor == valor) {
                Nodo<T>* temp = nodoAtual->proximo;
                nodoAtual->proximo = nodoAtual->proximo->proximo;
                delete temp;
                tamanho--;
                return;
            }
            nodoAtual = nodoAtual->proximo;
        }
    }

    int size() const {
        return tamanho;
    }

    void showList() const {
        Nodo<T>* nodoAtual = primeiro;
        while (nodoAtual != nullptr) {
            std::cout << nodoAtual->valor << " ";
            nodoAtual = nodoAtual->proximo;
        }
        std::cout << std::endl;
    }

    ~ListaLigada() {
        while (primeiro != nullptr) {
            Nodo<T>* temp = primeiro;
            primeiro = primeiro->proximo;
            delete temp;
        }
    }
};

int main() {
    ListaLigada<int> lista;
    lista.addList(10);
    lista.addList(20);
    lista.addList(30);

    std::cout << "Tamanho da lista: " << lista.size() << std::endl;
    std::cout << "Elementos da lista: ";
    lista.showList();

    lista.removeList(20);

    std::cout << "Tamanho da lista após remoção: " << lista.size() << std::endl;
    std::cout << "Elementos da lista após remoção: ";
    lista.showList();

    return 0;
}
