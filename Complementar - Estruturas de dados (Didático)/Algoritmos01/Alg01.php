<?php

/* Estrutura de dados linear de um array (de regra de acesso FIFO) unidimensional (vetor) de tipo genérico */

class Alg01 {
    private $elementos;
    private $sc;

    public function __construct() {
        $this->sc = readline("Tamanho: ");
        $tamanho = intval($this->sc);
        assert($tamanho > 0, "O tamanho do Vetor precisa ser maior que zero!");

        $tipo_de_dado = readline("Tipo de dados: digite 'p' para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' para não primitivos → [string] ...");
        assert($tipo_de_dado === "p" || $tipo_de_dado === "np", "Aceita-se 'p' ou 'np' como parâmetro!");

        if ($tipo_de_dado === "p") {
            $tipo = readline("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ");

            if ($tipo === "byte" || $tipo === "short" || $tipo === "int" || $tipo === "long" ||
                    $tipo === "float" || $tipo === "double" || $tipo === "char" || $tipo === "boolean") {
                try {
                    $className = "java.lang." . ucfirst($tipo);
                    $clazz = new ReflectionClass($className);
                    $this->elementos = array_fill(0, $tamanho, $clazz->newInstance());
                    $vetor = new Alg01($this->elementos);
                    printf("Vetor do tipo de dados %s de %d células alocadas.\n", $tipo, $tamanho);
                } catch (ReflectionException $e) {
                    echo "Tipo de dado inválido!";
                }
            } else {
                echo "Tipo de dado inválido!";
            }
        } else if ($tipo_de_dado === "np") {
            $this->elementos = array_fill(0, $tamanho, "");
            $vetor = new Alg01($this->elementos);
            printf("Vetor do tipo de dados String de %d células alocadas.\n", $tamanho);
        } else {
            echo "Tipo de dado inválido!";
        }
    }

    public function inserir($indice, $valor) {
        $this->elementos[$indice] = $valor;
    }

    public function valor($indice) {
        return $this->elementos[$indice];
    }
}

// Código adicional, se necessário

?>
