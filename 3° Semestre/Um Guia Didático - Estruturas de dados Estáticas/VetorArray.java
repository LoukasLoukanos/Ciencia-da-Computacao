import java.util.Scanner; // importação da classe Scanner do pacote java.util

//Declaração, alocação e operações — de forma estática na memória — de Vetor/Array de estrutura de dados primitivos (do mesmo tipo → estrutura homogênea), ou não primitivos:
public class VetorArray {
	public Scanner sc = new Scanner(System.in);

	public VetorArray() {
		System.out.print("Tamanho: ");
		int tamanho = sc.nextInt();
		assert (tamanho > 0) : "O tamanho do vetor precisa ser maior que zero";

		System.out.print("Tipo de dados: digite 'p' (para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' (para não primitivos → [string] ...");
		String tipo_de_dado = sc.nextLine();
		assert (tipo_de_dado == "p" || tipo_de_dado == "np") : "Aceita-se 'p' ou 'np' como parâmetro";

		if (tipo_de_dado == "p") {
			System.out.print("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ");
			String tipo = sc.nextLine();

			if (tipo == "byte") {
				getByteArray(tamanho, tipo, sc);
			} else if (tipo == "short") {
				getShortArray(tamanho, tipo, sc);
			} else if (tipo == "int") {
				getIntArray(tamanho, tipo, sc);
			} else if (tipo == "long") {
				getLongArray(tamanho, tipo, sc);
			} else if (tipo == "float") {
				getFloatArray(tamanho, tipo, sc);
			} else if (tipo == "double") {
				getDoubleArray(tamanho, tipo, sc);
			} else if (tipo == "char") {
				getCharArray(tamanho, tipo, sc);
			} else if (tipo == "boolean") {
				getBooleanArray(tamanho, tipo, sc);
			}
		} else if (tipo_de_dado == "np") {
				getStringArray(tamanho, sc);
		}
	}

	public static byte[] getByteArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		byte array[] = new byte[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			array[i] = sc.nextByte();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		//operações (→ exemplo em String, linha 201)
		sc.close();
		return array;
	}

	public static short[] getShortArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		short array[] = new short[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			array[i] = sc.nextShort();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		//operações (→ exemplo em String, linha 201)
		sc.close();
		return array;
	}

	public static int[] getIntArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		int array[] = new int[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			array[i] = sc.nextInt();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		//operações (→ exemplo em String, linha 201)
		sc.close();
		return array;
	}

	public static long[] getLongArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		long array[] = new long[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			array[i] = sc.nextLong();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		//operações (→ exemplo em String, linha 201)
		sc.close();
		return array;
	}

	public static float[] getFloatArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		float array[] = new float[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			array[i] = sc.nextFloat();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		//operações (→ exemplo em String, linha 201)
		sc.close();
		return array;
	}

	public static double[] getDoubleArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		double array[] = new double[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			array[i] = sc.nextDouble();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		//operações (→ exemplo em String, linha 201)
		sc.close();
		return array;
	}

	public static char[] getCharArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		char array[] = new char[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			array[i] = sc.next().charAt(0);
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		//operações (→ exemplo em String, linha 201)
		sc.close();
		return array;
	}

	public static boolean[] getBooleanArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		boolean array[] = new boolean[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			array[i] = sc.nextBoolean();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		//operações (→ exemplo em String, linha 201)
		sc.close();
		return array;
	}

	public static String[] getStringArray(int tamanho, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		String array[] = new String[tamanho];
		System.out.printf("Vetor do tipo de dados string de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo string:");
			array[i] = sc.nextLine();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		//___↓ operações ↓_________
		System.out.println("Digite uma operação ou 'q' para finalizar: \n 's' → para soma de células \n 'b' → para buscar o índice de um valor \n 'ri' → para remover um índice \n 'rv' → para remover um valor \n  'i' → para inserir um valor em um índice" );
		String operacao = sc.nextLine();
		while (operacao != "q") { 
			if (operacao == "s") {
				System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice:");
				String x = sc.nextLine();
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice procurado do valor " + x + " é " + i);
					} else {
						System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor" + x);
					}
				}	
			} else if (operacao == "ri") {
				System.out.print("Digite o índice a ser removido:");
				int indice = sc.nextInt();
				String valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Valor " + valor_indice + "da célula de índice" + indice + "removido.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor a ser removido:");
				String x = sc.nextLine();
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						String valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
						}
						System.out.println("Valor " + valor_indice + "da célula de índice" + i + "removido.");
					} else {
						System.out.println("Não há índice a ser removido, pois não há nenhuma célula com o valor" + x);
					}
				}
			} else if (operacao == "i") {
				System.out.print("Digite o valor a ser inserido:");
				String valor = sc.nextLine();
				System.out.print("Digite o índice no qual será inserido o valor:");
				int indice = sc.nextInt();
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				array[indice] = valor;
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println("Digite uma operação ou 'q' para finalizar: \n 's' → para soma de células \n 'b' → para buscar o índice de um valor \n 'ri' → para remover um índice \n 'rv' → para remover um valor \n  'i' → para inserir um valor em um índice" );
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		//___↑ operações ↑_________

		sc.close();
		return array;
	}
}