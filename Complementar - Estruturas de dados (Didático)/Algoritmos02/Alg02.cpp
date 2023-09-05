/* Estrutura de dados linear de uma fila (de regra de acesso FIFO) circular/não-circular 
  estática genérica utilizando um array unidimensional (vetor)

→ Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços 
  livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.

→ Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços 
  livres, caso haja, no início da fila.

Métodos:
 isEmpty - verificar se a fila está vazia; 
 isFull - verificar se a fila está cheia;
 enqueue - adicionar elementos;
 dequeue - remover o elemento da frente da fila;
 size - obter o tamanho atual da fila;
 front - acessar o elemento da frente da fila sem removê-lo;
 showQueue - mostar elementos da fila.
*/

#include <iostream>

template <typename T>
class Alg02 {
private:
    T* elementos;
    int tamanho;
    int capacidade;
    int inicio;
    int fim;

public:
    Alg02(int capacidade) {
        this->capacidade = capacidade;
        this->elementos = new T[capacidade];
        this->tamanho = 0;
        this->inicio = 0;
        this->fim = -1;
    }

    bool isEmpty() {
        return tamanho == 0;
    }

    bool isFull() {
        return tamanho == capacidade;
    }

    void enqueue(T elemento) {
        if (isFull()) {
            std::cout << "A fila está cheia. Não é possível adicionar mais elementos." << std::endl;
            return;
        }

        fim = (fim + 1) % capacidade;
        elementos[fim] = elemento;
        tamanho++;
    }

    T dequeue() {
        if (isEmpty()) {
            std::cout << "A fila está vazia. Não é possível remover elementos." << std::endl;
            return T();
        }

        T elementoRemovido = elementos[inicio];
        elementos[inicio] = T();
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elementoRemovido;
    }

    T front() {
        if (isEmpty()) {
            std::cout << "A fila está vazia. Não há elementos para retornar." << std::endl;
            return T();
        }

        return elementos[inicio];
    }

    int size() {
        return tamanho;
    }

    void showQueue() {
        if (isEmpty()) {
            std::cout << "A fila está vazia." << std::endl;
            return;
        }
        std::cout << "Elementos da fila:" << std::endl;
        for (int i = 0; i < tamanho; i++) {
            std::cout << elementos[i] << std::endl;
        }
    }
};

int main() {
    Alg02<int> fila(5);
    fila.enqueue(10);
    fila.enqueue(20);
    fila.enqueue(30);
    std::cout << "Tamanho da fila: " << fila.size() << std::endl;
    std::cout << "Elemento na frente da fila: " << fila.front() << std::endl;
    std::cout << "Removendo elemento da fila: " << fila.dequeue() << std::endl;
    std::cout << "Tamanho da fila após remoção: " << fila.size() << std::endl;

    fila.showQueue();

    return 0;
}
