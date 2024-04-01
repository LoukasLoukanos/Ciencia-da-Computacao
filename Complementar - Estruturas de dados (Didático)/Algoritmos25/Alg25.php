<?php
/*
♦ Algoritmo 25: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Não-Binária - Árvore B+.
→ Operações:
    • Inserção de Elementos;
    • Remoção de Elementos;
    • Divisão de Nós;
    • Fusão de Nós.
*/


class ArvoreBmais {
    private const ORDEM = 3; // Ordem da árvore B+
    private $raiz;

    private static class No {
        public $chaves = [];
        public $filhos = [];
        public $folha;

        public function __construct($folha) {
            $this->folha = $folha;
        }
    }

    public function __construct() {
        $this->raiz = new No(true);
    }

    public function inserir($chave) {
        $this->inserirNaArvore($this->raiz, $chave);
    }

    private function inserirNaArvore($no, $chave) {
        if (count($no->chaves) == self::ORDEM - 1) {
            $novoNo = new No(false);
            $novoNo->filhos[] = $no;
            $this->dividirNo($novoNo, 0, $no);
            $i = 0;
            if ($novoNo->chaves[0] < $chave) {
                $i++;
            }
            $this->inserirEmNoNaoCheio($novoNo->filhos[$i], $chave);
            $this->raiz = $novoNo;
        } else {
            $this->inserirEmNoNaoCheio($no, $chave);
        }
    }

    private function inserirEmNoNaoCheio($no, $chave) {
        $i = count($no->chaves) - 1;
        if ($no->folha) {
            $no->chaves[] = $chave;
            while ($i >= 0 && $no->chaves[$i] > $chave) {
                $no->chaves[$i + 1] = $no->chaves[$i];
                $i--;
            }
            $no->chaves[$i + 1] = $chave;
        } else {
            while ($i >= 0 && $no->chaves[$i] > $chave) {
                $i--;
            }
            $i++;
            if (count($no->filhos[$i]->chaves) == self::ORDEM - 1) {
                $this->dividirNo($no, $i, $no->filhos[$i]);
                if ($no->chaves[$i] < $chave) {
                    $i++;
                }
            }
            $this->inserirEmNoNaoCheio($no->filhos[$i], $chave);
        }
    }

    private function dividirNo($pai, $indiceFilho, $filho) {
        $novoNo = new No($filho->folha);
        for ($j = 0; $j < self::ORDEM / 2 - 1; $j++) {
            $novoNo->chaves[] = array_splice($filho->chaves, self::ORDEM / 2, 1)[0];
        }
        if (!$filho->folha) {
            for ($j = 0; $j < self::ORDEM / 2; $j++) {
                $novoNo->filhos[] = array_splice($filho->filhos, self::ORDEM / 2, 1)[0];
            }
        }
        array_splice($pai->chaves, $indiceFilho, 0, $filho->chaves[self::ORDEM / 2 - 1]);
        array_splice($pai->filhos, $indiceFilho + 1, 0, [$novoNo]);
    }

    public function remover($chave) {
        $this->removerNaArvore($this->raiz, $chave);
    }

    private function removerNaArvore($no, $chave) {
        // Implemente a remoção aqui
    }

    private function fundirNos($pai, $indiceFilho) {
        // Implemente a fusão de nós aqui
    }

    // Outros métodos necessários

}

// Exemplo de uso
$arvore = new ArvoreBmais(); // Exemplo de ordem 3
$arvore->inserir(10);
$arvore->inserir(20);
$arvore->inserir(5);
$arvore->inserir(15);
$arvore->inserir(25);
$arvore->remover(15); // Exemplo de remoção
// Imprimir árvore ou realizar outras operações para testar

?>
