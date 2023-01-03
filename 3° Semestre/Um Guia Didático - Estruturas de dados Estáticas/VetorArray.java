import java.sql.Array;
import java.util.Scanner; // importação da classe Scanner do pacote java.util

//Declaração, alocação e operações — de forma estática na memória — de Vetor (ou Array) de estrutura de dados primitivos, do mesmo tipo (estrutura homogênea), ou não primitivos:
public class VetorArray {

	public VetorArray () {
		Scanner sc = new Scanner(System.in);
        
		System.out.print("Tamanho: ");
		int tamanho = sc.nextInt();
		assert(tamanho>0): "O tamanho do vetor precisa ser maior que zero";

		System.out.print("Tipo de dados: digite 'p' (para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' (para não primitivos → [string] ...");
		String tipo_de_dado = sc.nextLine();
		assert(tipo_de_dado == "p" || tipo_de_dado == "np"): "Aceita-se 'p' ou 'np' como parâmetro";
		
		if (tipo_de_dado == "p") {
			System.out.print("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ");
        	String tipo = sc.nextLine();

			if (tipo == "byte") {
				//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
				byte array[] = new byte[tamanho];
				System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
				
				for (int i = 0; i < array.length; i++) {
					System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
					array[i] = sc.nextByte();
					if (i == array.length - 1) {
						System.out.print("Arranjo definido, todas as células foram preenchidas.");
					}
				}
			} else if (tipo == "short") {
				//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
				short array[] = new short[tamanho];
				System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

				for (int i = 0; i < array.length; i++) {
					System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
					array[i] = sc.nextShort();
					if (i == array.length - 1) {
						System.out.print("Arranjo definido, todas as células foram preenchidas.");
					}
				}
			} else if (tipo == "int") {
				//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
				int array[] = new int[tamanho];
				System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

				for (int i = 0; i < array.length; i++) {
					System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
					array[i] = sc.nextInt();
					if (i == array.length - 1) {
						System.out.print("Arranjo definido, todas as células foram preenchidas.");
					}
				}
			} else if (tipo == "long") {
				//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
				long array[] = new long[tamanho];
				System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

				for (int i = 0; i < array.length; i++) {
					System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
					array[i] = sc.nextLong();
					if (i == array.length - 1) {
						System.out.print("Arranjo definido, todas as células foram preenchidas.");
					}
				}
			} else if (tipo == "float") {
				//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
				float array[] = new float[tamanho];
				System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

				for (int i = 0; i < array.length; i++) {
					System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
					array[i] = sc.nextFloat();
					if (i == array.length - 1) {
						System.out.print("Arranjo definido, todas as células foram preenchidas.");
					}
				}
			} else if (tipo == "double") {
				//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
				double array[] = new double[tamanho];
				System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

				for (int i = 0; i < array.length; i++) {
					System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
					array[i] = sc.nextDouble();
					if (i == array.length - 1) {
						System.out.print("Arranjo definido, todas as células foram preenchidas.");
					}
				}
			} else if (tipo == "char") {
				//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
				char array[] = new char[tamanho];
				System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

				for (int i = 0; i < array.length; i++) {
					System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
					array[i] = sc.next().charAt(0);
					if (i == array.length - 1) {
						System.out.print("Arranjo definido, todas as células foram preenchidas.");
					}
				}
			} else if (tipo == "boolean") {
				//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
				boolean array[] = new boolean[tamanho];
				System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

				for (int i = 0; i < array.length; i++) {
					System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
					array[i] = sc.nextBoolean();
					if (i == array.length - 1) {
						System.out.print("Arranjo definido, todas as células foram preenchidas.");
					}
				}
			}
		} else if (tipo_de_dado == "np") {
			//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
			String array[] = new String[tamanho];
			System.out.printf("Vetor do tipo de dados string de ", tamanho, " células alocado.");

			for (int i = 0; i < array.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo string:");
				array[i] = sc.nextLine();
				if (i == array.length - 1) {
					System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
		}

		sc.close();
	}

	public static void main(String[] args) {
		//Exemplos de uso dos métodos
		somaCelulas (array);
		
		float valor_para_busca = 1.618;
		indice_retornado = buscaIndice (valor_para_busca, array); //buscou o índice do valor 1,618
		indice_removido = removeIndice (indice_retornado, array); //removeu esse índice, ou seja, removeu o próprio valor 1,618
		
		valor_para_remocao = valor_para_busca;
		valor_removido = removeValor (valor_para_remocao, array); //removeu o valr 1,618 sem precisar buscar o índice (o preocedimendo fez isso)
		arraynsereValor (valor_removido, indice_retornado, array); //insere novamente o valor 1,618 que foi removido
	}
	
	// Subrotina procedimento
	// Soma os valores das células de um vetor
	public static void somaCelulas(int array[]) {
		int soma = 0;
		try {
			for (int i = 0; i < array.length; i++) {
				System.out.println(array + "[" + i + "] = " + array[i]);
				soma += array[i];
			}
			System.out.println("Soma: " + soma);
		} catch (Exception e) {
			System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
		}
	}

	// Subrotina função
	// Busca o índice i de um valor x em um vetor
	public static int buscaIndice(int x, tipo array[]) {
		for (int i = 0; i < nome.length; i++) {
			if (array[i] == x) {
				System.out.println("O índice procurado do valor " + x + " é " + i);
				return i;
			} else {
				System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor" + x);
			}
		}
	}

	// Subrotina função
	// Remove o índice i de um vetor
	public static tipo removeIndice(int i, tipo array[]) {
		int valor_indice = array[i];
		for (int j = i + 1; j < array.length; j++) {
			array[j - 1] = array[j];
		}
		System.out.println("Valor " + valor_indice + "da célula de índice" + i + "removido.");
		return valor_indice;
	}

	// Subrotina procedimento (chama subrotinas funções)
	// Remove o valor x em qualquer indice i que for encontrado em um vetor
	public static void removeValor(int x, tipo array[]) {
		i = buscaIndice(x, array);
		x = removeIndice(i, array);
		System.out.println("Valor " + x + "da célula de índice" + i + "removido.");
	}

	// Subrotina procedimento
	// Insere o valor x no índice i de um vetor
	public static void insereValor(int x, int i, tipo array[]) {
		for (int j = array.length - 1; j > i; j--) {
			array[j] = array[j - 1];
		}
		array[i] = x;
		System.out.println("Valor " + x + "inserido na célula de índice" + i);
	}
}
