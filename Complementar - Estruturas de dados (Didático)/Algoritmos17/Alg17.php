<?php
/*
♦ Algoritmo 17: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Dinâmicas (não Estáticas): Counting Sort (Ordenação por Contagem).
*/

function countingSort(&$arr) {
    $max = max($arr);
    $min = min($arr);

    $range = $max - $min + 1;
    $countArray = array_fill(0, $range, 0);
    $outputArray = array_fill(0, count($arr), 0);

    // Inicializa o array de contagem
    foreach ($arr as $value) {
        $countArray[$value - $min]++;
    }

    // Atualiza o array de contagem para ter a soma acumulativa
    for ($i = 1; $i < $range; $i++) {
        $countArray[$i] += $countArray[$i - 1];
    }

    // Constrói o array de saída
    for ($i = count($arr) - 1; $i >= 0; $i--) {
        $outputArray[$countArray[$arr[$i] - $min] - 1] = $arr[$i];
        $countArray[$arr[$i] - $min]--;
    }

    // Copia o array ordenado de volta para o array original
    for ($i = 0; $i < count($arr); $i++) {
        $arr[$i] = $outputArray[$i];
    }
}

function printArray($arr) {
    echo implode(" ", $arr) . PHP_EOL;
}

$arr = [4, 2, 2, 8, 3, 3, 1];
echo "Array original:" . PHP_EOL;
printArray($arr);

countingSort($arr);

echo "Array ordenado:" . PHP_EOL;
printArray($arr);

?>
