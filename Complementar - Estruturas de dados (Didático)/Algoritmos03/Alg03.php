<?php

/* Estrutura de dados linear de uma pilha (de regra de acesso LIFO) estática genérica utilizando um array unidimensional (vetor)

Métodos:
 isEmpty - verificar se a pilha está vazia; 
 isFull - verificar se a pilha está cheia;
 push - inserir elementos no topo da pilha;
 pop - remover elementos do dopo da pilha;
 size - obter o tamanho atual da pilha;
 front - acessar o elemento do topo da pilha sem removê-lo;
 showStack - mostar elementos da pilha (do topo para base).
*/

class Alg03 {
    private $tamanhoMaximo;
    private $topo;
    private $elementos;

    public function __construct($tamanhoMaximo) {
        $this->tamanhoMaximo = $tamanhoMaximo;
        $this->topo = -1;
        $this->elementos = array_fill(0, $tamanhoMaximo, null);
    }

    public function isEmpty() {
        return $this->topo === -1;
    }

    public function isFull() {
        return $this->topo === $this->tamanhoMaximo - 1;
    }

    public function push($elemento) {
        if ($this->isFull()) {
            echo "A pilha está cheia. Não é possível empilhar o elemento.\n";
            return;
        }
        $this->topo++;
        $this->elementos[$this->topo] = $elemento;
    }

    public function pop() {
        if ($this->isEmpty()) {
            echo "A pilha está vazia. Não é possível desempilhar um elemento.\n";
            return null;
        }
        $elemento = $this->elementos[$this->topo];
        $this->topo--;
        return $elemento;
    }

    public function front() {
        if ($this->isEmpty()) {
            echo "A pilha está vazia. Não há elemento no topo.\n";
            return null;
        }
        return $this->elementos[$this->topo];
    }

    public function size() {
        return $this->topo + 1;
    }

    public function showStack() {
        if ($this->isEmpty()) {
            echo "A pilha está vazia.\n";
            return;
        }
        echo "Elementos da pilha (do topo para base):\n";
        for ($i = $this->topo; $i >= 0; $i--) {
            echo $this->elementos[$i] . "\n";
        }
    }
}

$pilha = new Alg03(5);

$pilha->push(10);
$pilha->push(20);
$pilha->push(30);

echo "Tamanho da pilha: " . $pilha->size() . "\n";
echo "Elemento no topo: " . $pilha->front() . "\n";

$pilha->pop();

echo "Tamanho da pilha: " . $pilha->size() . "\n";
echo "Elemento no topo: " . $pilha->front() . "\n";

$pilha->showStack();

?>