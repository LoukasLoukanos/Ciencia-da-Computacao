<?php
/*
♦ Algoritmo 26: Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo - Busca em Largura (Breadth-First Search - BFS).
*/


// Classe para representar um grafo não direcionado usando listas de adjacência
class Grafo {
    private $adjacencias;

    // Construtor
    public function __construct() {
        $this->adjacencias = [];
    }

    // Método para adicionar uma aresta ao grafo
    public function adicionarAresta($origem, $destino) {
        $this->adjacencias[$origem][] = $destino;
        $this->adjacencias[$destino][] = $origem; // Se o grafo é não direcionado, adicione a aresta em ambas as direções
    }

    // Algoritmo de busca em largura a partir de um vértice "inicio"
    public function BFS($inicio) {
        // Conjunto para marcar vértices visitados
        $visitados = [];

        // Fila para a BFS
        $fila = [];

        // Marca o vértice inicial como visitado e o adiciona à fila
        $visitados[$inicio] = true;
        array_push($fila, $inicio);

        while (!empty($fila)) {
            // Remove um vértice da fila e imprime
            $vertice = array_shift($fila);
            echo $vertice . " ";

            // Obtém todos os vértices adjacentes ao vértice desenfileirado
            // Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
            foreach ($this->adjacencias[$vertice] ?? [] as $adjacente) {
                if (!isset($visitados[$adjacente])) {
                    $visitados[$adjacente] = true;
                    array_push($fila, $adjacente);
                }
            }
        }
    }
}

// Criação do grafo de exemplo
$grafo = new Grafo();
$grafo->adicionarAresta(0, 1);
$grafo->adicionarAresta(0, 2);
$grafo->adicionarAresta(1, 2);
$grafo->adicionarAresta(2, 0);
$grafo->adicionarAresta(2, 3);
$grafo->adicionarAresta(3, 3);

// Executa a busca em largura a partir do vértice 2
echo "Busca em Largura (BFS) começando do vértice 2:\n";
$grafo->BFS(2);

?>
