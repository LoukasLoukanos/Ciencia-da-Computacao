/*
♦ Algoritmo 08: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Merge Sort (Ordenação por Mistura/Mesclagem).
*/

function mergeSort(array) {
  if (array.length <= 1) {
    return array;
  }

  const meio = Math.floor(array.length / 2);
  const metadeEsquerda = array.slice(0, meio);
  const metadeDireita = array.slice(meio);

  return merge(mergeSort(metadeEsquerda), mergeSort(metadeDireita));
}

function merge(metadeEsquerda, metadeDireita) {
  const array = [];
  let i = 0; // Índice para a metade esquerda
  let j = 0; // Índice para a metade direita

  while (i < metadeEsquerda.length && j < metadeDireita.length) {
    if (metadeEsquerda[i] <= metadeDireita[j]) {
      array.push(metadeEsquerda[i]);
      i++;
    } else {
      array.push(metadeDireita[j]);
      j++;
    }
  }

  // Copiar os elementos restantes da metade esquerda
  while (i < metadeEsquerda.length) {
    array.push(metadeEsquerda[i]);
    i++;
  }

  // Copiar os elementos restantes da metade direita
  while (j < metadeDireita.length) {
    array.push(metadeDireita[j]);
    j++;
  }

  return array;
}

const array = [64, 34, 25, 12, 22, 11, 90];

const sortedArray = mergeSort(array);

console.log("Array ordenado:");
console.log(sortedArray.join(" "));
