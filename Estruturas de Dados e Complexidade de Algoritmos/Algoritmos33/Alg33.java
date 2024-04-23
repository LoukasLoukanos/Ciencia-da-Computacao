/*
♦ Algoritmo 33: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).
*/


class No<T> {
    T valor;
    No<T> esquerda, direita;

    public No(T valor) {
        this.valor = valor;
        this.esquerda = this.direita = null;
    }
}

public class Alg33<T extends Comparable<T>> {
    private No<T> raiz;

    public Alg33() {
        this.raiz = null;
    }

    public void inserir(T valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    private No<T> inserirRecursivo(No<T> no, T valor) {
        if (no == null) {
            return new No<T>(valor);
        }

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = inserirRecursivo(no.direita, valor);
        }

        return no;
    }

    public boolean buscar(T valor) {
        return buscarRecursivo(this.raiz, valor);
    }

    private boolean buscarRecursivo(No<T> no, T valor) {
        if (no == null) {
            return false;
        }

        if (valor.compareTo(no.valor) == 0) {
            return true;
        }

        return valor.compareTo(no.valor) < 0 ? buscarRecursivo(no.esquerda, valor) : buscarRecursivo(no.direita, valor);
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(this.raiz);
    }

    private void imprimirEmOrdemRecursivo(No<T> no) {
        if (no != null) {
            imprimirEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdemRecursivo(no.direita);
        }
    }

    public static void main(String[] args) {
        Alg33<Integer> arvore = new Alg33<>();
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(20);
        arvore.inserir(3);
        arvore.inserir(8);
        arvore.inserir(15);

        System.out.println("Em Ordem:");
        arvore.imprimirEmOrdem();

        System.out.println("\nBuscar 8: " + arvore.buscar(8));
        System.out.println("Buscar 12: " + arvore.buscar(12));
    }
}
