/*
♦ Algoritmo 02: Estrutura de Dados Linear Estática de Fila Circular e Não-Circular: Queue (Fila).

obs: Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços 
    livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.

obs: Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços 
    livres, caso haja, no início da fila.
*/

public class Alg02<T> {
    private int capacidade;
    private Object[] elementos;
    private int tamanho;
    private int frente;
    private int traseira;

    public Alg02(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
        this.frente = 0;
        this.traseira = -1;
    }

    // Verificar se a fila está vazia
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Verificar se a fila está cheia
    public boolean isFull() {
        return tamanho == capacidade;
    }

    // Adicionar elementos à fila (enqueue)
    public void enqueue(T elemento) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia");
        }

        traseira = (traseira + 1) % capacidade;
        elementos[traseira] = elemento;
        tamanho++;
    }

    // Remover o elemento da frente da fila (dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        T elementoRemovido = (T) elementos[frente];
        elementos[frente] = null;
        frente = (frente + 1) % capacidade;
        tamanho--;

        return elementoRemovido;
    }

    // Obter o tamanho atual da fila
    public int size() {
        return tamanho;
    }

    // Acessar o elemento da frente da fila sem removê-lo
    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        return (T) elementos[frente];
    }

    // Mostrar elementos da fila
    public void showQueue() {
        int index = frente;
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[index] + " ");
            index = (index + 1) % capacidade;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Alg02<Integer> fila = new Alg02<>(5);
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        fila.showQueue();

        System.out.println("Frente da fila: " + fila.front());
        System.out.println("Tamanho da fila: " + fila.size());

        fila.dequeue();
        fila.showQueue();
    }
}
