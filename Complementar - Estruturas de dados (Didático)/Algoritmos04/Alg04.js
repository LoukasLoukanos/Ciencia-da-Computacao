/* Algoritmo da Estrutura de dados linear de Classificação/Ordenação estática (não dinâmica) 
   BubbleSort, também conhecida como Ordanação pelo Método (Iterativo) de Bolhas. */
   
function bubbleSort(array) {
    let n = array.length;
    let troca;

    for (let i = 0; i < n - 1; i++) {
        troca = false;

        for (let j = 0; j < n - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                // Troca os elementos
                let temp = array[j];
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

let array = [64, 34, 25, 12, 22, 11, 90];

bubbleSort(array);

console.log("Array ordenado:");
console.log(array.join(" "));
