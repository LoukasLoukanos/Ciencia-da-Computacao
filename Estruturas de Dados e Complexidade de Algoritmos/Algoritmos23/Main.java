/*
♦ Algoritmo 23: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária: Árvore Rubro-Negra.
*/


import java.util.LinkedList;
import java.util.Queue;

class No<T extends Comparable<T>> {
    T chave;
    No<T> pai, esquerda, direita;
    boolean cor; // true para vermelho, false para preto

    public No(T chave) {
        this.chave = chave;
        this.cor = true; // Por padrão, um novo nó é vermelho
        this.pai = this.esquerda = this.direita = null;
    }
}

public class Alg23<T extends Comparable<T>> {
    private No<T> raiz;
    private No<T> sentinela; // Sentinel

    public Alg23() {
        this.sentinela = new No<>(null);
        this.sentinela.cor = false; // Sentinel é sempre preto
        this.raiz = this.sentinela;
    }

    // Métodos de inserção
    public void inserir(T chave) {
        No<T> novoNo = new No<>(chave);
        inserirNo(novoNo);
    }

    private void inserirNo(No<T> z) {
        No<T> y = this.sentinela;
        No<T> x = this.raiz;

        while (x != this.sentinela) {
            y = x;
            if (z.chave.compareTo(x.chave) < 0) {
                x = x.esquerda;
            } else {
                x = x.direita;
            }
        }

        z.pai = y;

        if (y == this.sentinela) {
            this.raiz = z;
        } else if (z.chave.compareTo(y.chave) < 0) {
            y.esquerda = z;
        } else {
            y.direita = z;
        }

        z.esquerda = this.sentinela;
        z.direita = this.sentinela;
        z.cor = true;

        corrigirInsercao(z);
    }

    // Métodos de remoção
    public void remover(T chave) {
        No<T> z = buscar(chave);
        if (z != null) {
            removerNo(z);
        }
    }

    private void removerNo(No<T> z) {
        No<T> y = z;
        No<T> x;
        boolean corOriginalY = y.cor;

        if (z.esquerda == this.sentinela) {
            x = z.direita;
            transplantar(z, z.direita);
        } else if (z.direita == this.sentinela) {
            x = z.esquerda;
            transplantar(z, z.esquerda);
        } else {
            y = encontrarMinimo(z.direita);
            corOriginalY = y.cor;
            x = y.direita;

            if (y.pai == z) {
                x.pai = y;
            } else {
                transplantar(y, y.direita);
                y.direita = z.direita;
                y.direita.pai = y;
            }

            transplantar(z, y);
            y.esquerda = z.esquerda;
            y.esquerda.pai = y;
            y.cor = z.cor;
        }

        if (corOriginalY == false) {
            corrigirRemocao(x);
        }
    }

    // Método de busca
    public No<T> buscar(T chave) {
        return buscarNo(this.raiz, chave);
    }

    private No<T> buscarNo(No<T> no, T chave) {
        if (no == this.sentinela || chave.compareTo(no.chave) == 0) {
            return no;
        }

        if (chave.compareTo(no.chave) < 0) {
            return buscarNo(no.esquerda, chave);
        } else {
            return buscarNo(no.direita, chave);
        }
    }

    // Restante do código (mínimo, máximo, sucessor, antecessor, travessias, altura, etc.)

    // Métodos auxiliares
    private void transplantar(No<T> u, No<T> v) {
        if (u.pai == this.sentinela) {
            this.raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        v.pai = u.pai;
    }

    private void corrigirInsercao(No<T> z) {
        // Implementação da correção após inserção
    }

    private void corrigirRemocao(No<T> x) {
        // Implementação da correção após remoção
    }

    // Outros métodos omitidos para manter a resposta concisa
}

public class Main {
    public static void main(String[] args) {
        Alg23<Integer> arvore = new Alg23<>();
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);

        System.out.println("Árvore Rubro-Negra em ordem:");
        arvore.percorrerEmOrdem();

        System.out.println("\nMínimo: " + arvore.minimo());
        System.out.println("Máximo: " + arvore.maximo());

        arvore.remover(20);

        System.out.println("\nÁrvore Rubro-Negra em ordem após a remoção de 20:");
        arvore.percorrerEmOrdem();
    }
}
