/*
♦ Algoritmo 18: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Bucket Sort (Ordenação por Balde).
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void bucketSort(vector<double>& arr) {
    int n = arr.size();
    
    // Crie um vetor de baldes
    vector<vector<double>> buckets(n);

    // Coloque os elementos nos baldes
    for (int i = 0; i < n; i++) {
        int bucketIndex = n * arr[i];
        buckets[bucketIndex].push_back(arr[i]);
    }

    // Ordene os baldes e combine-os de volta no vetor original
    for (int i = 0; i < n; i++) {
        sort(buckets[i].begin(), buckets[i].end());
    }
    
    int index = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < buckets[i].size(); j++) {
            arr[index] = buckets[i][j];
            index++;
        }
    }
}

void printArray(const vector<double>& arr) {
    int n = arr.size();
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    vector<double> arr = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};
    cout << "Array original:" << endl;
    printArray(arr);

    bucketSort(arr);

    cout << "Array ordenado:" << endl;
    printArray(arr);

    return 0;
}
