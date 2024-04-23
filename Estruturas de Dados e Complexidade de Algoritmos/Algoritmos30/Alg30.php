<?php
/*
♦ Algoritmo 30: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Kruskal.
*/


// Classe para representar uma aresta em um grafo ponderado
class Aresta implements Comparable {
    public $origem, $destino, $peso;

    public function __construct($origem, $destino, $peso) {
        $this->origem = $origem;
        $this->destino = $destino;
        $this->peso = $peso;
    }

    // Método para comparar arestas com base em seus pesos
    public function compareTo($outra) {
        if ($this->peso instanceof Comparable) {
            return $this->peso->compareTo($outra->peso);
        } else {
            throw new Exception("Tipo de peso não suportado para comparação.");
        }
    }
}

// Classe para representar um grafo ponderado usando lista de adjacência
class Grafo {
    public $V; // Número de vértices
    public $arestas;

    public function __construct($V) {
        $this->V = $V;
        $this->arestas = [];
    }

    // Adiciona uma aresta ao grafo
    public function addAresta($origem, $destino, $peso) {
        $this->arestas[] = new Aresta($origem, $destino, $peso);
    }

    // Algoritmo de Kruskal para encontrar a árvore geradora mínima
    public function kruskal() {
        // Ordena as arestas por peso
        usort($this->arestas, function($a, $b) {
            return $a->peso - $b->peso;
        });

        $arvoreGeradoraMinima = [];
        $uf = new UnionFind($this->V);

        foreach ($this->arestas as $aresta) {
            if (!$uf->connected($aresta->origem, $aresta->destino)) {
                $arvoreGeradoraMinima[] = $aresta;
                $uf->union($aresta->origem, $aresta->destino);
            }
        }

        return $arvoreGeradoraMinima;
    }
}

// Classe Union-Find para representar uma estrutura de dados para detecção de ciclos
class UnionFind {
    private $parent;
    private $rank;

    public function __construct($n) {
        $this->parent = range(0, $n - 1);
        $this->rank = array_fill(0, $n, 0);
    }

    // Encontra o representante (raiz) do conjunto ao qual o elemento pertence
    private function find($x) {
        if ($x != $this->parent[$x]) {
            $this->parent[$x] = $this->find($this->parent[$x]);
        }
        return $this->parent[$x];
    }

    // Une os conjuntos que contêm os elementos x e y
    public function union($x, $y) {
        $raizX = $this->find($x);
        $raizY = $this->find($y);
        if ($raizX == $raizY) return;
        if ($this->rank[$raizX] < $this->rank[$raizY]) {
            $this->parent[$raizX] = $raizY;
        } elseif ($this->rank[$raizX] > $this->rank[$raizY]) {
            $this->parent[$raizY] = $raizX;
        } else {
            $this->parent[$raizY] = $raizX;
            $this->rank[$raizX]++;
        }
    }

    // Verifica se dois elementos estão no mesmo conjunto
    public function connected($x, $y) {
        return $this->find($x) == $this->find($y);
    }
}

// Função principal
function main() {
    // Criando um grafo com 4 vértices
    $grafo = new Grafo(4);

    // Adicionando as arestas ao grafo com seus pesos
    $grafo->addAresta(0, 1, 10);
    $grafo->addAresta(0, 2, 6);
    $grafo->addAresta(0, 3, 5);
    $grafo->addAresta(1, 3, 15);
    $grafo->addAresta(2, 3, 4);

    // Executando o algoritmo de Kruskal
    $arvoreGeradoraMinima = $grafo->kruskal();

    // Imprimindo a árvore geradora mínima
    foreach ($arvoreGeradoraMinima as $aresta) {
        echo "Aresta: {$aresta->origem} - {$aresta->destino}, Peso: {$aresta->peso}\n";
    }
}

// Chamando a função principal
main();

?>
