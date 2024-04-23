<?php
/*
♦ Algoritmo 28: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Dijkstra.
*/


// Classe para representar um vértice no grafo
class Vertice implements Comparable {
    public $indice;
    public $valor;

    public function __construct($indice, $valor) {
        $this->indice = $indice;
        $this->valor = $valor;
    }

    // Método para comparar vértices com base em seus valores
    public function compareTo($outro) {
        if ($this->valor instanceof Comparable) {
            return $this->valor->compareTo($outro->valor);
        } else {
            throw new Exception("Tipo de valor não suportado para comparação.");
        }
    }
}

// Classe para representar uma aresta no grafo ponderado
class Aresta {
    public $destino;
    public $peso;

    public function __construct($destino, $peso) {
        $this->destino = $destino;
        $this->peso = $peso;
    }
}

// Classe para representar um grafo ponderado usando lista de adjacência
class Grafo {
    public $adjacencia;

    public function __construct() {
        $this->adjacencia = array();
    }

    // Adiciona uma aresta ao grafo
    public function addAresta($origem, $destino, $peso) {
        if (!isset($this->adjacencia[$origem])) {
            $this->adjacencia[$origem] = array();
        }
        array_push($this->adjacencia[$origem], new Aresta($destino, $peso));
    }

    // Algoritmo de Dijkstra para encontrar os menores caminhos a partir de um vértice origem
    public function dijkstra($origem) {
        $distancia = array();
        $filaPrioridade = new SplPriorityQueue();

        // Inicialização das distâncias
        foreach (array_keys($this->adjacencia) as $v) {
            if ($v === $origem) {
                $distancia[$v] = 0.0;
            } else {
                $distancia[$v] = INF;
            }
            $filaPrioridade->insert($v, array($distancia[$v]));
        }

        while (!$filaPrioridade->isEmpty()) {
            $u = $filaPrioridade->extract();
            foreach ($this->adjacencia[$u] ?? [] as $aresta) {
                $v = $aresta->destino;
                $novaDistancia = $distancia[$u] + $aresta->peso;
                if ($novaDistancia < $distancia[$v]) {
                    $distancia[$v] = $novaDistancia;
                    unset($filaPrioridade[$v]);
                    $filaPrioridade->insert($v, array($distancia[$v]));
                }
            }
        }

        return $distancia;
    }
}

// Implementação de Comparable em PHP
interface Comparable {
    public function compareTo($outro);
}

// Implementação de PriorityQueue em PHP
class SplPriorityQueue extends SplHeap {
    public function compare($a, $b) {
        return $a[0] - $b[0];
    }
}

// Função principal
function main() {
    // Criando um grafo
    $grafo = new Grafo();

    // Criando vértices
    $A = new Vertice(0, "A");
    $B = new Vertice(1, "B");
    $C = new Vertice(2, "C");
    $D = new Vertice(3, "D");
    $E = new Vertice(4, "E");

    // Adicionando arestas ao grafo
    $grafo->addAresta($A, $B, 10);
    $grafo->addAresta($A, $C, 15);
    $grafo->addAresta($B, $D, 12);
    $grafo->addAresta($B, $E, 15);
    $grafo->addAresta($C, $D, 10);
    $grafo->addAresta($C, $E, 5);
    $grafo->addAresta($D, $E, 10);

    // Executando o algoritmo de Dijkstra a partir do vértice A
    $menoresCaminhos = $grafo->dijkstra($A);

    // Imprimindo os menores caminhos
    foreach ($menoresCaminhos as $v => $dist) {
        echo "Menor caminho de A para " . $v->valor . ": " . $dist . "\n";
    }
}

// Chamando a função principal
main();

?>
