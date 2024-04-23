<?php
/*
♦ Algoritmo 33: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).
*/


class No {
    public $valor;
    public $esquerda;
    public $direita;

    public function __construct($valor) {
        $this->valor = $valor;
        $this->esquerda = $this->direita = null;
    }
}

class ArvoreBinaria {
    private $raiz;

    public function __construct() {
        $this->raiz = null;
    }

    public function inserir($valor) {
        $this->raiz = $this->inserirRecursivo($this->raiz, $valor);
    }

    private function inserirRecursivo($no, $valor) {
        if ($no === null) {
            return new No($valor);
        }

        if ($valor < $no->valor) {
            $no->esquerda = $this->inserirRecursivo($no->esquerda, $valor);
        } else if ($valor > $no->valor) {
            $no->direita = $this->inserirRecursivo($no->direita, $valor);
        }

        return $no;
    }

    public function buscar($valor) {
        return $this->buscarRecursivo($this->raiz, $valor);
    }

    private function buscarRecursivo($no, $valor) {
        if ($no === null) {
            return false;
        }

        if ($valor === $no->valor) {
            return true;
        }

        return $valor < $no->valor ? $this->buscarRecursivo($no->esquerda, $valor) : $this->buscarRecursivo($no->direita, $valor);
    }

    public function imprimirEmOrdem() {
        $this->imprimirEmOrdemRecursivo($this->raiz);
    }

    private function imprimirEmOrdemRecursivo($no) {
        if ($no !== null) {
            $this->imprimirEmOrdemRecursivo($no->esquerda);
            echo $no->valor . " ";
            $this->imprimirEmOrdemRecursivo($no->direita);
        }
    }
}

$arvore = new ArvoreBinaria();
$arvore->inserir(10);
$arvore->inserir(5);
$arvore->inserir(20);
$arvore->inserir(3);
$arvore->inserir(8);
$arvore->inserir(15);

echo "Em Ordem:\n";
$arvore->imprimirEmOrdem();
echo "\n\nBuscar 8: " . ($arvore->buscar(8) ? 'true' : 'false');
echo "\nBuscar 12: " . ($arvore->buscar(12) ? 'true' : 'false');
?>
