<?php
/*
♦ Algoritmo 29: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Bellman-Ford.
*/


// Classe para representar uma aresta em um grafo ponderado
class Aresta {
    public $origem, $destino, $peso;

    public function __construct($origem, $destino, $peso) {
        $this->origem = $origem;
        $this->destino = $destino;
        $this->peso = $peso;
    }
}

// Classe para representar um grafo ponderado usando matriz de adjacência
class Grafo {
    public $V, $E; // Número de vértices e arestas
    public $arestas;

    public function __construct($V, $E) {
        $this->V = $V;
        $this->E = $E;
        $this->arestas = array();
    }

    // Adiciona uma aresta ao grafo
    public function addAresta($origem, $destino, $peso) {
        $this->arestas[] = new Aresta($origem, $destino, $peso);
    }

    // Algoritmo de Bellman-Ford para encontrar o caminho mais curto
    public function BellmanFord($origem) {
        // Inicializa as distâncias de todos os vértices como infinito
        $distancia = array_fill(0, $this->V, PHP_FLOAT_MAX);
        $distancia[$origem] = 0;

        // Relaxamento das arestas
        for ($i = 1; $i < $this->V; ++$i) {
            foreach ($this->arestas as $aresta) {
                $u = $aresta->origem;
                $v = $aresta->destino;
                $peso = $aresta->peso;
                if ($distancia[$u] != PHP_FLOAT_MAX && $distancia[$u] + $peso < $distancia[$v]) {
                    $distancia[$v] = $distancia[$u] + $peso;
                }
            }
        }

        // Verifica ciclos de peso negativo
        foreach ($this->arestas as $aresta) {
            $u = $aresta->origem;
            $v = $aresta->destino;
            $peso = $aresta->peso;
            if ($distancia[$u] != PHP_FLOAT_MAX && $distancia[$u] + $peso < $distancia[$v]) {
                echo "O grafo contém um ciclo de peso negativo!\n";
                return;
            }
        }

        // Imprime as distâncias mais curtas
        for ($i = 0; $i < $this->V; ++$i) {
            echo "Distância do vértice $origem ao vértice $i é " . $distancia[$i] . "\n";
        }
    }
}

// Função principal
function main() {
    // Criando um grafo com 5 vértices e 8 arestas
    $grafo = new Grafo(5, 8);

    // Adicionando as arestas ao grafo
    $grafo->addAresta(0, 1, 6.0);
    $grafo->addAresta(0, 2, 7.0);
    $grafo->addAresta(1, 2, 8.0);
    $grafo->addAresta(1, 3, -4.0);
    $grafo->addAresta(1, 4, 5.0);
    $grafo->addAresta(2, 3, 9.0);
    $grafo->addAresta(2, 4, -3.0);
    $grafo->addAresta(3, 4, 7.0);

    // Executando o algoritmo de Bellman-Ford a partir do vértice 0
    $grafo->BellmanFord(0);
}

// Chamando a função principal
main();

?>
