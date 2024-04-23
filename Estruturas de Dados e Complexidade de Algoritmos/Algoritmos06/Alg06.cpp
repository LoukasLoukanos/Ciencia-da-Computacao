/*
♦ Algoritmo 06: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Selection Sort (Ordenação por Seleção).
*/

#include <iostream>
using namespace std;

void selectionSort(int array[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int indiceMenor = i;
        
        for (int j = i + 1; j < n; j++) {
            if (array[j] < array[indiceMenor]) {
                indiceMenor = j;
            }
        }
        
        int temp = array[indiceMenor];
        array[indiceMenor] = array[i];
        array[i] = temp;
    }
}

int main() {
    int array[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(array) / sizeof(array[0]);
    
    selectionSort(array, n);
    
    cout << "Array ordenado: ";
    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
    }
    
    return 0;
}
