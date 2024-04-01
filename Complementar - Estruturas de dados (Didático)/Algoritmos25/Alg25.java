/*
♦ Algoritmo 25: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Não-Binária - Árvore B+.
→ Operações:
    • Inserção de Elementos;
    • Remoção de Elementos;
    • Divisão de Nós;
    • Fusão de Nós.
*/


import java.util.ArrayList;
import java.util.List;

class Alg25<T extends Comparable<T>> {
    private static final int ORDEM = 3; // Ordem da árvore B+

    private No<T> raiz;

    private static class No<T> {
        List<T> chaves;
        List<No<T>> filhos;
        boolean folha;

        No(boolean folha) {
            this.chaves = new ArrayList<>();
            this.filhos = new ArrayList<>();
            this.folha = folha;
        }
    }

    public Alg25() {
        this.raiz = new No<>(true);
    }

    public void inserir(T chave) {
        inserirNaArvore(this.raiz, chave);
    }

    private void inserirNaArvore(No<T> no, T chave) {
        if (no.chaves.size() == ORDEM - 1) {
            No<T> novoNo = new No<>(false);
            novoNo.filhos.add(no);
            dividirNo(novoNo, 0, no);
            int i = 0;
            if (novoNo.chaves.get(0).compareTo(chave) < 0) {
                i++;
            }
            inserirEmNoNaoCheio(novoNo.filhos.get(i), chave);
            this.raiz = novoNo;
        } else {
            inserirEmNoNaoCheio(no, chave);
        }
    }

    private void inserirEmNoNaoCheio(No<T> no, T chave) {
        int i = no.chaves.size() - 1;
        if (no.folha) {
            no.chaves.add(chave);
            while (i >= 0 && no.chaves.get(i).compareTo(chave) > 0) {
                no.chaves.set(i + 1, no.chaves.get(i));
                i--;
            }
            no.chaves.set(i + 1, chave);
        } else {
            while (i >= 0 && no.chaves.get(i).compareTo(chave) > 0) {
                i--;
            }
            i++;
            if (no.filhos.get(i).chaves.size() == ORDEM - 1) {
                dividirNo(no, i, no.filhos.get(i));
                if (no.chaves.get(i).compareTo(chave) < 0) {
                    i++;
                }
            }
            inserirEmNoNaoCheio(no.filhos.get(i), chave);
        }
    }

    private void dividirNo(No<T> pai, int indiceFilho, No<T> filho) {
        No<T> novoNo = new No<>(filho.folha);
        for (int j = 0; j < ORDEM / 2 - 1; j++) {
            novoNo.chaves.add(filho.chaves.remove(ORDEM / 2));
        }
        if (!filho.folha) {
            for (int j = 0; j < ORDEM / 2; j++) {
                novoNo.filhos.add(filho.filhos.remove(ORDEM / 2));
            }
        }
        pai.chaves.add(indiceFilho, filho.chaves.get(ORDEM / 2 - 1));
        pai.filhos.add(indiceFilho + 1, novoNo);
    }

    public void remover(T chave) {
        removerNaArvore(this.raiz, chave);
    }

    private void removerNaArvore(No<T> no, T chave) {
        // Implemente a remoção aqui
    }

    private void fundirNos(No<T> pai, int indiceFilho) {
        // Implemente a fusão de nós aqui
    }

    // Outros métodos necessários

    public static void main(String[] args) {
        Alg25<Integer> arvore = new Alg25<>(); // Exemplo de ordem 3
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(25);
        arvore.remover(15); // Exemplo de remoção
        // Imprimir árvore ou realizar outras operações para testar
    }
}
