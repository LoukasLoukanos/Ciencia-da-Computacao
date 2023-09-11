/* 
♦ Algoritmo 08: Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação de Divisão e Conquista Merge Sort (Ordenação pelo Método (Recursivo) de Mistura/Mesclagem).
*/

#include <iostream>
using namespace std;

void merge(int array[], int metadeEsquerda[], int tamanhoEsquerda, int metadeDireita[], int tamanhoDireita) {
    int i = 0; // Índice para a metade esquerda
    int j = 0; // Índice para a metade direita
    int k = 0; // Índice para o array final
    
    while (i < tamanhoEsquerda && j < tamanhoDireita) {
        if (metadeEsquerda[i] <= metadeDireita[j]) {
            array[k] = metadeEsquerda[i];
            i++;
        } else {
            array[k] = metadeDireita[j];
            j++;
        }
        k++;
    }
    
    // Copiar os elementos restantes da metade esquerda
    while (i < tamanhoEsquerda) {
        array[k] = metadeEsquerda[i];
        i++;
        k++;
    }
    
    // Copiar os elementos restantes da metade direita
    while (j < tamanhoDireita) {
        array[k] = metadeDireita[j];
        j++;
        k++;
    }
}

void mergeSort(int array[], int tamanho) {
    if (tamanho <= 1) {
        return;
    }
    
    int meio = tamanho / 2;
    int tamanhoEsquerda = meio;
    int tamanhoDireita = tamanho - meio;
    int metadeEsquerda[tamanhoEsquerda];
    int metadeDireita[tamanhoDireita];
    
    // Preencher as duas metades
    for (int i = 0; i < tamanhoEsquerda; i++) {
        metadeEsquerda[i] = array[i];
    }
    for (int i = meio; i < tamanho; i++) {
        metadeDireita[i - meio] = array[i];
    }
    
    // Recursivamente ordenar as duas metades
    mergeSort(metadeEsquerda, tamanhoEsquerda);
    mergeSort(metadeDireita, tamanhoDireita);
    
    // Mesclar as metades ordenadas
    merge(array, metadeEsquerda, tamanhoEsquerda, metadeDireita, tamanhoDireita);
}

int main() {
    int array[] = {64, 34, 25, 12, 22, 11, 90};
    int tamanho = sizeof(array) / sizeof(array[0]);
    
    mergeSort(array, tamanho);
    
    cout << "Array ordenado:" << endl;
    for (int i = 0; i < tamanho; i++) {
        cout << array[i] << " ";
    }
    
    return 0;
}
