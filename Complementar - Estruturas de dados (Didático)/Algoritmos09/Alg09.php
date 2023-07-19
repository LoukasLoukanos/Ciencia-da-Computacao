<?php
/* Algoritmo da Estrutura de dados linear estática (não dinâmica) de Pesquisa/Busca 
   buscaSequencial para pesquisa sequencial sem a utilização de sentinela */

function buscaSequencial($array, $valorProcurado) {
    for ($i = 0; $i < count($array); $i++) {
        if ($array[$i] === $valorProcurado) {
            return $i; // Retorna o índice do valor procurado
        }
    }
    return -1; // Retorna -1 se o valor não foi encontrado
}

$array = [10, 5, 2, 8, 3, 7, 1, 6, 9, 4];
$valorProcurado = 7;

$indiceEncontrado = buscaSequencial($array, $valorProcurado);

if ($indiceEncontrado !== -1) {
    echo "Valor " . $valorProcurado . " encontrado no índice: " . $indiceEncontrado;
} else {
    echo "Valor " . $valorProcurado . " não encontrado no array.";
}

?>
