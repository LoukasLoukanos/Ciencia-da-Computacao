/* Algoritmo da Estrutura de dados linear estática (não dinâmica)
   de Pesquisa/Busca buscaBinaria para busca binária */

#include <iostream>
using namespace std;

int buscaBinaria(int array[], int tamanhoArray, int valorProcurado) {
    int inicio = 0;
    int fim = tamanhoArray - 1;

    while (inicio <= fim) {
        int meio = inicio + (fim - inicio) / 2;

        if (array[meio] == valorProcurado) {
            return meio; // Retorna o índice do valor procurado
        } else if (array[meio] < valorProcurado) {
            inicio = meio + 1;
        } else {
            fim = meio - 1;
        }
    }

    return -1; // Retorna -1 se o valor não foi encontrado
}

int main() {
    int array[] = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
    int tamanhoArray = sizeof(array) / sizeof(array[0]);
    int valorProcurado = 11;

    int indiceEncontrado = buscaBinaria(array, tamanhoArray, valorProcurado);

    if (indiceEncontrado != -1) {
        cout << "Valor " << valorProcurado << " encontrado no índice: " << indiceEncontrado << endl;
    } else {
        cout << "Valor " << valorProcurado << " não encontrado no array." << endl;
    }

    return 0;
}
