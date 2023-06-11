/* Estrutura de dados linear de uma fila (de regra de acesso FIFO) circular/não-circular estática genérica utilizando um array unidimensional (vetor)

Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.
Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços livres, caso haja, no início da fila.

Métodos:
 isEmpty - verificar se a fila está vazia; 
 isFull - verificar se a fila está cheia;
 size - obter o tamanho atual da fila.
 front - acessar o elemento da frente da fila sem removê-lo; 
 enqueue - adicionar elementos;
 dequeue - remover o elemento da frente da fila;
*/

public class Alg02<T> {
    private T[] elementos;
    private int tamanho;
    private int capacidade;
    private int inicio;
    private int fim;

    public Alg02(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
        this.inicio = 0;
        this.fim = -1;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public void enqueue(T elemento) {
        if (isFull()) {
            System.out.println("A fila está cheia. Não é possível adicionar mais elementos.");
            return;
        }

        fim = (fim + 1) % capacidade;
        elementos[fim] = elemento;
        tamanho++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia. Não é possível remover elementos.");
            return null;
        }

        T elementoRemovido = elementos[inicio];
        elementos[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elementoRemovido;
    }

    public T front() {
        if (isEmpty()) {
            System.out.println("A fila está vazia. Não há elementos para retornar.");
            return null;
        }

        return elementos[inicio];
    }

    public int size() {
        return tamanho;
    }

    public static void main(String[] args) {
        Alg02<Integer> fila = new Alg02<>(5);
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        System.out.println("Tamanho da fila: " + fila.size()); // Saída: 3
        System.out.println("Elemento na frente da fila: " + fila.front()); // Saída: 10
        System.out.println("Removendo elemento da fila: " + fila.dequeue()); // Saída: 10
        System.out.println("Tamanho da fila após remoção: " + fila.size()); // Saída: 2
    }
}
