<?php
/*
♦ Algoritmo 19: Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 12: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada) de tipo de dados genérico].
→ Operações:
    • Busca de um valor em uma Lista Ligada Simples;
    • Identificar o menor valor em uma Lista Ligada Simples;
    • Identificar o maior valor em uma Lista Ligada Simples;
    • Retornar o sucessor de um valor em uma Lista Ligada Simples;
    • Retornar o predecessor de um valor em uma Lista Ligada Simples.
*/

class Node {
    public $value;
    public $next;

    public function __construct($value) {
        $this->value = $value;
        $this->next = null;
    }
}

class LinkedList {
    private $head;
    private $size;

    public function __construct() {
        $this->head = null;
        $this->size = 0;
    }

    public function insert($value) {
        $newNode = new Node($value);
        $newNode->next = $this->head;
        $this->head = $newNode;
        $this->size++;
    }

    public function remove($value) {
        if ($this->head === null) {
            return;
        }

        if ($this->head->value === $value) {
            $this->head = $this->head->next;
            $this->size--;
            return;
        }

        $current = $this->head;
        $prev = null;

        while ($current !== null) {
            if ($current->value === $value) {
                $prev->next = $current->next;
                $this->size--;
                return;
            }
            $prev = $current;
            $current = $current->next;
        }
    }

    public function size() {
        return $this->size;
    }

    public function display() {
        $current = $this->head;
        while ($current !== null) {
            echo $current->value . " ";
            $current = $current->next;
        }
        echo "\n";
    }

    public function search($value) {
        $current = $this->head;
        while ($current !== null) {
            if ($current->value === $value) {
                return true; // Valor encontrado
            }
            $current = $current->next;
        }
        return false; // Valor não encontrado
    }

    public function findMinimum() {
        if ($this->head === null) {
            return null;
        }

        $current = $this->head;
        $min = $current->value;

        while ($current !== null) {
            if ($current->value < $min) {
                $min = $current->value;
            }
            $current = $current->next;
        }
        return $min;
    }

    public function findMaximum() {
        if ($this->head === null) {
            return null;
        }

        $current = $this->head;
        $max = $current->value;

        while ($current !== null) {
            if ($current->value > $max) {
                $max = $current->value;
            }
            $current = $current->next;
        }
        return $max;
    }

    public function getSuccessor($value) {
        $current = $this->head;
        while ($current !== null) {
            if ($current->value === $value) {
                if ($current->next !== null) {
                    return $current->next->value;
                }
                break; // Último elemento, não há sucessor
            }
            $current = $current->next;
        }
        return null; // Valor não encontrado ou é o último
    }

    public function getPredecessor($value) {
        if ($this->head === null || $this->head->value === $value) {
            return null; // Valor não encontrado ou é o primeiro
        }

        $current = $this->head;
        while ($current !== null && $current->next !== null) {
            if ($current->next->value === $value) {
                return $current->value;
            }
            $current = $current->next;
        }
        return null; // Valor não encontrado
    }
}

$list = new LinkedList();
$list->insert(10);
$list->insert(20);
$list->insert(30);

echo "Tamanho da lista: " . $list->size() . "\n";
echo "Elementos da lista: ";
$list->display();

echo "Buscar 20: " . ($list->search(20) ? "true" : "false") . "\n";
echo "Menor valor: " . $list->findMinimum() . "\n";
echo "Maior valor: " . $list->findMaximum() . "\n";
echo "Sucessor de 20: " . $list->getSuccessor(20) . "\n";
echo "Predecessor de 20: " . $list->getPredecessor(20) . "\n";

$list->remove(20);

echo "Tamanho da lista após remoção: " . $list->size() . "\n";
echo "Elementos da lista após remoção: ";
$list->display();

?>
