/* Algoritmo da Estrutura de dados linear de Classificação/Ordenação estatica (não dinâmica)
   SelectionSort, também conhecida como Ordenação pelo Método (Iterativo) de Seleção */

   function selectionSort(array) {
    var n = array.length;
    
    for (var i = 0; i < n - 1; i++) {
        var indiceMenor = i;
        
        for (var j = i + 1; j < n; j++) {
            if (array[j] < array[indiceMenor]) {
                indiceMenor = j;
            }
        }
        
        var temp = array[indiceMenor];
        array[indiceMenor] = array[i];
        array[i] = temp;
    }
}

var array = [64, 34, 25, 12, 22, 11, 90];

selectionSort(array);

console.log("Array ordenado:");
for (var i = 0; i < array.length; i++) {
    console.log(array[i]);
}
