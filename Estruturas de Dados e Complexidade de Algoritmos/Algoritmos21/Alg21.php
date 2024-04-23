<?php
/*
♦ Algoritmo 21: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).
*/

class BinarySearchTree {
    private $root;

    public function __construct() {
        $this->root = null;
    }

    // Inserção de elementos
    public function insert($data) {
        $this->root = $this->insertRec($this->root, $data);
    }

    private function insertRec($root, $data) {
        if ($root === null) {
            $root = new TreeNode($data);
            return $root;
        }

        if ($data < $root->data) {
            $root->left = $this->insertRec($root->left, $data);
        } elseif ($data > $root->data) {
            $root->right = $this->insertRec($root->right, $data);
        }

        return $root;
    }

    // Remoção de elementos
    public function delete($data) {
        $this->root = $this->deleteRec($this->root, $data);
    }

    private function deleteRec($root, $data) {
        if ($root === null) {
            return $root;
        }

        if ($data < $root->data) {
            $root->left = $this->deleteRec($root->left, $data);
        } elseif ($data > $root->data) {
            $root->right = $this->deleteRec($root->right, $data);
        } else {
            if ($root->left === null) {
                return $root->right;
            } elseif ($root->right === null) {
                return $root->left;
            }

            $root->data = $this->minValue($root->right);

            $root->right = $this->deleteRec($root->right, $root->data);
        }

        return $root;
    }

    private function minValue($root) {
        $minValue = $root->data;
        while ($root->left !== null) {
            $minValue = $root->left->data;
            $root = $root->left;
        }
        return $minValue;
    }

    // Busca de elementos
    public function search($data) {
        return $this->searchRec($this->root, $data);
    }

    private function searchRec($root, $data) {
        if ($root === null) {
            return false;
        }

        if ($root->data === $data) {
            return true;
        }

        if ($data < $root->data) {
            return $this->searchRec($root->left, $data);
        }

        return $this->searchRec($root->right, $data);
    }

    // Encontrar o Mínimo e o Máximo
    public function findMin() {
        if ($this->root === null) {
            return null;
        }

        $current = $this->root;
        while ($current->left !== null) {
            $current = $current->left;
        }

        return $current->data;
    }

    public function findMax() {
        if ($this->root === null) {
            return null;
        }

        $current = $this->root;
        while ($current->right !== null) {
            $current = $current->right;
        }

        return $current->data;
    }

    // Travessias (in-order, pre-order, post-order)
    public function inOrder() {
        $this->inOrderRec($this->root);
    }

    private function inOrderRec($root) {
        if ($root !== null) {
            $this->inOrderRec($root->left);
            echo $root->data . " ";
            $this->inOrderRec($root->right);
        }
    }

    public function preOrder() {
        $this->preOrderRec($this->root);
    }

    private function preOrderRec($root) {
        if ($root !== null) {
            echo $root->data . " ";
            $this->preOrderRec($root->left);
            $this->preOrderRec($root->right);
        }
    }

    public function postOrder() {
        $this->postOrderRec($this->root);
    }

    private function postOrderRec($root) {
        if ($root !== null) {
            $this->postOrderRec($root->left);
            $this->postOrderRec($root->right);
            echo $root->data . " ";
        }
    }

    // Verificar se é uma BST válida
    public function isValidBST() {
        return $this->isValidBSTRec($this->root, null, null);
    }

    private function isValidBSTRec($root, $min, $max) {
        if ($root === null) {
            return true;
        }

        if (($min !== null && $root->data <= $min) || ($max !== null && $root->data >= $max)) {
            return false;
        }

        return $this->isValidBSTRec($root->left, $min, $root->data) && $this->isValidBSTRec($root->right, $root->data, $max);
    }
}

class TreeNode {
    public $data;
    public $left;
    public $right;

    public function __construct($data) {
        $this->data = $data;
        $this->left = null;
        $this->right = null;
    }
}

$tree = new BinarySearchTree();
$tree->insert(50);
$tree->insert(30);
$tree->insert(20);
$tree->insert(40);
$tree->insert(70);
$tree->insert(60);
$tree->insert(80);

echo "In-order traversal:\n";
$tree->inOrder();
echo "\n";

echo "Pre-order traversal:\n";
$tree->preOrder();
echo "\n";

echo "Post-order traversal:\n";
$tree->postOrder();
echo "\n";

echo "Minimum value: " . $tree->findMin() . "\n";
echo "Maximum value: " . $tree->findMax() . "\n";

$searchValue = 40;
echo "Search for " . $searchValue . ": " . ($tree->search($searchValue) ? "true" : "false") . "\n";

$tree->delete($searchValue);
echo "After deleting " . $searchValue . ":\n";
$tree->inOrder();

echo "\nIs valid BST? " . ($tree->isValidBST() ? "true" : "false") . "\n";

?>
