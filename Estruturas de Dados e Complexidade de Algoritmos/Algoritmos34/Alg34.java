/*
♦ Algoritmo 34: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore AVL.
*/


class No<T> {
    T valor;
    No<T> esquerda, direita;
    int altura;

    public No(T valor) {
        this.valor = valor;
        this.esquerda = this.direita = null;
        this.altura = 1;
    }
}

public class Alg34<T extends Comparable<T>> {
    private No<T> raiz;

    public Alg34() {
        this.raiz = null;
    }

    private int altura(No<T> no) {
        if (no == null)
            return 0;
        return no.altura;
    }

    private int balanceamento(No<T> no) {
        if (no == null)
            return 0;
        return altura(no.esquerda) - altura(no.direita);
    }

    private No<T> rotacaoDireita(No<T> y) {
        No<T> x = y.esquerda;
        No<T> T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No<T> rotacaoEsquerda(No<T> x) {
        No<T> y = x.direita;
        No<T> T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void inserir(T valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    private No<T> inserirRecursivo(No<T> no, T valor) {
        if (no == null)
            return new No<T>(valor);

        if (valor.compareTo(no.valor) < 0)
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = inserirRecursivo(no.direita, valor);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = balanceamento(no);

        if (balanceamento > 1 && valor.compareTo(no.esquerda.valor) < 0)
            return rotacaoDireita(no);

        if (balanceamento < -1 && valor.compareTo(no.direita.valor) > 0)
            return rotacaoEsquerda(no);

        if (balanceamento > 1 && valor.compareTo(no.esquerda.valor) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && valor.compareTo(no.direita.valor) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private void imprimirEmOrdemRecursivo(No<T> no) {
        if (no != null) {
            imprimirEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdemRecursivo(no.direita);
        }
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(this.raiz);
    }

    public static void main(String[] args) {
        Alg34<Integer> arvore = new Alg34<>();
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(20);
        arvore.inserir(3);
        arvore.inserir(8);
        arvore.inserir(15);

        System.out.println("Em Ordem:");
        arvore.imprimirEmOrdem();
    }
}
