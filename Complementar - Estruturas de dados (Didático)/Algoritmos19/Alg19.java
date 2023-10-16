/*
♦ Algoritmo 19: Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 12: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada) de tipo de dados genérico].
→ Operações:
    • Busca de um valor em uma Lista Ligada Simples;
    • Identificar o menor valor em uma Lista Ligada Simples;
    • Identificar o maior valor em uma Lista Ligada Simples;
    • Retornar o sucessor de um valor em uma Lista Ligada Simples;
    • Retornar o predecessor de um valor em uma Lista Ligada Simples.
*/
public class Alg19<T extends Comparable<T>> {

    private Node<T> head;
    private int size;

    public Alg19() {
        head = null;
        size = 0;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void remove(T value) {
        if (head == null) {
            return;
        }

        if (head.getValue().equals(value)) {
            head = head.getNext();
            size--;
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                prev.setNext(current.getNext());
                size--;
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public int size() {
        return size;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public boolean search(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true; // Valor encontrado
            }
            current = current.getNext();
        }
        return false; // Valor não encontrado
    }

    public T findMinimum() {
        if (head == null) {
            return null;
        }
        Node<T> current = head;
        T min = current.getValue();
        while (current != null) {
            if (current.getValue().compareTo(min) < 0) {
                min = current.getValue();
            }
            current = current.getNext();
        }
        return min;
    }

    public T findMaximum() {
        if (head == null) {
            return null;
        }
        Node<T> current = head;
        T max = current.getValue();
        while (current != null) {
            if (current.getValue().compareTo(max) > 0) {
                max = current.getValue();
            }
            current = current.getNext();
        }
        return max;
    }

    public T getSuccessor(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current.getNext() != null) {
                    return current.getNext().getValue();
                }
                break; // Último elemento, não há sucessor
            }
            current = current.getNext();
        }
        return null; // Valor não encontrado ou é o último
    }

    public T getPredecessor(T value) {
        if (head == null || head.getValue().equals(value)) {
            return null; // Valor não encontrado ou é o primeiro
        }

        Node<T> current = head;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null; // Valor não encontrado
    }

    public static void main(String[] args) {
        Alg19<Integer> list = new Alg19<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        System.out.println("Tamanho da lista: " + list.size());
        System.out.print("Elementos da lista: ");
        list.display();

        System.out.println("Buscar 20: " + list.search(20));
        System.out.println("Menor valor: " + list.findMinimum());
        System.out.println("Maior valor: " + list.findMaximum());
        System.out.println("Sucessor de 20: " + list.getSuccessor(20));
        System.out.println("Predecessor de 20: " + list.getPredecessor(20));

        list.remove(20);

        System.out.println("Tamanho da lista após remoção: " + list.size());
        System.out.print("Elementos da lista após remoção: ");
        list.display();
    }
}

class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
