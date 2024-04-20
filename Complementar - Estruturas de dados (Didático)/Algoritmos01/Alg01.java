/*
♦ Algoritmo 01: Implementação de um array unidimensional (vetor) de tipo genérico para dados primitivos de estrutura homogênea.
*/

import java.lang.reflect.Array;
import java.util.Scanner;

public class Alg01<T> {
    private T[] elementos;
    private int tamanho;
    private int tamanhoAtual;
    Scanner sc = new Scanner(System.in);

    public Alg01(T[] elementos) {
        this.elementos = elementos;
        this.tamanhoAtual = 0;

        System.out.print("Tamanho: ");
        tamanho = sc.nextInt();
        assert (tamanho > 0) : "O tamanho do Vetor precisa ser maior que zero!";
        this.elementos = (T[]) new Object[tamanho];

        System.out.print("Tipo de dados: digite 'p' para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' para não primitivos → [string] ...");
        sc.nextLine();
        String tipo_de_dado = sc.nextLine();
        assert (tipo_de_dado.equals("p") || tipo_de_dado.equals("np")) : "Aceita-se 'p' ou 'np' como parâmetro!";

        if (tipo_de_dado.equals("p")) {
            System.out.print("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ");
            String tipo = sc.nextLine();

            if (tipo.equals("byte") || tipo.equals("short") || tipo.equals("int") || tipo.equals("long") ||
                    tipo.equals("float") || tipo.equals("double") || tipo.equals("char") || tipo.equals("boolean")) {
                try {
                    Class<?> clazz = Class.forName("java.lang." + tipo.substring(0, 1).toUpperCase() + tipo.substring(1));
                    this.elementos = (T[]) Array.newInstance(clazz, tamanho);
                    System.out.printf("Vetor do tipo de dados %s de %d células alocadas.\n", tipo, tamanho);
                } catch (ClassNotFoundException e) {
                    System.out.println("Tipo de dado inválido!");
                }
            } else {
                System.out.println("Tipo de dado inválido!");
            }
        } else if (tipo_de_dado.equals("np")) {
            this.elementos = (T[]) new String[tamanho];
            System.out.printf("Vetor do tipo de dados String de %d células alocadas.\n", tamanho);
        } else {
            System.out.println("Tipo de dado inválido!");
        }
    }

    public boolean isEmpty() {
        return tamanhoAtual == 0;
    }

    public boolean isFull() {
        return tamanhoAtual == tamanho;
    }

    public void addElement(int indice, T valor) {
        if (indice < 0 || indice >= tamanho) {
            throw new IllegalArgumentException("Índice fora dos limites do vetor.");
        }

        if (isFull()) {
            throw new IllegalStateException("O vetor está cheio.");
        }

        elementos[indice] = valor;
        tamanhoAtual++;
    }

    public void removeElement(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IllegalArgumentException("Índice fora dos limites do vetor.");
        }

        if (isEmpty()) {
            throw new IllegalStateException("O vetor está vazio.");
        }

        elementos[indice] = null;
        tamanhoAtual--;
    }

    public int sizeArray() {
        return tamanhoAtual;
    }

    public T accessElement(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IllegalArgumentException("Índice fora dos limites do vetor.");
        }

        if (isEmpty()) {
            throw new IllegalStateException("O vetor está vazio.");
        }

        return elementos[indice];
    }

    public void showQueue() {
        for (T elemento : elementos) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Exemplo de criação de um vetor de inteiros
        Alg01<Integer> vetorInt = new Alg01<>(new Integer[10]);
    
        // Verificar se o vetor está vazio
        System.out.println("O vetor está vazio? " + vetorInt.isEmpty());
    
        // Adicionar elementos
        vetorInt.addElement(0, 10);
        vetorInt.addElement(1, 20);
        vetorInt.addElement(2, 30);
    
        // Verificar o tamanho atual do vetor
        System.out.println("Tamanho atual do vetor: " + vetorInt.sizeArray());
    
        // Acessar um elemento
        System.out.println("Elemento no índice 1: " + vetorInt.accessElement(1));
    
        // Remover um elemento
        vetorInt.removeElement(1);
    
        // Verificar se o vetor está vazio novamente
        System.out.println("O vetor está vazio? " + vetorInt.isEmpty());
    
        // Verificar se o vetor está cheio
        System.out.println("O vetor está cheio? " + vetorInt.isFull());
    
        // Mostrar todos os elementos
        System.out.print("Elementos do vetor: ");
        vetorInt.showQueue();
    }
    
}
