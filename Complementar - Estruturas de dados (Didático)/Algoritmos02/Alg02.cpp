/*
♦ Estrutura de Dados Linear Estática de Fila Circular e Não-Circular (regra de acesso FIFO) de tipo de dados genérico: Algoritmo 02.
→ Operações:
    • isEmpty - verificar se a fila está vazia;
    • isFull - verificar se a fila está cheia;
    • enqueue - adicionar elementos;
    • dequeue - remover o elemento da frente da fila;
    • size - obter o tamanho atual da fila;
    • front - acessar o elemento da frente da fila sem removê-lo;
    • showQueue - mostar elementos da fila.

obs: Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços 
    livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.

obs: Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços 
    livres, caso haja, no início da fila.
*/

#include <iostream>

template <typename T>
class FilaCircular {
private:
    int capacidade;
    T* elementos;
    int tamanho;
    int frente;
    int traseira;

public:
    FilaCircular(int capacidade) : capacidade(capacidade), elementos(new T[capacidade]), tamanho(0), frente(0), traseira(-1) {}

    // Verificar se a fila está vazia
    bool isEmpty() {
        return tamanho == 0;
    }

    // Verificar se a fila está cheia
    bool isFull() {
        return tamanho == capacidade;
    }

    // Adicionar elementos à fila (enqueue)
    void enqueue(T elemento) {
        if (isFull()) {
            throw std::runtime_error("A fila está cheia");
        }

        traseira = (traseira + 1) % capacidade;
        elementos[traseira] = elemento;
        tamanho++;
    }

    // Remover o elemento da frente da fila (dequeue)
    T dequeue() {
        if (isEmpty()) {
            throw std::runtime_error("A fila está vazia");
        }

        T elementoRemovido = elementos[frente];
        elementos[frente] = T();
        frente = (frente + 1) % capacidade;
        tamanho--;

        return elementoRemovido;
    }

    // Obter o tamanho atual da fila
    int size() {
        return tamanho;
    }

    // Acessar o elemento da frente da fila sem removê-lo
    T front() {
        if (isEmpty()) {
            throw std::runtime_error("A fila está vazia");
        }

        return elementos[frente];
    }

    // Mostrar elementos da fila
    void showQueue() {
        int index = frente;
        for (int i = 0; i < tamanho; i++) {
            std::cout << elementos[index] << " ";
            index = (index + 1) % capacidade;
        }
        std::cout << std::endl;
    }

    ~FilaCircular() {
        delete[] elementos;
    }
};

int main() {
    FilaCircular<int> fila(5);
    fila.enqueue(1);
    fila.enqueue(2);
    fila.enqueue(3);

    fila.showQueue();

    std::cout << "Frente da fila: " << fila.front() << std::endl;
    std::cout << "Tamanho da fila: " << fila.size() << std::endl;

    fila.dequeue();
    fila.showQueue();

    return 0;
}
