/* Algoritmo da Estrutura de dados linear estática (não dinâmica) genérica de 
 uma pilha (de regra de acesso LIFO) utilizando um array unidimensional (vetor)
 
Métodos:
 isEmpty - verificar se a pilha está vazia; 
 isFull - verificar se a pilha está cheia;
 push - inserir elementos no topo da pilha;
 pop - remover elementos do dopo da pilha;
 size - obter o tamanho atual da pilha;
 front - acessar o elemento do topo da pilha sem removê-lo;
 showStack - mostar elementos da pilha (do topo para base).
*/

#include <iostream>

template <class T>
class Alg03 {
private:
    int tamanhoMaximo;
    int topo;
    T* elementos;

public:
    Alg03(int tamanhoMaximo) {
        this->tamanhoMaximo = tamanhoMaximo;
        this->topo = -1;
        this->elementos = new T[tamanhoMaximo];
    }

    bool isEmpty() {
        return topo == -1;
    }

    bool isFull() {
        return topo == tamanhoMaximo - 1;
    }

    void push(T elemento) {
        if (isFull()) {
            std::cout << "A pilha está cheia. Não é possível empilhar o elemento." << std::endl;
            return;
        }
        topo++;
        elementos[topo] = elemento;
    }

    T pop() {
        if (isEmpty()) {
            std::cout << "A pilha está vazia. Não é possível desempilhar um elemento." << std::endl;
            return NULL;
        }
        T elemento = elementos[topo];
        topo--;
        return elemento;
    }

    T front() {
        if (isEmpty()) {
            std::cout << "A pilha está vazia. Não há elemento no topo." << std::endl;
            return NULL;
        }
        return elementos[topo];
    }

    int size() {
        return topo + 1;
    }

    void showStack() {
        if (isEmpty()) {
            std::cout << "A pilha está vazia." << std::endl;
            return;
        }
        std::cout << "Elementos da pilha (do topo para base):" << std::endl;
        for (int i = topo; i >= 0; i--) {
            std::cout << elementos[i] << std::endl;
        }
    }
};

int main() {
    Alg03<int> pilha(5);

    pilha.push(10);
    pilha.push(20);
    pilha.push(30);

    std::cout << "Tamanho da pilha: " << pilha.size() << std::endl;
    std::cout << "Elemento no topo: " << pilha.front() << std::endl;

    pilha.pop();

    std::cout << "Tamanho da pilha: " << pilha.size() << std::endl;
    std::cout << "Elemento no topo: " << pilha.front() << std::endl;

    pilha.showStack();

    return 0;
}
