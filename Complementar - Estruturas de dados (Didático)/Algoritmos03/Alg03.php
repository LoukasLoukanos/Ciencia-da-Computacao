<?php
/*
♦ Estrutura de Dados Linear Estática (não Dinâmica) de Pilha (regra de acesso LIFO) de tipo de dados genérico: Algoritmo 03.
→ Operações:
    • isEmpty - verificar se a pilha está vazia;
    • isFull - verificar se a pilha está cheia;
    • push - inserir elementos no topo da pilha;
    • pop - remover elementos do dopo da pilha;
    • size - obter o tamanho atual da pilha;
    • front - acessar o elemento do topo da pilha sem removê-lo;
    • showStack - mostar elementos da pilha (do topo para base).
*/

class Pilha {
    private $capacidade;
    private $elementos;
    private $topo;

    public function __construct($capacidade) {
        $this->capacidade = $capacidade;
        $this->elementos = array_fill(0, $capacidade, null);
        $this->topo = -1;
    }

    // Verificar se a pilha está vazia
    public function isEmpty() {
        return $this->topo == -1;
    }

    // Verificar se a pilha está cheia
    public function isFull() {
        return $this->topo == $this->capacidade - 1;
    }

    // Inserir elementos no topo da pilha
    public function push($elemento) {
        if ($this->isFull()) {
            throw new Exception("A pilha está cheia");
        }

        $this->topo++;
        $this->elementos[$this->topo] = $elemento;
    }

    // Remover elementos do topo da pilha
    public function pop() {
        if ($this->isEmpty()) {
            throw new Exception("A pilha está vazia");
        }

        $elementoRemovido = $this->elementos[$this->topo];
        $this->elementos[$this->topo] = null;
        $this->topo--;

        return $elementoRemovido;
    }

    // Obter o tamanho atual da pilha
    public function size() {
        return $this->topo + 1;
    }

    // Acessar o elemento do topo da pilha sem removê-lo
    public function front() {
        if ($this->isEmpty()) {
            throw new Exception("A pilha está vazia");
        }

        return $this->elementos[$this->topo];
    }

    // Mostrar elementos da pilha (do topo para base)
    public function showStack() {
        for ($i = $this->topo; $i >= 0; $i--) {
            echo $this->elementos[$i] . " ";
        }
        echo PHP_EOL;
    }
}

$pilha = new Pilha(5);
$pilha->push(1);
$pilha->push(2);
$pilha->push(3);

$pilha->showStack();

echo "Topo da pilha: " . $pilha->front() . PHP_EOL;
echo "Tamanho da pilha: " . $pilha->size() . PHP_EOL;

$pilha->pop();
$pilha->showStack();

?>