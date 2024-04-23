<?php
/*
♦ Algoritmo 16: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Dinâmicas (não Estáticas): Insertion Sort (Ordenação por Inserção).
*/

function insertionSort(&$arr) {
    $n = count($arr);
    for ($i = 1; $i < $n; $i++) {
        $key = $arr[$i];
        $j = $i - 1;
        
        // Move os elementos do arr[0..i-1] que são maiores que a chave
        // para uma posição à frente de sua posição atual
        while ($j >= 0 && $arr[$j] > $key) {
            $arr[$j + 1] = $arr[$j];
            $j--;
        }
        
        $arr[$j + 1] = $key;
    }
}

function printArray($arr) {
    $n = count($arr);
    for ($i = 0; $i < $n; $i++) {
        echo $arr[$i] . " ";
    }
    echo "\n";
}

$arr = array(12, 11, 13, 5, 6);
echo "Array original:\n";
printArray($arr);

insertionSort($arr);

echo "Array ordenado:\n";
printArray($arr);

?>
