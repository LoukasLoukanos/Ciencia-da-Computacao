/* Algoritmo da Estrutura de dados linear dinâmica (não estática) Alg13 de 
Lista Duplamente Ligada, também conhecida como Lista Duplamente Encadeada */

public class Alg13 {
    private Nodo cabeca;
    private Nodo cauda;
    private int tamanho;

    private class Nodo {
        int dado;
        Nodo proximo;
        Nodo anterior;

        public Nodo(int dado) {
            this.dado = dado;
            this.proximo = null;
            this.anterior = null;
        }
    }

    public Alg13() {
        cabeca = null;
        cauda = null;
        tamanho = 0;
    }

    // Inserir um elemento no final da lista
    public void addList(int dado) {
        Nodo novoNodo = new Nodo(dado);
        if (cabeca == null) {
            cabeca = novoNodo;
            cauda = novoNodo;
        } else {
            novoNodo.anterior = cauda;
            cauda.proximo = novoNodo;
            cauda = novoNodo;
        }
        tamanho++;
    }

    // Remover um elemento da lista
    public void removeList(int dado) {
        Nodo atual = cabeca;
        while (atual != null) {
            if (atual.dado == dado) {
                if (atual == cabeca) {
                    cabeca = atual.proximo;
                    if (cabeca != null) {
                        cabeca.anterior = null;
                    }
                } else if (atual == cauda) {
                    cauda = atual.anterior;
                    if (cauda != null) {
                        cauda.proximo = null;
                    }
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
                tamanho--;
                return;
            }
            atual = atual.proximo;
        }
    }

    // Exibir os elementos da lista
    public void showList() {
        Nodo atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Alg13 lista = new Alg13();
        lista.addList(1);
        lista.addList(2);
        lista.addList(3);
        lista.showList();

        lista.removeList(2);
        lista.showList();
    }
}
