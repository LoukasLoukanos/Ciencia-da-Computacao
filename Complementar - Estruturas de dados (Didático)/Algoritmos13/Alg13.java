/*
♦ Algoritmo 13: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada de tipo de dados genérico.
→ Operações:
    • addList: inserção em uma Lista Duplamente Ligada;
    • removeList: remoção em uma Lista Duplamente Ligada;
    • size - obter o tamanho atual da Lista Duplamente Ligada;
    • showList: exibição dos elementos da Lista Duplamente Ligada.
*/

public class Alg13<T> {
    private Nodo<T> primeiro;
    private Nodo<T> ultimo;
    private int tamanho;

    public Alg13() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void addList(T valor) {
        Nodo<T> novoNodo = new Nodo<>(valor);
        if (primeiro == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            novoNodo.setAnterior(ultimo);
            ultimo.setProximo(novoNodo);
            ultimo = novoNodo;
        }
        tamanho++;
    }

    public void removeList(T valor) {
        Nodo<T> nodoAtual = primeiro;
        while (nodoAtual != null) {
            if (nodoAtual.getValor().equals(valor)) {
                if (nodoAtual == primeiro) {
                    primeiro = nodoAtual.getProximo();
                    if (primeiro != null) {
                        primeiro.setAnterior(null);
                    }
                } else if (nodoAtual == ultimo) {
                    ultimo = nodoAtual.getAnterior();
                    if (ultimo != null) {
                        ultimo.setProximo(null);
                    }
                } else {
                    Nodo<T> anterior = nodoAtual.getAnterior();
                    Nodo<T> proximo = nodoAtual.getProximo();
                    anterior.setProximo(proximo);
                    proximo.setAnterior(anterior);
                }
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
        Alg13<Integer> lista = new Alg13<>();
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
    private Nodo<T> anterior;
    private Nodo<T> proximo;

    public Nodo(T valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }

    public T getValor() {
        return valor;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }
}
