/*
♦ Algoritmo 07: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Quick Sort (Ordenação Rápida).
*/

function trocar(array, indice1, indice2) {
    var temp = array[indice1];
    array[indice1] = array[indice2];
    array[indice2] = temp;
}

function partition(array, inicio, fim) {
    var pivo = array[fim];
    var i = inicio - 1;

    for (var j = inicio; j < fim; j++) {
        if (array[j] < pivo) {
            i++;
            trocar(array, i, j);
        }
    }

    trocar(array, i + 1, fim);
    return i + 1;
}

function quicksort(array, inicio, fim) {
    if (inicio < fim) {
        var indicePivo = partition(array, inicio, fim);
        quicksort(array, inicio, indicePivo - 1);
        quicksort(array, indicePivo + 1, fim);
    }
}

var array = [64, 34, 25, 12, 22, 11, 90];
var n = array.length;

quicksort(array, 0, n - 1);

console.log("Array ordenado:");
for (var i = 0; i < n; i++) {
    console.log(array[i] + " ");
}
