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
	
	/*
	public T[] tipo_alocado (T tamanho) {
		T elementos[] = new T[tamanho];
	    Lista<T> lista = new Lista<T>(elementos);
		System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
	}
	*/
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
				Short elementos[] = new Short[tamanho];
	    		Lista<Short> lista = new Lista<Short>(elementos);
				System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
			} else if (tipo == "int") {
				Integer elementos[] = new Integer[tamanho];
	    		Lista<Integer> lista = new Lista<Integer>(elementos);
				System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
			} else if (tipo == "long") {
				Long elementos[] = new Long[tamanho];
	    		Lista<Long> lista = new Lista<Long>(elementos);
				System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
			} else if (tipo == "float") {
				Float elementos[] = new Float[tamanho];
	    		Lista<Float> lista = new Lista<Float>(elementos);
				System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
			} else if (tipo == "double") {
				Double elementos[] = new Double[tamanho];
	    		Lista<Double> lista = new Lista<Double>(elementos);
				System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
			} else if (tipo == "char") {
				Character elementos[] = new Character[tamanho];
	    		Lista<Character> lista = new Lista<Character>(elementos);
				System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
			} else if (tipo == "boolean") {
				Boolean elementos[] = new Boolean[tamanho];
	    		Lista<Boolean> lista = new Lista<Boolean>(elementos);
				System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
			}
		} else if (tipo_de_dado == "np") {
			String elementos[] = new String[tamanho];
	    	Lista<String> lista = new Lista<String>(elementos);
			System.out.printf("Lista do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
		}
	}
	public void Define(int indice) {
        // ___↓ operações ↓_________
    }
}
