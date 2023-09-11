/* 
♦ Algoritmo 05: Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação Insertion Sort (Ordenação pelo Método (Iterativo) de Inserção).
*/

#include <iostream>
using namespace std;

void insertionSort(int array[], int n) {
    for (int i = 1; i < n; i++) {
        int chave = array[i];
        int j = i - 1;
        
        while (j >= 0 && array[j] > chave) {
            array[j + 1] = array[j];
            j--;
        }
        
        array[j + 1] = chave;
    }
}

int main() {
    int array[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(array) / sizeof(array[0]);
    
    insertionSort(array, n);
    
    cout << "Array ordenado:" << endl;
    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
    }
    
    return 0;
}
