import java.util.Scanner; // importação da classe Scanner do pacote java.util

public class Lista<T> {
    public Scanner sc = new Scanner(System.in);
	private int tamanho;
	private String tipo_de_dado;
	private String tipo;
	private T[] elementos;

	public static void main () {
		
	}

    public Lista(T[] elementos) {
        this.elementos = elementos;
    }
    
    public T get(int indice) {
        return elementos[indice];
    }
    
    public void set(int indice, T elemento) {
        elementos[indice] = elemento;
    }
	
	public void Aloca() {
		System.out.print("Tamanho: ");
		this.tamanho = sc.nextInt();
		assert (tamanho > 0) : "O tamanho da lista precisa ser maior que zero!";

		System.out.print("Tipo de dados: digite 'p' para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' para não primitivos → [string] ...");
		sc.nextLine();
		this.tipo_de_dado = sc.nextLine();
		assert (tipo_de_dado == "p" || tipo_de_dado == "np") : "Aceita-se 'p' ou 'np' como parâmetro!";

		if (tipo_de_dado == "p") {
			System.out.print("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ");
			sc.nextLine();
			this.tipo = sc.nextLine();

			if (tipo == "byte") {
				Byte elementos[] = new Byte[tamanho];
	    		Lista<Byte> lista = new Lista<Byte>(elementos);
				System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
			} else if (tipo == "short") {

			} else if (tipo == "int") {

			} else if (tipo == "long") {

			} else if (tipo == "float") {

			} else if (tipo == "double") {

			} else if (tipo == "char") {

			} else if (tipo == "boolean") {

			}
		} else if (tipo_de_dado == "np") {

		}
	}
	public void Define(int indice) {
        // ___↓ operações ↓_________
    }
}
