<?php
/*
♦ Algoritmo 06: Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação Selection Sort (Ordenação pelo Método (Iterativo) de Seleção).
*/

function selectionSort(&$array) {
    $n = count($array);
    
    for ($i = 0; $i < $n - 1; $i++) {
        $indiceMenor = $i;
        
        for ($j = $i + 1; $j < $n; $j++) {
            if ($array[$j] < $array[$indiceMenor]) {
                $indiceMenor = $j;
            }
        }
        
        $temp = $array[$indiceMenor];
        $array[$indiceMenor] = $array[$i];
        $array[$i] = $temp;
    }
}

$array = array(64, 34, 25, 12, 22, 11, 90);

selectionSort($array);

echo "Array ordenado: ";
foreach ($array as $element) {
    echo $element . " ";
}

?>
