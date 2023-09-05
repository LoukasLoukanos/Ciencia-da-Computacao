/* Algoritmo da Estrutura de dados linear dinâmica (não estática) 
ListaLigada de Lista Ligada, também conhecida como Lista Encadeada */

public class Alg12 {
    private No cabeca;

    private class No {
        int dado;
        No proximo;

        public No(int dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    public Alg12() {
        this.cabeca = null;
    }

    // Adicionar um elemento no final da lista
    public void addList(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    // Remover um elemento da lista
    public void removeList(int dado) {
        if (cabeca == null) {
            return;
        }

        if (cabeca.dado == dado) {
            cabeca = cabeca.proximo;
            return;
        }

        No atual = cabeca;
        No anterior = null;
        while (atual != null && atual.dado != dado) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual == null) {
            return;
        }

        anterior.proximo = atual.proximo;
    }

    // Imprimir a lista
    public void showList() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Alg12 lista = new Alg12();
        lista.addList(1);
        lista.addList(2);
        lista.addList(3);
        lista.showList();

        lista.removeList(2);
        lista.showList();
    }
}
