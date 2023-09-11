<?php
/*
♦ Algoritmo 09: Estrutura de Dados Linear Estática (não Dinâmica) de Pesquisa/Busca Pesquisa Sequencial (sem a utilização de variável/sentinela).
*/

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
