<?php
/* Algoritmo da Estrutura de dados linear de Classificação/Ordenação estática (não dinâmica) 
   BubbleSort, também conhecida como Ordanação pelo Método (Iterativo) de Bolhas. */
   
function bubbleSort(&$array) {
    $n = count($array);
    $troca = false;

    for ($i = 0; $i < $n - 1; $i++) {
        $troca = false;

        for ($j = 0; $j < $n - $i - 1; $j++) {
            if ($array[$j] > $array[$j + 1]) {
                // Troca os elementos
                $temp = $array[$j];
                $array[$j] = $array[$j + 1];
                $array[$j + 1] = $temp;
                $troca = true;
            }
        }

        // Se não houve trocas na passagem atual, o array está ordenado
        if (!$troca) {
            break;
        }
    }
}

$array = array(64, 34, 25, 12, 22, 11, 90);

bubbleSort($array);

echo "Array ordenado: ";
foreach ($array as $elemento) {
    echo $elemento . " ";
}

?>
