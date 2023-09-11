<?php
/*
♦ Algoritmo 07: Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação de Divisão e Conquista Quick Sort (Ordenação pelo Método (Recursivo) Rápido).
*/

   function trocar(&$array, $indice1, $indice2) {
    $temp = $array[$indice1];
    $array[$indice1] = $array[$indice2];
    $array[$indice2] = $temp;
}

function partition(&$array, $inicio, $fim) {
    $pivo = $array[$fim];
    $i = $inicio - 1;

    for ($j = $inicio; $j < $fim; $j++) {
        if ($array[$j] < $pivo) {
            $i++;
            trocar($array, $i, $j);
        }
    }

    trocar($array, $i + 1, $fim);
    return $i + 1;
}

function quicksort(&$array, $inicio, $fim) {
    if ($inicio < $fim) {
        $indicePivo = partition($array, $inicio, $fim);
        quicksort($array, $inicio, $indicePivo - 1);
        quicksort($array, $indicePivo + 1, $fim);
    }
}

$array = [64, 34, 25, 12, 22, 11, 90];
$n = count($array);

quicksort($array, 0, $n - 1);

echo "Array ordenado:\n";
for ($i = 0; $i < $n; $i++) {
    echo $array[$i] . " ";
}

?>
