/*
♦ Algoritmo 13: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada: Doubly Linked List (Lista Duplamente Ligada).
*/

#include <iostream>

template <typename T>
class Nodo {
public:
    T valor;
    Nodo<T>* anterior;
    Nodo<T>* proximo;

    Nodo(T valor) : valor(valor), anterior(nullptr), proximo(nullptr) {}
};

template <typename T>
class ListaDuplamenteLigada {
private:
    Nodo<T>* primeiro;
    Nodo<T>* ultimo;
    int tamanho;

public:
    ListaDuplamenteLigada() : primeiro(nullptr), ultimo(nullptr), tamanho(0) {}

    void addList(T valor) {
        Nodo<T>* novoNodo = new Nodo<T>(valor);
        if (primeiro == nullptr) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            novoNodo->anterior = ultimo;
            ultimo->proximo = novoNodo;
            ultimo = novoNodo;
        }
        tamanho++;
    }

    void removeList(T valor) {
        Nodo<T>* nodoAtual = primeiro;
        while (nodoAtual != nullptr) {
            if (nodoAtual->valor == valor) {
                if (nodoAtual == primeiro) {
                    primeiro = nodoAtual->proximo;
                    if (primeiro != nullptr) {
                        primeiro->anterior = nullptr;
                    }
                } else if (nodoAtual == ultimo) {
                    ultimo = nodoAtual->anterior;
                    if (ultimo != nullptr) {
                        ultimo->proximo = nullptr;
                    }
                } else {
                    Nodo<T>* anterior = nodoAtual->anterior;
                    Nodo<T>* proximo = nodoAtual->proximo;
                    anterior->proximo = proximo;
                    proximo->anterior = anterior;
                }
                tamanho--;
                delete nodoAtual;
                return;
            }
            nodoAtual = nodoAtual->proximo;
        }
    }

    int size() {
        return tamanho;
    }

    void showList() {
        Nodo<T>* nodoAtual = primeiro;
        while (nodoAtual != nullptr) {
            std::cout << nodoAtual->valor << " ";
            nodoAtual = nodoAtual->proximo;
        }
        std::cout << std::endl;
    }

    ~ListaDuplamenteLigada() {
        Nodo<T>* nodoAtual = primeiro;
        while (nodoAtual != nullptr) {
            Nodo<T>* proximo = nodoAtual->proximo;
            delete nodoAtual;
            nodoAtual = proximo;
        }
    }
};

int main() {
    ListaDuplamenteLigada<int> lista;
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
