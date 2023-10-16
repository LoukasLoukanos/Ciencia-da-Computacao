<?php
/*
♦ Algoritmo 20: Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 13: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada de tipo de dados genérico].
→ Operações:
    • Busca de um valor em uma Lista Duplamente Ligada;
    • Identificar o menor valor em uma Lista Duplamente Ligada;
    • Identificar o maior valor em uma Lista Duplamente Ligada;
    • Retornar o sucessor de um valor em uma Lista Duplamente Ligada;
    • Retornar o predecessor de um valor em uma Lista Duplamente Ligada.
*/

class Node {
    public $value;
    public $previous;
    public $next;

    public function __construct($value) {
        $this->value = $value;
        $this->previous = null;
        $this->next = null;
    }
}

class DoublyLinkedList {
    private $first;

    public function __construct() {
        $this->first = null;
    }

    public function searchList($value) {
        $currentNode = $this->first;
        while ($currentNode !== null) {
            if ($currentNode->value === $value) {
                return true;
            }
            $currentNode = $currentNode->next;
        }
        return false;
    }

    public function findMinimum() {
        if ($this->first === null) {
            return null;
        }

        $currentNode = $this->first;
        $min = $currentNode->value;

        while ($currentNode !== null) {
            if ($currentNode->value < $min) {
                $min = $currentNode->value;
            }
            $currentNode = $currentNode->next;
        }
        return $min;
    }

    public function findMaximum() {
        if ($this->first === null) {
            return null;
        }

        $currentNode = $this->first;
        $max = $currentNode->value;

        while ($currentNode !== null) {
            if ($currentNode->value > $max) {
                $max = $currentNode->value;
            }
            $currentNode = $currentNode->next;
        }
        return $max;
    }

    public function getSuccessor($value) {
        $currentNode = $this->first;
        while ($currentNode !== null) {
            if ($currentNode->value === $value) {
                if ($currentNode->next !== null) {
                    return $currentNode->next->value;
                }
                break;
            }
            $currentNode = $currentNode->next;
        }
        return null;
    }

    public function getPredecessor($value) {
        if ($this->first === null || $this->first->value === $value) {
            return null;
        }

        $currentNode = $this->first;
        while ($currentNode !== null && $currentNode->next !== null) {
            if ($currentNode->next->value === $value) {
                return $currentNode->value;
            }
            $currentNode = $currentNode->next;
        }
        return null;
    }
}

// Exemplo de uso:
$list = new DoublyLinkedList();
$list->searchList(10);
$list->findMinimum();
$list->findMaximum();
$list->getSuccessor(10);
$list->getPredecessor(10);

?>