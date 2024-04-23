/*
♦ Algoritmo 03: Estrutura de Dados Linear Estática (não Dinâmica) de Pilha: Stack (Pilha).
*/

#include <iostream>
#include <stdexcept>

template <typename T>
class Pilha {
private:
    int capacidade;
    T *elementos;
    int topo;

public:
    Pilha(int capacidade) {
        this->capacidade = capacidade;
        this->elementos = new T[capacidade];
        this->topo = -1;
    }

    // Verificar se a pilha está vazia
    bool isEmpty() {
        return topo == -1;
    }

    // Verificar se a pilha está cheia
    bool isFull() {
        return topo == capacidade - 1;
    }

    // Inserir elementos no topo da pilha
    void push(T elemento) {
        if (isFull()) {
            throw std::overflow_error("A pilha está cheia");
        }

        topo++;
        elementos[topo] = elemento;
    }

    // Remover elementos do topo da pilha
    T pop() {
        if (isEmpty()) {
            throw std::underflow_error("A pilha está vazia");
        }

        T elementoRemovido = elementos[topo];
        topo--;

        return elementoRemovido;
    }

    // Obter o tamanho atual da pilha
    int size() {
        return topo + 1;
    }

    // Acessar o elemento do topo da pilha sem removê-lo
    T front() {
        if (isEmpty()) {
            throw std::underflow_error("A pilha está vazia");
        }

        return elementos[topo];
    }

    // Mostrar elementos da pilha (do topo para base)
    void showStack() {
        for (int i = topo; i >= 0; i--) {
            std::cout << elementos[i] << " ";
        }
        std::cout << std::endl;
    }

    ~Pilha() {
        delete[] elementos;
    }
};

int main() {
    Pilha<int> pilha(5);
    pilha.push(1);
    pilha.push(2);
    pilha.push(3);

    pilha.showStack();

    std::cout << "Topo da pilha: " << pilha.front() << std::endl;
    std::cout << "Tamanho da pilha: " << pilha.size() << std::endl;

    pilha.pop();
    pilha.showStack();

    return 0;
}
