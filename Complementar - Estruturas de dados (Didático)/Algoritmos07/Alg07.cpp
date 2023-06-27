/* Algoritmo da Estrutura de dados linear de Classificação/Ordenação estática (não dinâmica) de divisão e 
   conquista QuickSort, também conhecida como Ordenação pelo Método (Recursivo) Rápido */
   
#include <iostream>
using namespace std;

void trocar(int array[], int indice1, int indice2) {
    int temp = array[indice1];
    array[indice1] = array[indice2];
    array[indice2] = temp;
}

int partition(int array[], int inicio, int fim) {
    int pivo = array[fim];
    int i = inicio - 1;
    
    for (int j = inicio; j < fim; j++) {
        if (array[j] < pivo) {
            i++;
            trocar(array, i, j);
        }
    }
    
    trocar(array, i + 1, fim);
    return i + 1;
}

void quicksort(int array[], int inicio, int fim) {
    if (inicio < fim) {
        int indicePivo = partition(array, inicio, fim);
        quicksort(array, inicio, indicePivo - 1);
        quicksort(array, indicePivo + 1, fim);
    }
}

int main() {
    int array[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(array) / sizeof(array[0]);
    
    quicksort(array, 0, n - 1);
    
    cout << "Array ordenado:" << endl;
    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
    }
    
    return 0;
}
