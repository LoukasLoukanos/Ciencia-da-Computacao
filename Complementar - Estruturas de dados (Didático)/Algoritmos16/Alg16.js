/*
♦ Algoritmo 16: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Insertion Sort (Ordenação por Inserção).
*/

function insertionSort(arr) {
    const n = arr.length;
    for (let i = 1; i < n; i++) {
        const key = arr[i];
        let j = i - 1;

        // Move os elementos do arr[0..i-1] que são maiores que a chave
        // para uma posição à frente de sua posição atual
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}

function printArray(arr) {
    const n = arr.length;
    for (let i = 0; i < n; i++) {
        process.stdout.write(arr[i] + " ");
    }
    process.stdout.write("\n");
}

const arr = [12, 11, 13, 5, 6];
console.log("Array original:");
printArray(arr);

insertionSort(arr);

console.log("Array ordenado:");
printArray(arr);
