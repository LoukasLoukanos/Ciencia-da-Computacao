/*
♦ Algoritmo 09: Estrutura de Dados Linear Estática (não Dinâmica) de Pesquisa/Busca Pesquisa Sequencial (sem a utilização de variável/sentinela).
*/

function buscaSequencial(array, valorProcurado) {
    for (let i = 0; i < array.length; i++) {
        if (array[i] === valorProcurado) {
            return i; // Retorna o índice do valor procurado
        }
    }
    return -1; // Retorna -1 se o valor não foi encontrado
}

const array = [10, 5, 2, 8, 3, 7, 1, 6, 9, 4];
const valorProcurado = 7;

const indiceEncontrado = buscaSequencial(array, valorProcurado);

if (indiceEncontrado !== -1) {
    console.log(`Valor ${valorProcurado} encontrado no índice: ${indiceEncontrado}`);
} else {
    console.log(`Valor ${valorProcurado} não encontrado no array.`);
}
