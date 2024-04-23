<?php
/*
♦ Algoritmo 13: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada: Doubly Linked List (Lista Duplamente Ligada).
*/

class Nodo {
    public $valor;
    public $anterior;
    public $proximo;

    public function __construct($valor) {
        $this->valor = $valor;
        $this->anterior = null;
        $this->proximo = null;
    }
}

class ListaDuplamenteLigada {
    private $primeiro;
    private $ultimo;
    private $tamanho;

    public function __construct() {
        $this->primeiro = null;
        $this->ultimo = null;
        $this->tamanho = 0;
    }

    public function addList($valor) {
        $novoNodo = new Nodo($valor);
        if ($this->primeiro === null) {
            $this->primeiro = $novoNodo;
            $this->ultimo = $novoNodo;
        } else {
            $novoNodo->anterior = $this->ultimo;
            $this->ultimo->proximo = $novoNodo;
            $this->ultimo = $novoNodo;
        }
        $this->tamanho++;
    }

    public function removeList($valor) {
        $nodoAtual = $this->primeiro;
        while ($nodoAtual !== null) {
            if ($nodoAtual->valor === $valor) {
                if ($nodoAtual === $this->primeiro) {
                    $this->primeiro = $nodoAtual->proximo;
                    if ($this->primeiro !== null) {
                        $this->primeiro->anterior = null;
                    }
                } else if ($nodoAtual === $this->ultimo) {
                    $this->ultimo = $nodoAtual->anterior;
                    if ($this->ultimo !== null) {
                        $this->ultimo->proximo = null;
                    }
                } else {
                    $anterior = $nodoAtual->anterior;
                    $proximo = $nodoAtual->proximo;
                    $anterior->proximo = $proximo;
                    $proximo->anterior = $anterior;
                }
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
        echo PHP_EOL;
    }
}

$lista = new ListaDuplamenteLigada();
$lista->addList(10);
$lista->addList(20);
$lista->addList(30);

echo "Tamanho da lista: " . $lista->size() . PHP_EOL;
echo "Elementos da lista: ";
$lista->showList();

$lista->removeList(20);

echo "Tamanho da lista após remoção: " . $lista->size() . PHP_EOL;
echo "Elementos da lista após remoção: ";
$lista->showList();

?>
