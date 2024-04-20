/*
♦ Algoritmo 10: Algoritmo de Pesquisa/Busca para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Busca Sequencial (com a utilização de variável/sentinela).
*/

#include <iostream>
using namespace std;

int buscaSequencialComSentinela(int array[], int valorProcurado, int tamanhoArray) {
    // Adiciona o valor procurado como sentinela na última posição do array
    int valorAnterior = array[tamanhoArray - 1];
    array[tamanhoArray - 1] = valorProcurado;

    int i = 0;
    // Percorre o array até encontrar o valor procurado ou a sentinela
    while (array[i] != valorProcurado) {
        i++;
    }

    // Restaura o valor anterior da última posição do array
    array[tamanhoArray - 1] = valorAnterior;

    if (i < tamanhoArray - 1 || array[tamanhoArray - 1] == valorProcurado) {
        return i; // Retorna o índice do valor procurado
    } else {
        return -1; // Retorna -1 se o valor não foi encontrado
    }
}

int main() {
    int array[] = {10, 5, 2, 8, 3, 7, 1, 6, 9, 4};
    int tamanhoArray = sizeof(array) / sizeof(array[0]);
    int valorProcurado = 7;

    int indiceEncontrado = buscaSequencialComSentinela(array, valorProcurado, tamanhoArray);

    if (indiceEncontrado != -1) {
        cout << "Valor " << valorProcurado << " encontrado no índice: " << indiceEncontrado << endl;
    } else {
        cout << "Valor " << valorProcurado << " não encontrado no array." << endl;
    }

    return 0;
}
