import java.util.Scanner;

public class Lista<T> {
    private int tamanho;
    private T[] elementos;

    public static void main(String[] args) {
        // Código adicional, se necessário
    }

    public Lista(T[] elementos) {
        this.elementos = elementos;
    }

    public void set(int indice, T elemento) {
        elementos[indice] = elemento;
    }

    public T get(int indice) {
        return elementos[indice];
    }

    public void Aloca() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamanho: ");
        this.tamanho = sc.nextInt();
        assert (tamanho > 0) : "O tamanho da lista precisa ser maior que zero!";

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
                    elementos = (T[]) Array.newInstance(clazz, tamanho);
                    Lista<T> lista = new Lista<T>(elementos);
                    System.out.printf("Lista do tipo de dados %s de %d células alocadas.\n", tipo, tamanho);
                } catch (ClassNotFoundException e) {
                    System.out.println("Tipo de dado inválido!");
                }
            } else {
                System.out.println("Tipo de dado inválido!");
            }
        } else if (tipo_de_dado.equals("np")) {
            elementos = (T[]) new String[tamanho];
            Lista<T> lista = new Lista<T>(elementos);
            System.out.printf("Lista do tipo de dados String de %d células alocadas.\n", tamanho);
        } else {
            System.out.println("Tipo de dado inválido!");
        }
    }
}
