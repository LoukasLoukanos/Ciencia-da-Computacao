<?php
/*
♦ Algoritmo 31: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Prim.
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
        if (!isset($this->adjacencia[$destino])) {
            $this->adjacencia[$destino] = array();
        }
        array_push($this->adjacencia[$origem], new Aresta($destino, $peso));
        array_push($this->adjacencia[$destino], new Aresta($origem, $peso)); // Para grafos não direcionados
    }

    // Algoritmo de Prim para encontrar a árvore geradora mínima
    public function prim($origem) {
        $visitados = array();
        $arvoreGeradoraMinima = array();
        $filaPrioridade = new SplPriorityQueue();

        $visitados[$origem->indice] = true;
        $this->adicionarArestasAdjacentes($origem, $filaPrioridade, $visitados);

        while (!$filaPrioridade->isEmpty()) {
            $aresta = $filaPrioridade->extract();
            $destino = $aresta->destino;

            if (!isset($visitados[$destino->indice])) {
                $visitados[$destino->indice] = true;
                array_push($arvoreGeradoraMinima, $aresta);
                $this->adicionarArestasAdjacentes($destino, $filaPrioridade, $visitados);
            }
        }

        return $arvoreGeradoraMinima;
    }

    private function adicionarArestasAdjacentes($vertice, $filaPrioridade, &$visitados) {
        foreach ($this->adjacencia[$vertice] as $aresta) {
            if (!isset($visitados[$aresta->destino->indice])) {
                $filaPrioridade->insert($aresta, $aresta->peso);
            }
        }
    }
}

// Classe principal
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
    $grafo->addAresta($A, $B, 4);
    $grafo->addAresta($A, $C, 1);
    $grafo->addAresta($B, $C, 2);
    $grafo->addAresta($B, $D, 5);
    $grafo->addAresta($C, $D, 8);
    $grafo->addAresta($C, $E, 10);
    $grafo->addAresta($D, $E, 2);

    // Executando o algoritmo de Prim a partir do vértice A
    $arvoreGeradoraMinima = $grafo->prim($A);

    // Imprimindo a árvore geradora mínima
    foreach ($arvoreGeradoraMinima as $aresta) {
        echo "Aresta: " . $aresta->destino->valor . ", Peso: " . $aresta->peso . "\n";
    }
}

// Executando a função principal
main();
?>
