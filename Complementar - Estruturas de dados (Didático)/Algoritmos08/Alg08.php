<?php
/*
♦ Algoritmo 08: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Merge Sort (Ordenação por Mistura/Mesclagem).
*/

function mergeSort(&$array) {
    $length = count($array);
    if ($length <= 1) {
        return;
    }

    $meio = floor($length / 2);
    $metadeEsquerda = array_slice($array, 0, $meio);
    $metadeDireita = array_slice($array, $meio);

    mergeSort($metadeEsquerda);
    mergeSort($metadeDireita);

    merge($metadeEsquerda, $metadeDireita, $array);
}

function merge(&$metadeEsquerda, &$metadeDireita, &$array) {
    $i = 0; // Índice para a metade esquerda
    $j = 0; // Índice para a metade direita
    $k = 0; // Índice para o array final

    while ($i < count($metadeEsquerda) && $j < count($metadeDireita)) {
        if ($metadeEsquerda[$i] <= $metadeDireita[$j]) {
            $array[$k] = $metadeEsquerda[$i];
            $i++;
        } else {
            $array[$k] = $metadeDireita[$j];
            $j++;
        }
        $k++;
    }

    while ($i < count($metadeEsquerda)) {
        $array[$k] = $metadeEsquerda[$i];
        $i++;
        $k++;
    }

    while ($j < count($metadeDireita)) {
        $array[$k] = $metadeDireita[$j];
        $j++;
        $k++;
    }
}

$array = [64, 34, 25, 12, 22, 11, 90];

mergeSort($array);

echo "Array ordenado:\n";
for ($i = 0; $i < count($array); $i++) {
    echo $array[$i] . " ";
}
?>
