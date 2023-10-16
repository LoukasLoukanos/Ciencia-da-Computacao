/*
♦ Algoritmo 17: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação em tempo linear Counting Sort (Ordenação por Contagem).
*/

function countingSort(arr) {
    const max = Math.max(...arr);
    const min = Math.min(...arr);

    const range = max - min + 1;
    const countArray = new Array(range).fill(0);
    const outputArray = new Array(arr.length);

    // Inicializa o array de contagem
    for (let i = 0; i < arr.length; i++) {
        countArray[arr[i] - min]++;
    }

    // Atualiza o array de contagem para ter a soma acumulativa
    for (let i = 1; i < range; i++) {
        countArray[i] += countArray[i - 1];
    }

    // Constrói o array de saída
    for (let i = arr.length - 1; i >= 0; i--) {
        outputArray[countArray[arr[i] - min] - 1] = arr[i];
        countArray[arr[i] - min]--;
    }

    // Copia o array ordenado de volta para o array original
    for (let i = 0; i < arr.length; i++) {
        arr[i] = outputArray[i];
    }
}

function printArray(arr) {
    console.log(arr.join(" "));
}

const arr = [4, 2, 2, 8, 3, 3, 1];
console.log("Array original:");
printArray(arr);

countingSort(arr);

console.log("Array ordenado:");
printArray(arr);
