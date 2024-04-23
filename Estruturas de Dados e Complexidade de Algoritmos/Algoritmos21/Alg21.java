/*
♦ Algoritmo 21: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).
*/

import java.util.Stack;

class Alg21<T extends Comparable<T>> {
    class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;

        TreeNode(T data) {
            this.data = data;
            left = right = null;
        }
    }

    private TreeNode root;

    Alg21() {
        root = null;
    }

    // Inserção de elementos
    public void insert(T data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, T data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Remoção de elementos
    public void delete(T data) {
        root = deleteRec(root, data);
    }

    private TreeNode deleteRec(TreeNode root, T data) {
        if (root == null) {
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private T minValue(TreeNode root) {
        T minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Busca de elementos
    public boolean search(T data) {
        return searchRec(root, data);
    }

    private boolean searchRec(TreeNode root, T data) {
        if (root == null) {
            return false;
        }

        if (root.data.equals(data)) {
            return true;
        }

        if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        }

        return searchRec(root.right, data);
    }

    // Encontrar o Mínimo e o Máximo
    public T findMin() {
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    public T findMax() {
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    // Travessias (in-order, pre-order, post-order)
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Verificar se é uma BST válida
    public boolean isValidBST() {
        return isValidBSTRec(root, null, null);
    }

    private boolean isValidBSTRec(TreeNode root, T min, T max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.data.compareTo(min) <= 0) || (max != null && root.data.compareTo(max) >= 0)) {
            return false;
        }

        return isValidBSTRec(root.left, min, root.data) && isValidBSTRec(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Alg21<Integer> tree = new Alg21<>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal:");
        tree.inOrder();
        System.out.println();

        System.out.println("Pre-order traversal:");
        tree.preOrder();
        System.out.println();

        System.out.println("Post-order traversal:");
        tree.postOrder();
        System.out.println();

        System.out.println("Minimum value: " + tree.findMin());
        System.out.println("Maximum value: " + tree.findMax());

        int searchValue = 40;
        System.out.println("Search for " + searchValue + ": " + tree.search(searchValue));

        tree.delete(40);
        System.out.println("After deleting " + searchValue + ":");
        tree.inOrder();

        System.out.println("\nIs valid BST? " + tree.isValidBST());
    }
}
