<?php
/*
♦ Algoritmo 15: Estrutura de Dados Linear Dinâmica (não Estática) de Pilha (regra de acesso LIFO) de tipo de dados genérico.
→ Operações:
    • isEmpty - verificar se a pilha está vazia;
    • push - inserir elementos no topo da pilha;
    • pop - remover elementos do dopo da pilha;
    • size - obter o tamanho atual da pilha;
    • front - acessar o elemento do topo da pilha sem removê-lo;
    • showStack - mostar elementos da pilha (do topo para base).
*/

class PilhaDinamica {
    private $pilha;

    public function __construct() {
        $this->pilha = [];
    }

    public function isEmpty() {
        return empty($this->pilha);
    }

    public function push($elemento) {
        array_unshift($this->pilha, $elemento);
    }

    public function pop() {
        if ($this->isEmpty()) {
            throw new Exception("A pilha está vazia");
        }
        array_shift($this->pilha);
    }

    public function size() {
        return count($this->pilha);
    }

    public function front() {
        if ($this->isEmpty()) {
            throw new Exception("A pilha está vazia");
        }
        return $this->pilha[0];
    }

    public function showStack() {
        echo implode(' ', $this->pilha) . PHP_EOL;
    }
}

$pilha = new PilhaDinamica();

$pilha->push(1);
$pilha->push(2);
$pilha->push(3);

$pilha->showStack();

echo "Tamanho da pilha: " . $pilha->size() . PHP_EOL;
echo "Topo da pilha: " . $pilha->front() . PHP_EOL;

$pilha->pop();
$pilha->showStack();

?>
