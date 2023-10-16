/*
♦ Algoritmo 17: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação em tempo linear Counting Sort (Ordenação por Contagem).
*/

#include <iostream>
#include <vector>

using namespace std;

void countingSort(vector<int> &arr) {
    int max = *max_element(arr.begin(), arr.end());
    int min = *min_element(arr.begin(), arr.end());

    int range = max - min + 1;
    vector<int> countArray(range, 0);
    vector<int> outputArray(arr.size());

    // Inicializa o array de contagem
    for (int i = 0; i < arr.size(); i++) {
        countArray[arr[i] - min]++;
    }

    // Atualiza o array de contagem para ter a soma acumulativa
    for (int i = 1; i < range; i++) {
        countArray[i] += countArray[i - 1];
    }

    // Constrói o array de saída
    for (int i = arr.size() - 1; i >= 0; i--) {
        outputArray[countArray[arr[i] - min] - 1] = arr[i];
        countArray[arr[i] - min]--;
    }

    // Copia o array ordenado de volta para o array original
    for (int i = 0; i < arr.size(); i++) {
        arr[i] = outputArray[i];
    }
}

void printArray(const vector<int> &arr) {
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;
}

int main() {
    vector<int> arr = {4, 2, 2, 8, 3, 3, 1};
    cout << "Array original:" << endl;
    printArray(arr);

    countingSort(arr);

    cout << "Array ordenado:" << endl;
    printArray(arr);

    return 0;
}
