/*
♦ Algoritmo 16: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Insertion Sort (Ordenação por Inserção).
*/

#include <iostream>

void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        // Move os elementos do arr[0..i-1] que são maiores que a chave
        // para uma posição à frente de sua posição atual
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}

int main() {
    int arr[] = {12, 11, 13, 5, 6};
    int n = sizeof(arr) / sizeof(arr[0]);

    std::cout << "Array original:" << std::endl;
    printArray(arr, n);

    insertionSort(arr, n);

    std::cout << "Array ordenado:" << std::endl;
    printArray(arr, n);

    return 0;
}
