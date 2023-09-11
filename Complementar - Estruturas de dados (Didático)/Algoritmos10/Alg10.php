<?php
/*
♦ Algoritmo 10: Estrutura de Dados Linear Estática (não Dinâmica) de Pesquisa/Busca Busca Sequencial com Sentinela.
*/

function buscaSequencialComSentinela($array, $valorProcurado) {
    $tamanhoArray = count($array);

    // Adiciona o valor procurado como sentinela na última posição do array
    $valorAnterior = $array[$tamanhoArray - 1];
    $array[$tamanhoArray - 1] = $valorProcurado;

    $i = 0;
    // Percorre o array até encontrar o valor procurado ou a sentinela
    while ($array[$i] != $valorProcurado) {
        $i++;
    }

    // Restaura o valor anterior da última posição do array
    $array[$tamanhoArray - 1] = $valorAnterior;

    if ($i < $tamanhoArray - 1 || $array[$tamanhoArray - 1] == $valorProcurado) {
        return $i; // Retorna o índice do valor procurado
    } else {
        return -1; // Retorna -1 se o valor não foi encontrado
    }
}

$array = array(10, 5, 2, 8, 3, 7, 1, 6, 9, 4);
$valorProcurado = 7;

$indiceEncontrado = buscaSequencialComSentinela($array, $valorProcurado);

if ($indiceEncontrado != -1) {
    echo "Valor " . $valorProcurado . " encontrado no índice: " . $indiceEncontrado;
} else {
    echo "Valor " . $valorProcurado . " não encontrado no array.";
}

?>
