<?php

/* Estrutura de dados linear de Classificação/Ordenação estatica 
   InsertionSort ou Método (Iterativo) de Ordenação por inserção */

function insertionSort(&$array) {
    $n = count($array);
    
    for ($i = 1; $i < $n; $i++) {
        $chave = $array[$i];
        $j = $i - 1;
        
        while ($j >= 0 && $array[$j] > $chave) {
            $array[$j + 1] = $array[$j];
            $j--;
        }
        
        $array[$j + 1] = $chave;
    }
}

$array = [64, 34, 25, 12, 22, 11, 90];

insertionSort($array);

echo "Array ordenado: ";
foreach ($array as $elemento) {
    echo $elemento . " ";
}

?>
