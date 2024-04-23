<?php
/*
♦ Algoritmo 32: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Floyd-Warshall.
*/


// Classe para representar o grafo
class Grafo {
    private $adjacencia;

    // Construtor
    public function __construct() {
        $this->adjacencia = array();
    }

    // Adiciona uma aresta ao grafo
    public function addAresta($origem, $destino, $peso) {
        if (!isset($this->adjacencia[$origem])) {
            $this->adjacencia[$origem] = array();
        }
        $this->adjacencia[$origem][$destino] = $peso;
    }

    // Algoritmo de Floyd-Warshall para encontrar os menores caminhos entre todos os pares de vértices
    public function floydWarshall() {
        $distancias = $this->adjacencia;

        // Inicializa a diagonal com 0 e as outras posições com infinito
        foreach ($this->adjacencia as $vertice1 => $adjacentes) {
            foreach ($this->adjacencia as $vertice2 => $adjacentes) {
                if ($vertice1 !== $vertice2 && !isset($distancias[$vertice1][$vertice2])) {
                    $distancias[$vertice1][$vertice2] = INF;
                }
            }
        }

        // Algoritmo de Floyd-Warshall
        foreach ($this->adjacencia as $k => $adjacentesK) {
            foreach ($this->adjacencia as $i => $adjacentesI) {
                foreach ($this->adjacencia as $j => $adjacentesJ) {
                    $distanciaIJ = $distancias[$i][$j];
                    $distanciaIK = isset($distancias[$i][$k]) ? $distancias[$i][$k] : INF;
                    $distanciaKJ = isset($distancias[$k][$j]) ? $distancias[$k][$j] : INF;

                    if ($distanciaIK + $distanciaKJ < $distanciaIJ) {
                        $distancias[$i][$j] = $distanciaIK + $distanciaKJ;
                    }
                }
            }
        }

        return $distancias;
    }
}

// Função principal
function main() {
    // Criando um grafo
    $grafo = new Grafo();

    // Adicionando arestas ao grafo
    $grafo->addAresta("A", "B", 3);
    $grafo->addAresta("A", "C", 6);
    $grafo->addAresta("B", "C", 2);
    $grafo->addAresta("B", "D", 1);
    $grafo->addAresta("C", "B", 4);
    $grafo->addAresta("C", "D", 5);
    $grafo->addAresta("D", "A", 3);

    // Executando o algoritmo de Floyd-Warshall
    $distancias = $grafo->floydWarshall();

    // Imprimindo as distâncias mínimas entre todos os pares de vértices
    foreach ($distancias as $vertice1 => $distanciasVertice1) {
        foreach ($distanciasVertice1 as $vertice2 => $distancia) {
            echo "Distância de $vertice1 para $vertice2: $distancia\n";
        }
    }
}

// Chamando a função principal
main();

?>
