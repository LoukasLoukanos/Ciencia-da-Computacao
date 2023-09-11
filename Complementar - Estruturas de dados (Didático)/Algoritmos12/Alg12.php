<?php
/*
♦ Algoritmo 12: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada) de tipo de dados genérico.
→ Operações:
    • addList: inserção em uma Lista Ligada Simples;
    • removeList: remoção em uma Lista Ligada Simples;
    • size - obter o tamanho atual da Lista Ligada Simples;
    • showList: exibição dos elementos da Lista Ligada Simples.
*/

class Nodo {
    public $valor;
    public $proximo;

    public function __construct($valor) {
        $this->valor = $valor;
        $this->proximo = null;
    }
}

class ListaLigada {
    private $primeiro;
    private $tamanho;

    public function __construct() {
        $this->primeiro = null;
        $this->tamanho = 0;
    }

    public function addList($valor) {
        $novoNodo = new Nodo($valor);
        $novoNodo->proximo = $this->primeiro;
        $this->primeiro = $novoNodo;
        $this->tamanho++;
    }

    public function removeList($valor) {
        if ($this->primeiro === null) {
            return;
        }

        if ($this->primeiro->valor == $valor) {
            $this->primeiro = $this->primeiro->proximo;
            $this->tamanho--;
            return;
        }

        $nodoAtual = $this->primeiro;
        while ($nodoAtual->proximo !== null) {
            if ($nodoAtual->proximo->valor == $valor) {
                $nodoAtual->proximo = $nodoAtual->proximo->proximo;
                $this->tamanho--;
                return;
            }
            $nodoAtual = $nodoAtual->proximo;
        }
    }

    public function size() {
        return $this->tamanho;
    }

    public function showList() {
        $nodoAtual = $this->primeiro;
        while ($nodoAtual !== null) {
            echo $nodoAtual->valor . " ";
            $nodoAtual = $nodoAtual->proximo;
        }
        echo "\n";
    }
}

$lista = new ListaLigada();
$lista->addList(10);
$lista->addList(20);
$lista->addList(30);

echo "Tamanho da lista: " . $lista->size() . "\n";
echo "Elementos da lista: ";
$lista->showList();

$lista->removeList(20);

echo "Tamanho da lista após remoção: " . $lista->size() . "\n";
echo "Elementos da lista após remoção: ";
$lista->showList();
