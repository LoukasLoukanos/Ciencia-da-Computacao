<?php
/*
♦ Algoritmo 18: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Bucket Sort (Ordenação por Balde).
*/

function bucketSort(&$arr) {
    $n = count($arr);

    // Crie um array de baldes
    $buckets = array();
    for ($i = 0; $i < $n; $i++) {
        $buckets[$i] = array();
    }

    // Coloque os elementos nos baldes
    for ($i = 0; $i < $n; $i++) {
        $bucketIndex = (int)($n * $arr[$i]);
        array_push($buckets[$bucketIndex], $arr[$i]);
    }

    // Ordene os baldes e combine-os de volta no array original
    for ($i = 0; $i < $n; $i++) {
        sort($buckets[$i]);
    }

    $index = 0;
    for ($i = 0; $i < $n; $i++) {
        $bucketSize = count($buckets[$i]);
        for ($j = 0; $j < $bucketSize; $j++) {
            $arr[$index] = $buckets[$i][$j];
            $index++;
        }
    }
}

function printArray($arr) {
    $n = count($arr);
    for ($i = 0; $i < $n; $i++) {
        echo $arr[$i] . " ";
    }
    echo "\n";
}

$arr = array(0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51);
echo "Array original:\n";
printArray($arr);

bucketSort($arr);

echo "Array ordenado:\n";
printArray($arr);

?>
