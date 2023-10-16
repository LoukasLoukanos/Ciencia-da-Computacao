/*
♦ Algoritmo 18: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Bucket Sort (Ordenação por Balde).
*/

function bucketSort(arr) {
    const n = arr.length;
    
    // Crie um array de baldes
    const buckets = new Array(n);
    for (let i = 0; i < n; i++) {
        buckets[i] = [];
    }

    // Coloque os elementos nos baldes
    for (let i = 0; i < n; i++) {
        const bucketIndex = Math.floor(n * arr[i]);
        buckets[bucketIndex].push(arr[i]);
    }

    // Ordene os baldes e combine-os de volta no array original
    for (let i = 0; i < n; i++) {
        buckets[i].sort((a, b) => a - b);
    }
    
    let index = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < buckets[i].length; j++) {
            arr[index] = buckets[i][j];
            index++;
        }
    }
}

function printArray(arr) {
    const n = arr.length;
    for (let i = 0; i < n; i++) {
        process.stdout.write(arr[i] + " ");
    }
    process.stdout.write("\n");
}

const arr = [0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51];
console.log("Array original:");
printArray(arr);

bucketSort(arr);

console.log("Array ordenado:");
printArray(arr);
