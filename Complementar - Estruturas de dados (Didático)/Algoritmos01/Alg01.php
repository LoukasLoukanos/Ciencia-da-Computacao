<?php
/*
♦ Implementação de um array unidimensional (vetor) de tipo genérico (considerando uma estrutura de dados que armazena, a princípio, dados primitivos desde que sejam do mesmo tipo — estrutura homogênea — ): Algoritmo 01.
*/

class Alg01 {
    private $elementos;
    private $tamanho;
    private $tamanhoAtual;

    public function __construct($tamanho) {
        $this->elementos = array();
        $this->tamanho = $tamanho;
        $this->tamanhoAtual = 0;

        echo "Tamanho: ";
        $tamanhoInput = intval(fgets(STDIN));
        if ($tamanhoInput > 0) {
            $this->tamanho = $tamanhoInput;
            echo 'Tipo de dados: digite "p" para primitivos ou "np" para não primitivos: ';
            $tipo_de_dado = trim(fgets(STDIN));
            if ($tipo_de_dado === "p") {
                echo 'Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ';
                $tipo = trim(fgets(STDIN));
                if (in_array($tipo, array("byte", "short", "int", "long", "float", "double", "char", "boolean"))) {
                    $this->elementos = array_fill(0, $this->tamanho, null);
                    echo "Vetor do tipo de dados $tipo de $this->tamanho células alocadas.\n";
                } else {
                    echo "Tipo de dado inválido!\n";
                }
            } else if ($tipo_de_dado === "np") {
                $this->elementos = array_fill(0, $this->tamanho, null);
                echo "Vetor do tipo de dados String de $this->tamanho células alocadas.\n";
            } else {
                echo "Tipo de dado inválido!\n";
            }
        } else {
            echo "O tamanho do vetor precisa ser maior que zero!\n";
        }
    }

    public function isEmpty() {
        return $this->tamanhoAtual == 0;
    }

    public function isFull() {
        return $this->tamanhoAtual == $this->tamanho;
    }

    public function addElement($indice, $valor) {
        if ($indice < 0 || $indice >= $this->tamanho) {
            throw new InvalidArgumentException("Índice fora dos limites do vetor.");
        }

        if ($this->isFull()) {
            throw new RuntimeException("O vetor está cheio.");
        }

        $this->elementos[$indice] = $valor;
        $this->tamanhoAtual++;
    }

    public function removeElement($indice) {
        if ($indice < 0 || $indice >= $this->tamanho) {
            throw new InvalidArgumentException("Índice fora dos limites do vetor.");
        }

        if ($this->isEmpty()) {
            throw new RuntimeException("O vetor está vazio.");
        }

        $this->elementos[$indice] = null;
        $this->tamanhoAtual--;
    }

    public function sizeArray() {
        return $this->tamanhoAtual;
    }

    public function accessElement($indice) {
        if ($indice < 0 || $indice >= $this->tamanho) {
            throw new InvalidArgumentException("Índice fora dos limites do vetor.");
        }

        if ($this->isEmpty()) {
            throw new RuntimeException("O vetor está vazio.");
        }

        return $this->elementos[$indice];
    }

    public function showQueue() {
        echo "Elementos do vetor: " . implode(" ", $this->elementos) . "\n";
    }
}

// Exemplo de criação de um vetor de inteiros
$vetorInt = new Alg01(10);

// Verificar se o vetor está vazio
echo "O vetor está vazio? " . ($vetorInt->isEmpty() ? "Sim" : "Não") . "\n";

// Adicionar elementos
$vetorInt->addElement(0, 10);
$vetorInt->addElement(1, 20);
$vetorInt->addElement(2, 30);

// Verificar o tamanho atual do vetor
echo "Tamanho atual do vetor: " . $vetorInt->sizeArray() . "\n";

// Acessar um elemento
echo "Elemento no índice 1: " . $vetorInt->accessElement(1) . "\n";

// Remover um elemento
$vetorInt->removeElement(1);

// Verificar se o vetor está vazio novamente
echo "O vetor está vazio? " . ($vetorInt->isEmpty() ? "Sim" : "Não") . "\n";

// Verificar se o vetor está cheio
echo "O vetor está cheio? " . ($vetorInt->isFull() ? "Sim" : "Não") . "\n";

// Mostrar todos os elementos
echo "Elementos do vetor: ";
$vetorInt->showQueue();

?>
