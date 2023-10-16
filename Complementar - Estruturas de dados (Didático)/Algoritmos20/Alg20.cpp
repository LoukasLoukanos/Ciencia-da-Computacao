/*
♦ Algoritmo 20: Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 13: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada de tipo de dados genérico].
→ Operações:
    • Busca de um valor em uma Lista Duplamente Ligada;
    • Identificar o menor valor em uma Lista Duplamente Ligada;
    • Identificar o maior valor em uma Lista Duplamente Ligada;
    • Retornar o sucessor de um valor em uma Lista Duplamente Ligada;
    • Retornar o predecessor de um valor em uma Lista Duplamente Ligada.
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
class DoublyLinkedList {
private:
    Nodo<T>* primeiro;

public:
    DoublyLinkedList() : primeiro(nullptr) {}

    bool searchList(T valor) {
        Nodo<T>* nodoAtual = primeiro;
        while (nodoAtual != nullptr) {
            if (nodoAtual->valor == valor) {
                return true;
            }
            nodoAtual = nodoAtual->proximo;
        }
        return false;
    }

    T findMinimum() {
        if (primeiro == nullptr) {
            return T();
        }

        Nodo<T>* nodoAtual = primeiro;
        T min = nodoAtual->valor;

        while (nodoAtual != nullptr) {
            if (nodoAtual->valor < min) {
                min = nodoAtual->valor;
            }
            nodoAtual = nodoAtual->proximo;
        }
        return min;
    }

    T findMaximum() {
        if (primeiro == nullptr) {
            return T();
        }

        Nodo<T>* nodoAtual = primeiro;
        T max = nodoAtual->valor;

        while (nodoAtual != nullptr) {
            if (nodoAtual->valor > max) {
                max = nodoAtual->valor;
            }
            nodoAtual = nodoAtual->proximo;
        }
        return max;
    }

    T getSuccessor(T valor) {
        Nodo<T>* nodoAtual = primeiro;
        while (nodoAtual != nullptr) {
            if (nodoAtual->valor == valor) {
                if (nodoAtual->proximo != nullptr) {
                    return nodoAtual->proximo->valor;
                }
                break;
            }
            nodoAtual = nodoAtual->proximo;
        }
        return T();
    }

    T getPredecessor(T valor) {
        if (primeiro == nullptr || primeiro->valor == valor) {
            return T();
        }

        Nodo<T>* nodoAtual = primeiro;
        while (nodoAtual != nullptr && nodoAtual->proximo != nullptr) {
            if (nodoAtual->proximo->valor == valor) {
                return nodoAtual->valor;
            }
            nodoAtual = nodoAtual->proximo;
        }
        return T();
    }
};

int main() {
    DoublyLinkedList<int> lista;
    lista.searchList(10);
    lista.findMinimum();
    lista.findMaximum();
    lista.getSuccessor(10);
    lista.getPredecessor(10);

    return 0;
}
