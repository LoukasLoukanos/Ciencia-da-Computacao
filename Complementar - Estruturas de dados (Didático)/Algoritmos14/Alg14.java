/*
♦ Algoritmo 14: Estrutura de Dados Linear Dinâmica (não Estática) de Fila (regra de acesso FIFO) de tipo de dados genérico.
→ Operações:
    • isEmpty - verificar se a fila está vazia;
    • enqueue - adicionar elementos;
    • dequeue - remover o elemento da frente da fila;
    • size - obter o tamanho atual da fila;
    • front - acessar o elemento da frente da fila sem removê-lo;
    • showQueue - mostar elementos da fila.
*/

import java.util.LinkedList;
import java.util.Queue;

public class Alg14<T> {
    private Queue<T> fila;

    public Alg14() {
        fila = new LinkedList<>();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public void enqueue(T elemento) {
        fila.add(elemento);
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        fila.poll();
    }

    public int size() {
        return fila.size();
    }

    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return fila.peek();
    }

    public void showQueue() {
        for (T elemento : fila) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Alg14<Integer> fila = new Alg14<>();

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        fila.showQueue();

        System.out.println("Tamanho da fila: " + fila.size());
        System.out.println("Frente da fila: " + fila.front());

        fila.dequeue();
        fila.showQueue();
    }
}
