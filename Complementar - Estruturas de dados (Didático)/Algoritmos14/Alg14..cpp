/* Algoritmo da Estrutura de dados linear dinâmica (não estática) 
   Alg14 de Fila (regra de acesso FIFO) Dinâmica */
   
#include <iostream>

template <typename T>
class FilaDinamica {
private:
    struct Nodo {
        T dado;
        Nodo* proximo;

        Nodo(T dado) : dado(dado), proximo(nullptr) {}
    };

    Nodo* cabeca;
    Nodo* cauda;
    int tamanho;

public:
    FilaDinamica() : cabeca(nullptr), cauda(nullptr), tamanho(0) {}

    // Verificar se a fila está vazia
    bool isEmpty() const {
        return tamanho == 0;
    }

    // Adicionar elementos à fila (enqueue)
    void enqueue(T dado) {
        Nodo* novoNodo = new Nodo(dado);
        if (isEmpty()) {
            cabeca = novoNodo;
            cauda = novoNodo;
        } else {
            cauda->proximo = novoNodo;
            cauda = novoNodo;
        }
        tamanho++;
    }

    // Remover o elemento da frente da fila (dequeue)
    T dequeue() {
        if (isEmpty()) {
            throw std::runtime_error("A fila está vazia");
        }

        T dadoRemovido = cabeca->dado;
        Nodo* temp = cabeca;
        cabeca = cabeca->proximo;
        delete temp;
        tamanho--;

        if (isEmpty()) {
            cauda = nullptr;
        }

        return dadoRemovido;
    }

    // Obter o tamanho atual da fila
    int size() const {
        return tamanho;
    }

    // Acessar o elemento da frente da fila sem removê-lo
    T front() const {
        if (isEmpty()) {
            throw std::runtime_error("A fila está vazia");
        }

        return cabeca->dado;
    }

    // Mostrar elementos da fila
    void showQueue() const {
        Nodo* atual = cabeca;
        while (atual != nullptr) {
            std::cout << atual->dado << " ";
            atual = atual->proximo;
        }
        std::cout << std::endl;
    }

    ~FilaDinamica() {
        while (!isEmpty()) {
            dequeue();
        }
    }
};

int main() {
    FilaDinamica<int> fila;
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
