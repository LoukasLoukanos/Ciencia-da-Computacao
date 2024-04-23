<?php
/*
♦ Algoritmo 38: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Dijkstra.
*/


<?php
class Aresta {
    private $destino;
    private $peso;

    public function __construct($destino, $peso) {
        $this->destino = $destino;
        $this->peso = $peso;
    }

    public function getDestino() {
        return $this->destino;
    }

    public function getPeso() {
        return $this->peso;
    }
}

class No {
    private $valor;
    private $arestas;

    public function __construct($valor) {
        $this->valor = $valor;
        $this->arestas = array();
    }

    public function getValor() {
        return $this->valor;
    }

    public function getArestas() {
        return $this->arestas;
    }

    public function adicionarAresta($destino, $peso) {
        $this->arestas[] = new Aresta($destino, $peso);
    }
}

class Grafo {
    private $nos;

    public function __construct() {
        $this->nos = array();
    }

    public function adicionarNo($valor) {
        if (!isset($this->nos[$valor])) {
            $this->nos[$valor] = new No($valor);
        }
    }

    public function adicionarAresta($origem, $destino, $peso) {
        $this->adicionarNo($origem);
        $this->adicionarNo($destino);
        $this->nos[$origem]->adicionarAresta($this->nos[$destino], $peso);
    }

    public function dijkstra($origem) {
        $distancias = array();
        $filaPrioridade = array();

        foreach (array_keys($this->nos) as $valor) {
            $distancias[$valor] = PHP_INT_MAX;
        }

        $distancias[$origem] = 0;
        $filaPrioridade[] = array('no' => $this->nos[$origem], 'distancia' => 0);

        while (!empty($filaPrioridade)) {
            usort($filaPrioridade, function ($a, $b) use ($distancias) {
                return $distancias[$a['no']->getValor()] - $distancias[$b['no']->getValor()];
            });

            $noAtual = array_shift($filaPrioridade);
            $noAtualValor = $noAtual['no']->getValor();
            $distanciaAtual = $distancias[$noAtualValor];

            foreach ($noAtual['no']->getArestas() as $aresta) {
                $vizinho = $aresta->getDestino();
                $novaDistancia = $distanciaAtual + $aresta->getPeso();

                if ($novaDistancia < $distancias[$vizinho->getValor()]) {
                    $distancias[$vizinho->getValor()] = $novaDistancia;
                    $filaPrioridade[] = array('no' => $vizinho, 'distancia' => $novaDistancia);
                }
            }
        }

        return $distancias;
    }
}

$grafo = new Grafo();

$grafo->adicionarAresta('A', 'B', 10);
$grafo->adicionarAresta('A', 'C', 15);
$grafo->adicionarAresta('B', 'D', 12);
$grafo->adicionarAresta('B', 'F', 15);
$grafo->adicionarAresta('C', 'E', 10);
$grafo->adicionarAresta('D', 'E', 2);
$grafo->adicionarAresta('D', 'F', 1);
$grafo->adicionarAresta('F', 'E', 5);

$distancias = $grafo->dijkstra('A');
foreach ($distancias as $vertice => $distancia) {
    echo "Distância de A até $vertice: $distancia\n";
}
?>
