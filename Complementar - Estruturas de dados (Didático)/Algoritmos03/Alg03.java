/* Algoritmo da Estrutura de dados linear estática (não dinâmica) genérica de 
 uma pilha (de regra de acesso LIFO) utilizando um array unidimensional (vetor)
 
Métodos:
 isEmpty - verificar se a pilha está vazia; 
 isFull - verificar se a pilha está cheia;
 push - inserir elementos no topo da pilha;
 pop - remover elementos do dopo da pilha;
 size - obter o tamanho atual da pilha;
 front - acessar o elemento do topo da pilha sem removê-lo;
 showStack - mostar elementos da pilha (do topo para base).
*/

public class Alg03<T> {
    private int tamanhoMaximo;
    private int topo;
    private T[] elementos;

    public Alg03(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.topo = -1;
        this.elementos = (T[]) new Object[tamanhoMaximo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == tamanhoMaximo - 1;
    }

    public void push(T elemento) {
        if (isFull()) {
            System.out.println("A pilha está cheia. Não é possível empilhar o elemento.");
            return;
        }
        topo++;
        elementos[topo] = elemento;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia. Não é possível desempilhar um elemento.");
            return null;
        }
        T elemento = elementos[topo];
        topo--;
        return elemento;
    }

    public T front() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia. Não há elemento no topo.");
            return null;
        }
        return elementos[topo];
    }

    public int size() {
        return topo + 1;
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
            return;
        }
        System.out.println("Elementos da pilha (do topo para base):");
        for (int i = topo; i >= 0; i--) {
            System.out.println(elementos[i]);
        }
    }

    public static void main(String[] args) {
        Alg03<Integer> pilha = new Alg03<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Tamanho da pilha: " + pilha.size());
        System.out.println("Elemento no topo: " + pilha.front());

        pilha.pop();

        System.out.println("Tamanho da pilha: " + pilha.size());
        System.out.println("Elemento no topo: " + pilha.front());

        pilha.showStack();
    }
}
