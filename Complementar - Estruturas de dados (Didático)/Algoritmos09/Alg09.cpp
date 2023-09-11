/*
♦ Algoritmo 09: Estrutura de Dados Linear Estática (não Dinâmica) de Pesquisa/Busca Pesquisa Sequencial (sem a utilização de variável/sentinela).
*/

#include <iostream>
using namespace std;

int buscaSequencial(int array[], int tamanho, int valorProcurado) {
    for (int i = 0; i < tamanho; i++) {
        if (array[i] == valorProcurado) {
            return i; // Retorna o índice do valor procurado
        }
    }
    return -1; // Retorna -1 se o valor não foi encontrado
}

int main() {
    int array[] = {10, 5, 2, 8, 3, 7, 1, 6, 9, 4};
    int tamanho = sizeof(array) / sizeof(array[0]);
    int valorProcurado = 7;

    int indiceEncontrado = buscaSequencial(array, tamanho, valorProcurado);

    if (indiceEncontrado != -1) {
        cout << "Valor " << valorProcurado << " encontrado no índice: " << indiceEncontrado << endl;
    } else {
        cout << "Valor " << valorProcurado << " não encontrado no array." << endl;
    }

    return 0;
}
