<?php
/*
♦ Algoritmo 35: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore Rubro-Negra.
*/


class No {
    public $valor;
    public $esquerda;
    public $direita;
    public $vermelho;

    public function __construct($valor) {
        $this->valor = $valor;
        $this->esquerda = null;
        $this->direita = null;
        $this->vermelho = true; // Por padrão, os nós são vermelhos quando adicionados à árvore
    }
}

class ArvoreRubroNegra {
    private $raiz;
    private const VERMELHO = true;
    private const PRETO = false;

    // Verifica se um nó é vermelho
    private function isVermelho($no) {
        if ($no === null) return false;
        return $no->vermelho === self::VERMELHO;
    }

    // Realiza uma rotação para a esquerda em torno do nó dado
    private function rotacaoEsquerda($no) {
        $temp = $no->direita;
        $no->direita = $temp->esquerda;
        $temp->esquerda = $no;
        $temp->vermelho = $no->vermelho;
        $no->vermelho = self::VERMELHO;
        return $temp;
    }

    // Realiza uma rotação para a direita em torno do nó dado
    private function rotacaoDireita($no) {
        $temp = $no->esquerda;
        $no->esquerda = $temp->direita;
        $temp->direita = $no;
        $temp->vermelho = $no->vermelho;
        $no->vermelho = self::VERMELHO;
        return $temp;
    }

    // Inverte as cores do nó e de seus filhos
    private function inverterCores($no) {
        $no->vermelho = !$no->vermelho;
        $no->esquerda->vermelho = !$no->esquerda->vermelho;
        $no->direita->vermelho = !$no->direita->vermelho;
    }

    // Insere um novo nó na árvore Rubro-Negra
    public function inserir($valor) {
        $this->raiz = $this->inserirRecursivo($this->raiz, $valor);
        $this->raiz->vermelho = self::PRETO; // A raiz sempre será preta
    }

    // Método auxiliar recursivo para inserção
    private function inserirRecursivo($no, $valor) {
        if ($no === null) return new No($valor);

        // Inserção normal como em uma árvore de busca binária
        if ($valor < $no->valor)
            $no->esquerda = $this->inserirRecursivo($no->esquerda, $valor);
        elseif ($valor > $no->valor)
            $no->direita = $this->inserirRecursivo($no->direita, $valor);
        else
            return $no; // Valor já existe na árvore

        // Correção da propriedade de cor após a inserção
        if ($this->isVermelho($no->direita) && !$this->isVermelho($no->esquerda))
            $no = $this->rotacaoEsquerda($no);
        if ($this->isVermelho($no->esquerda) && $this->isVermelho($no->esquerda->esquerda))
            $no = $this->rotacaoDireita($no);
        if ($this->isVermelho($no->esquerda) && $this->isVermelho($no->direita))
            $this->inverterCores($no);

        return $no;
    }

    // Método para imprimir a árvore em ordem
    public function imprimirEmOrdem() {
        $this->imprimirEmOrdemRecursivo($this->raiz);
    }

    // Método auxiliar recursivo para impressão em ordem
    private function imprimirEmOrdemRecursivo($no) {
        if ($no !== null) {
            $this->imprimirEmOrdemRecursivo($no->esquerda);
            echo $no->valor . " ";
            $this->imprimirEmOrdemRecursivo($no->direita);
        }
    }

    // Método para verificar se a árvore Rubro-Negra está vazia
    public function estaVazia() {
        return $this->raiz === null;
    }
}

// Teste
$arvore = new ArvoreRubroNegra();
$arvore->inserir(10);
$arvore->inserir(5);
$arvore->inserir(20);
$arvore->inserir(3);
$arvore->inserir(8);
$arvore->inserir(15);

echo "Em Ordem: ";
$arvore->imprimirEmOrdem();
?>
