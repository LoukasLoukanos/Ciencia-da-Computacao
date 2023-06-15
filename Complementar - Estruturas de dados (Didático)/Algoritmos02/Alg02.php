<?php

class Alg02 {
    private $elementos;
    private $tamanho;
    private $capacidade;
    private $inicio;
    private $fim;

    public function __construct($capacidade) {
        $this->capacidade = $capacidade;
        $this->elementos = array_fill(0, $capacidade, null);
        $this->tamanho = 0;
        $this->inicio = 0;
        $this->fim = -1;
    }

    public function isEmpty() {
        return $this->tamanho == 0;
    }

    public function isFull() {
        return $this->tamanho == $this->capacidade;
    }

    public function enqueue($elemento) {
        if ($this->isFull()) {
            echo "A fila está cheia. Não é possível adicionar mais elementos.\n";
            return;
        }

        $this->fim = ($this->fim + 1) % $this->capacidade;
        $this->elementos[$this->fim] = $elemento;
        $this->tamanho++;
    }

    public function dequeue() {
        if ($this->isEmpty()) {
            echo "A fila está vazia. Não é possível remover elementos.\n";
            return null;
        }

        $elementoRemovido = $this->elementos[$this->inicio];
        $this->elementos[$this->inicio] = null;
        $this->inicio = ($this->inicio + 1) % $this->capacidade;
        $this->tamanho--;
        return $elementoRemovido;
    }

    public function front() {
        if ($this->isEmpty()) {
            echo "A fila está vazia. Não há elementos para retornar.\n";
            return null;
        }

        return $this->elementos[$this->inicio];
    }

    public function size() {
        return $this->tamanho;
    }

    public function showQueue() {
        if ($this->isEmpty()) {
            echo "A fila está vazia.\n";
            return;
        }
        echo "Elementos da fila:\n";
        for ($i = 0; $i < $this->tamanho; $i++) {
            echo $this->elementos[$i] . "\n";
        }
    }
}

$fila = new Alg02(5);
$fila->enqueue(10);
$fila->enqueue(20);
$fila->enqueue(30);
echo "Tamanho da fila: " . $fila->size() . "\n";
echo "Elemento na frente da fila: " . $fila->front() . "\n";
echo "Removendo elemento da fila: " . $fila->dequeue() . "\n";
echo "Tamanho da fila após remoção: " . $fila->size() . "\n";

$fila->showQueue();

?>
