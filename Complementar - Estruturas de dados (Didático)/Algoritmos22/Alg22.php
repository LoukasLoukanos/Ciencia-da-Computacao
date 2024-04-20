<?php
/*
♦ Algoritmo 22: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária: Árvore AVL.
*/

class Node {
    public $data;
    public $left;
    public $right;
    public $height;

    public function __construct($data) {
        $this->data = $data;
        $this->left = null;
        $this->right = null;
        $this->height = 1;
    }
}

class AVLTree {
    private $root;

    public function __construct() {
        $this->root = null;
    }

    private function height($node) {
        if ($node === null)
            return 0;
        return $node->height;
    }

    private function balanceFactor($node) {
        if ($node === null)
            return 0;
        return $this->height($node->left) - $this->height($node->right);
    }

    private function rotateRight($y) {
        $x = $y->left;
        $T2 = $x->right;

        $x->right = $y;
        $y->left = $T2;

        $y->height = max($this->height($y->left), $this->height($y->right)) + 1;
        $x->height = max($this->height($x->left), $this->height($x->right)) + 1;

        return $x;
    }

    private function rotateLeft($x) {
        $y = $x->right;
        $T2 = $y->left;

        $y->left = $x;
        $x->right = $T2;

        $x->height = max($this->height($x->left), $this->height($x->right)) + 1;
        $y->height = max($this->height($y->left), $this->height($y->right)) + 1;

        return $y;
    }

    public function insert($data) {
        $this->root = $this->insertNode($this->root, $data);
    }

    private function insertNode($node, $data) {
        if ($node === null)
            return new Node($data);

        if ($data < $node->data)
            $node->left = $this->insertNode($node->left, $data);
        elseif ($data > $node->data)
            $node->right = $this->insertNode($node->right, $data);
        else
            return $node; // Duplicatas não são permitidas

        $node->height = 1 + max($this->height($node->left), $this->height($node->right));

        $balance = $this->balanceFactor($node);

        // Casos de desequilíbrio
        if ($balance > 1) {
            if ($data < $node->left->data) {
                // Rotação simples à direita
                return $this->rotateRight($node);
            } else {
                // Rotação dupla à esquerda-direita
                $node->left = $this->rotateLeft($node->left);
                return $this->rotateRight($node);
            }
        }

        if ($balance < -1) {
            if ($data > $node->right->data) {
                // Rotação simples à esquerda
                return $this->rotateLeft($node);
            } else {
                // Rotação dupla à direita-esquerda
                $node->right = $this->rotateRight($node->right);
                return $this->rotateLeft($node);
            }
        }

        return $node;
    }

    public function remove($data) {
        $this->root = $this->removeNode($this->root, $data);
    }

    private function removeNode($node, $data) {
        if ($node === null)
            return $node;

        if ($data < $node->data)
            $node->left = $this->removeNode($node->left, $data);
        elseif ($data > $node->data)
            $node->right = $this->removeNode($node->right, $data);
        else {
            if ($node->left === null || $node->right === null) {
                $temp = ($node->left !== null) ? $node->left : $node->right;

                if ($temp === null) {
                    $temp = $node;
                    $node = null;
                } else {
                    $node = $temp;
                }
            } else {
                $temp = $this->findMin($node->right);
                $node->data = $temp->data;
                $node->right = $this->removeNode($node->right, $temp->data);
            }
        }

        if ($node === null)
            return $node;

        $node->height = 1 + max($this->height($node->left), $this->height($node->right));

        $balance = $this->balanceFactor($node);

        // Casos de desequilíbrio
        if ($balance > 1) {
            if ($this->balanceFactor($node->left) >= 0) {
                // Rotação simples à direita
                return $this->rotateRight($node);
            } else {
                // Rotação dupla à esquerda-direita
                $node->left = $this->rotateLeft($node->left);
                return $this->rotateRight($node);
            }
        }

        if ($balance < -1) {
            if ($this->balanceFactor($node->right) <= 0) {
                // Rotação simples à esquerda
                return $this->rotateLeft($node);
            } else {
                // Rotação dupla à direita-esquerda
                $node->right = $this->rotateRight($node->right);
                return $this->rotateLeft($node);
            }
        }

        return $node;
    }

    private function findMin($node) {
        while ($node->left !== null)
            $node = $node->left;
        return $node;
    }

    public function inorder() {
        $this->inorderTraversal($this->root);
        echo PHP_EOL;
    }

    private function inorderTraversal($node) {
        if ($node !== null) {
            $this->inorderTraversal($node->left);
            echo $node->data . " ";
            $this->inorderTraversal($node->right);
        }
    }
}

$tree = new AVLTree();

$tree->insert(10);
$tree->insert(20);
$tree->insert(30);
$tree->insert(40);
$tree->insert(50);

echo "Árvore AVL In-Order:" . PHP_EOL;
$tree->inorder();

$tree->remove(30);
$tree->remove(40);

echo "Árvore AVL In-Order após a remoção de 30 e 40:" . PHP_EOL;
$tree->inorder();

?>
