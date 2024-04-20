/*
♦ Algoritmo 11: Algoritmo de Pesquisa/Busca para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Busca Binária.
*/

function buscaBinaria(array, valorProcurado) {
    let inicio = 0;
    let fim = array.length - 1;

    while (inicio <= fim) {
        let meio = Math.floor((inicio + fim) / 2);

        if (array[meio] === valorProcurado) {
            return meio; // Retorna o índice do valor procurado
        } else if (array[meio] < valorProcurado) {
            inicio = meio + 1;
        } else {
            fim = meio - 1;
        }
    }

    return -1; // Retorna -1 se o valor não foi encontrado
}

const array = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19];
const valorProcurado = 11;

const indiceEncontrado = buscaBinaria(array, valorProcurado);

if (indiceEncontrado !== -1) {
    console.log(`Valor ${valorProcurado} encontrado no índice: ${indiceEncontrado}`);
} else {
    console.log(`Valor ${valorProcurado} não encontrado no array.`);
}
