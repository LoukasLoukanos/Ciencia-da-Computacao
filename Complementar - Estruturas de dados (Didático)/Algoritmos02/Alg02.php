<?php
/*
♦ Estrutura de Dados Linear Estática de Fila Circular e Não-Circular (regra de acesso FIFO) de tipo de dados genérico: Algoritmo 02.
→ Operações:
    • isEmpty - verificar se a fila está vazia;
    • isFull - verificar se a fila está cheia;
    • enqueue - adicionar elementos;
    • dequeue - remover o elemento da frente da fila;
    • size - obter o tamanho atual da fila;
    • front - acessar o elemento da frente da fila sem removê-lo;
    • showQueue - mostar elementos da fila.

obs: Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços 
    livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.

obs: Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços 
    livres, caso haja, no início da fila.
*/

class FilaCircular {
    private $capacidade;
    private $elementos;
    private $tamanho;
    private $frente;
    private $traseira;

    public function __construct($capacidade) {
        $this->capacidade = $capacidade;
        $this->elementos = array_fill(0, $capacidade, null);
        $this->tamanho = 0;
        $this->frente = 0;
        $this->traseira = -1;
    }

    // Verificar se a fila está vazia
    public function isEmpty() {
        return $this->tamanho == 0;
    }

    // Verificar se a fila está cheia
    public function isFull() {
        return $this->tamanho == $this->capacidade;
    }

    // Adicionar elementos à fila (enqueue)
    public function enqueue($elemento) {
        if ($this->isFull()) {
            throw new Exception("A fila está cheia");
        }

        $this->traseira = ($this->traseira + 1) % $this->capacidade;
        $this->elementos[$this->traseira] = $elemento;
        $this->tamanho++;
    }

    // Remover o elemento da frente da fila (dequeue)
    public function dequeue() {
        if ($this->isEmpty()) {
            throw new Exception("A fila está vazia");
        }

        $elementoRemovido = $this->elementos[$this->frente];
        $this->elementos[$this->frente] = null;
        $this->frente = ($this->frente + 1) % $this->capacidade;
        $this->tamanho--;

        return $elementoRemovido;
    }

    // Obter o tamanho atual da fila
    public function size() {
        return $this->tamanho;
    }

    // Acessar o elemento da frente da fila sem removê-lo
    public function front() {
        if ($this->isEmpty()) {
            throw new Exception("A fila está vazia");
        }

        return $this->elementos[$this->frente];
    }

    // Mostrar elementos da fila
    public function showQueue() {
        $index = $this->frente;
        for ($i = 0; $i < $this->tamanho; $i++) {
            echo $this->elementos[$index] . " ";
            $index = ($index + 1) % $this->capacidade;
        }
        echo "\n";
    }
}

// Exemplo de uso
$fila = new FilaCircular(5);
$fila->enqueue(1);
$fila->enqueue(2);
$fila->enqueue(3);

$fila->showQueue();

echo "Frente da fila: " . $fila->front() . "\n";
echo "Tamanho da fila: " . $fila->size() . "\n";

$fila->dequeue();
$fila->showQueue();

?>
