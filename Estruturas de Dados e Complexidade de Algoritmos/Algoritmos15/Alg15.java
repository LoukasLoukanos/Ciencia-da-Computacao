/*
♦ Algoritmo 15: Estrutura de Dados Linear Dinâmica (não Estática) de Pilha: Stack (Pilha).
*/

import java.util.LinkedList;

public class Alg15<T> {
    private LinkedList<T> pilha;

    public Alg15() {
        pilha = new LinkedList<>();
    }

    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    public void push(T elemento) {
        pilha.addFirst(elemento);
    }

    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        pilha.removeFirst();
    }

    public int size() {
        return pilha.size();
    }

    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return pilha.getFirst();
    }

    public void showStack() {
        for (T elemento : pilha) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Alg15<Integer> pilha = new Alg15<>();

        pilha.push(1);
        pilha.push(2);
        pilha.push(3);

        pilha.showStack();

        System.out.println("Tamanho da pilha: " + pilha.size());
        System.out.println("Topo da pilha: " + pilha.front());

        pilha.pop();
        pilha.showStack();
    }
}
