<?php
/*
♦ Algoritmo 27: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
*/


class Grafo {
    private $adjacencias;

    public function __construct() {
        $this->adjacencias = [];
    }

    public function adicionarAresta($origem, $destino) {
        if (!array_key_exists($origem, $this->adjacencias)) {
            $this->adjacencias[$origem] = [];
        }
        if (!array_key_exists($destino, $this->adjacencias)) {
            $this->adjacencias[$destino] = [];
        }
        array_push($this->adjacencias[$origem], $destino);
        array_push($this->adjacencias[$destino], $origem); // Se o grafo é não direcionado, adicione a aresta em ambas as direções
    }

    public function DFS($inicio) {
        $visitados = [];
        $pilha = [];

        array_push($pilha, $inicio);

        while (!empty($pilha)) {
            $vertice = array_pop($pilha);

            if (!in_array($vertice, $visitados)) {
                echo $vertice . " ";
                array_push($visitados, $vertice);

                foreach ($this->adjacencias[$vertice] ?? [] as $adjacente) {
                    if (!in_array($adjacente, $visitados)) {
                        array_push($pilha, $adjacente);
                    }
                }
            }
        }
    }
}

$grafo = new Grafo();
$grafo->adicionarAresta(0, 1);
$grafo->adicionarAresta(0, 2);
$grafo->adicionarAresta(1, 2);
$grafo->adicionarAresta(2, 0);
$grafo->adicionarAresta(2, 3);
$grafo->adicionarAresta(3, 3);

echo "Busca em Profundidade (DFS) começando do vértice 2:\n";
$grafo->DFS(2);

?>
