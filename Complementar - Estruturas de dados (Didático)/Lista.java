import java.util.Scanner;

public class Lista<T> {
    private T[] elementos;
    Scanner sc = new Scanner(System.in);

    public Lista(T[] elementos) {
        this.elementos = elementos;

        System.out.print("Tamanho: ");
        int tamanho = sc.nextInt();
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
                    this.elementos = (T[]) Array.newInstance(clazz, tamanho);
                    Lista<T> lista = new Lista<T>(this.elementos);
                    System.out.printf("Lista do tipo de dados %s de %d células alocadas.\n", tipo, tamanho);
                } catch (ClassNotFoundException e) {
                    System.out.println("Tipo de dado inválido!");
                }
            } else {
                System.out.println("Tipo de dado inválido!");
            }
        } else if (tipo_de_dado.equals("np")) {
            this.elementos = (T[]) new String[tamanho];
            Lista<T> lista = new Lista<T>(this.elementos);
            System.out.printf("Lista do tipo de dados String de %d células alocadas.\n", tamanho);
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

    /*↓ Considerando uma lista doi tipo int → (modificar para aceitar todos os tipos) ↓*/
    public T operacoes(T[] elementos) {
    	System.out.println("Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
        sc.nextLine();
        String operacao = sc.nextLine();
        while (operacao != "q") {
            if (operacao == "s") {
                try {
                    int valor = elementos[0];
                    for (int i = 1; i < elementos.length; i++) {
                        System.out.println(elementos + "[" + i + "] = " + elementos[i]);
                        valor = valor + elementos[i];
                    }
                    System.out.println("Soma: " + valor);
                } catch (Exception e) {
                    System.out.println("Lista de tipo de dados inválido para esta operação.");
                }
            } else if (operacao == "b") {
                System.out.print("Digite o valor a ser buscado o índice: ");
                sc.nextLine();
                int x = sc.nextInt();
                int count = 0;
                for (int i = 0; i < elementos.length; i++) {
                    if (elementos[i] == x) {
                        System.out.println("O índice" + i + " contém o valor " + x);
                    }
                    count++;
                }
                if (count == 0) {
                    System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
                }
            } else if (operacao == "ri") {
                System.out.print("Digite o índice da célula a ser removida: ");
                sc.nextLine();
                int indice = sc.nextInt();
                int valor_indice = elementos[indice];
                for (int j = indice + 1; j < elementos.length; j++) {
                    elementos[j - 1] = elementos[j];
                }
                System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
            } else if (operacao == "rv") {
                System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
                sc.nextLine();
                int x = sc.nextInt();
                int count = 0;
                for (int i = 0; i < elementos.length; i++) {
                    if (elementos[i] == x) {
                        int valor_indice = elementos[i];
                        for (int j = i + 1; j < elementos.length; j++) {
                            elementos[j - 1] = elementos[j];
                        }
                        System.out.println("Valor " + valor_indice + "da célula de índice" + i + "removido.");
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Não há índice a ser removido, pois não há nenhuma célula com o valor" + x);
                }
            } else if (operacao == "i") {
                System.out.print("Digite o valor a ser inserido:");
                sc.nextLine();
                int valor = sc.nextInt();
                System.out.print("Digite o índice no qual será inserido o valor:");
                sc.nextLine();
                int indice = sc.nextInt();

                lista.inserir(indice, valor);

                System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
            }

            System.out.println("Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
            sc.nextLine();
            String novaoperacao = sc.nextLine();
            operacao = novaoperacao;
        }
    }

    public static void main(String[] args) {
        // Código adicional, se necessário
    }
    
}
