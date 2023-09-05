/* Algoritmo da Estrutura de dados linear dinâmica (não estática) 
   Alg14 de Fila (regra de acesso FIFO) Dinâmica */

public class Alg14<T> {
    private Nodo cabeca;
    private Nodo cauda;
    private int tamanho;

    private class Nodo {
        T dado;
        Nodo proximo;

        public Nodo(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    public Alg14() {
        cabeca = null;
        cauda = null;
        tamanho = 0;
    }

    // Verificar se a fila está vazia
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Adicionar elementos à fila (enqueue)
    public void enqueue(T dado) {
        Nodo novoNodo = new Nodo(dado);
        if (isEmpty()) {
            cabeca = novoNodo;
            cauda = novoNodo;
        } else {
            cauda.proximo = novoNodo;
            cauda = novoNodo;
        }
        tamanho++;
    }

    // Remover o elemento da frente da fila (dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        T dadoRemovido = cabeca.dado;
        cabeca = cabeca.proximo;
        tamanho--;

        if (isEmpty()) {
            cauda = null;
        }

        return dadoRemovido;
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

        return cabeca.dado;
    }

    // Mostrar elementos da fila
    public void showQueue() {
        Nodo atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Alg14<Integer> fila = new Alg14<>();
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
