/*
♦ Algoritmo 12: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada): Linked List (Lista Ligada).
*/

public class Alg12<T> {

    private Nodo<T> primeiro;
    private int tamanho;

    public Alg12() {
        primeiro = null;
        tamanho = 0;
    }

    public void addList(T valor) {
        Nodo<T> novoNodo = new Nodo<>(valor);
        novoNodo.setProximo(primeiro);
        primeiro = novoNodo;
        tamanho++;
    }

    public void removeList(T valor) {
        if (primeiro == null) {
            return;
        }

        if (primeiro.getValor().equals(valor)) {
            primeiro = primeiro.getProximo();
            tamanho--;
            return;
        }

        Nodo<T> nodoAtual = primeiro;
        while (nodoAtual.getProximo() != null) {
            if (nodoAtual.getProximo().getValor().equals(valor)) {
                nodoAtual.setProximo(nodoAtual.getProximo().getProximo());
                tamanho--;
                return;
            }
            nodoAtual = nodoAtual.getProximo();
        }
    }

    public int size() {
        return tamanho;
    }

    public void showList() {
        Nodo<T> nodoAtual = primeiro;
        while (nodoAtual != null) {
            System.out.print(nodoAtual.getValor() + " ");
            nodoAtual = nodoAtual.getProximo();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Alg12<Integer> lista = new Alg12<>();
        lista.addList(10);
        lista.addList(20);
        lista.addList(30);

        System.out.println("Tamanho da lista: " + lista.size());
        System.out.print("Elementos da lista: ");
        lista.showList();

        lista.removeList(20);

        System.out.println("Tamanho da lista após remoção: " + lista.size());
        System.out.print("Elementos da lista após remoção: ");
        lista.showList();
    }
}

class Nodo<T> {
    private T valor;
    private Nodo<T> proximo;

    public Nodo(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public T getValor() {
        return valor;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }
}
