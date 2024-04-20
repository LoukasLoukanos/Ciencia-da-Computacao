<?php
/*
♦ Algoritmo 06: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Selection Sort (Ordenação por Seleção).
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
