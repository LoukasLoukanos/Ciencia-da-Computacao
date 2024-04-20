<?php
/*
♦ Algoritmo 37: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
*/


// Classe para representar um nó do grafo genérico
class No {
    public $valor;
    public $vizinhos;

    public function __construct($valor) {
        $this->valor = $valor;
        $this->vizinhos = array();
    }

    public function adicionarVizinho($vizinho) {
        array_push($this->vizinhos, $vizinho);
    }
}

// Classe para representar o Grafo Genérico
class Grafo {
    private $nos;

    public function __construct() {
        $this->nos = array();
    }

    public function adicionarNo($valor) {
        if (!array_key_exists($valor, $this->nos)) {
            $this->nos[$valor] = new No($valor);
        }
    }

    public function adicionarAresta($origem, $destino) {
        if (!array_key_exists($origem, $this->nos)) {
            $this->adicionarNo($origem);
        }
        if (!array_key_exists($destino, $this->nos)) {
            $this->adicionarNo($destino);
        }
        array_push($this->nos[$origem]->vizinhos, $this->nos[$destino]);
    }

    // Método de busca em profundidade (DFS)
    public function DFS($inicio) {
        $visitados = array();
        $this->DFSRecursivo($this->nos[$inicio], $visitados);
    }

    private function DFSRecursivo($no, &$visitados) {
        array_push($visitados, $no->valor);
        echo $no->valor . " ";

        foreach ($no->vizinhos as $vizinho) {
            if (!in_array($vizinho->valor, $visitados)) {
                $this->DFSRecursivo($vizinho, $visitados);
            }
        }
    }
}

// Função principal para teste
function main() {
    $grafo = new Grafo();

    $grafo->adicionarAresta(0, 1);
    $grafo->adicionarAresta(0, 2);
    $grafo->adicionarAresta(1, 2);
    $grafo->adicionarAresta(2, 0);
    $grafo->adicionarAresta(2, 3);
    $grafo->adicionarAresta(3, 3);

    echo "Busca em Profundidade (DFS) a partir do vértice 2:\n";
    $grafo->DFS(2);
}

main();
?>
