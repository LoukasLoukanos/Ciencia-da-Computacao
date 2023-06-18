/* Estrutura de dados linear de Classificação/Ordenação estatica BubbleSort 
   ou Método BubbleSort (Iterativo): Ordenação pelo método de bolhas. */

#include <iostream>
using namespace std;

void bubbleSort(int array[], int n) {
    bool troca;
    
    for (int i = 0; i < n - 1; i++) {
        troca = false;
        
        for (int j = 0; j < n - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                // Troca os elementos
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                troca = true;
            }
        }
        
        // Se não houve trocas na passagem atual, o array está ordenado
        if (!troca) {
            break;
        }
    }
}

int main() {
    int array[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(array) / sizeof(array[0]);
    
    bubbleSort(array, n);
    
    cout << "Array ordenado:" << endl;
    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
    }
    
    return 0;
}
