/*
♦ Algoritmo 01: Implementação de um array unidimensional (vetor) de tipo genérico para dados primitivos de estrutura homogênea.
*/

#include <iostream>
#include <cassert>
#include <cstring>

template <typename T>
class Alg01 {
private:
    T* elementos;
    int tamanho;
    int tamanhoAtual;

public:
    Alg01(int tamanho) : tamanho(tamanho), tamanhoAtual(0) {
        elementos = new T[tamanho];
    }

    ~Alg01() {
        delete[] elementos;
    }

    bool isEmpty() const {
        return tamanhoAtual == 0;
    }

    bool isFull() const {
        return tamanhoAtual == tamanho;
    }

    void addElement(int indice, const T& valor) {
        if (indice < 0 || indice >= tamanho) {
            throw std::out_of_range("Índice fora dos limites do vetor.");
        }

        if (isFull()) {
            throw std::runtime_error("O vetor está cheio.");
        }

        elementos[indice] = valor;
        tamanhoAtual++;
    }

    void removeElement(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw std::out_of_range("Índice fora dos limites do vetor.");
        }

        if (isEmpty()) {
            throw std::runtime_error("O vetor está vazio.");
        }

        elementos[indice] = T(); // Define o elemento como um valor padrão (0 para tipos numéricos).
        tamanhoAtual--;
    }

    int sizeArray() const {
        return tamanhoAtual;
    }

    T accessElement(int indice) const {
        if (indice < 0 || indice >= tamanho) {
            throw std::out_of_range("Índice fora dos limites do vetor.");
        }

        if (isEmpty()) {
            throw std::runtime_error("O vetor está vazio.");
        }

        return elementos[indice];
    }

    void showQueue() const {
        for (int i = 0; i < tamanhoAtual; i++) {
            std::cout << elementos[i] << " ";
        }
        std::cout << std::endl;
    }
};

int main() {
    // Exemplo de criação de um vetor de inteiros
    Alg01<int> vetorInt(10);

    // Verificar se o vetor está vazio
    std::cout << "O vetor está vazio? " << (vetorInt.isEmpty() ? "Sim" : "Não") << std::endl;

    // Adicionar elementos
    vetorInt.addElement(0, 10);
    vetorInt.addElement(1, 20);
    vetorInt.addElement(2, 30);

    // Verificar o tamanho atual do vetor
    std::cout << "Tamanho atual do vetor: " << vetorInt.sizeArray() << std::endl;

    // Acessar um elemento
    std::cout << "Elemento no índice 1: " << vetorInt.accessElement(1) << std::endl;

    // Remover um elemento
    vetorInt.removeElement(1);

    // Verificar se o vetor está vazio novamente
    std::cout << "O vetor está vazio? " << (vetorInt.isEmpty() ? "Sim" : "Não") << std::endl;

    // Verificar se o vetor está cheio
    std::cout << "O vetor está cheio? " << (vetorInt.isFull() ? "Sim" : "Não") << std::endl;

    // Mostrar todos os elementos
    std::cout << "Elementos do vetor: ";
    vetorInt.showQueue();

    return 0;
}
