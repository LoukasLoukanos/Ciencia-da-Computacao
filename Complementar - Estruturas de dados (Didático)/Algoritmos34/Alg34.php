<?php
/*
♦ Algoritmo 34: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore AVL.
*/


class No {
    public $valor;
    public $esquerda, $direita;
    public $altura;

    public function __construct($valor) {
        $this->valor = $valor;
        $this->esquerda = $this->direita = null;
        $this->altura = 1;
    }
}

class ArvoreAVL {
    private $raiz;

    public function __construct() {
        $this->raiz = null;
    }

    private function altura($no) {
        if ($no == null)
            return 0;
        return $no->altura;
    }

    private function balanceamento($no) {
        if ($no == null)
            return 0;
        return $this->altura($no->esquerda) - $this->altura($no->direita);
    }

    private function rotacaoDireita($y) {
        $x = $y->esquerda;
        $T2 = $x->direita;

        $x->direita = $y;
        $y->esquerda = $T2;

        $y->altura = max($this->altura($y->esquerda), $this->altura($y->direita)) + 1;
        $x->altura = max($this->altura($x->esquerda), $this->altura($x->direita)) + 1;

        return $x;
    }

    private function rotacaoEsquerda($x) {
        $y = $x->direita;
        $T2 = $y->esquerda;

        $y->esquerda = $x;
        $x->direita = $T2;

        $x->altura = max($this->altura($x->esquerda), $this->altura($x->direita)) + 1;
        $y->altura = max($this->altura($y->esquerda), $this->altura($y->direita)) + 1;

        return $y;
    }

    public function inserir($valor) {
        $this->raiz = $this->inserirRecursivo($this->raiz, $valor);
    }

    private function inserirRecursivo($no, $valor) {
        if ($no == null)
            return new No($valor);

        if ($valor < $no->valor)
            $no->esquerda = $this->inserirRecursivo($no->esquerda, $valor);
        else if ($valor > $no->valor)
            $no->direita = $this->inserirRecursivo($no->direita, $valor);
        else
            return $no;

        $no->altura = 1 + max($this->altura($no->esquerda), $this->altura($no->direita));

        $balanceamento = $this->balanceamento($no);

        if ($balanceamento > 1 && $valor < $no->esquerda->valor)
            return $this->rotacaoDireita($no);

        if ($balanceamento < -1 && $valor > $no->direita->valor)
            return $this->rotacaoEsquerda($no);

        if ($balanceamento > 1 && $valor > $no->esquerda->valor) {
            $no->esquerda = $this->rotacaoEsquerda($no->esquerda);
            return $this->rotacaoDireita($no);
        }

        if ($balanceamento < -1 && $valor < $no->direita->valor) {
            $no->direita = $this->rotacaoDireita($no->direita);
            return $this->rotacaoEsquerda($no);
        }

        return $no;
    }

    private function imprimirEmOrdemRecursivo($no) {
        if ($no != null) {
            $this->imprimirEmOrdemRecursivo($no->esquerda);
            echo $no->valor . " ";
            $this->imprimirEmOrdemRecursivo($no->direita);
        }
    }

    public function imprimirEmOrdem() {
        $this->imprimirEmOrdemRecursivo($this->raiz);
    }
}

// Teste
$arvore = new ArvoreAVL();
$arvore->inserir(10);
$arvore->inserir(5);
$arvore->inserir(20);
$arvore->inserir(3);
$arvore->inserir(8);
$arvore->inserir(15);

echo "Em Ordem:\n";
$arvore->imprimirEmOrdem();

?>
