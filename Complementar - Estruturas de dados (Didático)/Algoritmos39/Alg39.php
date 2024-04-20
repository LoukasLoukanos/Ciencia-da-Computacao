<?php
/*
♦ Algoritmo 39: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Bellman-Ford.
*/


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
        $this->arestas = [];
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
        $this->nos = [];
    }

    public function adicionarNo($valor) {
        if (!array_key_exists($valor, $this->nos)) {
            $this->nos[$valor] = new No($valor);
        }
    }

    public function adicionarAresta($origem, $destino, $peso) {
        $this->adicionarNo($origem);
        $this->adicionarNo($destino);
        $this->nos[$origem]->adicionarAresta($this->nos[$destino], $peso);
    }

    public function bellmanFord($origem) {
        $distancias = [];
        foreach ($this->nos as $valor => $no) {
            $distancias[$valor] = PHP_INT_MAX;
        }
        $distancias[$origem] = 0;

        // Relaxamento de arestas repetido |V| - 1 vezes
        for ($i = 0; $i < count($this->nos) - 1; $i++) {
            foreach ($this->nos as $no) {
                foreach ($no->getArestas() as $aresta) {
                    $u = $no->getValor();
                    $v = $aresta->getDestino()->getValor();
                    $peso = $aresta->getPeso();
                    if ($distancias[$u] != PHP_INT_MAX && $distancias[$u] + $peso < $distancias[$v]) {
                        $distancias[$v] = $distancias[$u] + $peso;
                    }
                }
            }
        }

        // Detecção de ciclos negativos
        for ($i = 0; $i < count($this->nos) - 1; $i++) {
            foreach ($this->nos as $no) {
                foreach ($no->getArestas() as $aresta) {
                    $u = $no->getValor();
                    $v = $aresta->getDestino()->getValor();
                    $peso = $aresta->getPeso();
                    if ($distancias[$u] != PHP_INT_MAX && $distancias[$u] + $peso < $distancias[$v]) {
                        throw new RuntimeException("Ciclo negativo detectado");
                    }
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

try {
    $distancias = $grafo->bellmanFord('A');
    foreach ($distancias as $vertice => $distancia) {
        echo "Distância de A até $vertice: $distancia\n";
    }
} catch (RuntimeException $e) {
    echo $e->getMessage() . "\n";
}

?>
