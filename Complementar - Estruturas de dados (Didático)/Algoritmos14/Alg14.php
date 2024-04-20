<?php
/*
♦ Algoritmo 14: Estrutura de Dados Linear Dinâmica (não Estática) de Fila: Queue (Fila).
*/

class FilaDinamica {
    private $fila = [];

    public function isEmpty() {
        return empty($this->fila);
    }

    public function enqueue($elemento) {
        array_push($this->fila, $elemento);
    }

    public function dequeue() {
        if ($this->isEmpty()) {
            throw new Exception("A fila está vazia");
        }
        array_shift($this->fila);
    }

    public function size() {
        return count($this->fila);
    }

    public function front() {
        if ($this->isEmpty()) {
            throw new Exception("A fila está vazia");
        }
        return reset($this->fila);
    }

    public function showQueue() {
        echo implode(' ', $this->fila) . "\n";
    }
}

$fila = new FilaDinamica();

$fila->enqueue(1);
$fila->enqueue(2);
$fila->enqueue(3);

$fila->showQueue();

echo "Tamanho da fila: " . $fila->size() . "\n";
echo "Frente da fila: " . $fila->front() . "\n";

$fila->dequeue();
$fila->showQueue();

?>
