<?php
/* Algoritmo da Estrutura de dados linear dinâmica (não estática) ListaDuplamenteLigada 
de Lista Duplamente Ligada, também conhecida como Lista Duplamente Encadeada */

class ListaDuplamenteLigada {
    private $cabeca;
    private $cauda;
    private $tamanho;

    private class Nodo {
        public $dado;
        public $proximo;
        public $anterior;

        public function __construct($dado) {
            $this->dado = $dado;
            $this->proximo = null;
            $this->anterior = null;
        }
    }

    public function __construct() {
        $this->cabeca = null;
        $this->cauda = null;
        $this->tamanho = 0;
    }

    // Inserir um elemento no final da lista
    public function addList($dado) {
        $novoNodo = new Nodo($dado);
        if ($this->cabeca === null) {
            $this->cabeca = $novoNodo;
            $this->cauda = $novoNodo;
        } else {
            $novoNodo->anterior = $this->cauda;
            $this->cauda->proximo = $novoNodo;
            $this->cauda = $novoNodo;
        }
        $this->tamanho++;
    }

    // Remover um elemento da lista
    public function removeList($dado) {
        $atual = $this->cabeca;
        while ($atual !== null) {
            if ($atual->dado === $dado) {
                if ($atual === $this->cabeca) {
                    $this->cabeca = $atual->proximo;
                    if ($this->cabeca !== null) {
                        $this->cabeca->anterior = null;
                    }
                } elseif ($atual === $this->cauda) {
                    $this->cauda = $atual->anterior;
                    if ($this->cauda !== null) {
                        $this->cauda->proximo = null;
                    }
                } else {
                    $atual->anterior->proximo = $atual->proximo;
                    $atual->proximo->anterior = $atual->anterior;
                }
                $this->tamanho--;
                return;
            }
            $atual = $atual->proximo;
        }
    }

    // Exibir os elementos da lista
    public function showList() {
        $atual = $this->cabeca;
        while ($atual !== null) {
            echo $atual->dado . " ";
            $atual = $atual->proximo;
        }
        echo "\n";
    }
}

$lista = new ListaDuplamenteLigada();
$lista->addList(1);
$lista->addList(2);
$lista->addList(3);
$lista->showList();

$lista->removeList(2);
$lista->showList();

?>
