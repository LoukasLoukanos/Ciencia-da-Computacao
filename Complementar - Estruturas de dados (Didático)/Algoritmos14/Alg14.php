<?php
/* Algoritmo da Estrutura de dados linear dinâmica (não estática) 
   Alg14 de Fila (regra de acesso FIFO) Dinâmica */
   
class FilaDinamica {
    private $cabeca;
    private $cauda;
    private $tamanho;

    private class Nodo {
        public $dado;
        public $proximo;

        public function __construct($dado) {
            $this->dado = $dado;
            $this->proximo = null;
        }
    }

    public function __construct() {
        $this->cabeca = null;
        $this->cauda = null;
        $this->tamanho = 0;
    }

    // Verificar se a fila está vazia
    public function isEmpty() {
        return $this->tamanho == 0;
    }

    // Adicionar elementos à fila (enqueue)
    public function enqueue($dado) {
        $novoNodo = new Nodo($dado);
        if ($this->isEmpty()) {
            $this->cabeca = $novoNodo;
            $this->cauda = $novoNodo;
        } else {
            $this->cauda->proximo = $novoNodo;
            $this->cauda = $novoNodo;
        }
        $this->tamanho++;
    }

    // Remover o elemento da frente da fila (dequeue)
    public function dequeue() {
        if ($this->isEmpty()) {
            throw new Exception("A fila está vazia");
        }

        $dadoRemovido = $this->cabeca->dado;
        $this->cabeca = $this->cabeca->proximo;
        $this->tamanho--;

        if ($this->isEmpty()) {
            $this->cauda = null;
        }

        return $dadoRemovido;
    }

    // Obter o tamanho atual da fila
    public function size() {
        return $this->tamanho;
    }

    // Acessar o elemento da frente da fila sem removê-lo
    public function front() {
        if ($this->isEmpty()) {
            throw new Exception("A fila está vazia");
        }

        return $this->cabeca->dado;
    }

    // Mostrar elementos da fila
    public function showQueue() {
        $atual = $this->cabeca;
        while ($atual != null) {
            echo $atual->dado . " ";
            $atual = $atual->proximo;
        }
        echo "\n";
    }
}

// Exemplo de uso
$fila = new FilaDinamica();
$fila->enqueue(1);
$fila->enqueue(2);
$fila->enqueue(3);

$fila->showQueue();

echo "Frente da fila: " . $fila->front() . "\n";
echo "Tamanho da fila: " . $fila->size() . "\n";

$fila->dequeue();
$fila->showQueue();

?>
