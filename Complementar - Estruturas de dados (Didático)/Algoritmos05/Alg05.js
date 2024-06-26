/*
♦ Algoritmo 05: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Insertion Sort (Ordenação por Inserção).
*/

function insertionSort(array) {
    var n = array.length;
    
    for (var i = 1; i < n; i++) {
        var chave = array[i];
        var j = i - 1;
        
        while (j >= 0 && array[j] > chave) {
            array[j + 1] = array[j];
            j--;
        }
        
        array[j + 1] = chave;
    }
}

var array = [64, 34, 25, 12, 22, 11, 90];

insertionSort(array);

console.log("Array ordenado:");
for (var i = 0; i < array.length; i++) {
    console.log(array[i] + " ");
}
