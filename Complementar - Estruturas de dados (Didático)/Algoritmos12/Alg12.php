<?php
/* Algoritmo da Estrutura de dados linear dinâmica (não estática) 
ListaLigada de Lista Ligada, também conhecida como Lista Encadeada */

class ListaLigada {
    private $cabeca;

    private class No {
        public $dado;
        public $proximo;

        public function __construct($dado) {
            $this->dado = $dado;
            $this->proximo = null;
        }
    }

    public function __construct() {
        $this->cabeca = null;
    }

    // Adicionar um elemento no final da lista
    public function addList($dado) {
        $novoNo = new No($dado);
        if ($this->cabeca == null) {
            $this->cabeca = $novoNo;
        } else {
            $atual = $this->cabeca;
            while ($atual->proximo != null) {
                $atual = $atual->proximo;
            }
            $atual->proximo = $novoNo;
        }
    }

    // Remover um elemento da lista
    public function removeList($dado) {
        if ($this->cabeca == null) {
            return;
        }

        if ($this->cabeca->dado == $dado) {
            $this->cabeca = $this->cabeca->proximo;
            return;
        }

        $atual = $this->cabeca;
        $anterior = null;
        while ($atual != null && $atual->dado != $dado) {
            $anterior = $atual;
            $atual = $atual->proximo;
        }

        if ($atual == null) {
            return;
        }

        $anterior->proximo = $atual->proximo;
    }

    // Imprimir a lista
    public function showList() {
        $atual = $this->cabeca;
        while ($atual != null) {
            echo $atual->dado . " ";
            $atual = $atual->proximo;
        }
        echo "\n";
    }
}

$lista = new ListaLigada();
$lista->addList(1);
$lista->addList(2);
$lista->addList(3);
$lista->showList();

$lista->removeList(2);
$lista->showList();

?>
