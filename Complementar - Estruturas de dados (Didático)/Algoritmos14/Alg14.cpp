/*
♦ Algoritmo 14: Estrutura de Dados Linear Dinâmica (não Estática) de Fila (regra de acesso FIFO) de tipo de dados genérico.
→ Operações:
    • isEmpty - verificar se a fila está vazia;
    • enqueue - adicionar elementos;
    • dequeue - remover o elemento da frente da fila;
    • size - obter o tamanho atual da fila;
    • front - acessar o elemento da frente da fila sem removê-lo;
    • showQueue - mostar elementos da fila.
*/

#include <iostream>
#include <queue>

template <typename T>
class FilaDinamica {
private:
    std::queue<T> fila;

public:
    bool isEmpty() {
        return fila.empty();
    }

    void enqueue(T elemento) {
        fila.push(elemento);
    }

    void dequeue() {
        if (isEmpty()) {
            throw std::runtime_error("A fila está vazia");
        }
        fila.pop();
    }

    int size() {
        return fila.size();
    }

    T front() {
        if (isEmpty()) {
            throw std::runtime_error("A fila está vazia");
        }
        return fila.front();
    }

    void showQueue() {
        std::queue<T> temp = fila;
        while (!temp.empty()) {
            std::cout << temp.front() << " ";
            temp.pop();
        }
        std::cout << std::endl;
    }
};

int main() {
    FilaDinamica<int> fila;

    fila.enqueue(1);
    fila.enqueue(2);
    fila.enqueue(3);

    fila.showQueue();

    std::cout << "Tamanho da fila: " << fila.size() << std::endl;
    std::cout << "Frente da fila: " << fila.front() << std::endl;

    fila.dequeue();
    fila.showQueue();

    return 0;
}
