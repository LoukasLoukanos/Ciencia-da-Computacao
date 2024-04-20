/*
♦ Algoritmo 10: Algoritmo de Pesquisa/Busca para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Busca Sequencial (com a utilização de variável/sentinela).
*/

function buscaSequencialComSentinela(array, valorProcurado) {
    let tamanhoArray = array.length;

    // Adiciona o valor procurado como sentinela na última posição do array
    let valorAnterior = array[tamanhoArray - 1];
    array[tamanhoArray - 1] = valorProcurado;

    let i = 0;
    // Percorre o array até encontrar o valor procurado ou a sentinela
    while (array[i] !== valorProcurado) {
        i++;
    }

    // Restaura o valor anterior da última posição do array
    array[tamanhoArray - 1] = valorAnterior;

    if (i < tamanhoArray - 1 || array[tamanhoArray - 1] === valorProcurado) {
        return i; // Retorna o índice do valor procurado
    } else {
        return -1; // Retorna -1 se o valor não foi encontrado
    }
}

let array = [10, 5, 2, 8, 3, 7, 1, 6, 9, 4];
let valorProcurado = 7;

let indiceEncontrado = buscaSequencialComSentinela(array, valorProcurado);

if (indiceEncontrado !== -1) {
    console.log("Valor " + valorProcurado + " encontrado no índice: " + indiceEncontrado);
} else {
    console.log("Valor " + valorProcurado + " não encontrado no array.");
}
