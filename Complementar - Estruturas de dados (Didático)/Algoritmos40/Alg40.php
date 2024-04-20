<?php
/*
♦ Algoritmo 40: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Floyd-Warshall.
*/


class FloydWarshall {
    private $distancias;
    private $predecessores;

    public function __construct() {
        $this->distancias = [];
        $this->predecessores = [];
    }

    public function adicionarVertice($vertice) {
        if (!array_key_exists($vertice, $this->distancias)) {
            $this->distancias[$vertice] = [];
            $this->predecessores[$vertice] = [];
        }
    }

    public function adicionarAresta($origem, $destino, $peso) {
        $this->adicionarVertice($origem);
        $this->adicionarVertice($destino);

        $this->distancias[$origem][$destino] = $peso;
        $this->predecessores[$origem][$destino] = $origem;

        $this->distancias[$destino][$origem] = $peso;
        $this->predecessores[$destino][$origem] = $destino;
    }

    public function floydWarshall() {
        foreach ($this->distancias as $k => $value_k) {
            foreach ($this->distancias as $i => $value_i) {
                foreach ($this->distancias as $j => $value_j) {
                    if (isset($this->distancias[$i][$k]) && isset($this->distancias[$k][$j])) {
                        $novoPeso = $this->distancias[$i][$k] + $this->distancias[$k][$j];
                        if (!isset($this->distancias[$i][$j]) || $novoPeso < $this->distancias[$i][$j]) {
                            $this->distancias[$i][$j] = $novoPeso;
                            $this->predecessores[$i][$j] = $this->predecessores[$k][$j];
                        }
                    }
                }
            }
        }
    }

    public function obterDistancias() {
        return $this->distancias;
    }

    public function obterPredecessores() {
        return $this->predecessores;
    }
}

$floydWarshall = new FloydWarshall();

$floydWarshall->adicionarAresta('A', 'B', 10);
$floydWarshall->adicionarAresta('A', 'C', 15);
$floydWarshall->adicionarAresta('B', 'D', 12);
$floydWarshall->adicionarAresta('B', 'F', 15);
$floydWarshall->adicionarAresta('C', 'E', 10);
$floydWarshall->adicionarAresta('D', 'E', 2);
$floydWarshall->adicionarAresta('D', 'F', 1);
$floydWarshall->adicionarAresta('F', 'E', 5);

$floydWarshall->floydWarshall();

$distancias = $floydWarshall->obterDistancias();
$predecessores = $floydWarshall->obterPredecessores();

foreach ($distancias as $u => $value_u) {
    foreach ($value_u as $v => $peso) {
        echo "Distância de $u até $v: $peso\n";
    }
}

foreach ($predecessores as $u => $value_u) {
    foreach ($value_u as $v => $predecessor) {
        echo "Predecessor de $v no caminho de $u até $v: $predecessor\n";
    }
}

?>
