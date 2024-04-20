/*
♦ Algoritmo 03: Estrutura de Dados Linear Estática (não Dinâmica) de Pilha: Stack (Pilha).
*/

public class Alg03<T> {
    private int capacidade;
    private Object[] elementos;
    private int topo;

    public Alg03(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Object[capacidade];
        this.topo = -1;
    }

    // Verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Verificar se a pilha está cheia
    public boolean isFull() {
        return topo == capacidade - 1;
    }

    // Inserir elementos no topo da pilha
    public void push(T elemento) {
        if (isFull()) {
            throw new IllegalStateException("A pilha está cheia");
        }

        topo++;
        elementos[topo] = elemento;
    }

    // Remover elementos do topo da pilha
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }

        T elementoRemovido = (T) elementos[topo];
        elementos[topo] = null;
        topo--;

        return elementoRemovido;
    }

    // Obter o tamanho atual da pilha
    public int size() {
        return topo + 1;
    }

    // Acessar o elemento do topo da pilha sem removê-lo
    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }

        return (T) elementos[topo];
    }

    // Mostrar elementos da pilha (do topo para base)
    public void showStack() {
        for (int i = topo; i >= 0; i--) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Alg03<Integer> pilha = new Alg03<>(5);
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);

        pilha.showStack();

        System.out.println("Topo da pilha: " + pilha.front());
        System.out.println("Tamanho da pilha: " + pilha.size());

        pilha.pop();
        pilha.showStack();
    }
}
