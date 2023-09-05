/* Estrutura de dados linear de um array (de regra de acesso FIFO) unidimensional (vetor) de tipo genérico */

import java.util.Scanner;

public class Alg01<T> {
    private T[] elementos;
    Scanner sc = new Scanner(System.in);

    public Alg01(T[] elementos) {
        this.elementos = elementos;

        System.out.print("Tamanho: ");
        int tamanho = sc.nextInt();
        assert (tamanho > 0) : "O tamanho do Vetor precisa ser maior que zero!";

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
                    Alg01<T> vetor = new Alg01<T>(this.elementos);
                    System.out.printf("Vetor do tipo de dados %s de %d células alocadas.\n", tipo, tamanho);
                } catch (ClassNotFoundException e) {
                    System.out.println("Tipo de dado inválido!");
                }
            } else {
                System.out.println("Tipo de dado inválido!");
            }
        } else if (tipo_de_dado.equals("np")) {
            this.elementos = (T[]) new String[tamanho];
            Alg01<T> vetor = new Alg01<T>(this.elementos);
            System.out.printf("Vetor do tipo de dados String de %d células alocadas.\n", tamanho);
        } else {
            System.out.println("Tipo de dado inválido!");
        }
    }

    public void inserir(int indice, T valor) {
        this.elementos[indice] = valor;
    }

    public T valor(int indice) {
        return this.elementos[indice];
    }

    public static void main(String[] args) {
        // Código adicional, se necessário
    }
}
