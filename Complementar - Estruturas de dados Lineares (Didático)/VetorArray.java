import java.util.Scanner; // importação da classe Scanner do pacote java.util

//Declaração, alocação e operações — de forma estática na memória — de Vetor/Array de estrutura
//de dados primitivos (do mesmo tipo → estrutura homogênea), ou não primitivos:
public class VetorArray {
	public Scanner sc = new Scanner(System.in);
	private int tamanho;
	private String tipo_de_dado;
	private String tipo;

	public static void main(String[] args, Scanner sc) {
		VetorArray myobj = new VetorArray ();
        myobj.info();
	}
	
	public VetorArray() {
		System.out.print("Tamanho: ");
		this.tamanho = sc.nextInt();
		assert (tamanho > 0) : "O tamanho do vetor precisa ser maior que zero!";

		System.out.print(
				"Tipo de dados: digite 'p' para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' para não primitivos → [string] ...");
		sc.nextLine();
		this.tipo_de_dado = sc.nextLine();
		assert (tipo_de_dado == "p" || tipo_de_dado == "np") : "Aceita-se 'p' ou 'np' como parâmetro!";

		if (tipo_de_dado == "p") {
			System.out.print("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ");
			sc.nextLine();
			this.tipo = sc.nextLine();

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

	public void info() {
		System.out.printf("Vetor do tipo de dados " + this.tipo_de_dado + "(" + this.tipo + ")" + " de " + this.tamanho + " células definido.");
	}

	public static byte[] getByteArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		byte array[] = new byte[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			sc.nextLine();
			array[i] = sc.nextByte();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		// ___↓ operações ↓_________
		System.out.println(
				"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
		sc.nextLine();
		String operacao = sc.nextLine();
		while (operacao != "q") {
			if (operacao == "s") {
				try {
					byte valor = array[0];
					for (int i = 1; i < array.length; i++) {
						System.out.println(array + "[" + i + "] = " + array[i]);
						valor = (byte) (valor + array[i]);
					}
					System.out.println("Soma: " + valor);
				} catch (Exception e) {
					System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
				}
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice: ");
				sc.nextLine();
				byte x = sc.nextByte();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice" + i + " contém o valor " + x);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
				}
			} else if (operacao == "ri") {
				System.out.print("Digite o índice da célula a ser removida: ");
				sc.nextLine();
				int indice = sc.nextInt();
				byte valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
				sc.nextLine();
				byte x = sc.nextByte();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						byte valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
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
				byte valor = sc.nextByte();
				System.out.print("Digite o índice no qual será inserido o valor:");
				sc.nextLine();
				int indice = sc.nextInt();
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				valor = array[indice];
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println(
					"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
			sc.nextLine();
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		// ___↑ operações ↑_________

		sc.close();
		return array;
	}

	public static short[] getShortArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		short array[] = new short[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			sc.nextLine();
			array[i] = sc.nextShort();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		// ___↓ operações ↓_________
		System.out.println(
				"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
		sc.nextLine();
		String operacao = sc.nextLine();
		while (operacao != "q") {
			if (operacao == "s") {
				try {
					short valor = array[0];
					for (int i = 1; i < array.length; i++) {
						System.out.println(array + "[" + i + "] = " + array[i]);
						valor = (short) (valor + array[i]);
					}
					System.out.println("Soma: " + valor);
				} catch (Exception e) {
					System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
				}
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice: ");
				sc.nextLine();
				short x = sc.nextShort();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice" + i + " contém o valor " + x);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
				}
			} else if (operacao == "ri") {
				System.out.print("Digite o índice da célula a ser removida: ");
				sc.nextLine();
				int indice = sc.nextInt();
				short valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
				sc.nextLine();
				short x = sc.nextShort();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						short valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
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
				short valor = sc.nextShort();
				System.out.print("Digite o índice no qual será inserido o valor:");
				sc.nextLine();
				int indice = sc.nextInt();
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				valor = array[indice];
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println(
					"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
			sc.nextLine();
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		// ___↑ operações ↑_________

		sc.close();
		return array;
	}

	public static int[] getIntArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		int array[] = new int[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			sc.nextLine();
			array[i] = sc.nextInt();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		// ___↓ operações ↓_________
		System.out.println(
				"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
		sc.nextLine();
		String operacao = sc.nextLine();
		while (operacao != "q") {
			if (operacao == "s") {
				try {
					int valor = array[0];
					for (int i = 1; i < array.length; i++) {
						System.out.println(array + "[" + i + "] = " + array[i]);
						valor = valor + array[i];
					}
					System.out.println("Soma: " + valor);
				} catch (Exception e) {
					System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
				}
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice: ");
				sc.nextLine();
				int x = sc.nextInt();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice" + i + " contém o valor " + x);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
				}
			} else if (operacao == "ri") {
				System.out.print("Digite o índice da célula a ser removida: ");
				sc.nextLine();
				int indice = sc.nextInt();
				int valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
				sc.nextLine();
				int x = sc.nextInt();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						int valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
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
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				valor = array[indice];
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println(
					"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
			sc.nextLine();
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		// ___↑ operações ↑_________

		sc.close();
		return array;
	}

	public static long[] getLongArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		long array[] = new long[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			sc.nextLine();
			array[i] = sc.nextLong();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		// ___↓ operações ↓_________
		System.out.println(
				"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
		sc.nextLine();
		String operacao = sc.nextLine();
		while (operacao != "q") {
			if (operacao == "s") {
				try {
					long valor = array[0];
					for (int i = 1; i < array.length; i++) {
						System.out.println(array + "[" + i + "] = " + array[i]);
						valor = valor + array[i];
					}
					System.out.println("Soma: " + valor);
				} catch (Exception e) {
					System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
				}
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice: ");
				sc.nextLine();
				long x = sc.nextLong();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice" + i + " contém o valor " + x);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
				}
			} else if (operacao == "ri") {
				System.out.print("Digite o índice da célula a ser removida: ");
				sc.nextLine();
				int indice = sc.nextInt();
				long valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
				sc.nextLine();
				long x = sc.nextLong();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						long valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
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
				long valor = sc.nextLong();
				System.out.print("Digite o índice no qual será inserido o valor:");
				sc.nextLine();
				int indice = sc.nextInt();
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				valor = array[indice];
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println(
					"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
			sc.nextLine();
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		// ___↑ operações ↑_________

		sc.close();
		return array;
	}

	public static float[] getFloatArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		float array[] = new float[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			sc.nextLine();
			array[i] = sc.nextFloat();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		// ___↓ operações ↓_________
		System.out.println(
				"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
		sc.nextLine();
		String operacao = sc.nextLine();
		while (operacao != "q") {
			if (operacao == "s") {
				try {
					float valor = array[0];
					for (int i = 1; i < array.length; i++) {
						System.out.println(array + "[" + i + "] = " + array[i]);
						valor = valor + array[i];
					}
					System.out.println("Soma: " + valor);
				} catch (Exception e) {
					System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
				}
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice: ");
				sc.nextLine();
				float x = sc.nextFloat();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice" + i + " contém o valor " + x);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
				}
			} else if (operacao == "ri") {
				System.out.print("Digite o índice da célula a ser removida: ");
				sc.nextLine();
				int indice = sc.nextInt();
				float valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
				sc.nextLine();
				float x = sc.nextFloat();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						float valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
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
				float valor = sc.nextFloat();
				System.out.print("Digite o índice no qual será inserido o valor:");
				sc.nextLine();
				int indice = sc.nextInt();
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				valor = array[indice];
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println(
					"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
			sc.nextLine();
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		// ___↑ operações ↑_________

		sc.close();
		return array;
	}

	public static double[] getDoubleArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		double array[] = new double[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			sc.nextLine();
			array[i] = sc.nextDouble();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		// ___↓ operações ↓_________
		System.out.println(
				"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
		sc.nextLine();
		String operacao = sc.nextLine();
		while (operacao != "q") {
			if (operacao == "s") {
				try {
					double valor = array[0];
					for (int i = 1; i < array.length; i++) {
						System.out.println(array + "[" + i + "] = " + array[i]);
						valor = valor + array[i];
					}
					System.out.println("Soma: " + valor);
				} catch (Exception e) {
					System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
				}
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice: ");
				sc.nextLine();
				double x = sc.nextDouble();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice" + i + " contém o valor " + x);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
				}
			} else if (operacao == "ri") {
				System.out.print("Digite o índice da célula a ser removida: ");
				sc.nextLine();
				int indice = sc.nextInt();
				double valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
				sc.nextLine();
				double x = sc.nextDouble();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						double valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
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
				double valor = sc.nextDouble();
				System.out.print("Digite o índice no qual será inserido o valor:");
				sc.nextLine();
				int indice = sc.nextInt();
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				valor = array[indice];
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println(
					"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
			sc.nextLine();
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		// ___↑ operações ↑_________

		sc.close();
		return array;
	}

	public static char[] getCharArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		char array[] = new char[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			sc.nextLine();
			array[i] = sc.next().charAt(0);
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		// ___↓ operações ↓_________
		System.out.println(
				"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
		sc.nextLine();
		String operacao = sc.nextLine();
		while (operacao != "q") {
			if (operacao == "s") {
				System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice: ");
				sc.nextLine();
				char x = sc.next().charAt(0);
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice" + i + " contém o valor " + x);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
				}
			} else if (operacao == "ri") {
				System.out.print("Digite o índice da célula a ser removida: ");
				sc.nextLine();
				int indice = sc.nextInt();
				char valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
				sc.nextLine();
				char x = sc.next().charAt(0);
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						char valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
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
				char valor = sc.next().charAt(0);
				System.out.print("Digite o índice no qual será inserido o valor:");
				sc.nextLine();
				int indice = sc.nextInt();
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				valor = array[indice];
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println(
					"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
			sc.nextLine();
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		// ___↑ operações ↑_________

		sc.close();
		return array;
	}

	public static boolean[] getBooleanArray(int tamanho, String tipo, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		boolean array[] = new boolean[tamanho];
		System.out.printf("Vetor do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
			sc.nextLine();
			array[i] = sc.nextBoolean();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		// ___↓ operações ↓_________
		System.out.println(
				"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
		sc.nextLine();
		String operacao = sc.nextLine();
		while (operacao != "q") {
			if (operacao == "s") {
				try {
					boolean valor = array[0];
					for (int i = 1; i < array.length; i++) {
						System.out.println(array + "[" + i + "] = " + array[i]);
						valor = valor & array[i];
					}
					System.out.println("Soma: " + valor);
				} catch (Exception e) {
					System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
				}
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice: ");
				sc.nextLine();
				boolean x = sc.nextBoolean();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice" + i + " contém o valor " + x);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
				}
			} else if (operacao == "ri") {
				System.out.print("Digite o índice da célula a ser removida: ");
				sc.nextLine();
				int indice = sc.nextInt();
				boolean valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
				sc.nextLine();
				boolean x = sc.nextBoolean();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						boolean valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
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
				boolean valor = sc.nextBoolean();
				System.out.print("Digite o índice no qual será inserido o valor:");
				sc.nextLine();
				int indice = sc.nextInt();
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				valor = array[indice];
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println(
					"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
			sc.nextLine();
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		// ___↑ operações ↑_________

		sc.close();
		return array;
	}

	public static String[] getStringArray(int tamanho, Scanner sc) {
		// Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		String array[] = new String[tamanho];
		System.out.printf("Vetor do tipo de dados string de ", tamanho, " células alocado.");

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, "de tipo string:");
			sc.nextLine();
			array[i] = sc.nextLine();
			if (i == array.length - 1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}

		// ___↓ operações ↓_________
		System.out.println(
				"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
		sc.nextLine();
		String operacao = sc.nextLine();
		while (operacao != "q") {
			if (operacao == "s") {
				try {
					String valor = array[0];
					for (int i = 1; i < array.length; i++) {
						System.out.println(array + "[" + i + "] = " + array[i]);
						valor = valor + array[i];
					}
					System.out.println("Soma: " + valor);
				} catch (Exception e) {
					System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
				}
			} else if (operacao == "b") {
				System.out.print("Digite o valor a ser buscado o índice: ");
				sc.nextLine();
				String x = sc.nextLine();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						System.out.println("O índice" + i + " contém o valor " + x);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor " + x);
				}
			} else if (operacao == "ri") {
				System.out.print("Digite o índice da célula a ser removida: ");
				sc.nextLine();
				int indice = sc.nextInt();
				String valor_indice = array[indice];
				for (int j = indice + 1; j < array.length; j++) {
					array[j - 1] = array[j];
				}
				System.out.println("Célula de índice " + indice + " de valor " + valor_indice + " removida.");
			} else if (operacao == "rv") {
				System.out.print("Digite o valor contido na(s) célula(s) a ser removida(s): ");
				sc.nextLine();
				String x = sc.nextLine();
				int count = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == x) {
						String valor_indice = array[i];
						for (int j = i + 1; j < array.length; j++) {
							array[j - 1] = array[j];
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
				String valor = sc.nextLine();
				System.out.print("Digite o índice no qual será inserido o valor:");
				sc.nextLine();
				int indice = sc.nextInt();
				for (int j = array.length - 1; j > indice; j--) {
					array[j] = array[j - 1];
				}
				array[indice] = valor;
				System.out.println("Valor " + valor + "inserido na célula de índice" + indice);
			}

			System.out.println(
					"Digite uma operação ou 'q' para finalizar: \n 's' → para soma dos valores de todas as células \n 'b' → para buscar os índices de um valor \n 'ri' → para remover o valor da célula informando o índice \n 'rv' → para remover valor de célula(s) informando o valor\n  'i' → para inserir um valor em uma célula informando o índice");
			sc.nextLine();
			String novaoperacao = sc.nextLine();
			operacao = novaoperacao;
		}
		// ___↑ operações ↑_________

		sc.close();
		return array;
	}
}
