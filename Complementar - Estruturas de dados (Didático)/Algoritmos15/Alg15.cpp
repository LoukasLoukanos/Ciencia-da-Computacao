/*
♦ Algoritmo 15: Estrutura de Dados Linear Dinâmica (não Estática) de Pilha (regra de acesso LIFO) de tipo de dados genérico.
→ Operações:
    • isEmpty - verificar se a pilha está vazia;
    • push - inserir elementos no topo da pilha;
    • pop - remover elementos do dopo da pilha;
    • size - obter o tamanho atual da pilha;
    • front - acessar o elemento do topo da pilha sem removê-lo;
    • showStack - mostar elementos da pilha (do topo para base).
*/

#include <iostream>
#include <deque>

template <typename T>
class PilhaDinamica {
private:
    std::deque<T> pilha;

public:
    bool isEmpty() {
        return pilha.empty();
    }

    void push(T elemento) {
        pilha.push_front(elemento);
    }

    void pop() {
        if (isEmpty()) {
            throw std::runtime_error("A pilha está vazia");
        }
        pilha.pop_front();
    }

    int size() {
        return pilha.size();
    }

    T front() {
        if (isEmpty()) {
            throw std::runtime_error("A pilha está vazia");
        }
        return pilha.front();
    }

    void showStack() {
        for (const T& elemento : pilha) {
            std::cout << elemento << " ";
        }
        std::cout << std::endl;
    }
};

int main() {
    PilhaDinamica<int> pilha;

    pilha.push(1);
    pilha.push(2);
    pilha.push(3);

    pilha.showStack();

    std::cout << "Tamanho da pilha: " << pilha.size() << std::endl;
    std::cout << "Topo da pilha: " << pilha.front() << std::endl;

    pilha.pop();
    pilha.showStack();

    return 0;
}
