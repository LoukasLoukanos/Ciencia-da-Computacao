<?php
/*
♦ Algoritmo 36: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Largura (Breadth-First Search - BFS).
*/


class Grafo {
    private $V; // Número de vértices
    private $adj; // Lista de adjacência

    // Construtor
    public function __construct($v) {
        $this->V = $v;
        $this->adj = array_fill(0, $v, new SplDoublyLinkedList());
        for ($i = 0; $i < $v; ++$i)
            $this->adj[$i] = new SplDoublyLinkedList();
    }

    // Adiciona uma aresta ao grafo
    public function adicionarAresta($v, $w) {
        $this->adj[$v]->push($w);
    }

    // Executa a busca em largura a partir de um vértice inicial
    public function BFS($s) {
        // Marca todos os vértices como não visitados
        $visitados = array_fill(0, $this->V, false);

        // Cria uma fila para o BFS
        $fila = new SplQueue();

        // Marca o vértice atual como visitado e o adiciona à fila
        $visitados[$s] = true;
        $fila->enqueue($s);

        while (!$fila->isEmpty()) {
            // Remove um vértice da fila e imprime
            $s = $fila->dequeue();
            echo $s . " ";

            // Obtém todos os vértices adjacentes do vértice removido da fila
            $it = $this->adj[$s]->getIterator();
            while ($it->valid()) {
                $n = $it->current();
                // Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
                if (!$visitados[$n]) {
                    $visitados[$n] = true;
                    $fila->enqueue($n);
                }
                $it->next();
            }
        }
    }
}

$g = new Grafo(4);

$g->adicionarAresta(0, 1);
$g->adicionarAresta(0, 2);
$g->adicionarAresta(1, 2);
$g->adicionarAresta(2, 0);
$g->adicionarAresta(2, 3);
$g->adicionarAresta(3, 3);

echo "Busca em Largura (BFS) a partir do vértice 2:\n";
$g->BFS(2);

?>
