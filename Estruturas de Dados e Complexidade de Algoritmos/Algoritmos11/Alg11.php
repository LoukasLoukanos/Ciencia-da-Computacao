<?php
/*
♦ Algoritmo 11: Algoritmo de Pesquisa/Busca para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Busca Binária.
*/

function buscaBinaria($array, $valorProcurado) {
    $inicio = 0;
    $fim = count($array) - 1;

    while ($inicio <= $fim) {
        $meio = floor(($inicio + $fim) / 2);

        if ($array[$meio] == $valorProcurado) {
            return $meio; // Retorna o índice do valor procurado
        } else if ($array[$meio] < $valorProcurado) {
            $inicio = $meio + 1;
        } else {
            $fim = $meio - 1;
        }
    }

    return -1; // Retorna -1 se o valor não foi encontrado
}

$array = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19];
$valorProcurado = 11;

$indiceEncontrado = buscaBinaria($array, $valorProcurado);

if ($indiceEncontrado !== -1) {
    echo "Valor $valorProcurado encontrado no índice: $indiceEncontrado";
} else {
    echo "Valor $valorProcurado não encontrado no array.";
}

?>
