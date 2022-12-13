import java.util.Scanner; // importação da classe Scanner do pacote java.util

//Declaração, alocação e operações de Vetor (ou Array) — de forma estática na memória —:
public class VetorArray {
	
	public VetorArray () {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome: ");
        String nome = sc.nextLine();
        
		System.out.print("Tamanho: ");
		int tamanho = sc.nextInt();
		assert(tamanho>0): "O tamanho do vetor precisa ser maior que zero";

		System.out.print("Tipo de dados: digite 'p' (para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' (para não primitivos → [string] ...");
		String tipo_de_dado = sc.nextLine();
		assert(tipo_de_dado == "p" || tipo_de_dado == "np"): "Aceita-se 'p' ou 'np' como parâmetro";
		
		if (tipo_de_dado == "p") {
			System.out.print("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ");
        	String tipo = sc.nextLine();
		} else if (tipo_de_dado == "np") {
			String tipo = "String";
		}

		//Declaração e Alocação estaticamente do vetor/array arranjo na memória:
		tipo nome[] = new int[tamanho];
		System.out.printf("Arranjo ", nome, " do tipo de dados ", tipo, " de ", tamanho, " células alocado.");
		
		//Chamando o procedimento de preenchimento das células
		preencher (tipo nome[]);
		sc.close();
	}
	
	
	//Subrotina procedimento
	//Preenche todas as células de um vetor/array arranjo
	public static void preencher (tipo nome[]) {
        if (tipo == "byte") {
			for (int i=0; i<nome.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
				nome[i] = sc.nextByte();
				if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
		} else if (tipo == "short") {
			for (int i=0; i<nome.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
				nome[i] = sc.nextShort();
				if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
        } else if (tipo == "int") {
			for (int i=0; i<nome.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
				nome[i] = sc.nextInt();
				if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
        } else if (tipo == "long") {
			for (int i=0; i<nome.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
				nome[i] = sc.nextLong();
				if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
        } else if (tipo == "float") {
			for (int i=0; i<nome.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
				nome[i] = sc.nextFloat();
				if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
        } else if (tipo == "double") {
			for (int i=0; i<nome.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
				nome[i] = sc.nextDouble();
				if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
        } else if (tipo == "char") {
			for (int i=0; i<nome.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
				nome[i] = sc.next().charAt(0);
				if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
        } else if (tipo == "boolean") {
			for (int i=0; i<nome.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
				nome[i] = sc.nextBoolean();
				if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
        } else if (tipo == "String") {
			for (int i=0; i<nome.length; i++) {
				System.out.printf("Defina o elemento da célula de índice ", i, "de tipo", tipo, ":");
				nome[i] = sc.nextLine();
				if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
				}
			}
		}
    }
	
 
    //Subrotina função
    //Soma os valores das células de um vetor
    public static void somaCelulas (tipo nome[]) {
		try {
			tipo soma; 
			for (int i=0; i<nome.length; i++) {
				System.out.println(nome+"["+i+"] = "+nome[i]);
				soma += nome[i];
			}
			System.out.println("Soma: "+soma);

		} catch (Exception e) {
			System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
			return soma;
		}
	}
	
	
	//Subrotina função
	//Busca o índice i de um valor x em um vetor
	public static void buscaIndice (int x, tipo nome[]) {
		for (int i=0; i<nome.length; i++) {
			if (nome[i] == x) {
				System.out.println("O índice procurado do valor " + x + " é " + i);
				return i;
			} else {
				System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor" + x);
				return null;
			}
		}
	}
	
	
	//Subrotina função
	//Remove o índice i de um vetor
	public static void removeIndice (int i, tipo nome[]) {
		int valor_indice = nome[i];
		for (int j=i+1; j<nome.length; j++) {
			v[j-1] = v[j];
		}
		System.out.println("Valor " + valor_indice + "da célula de índice" + i + "removido.");
		return valor_indice;
	}
	
	
	//Subrotina procedimento (chama subrotinas funções)
	//Remove o valor x em qualquer indice i que for encontrado em um vetor
	public static void removeValor (int x, tipo nome[]) {
		i = buscaIndice (x, nome[])
		x = removeIndice (i, nome[])
		System.out.println("Valor " + x + "da célula de índice" + i + "removido.");
	}	
	
	
	//Subrotina procedimento
	//Insere o valor x no índice i de um vetor
	public static void insereValor (int x, int i, tipo nome[]) {
		for (int j=nome.length-1; j>i; j--) {
			nome[j] = nome[j-1];
		}
		nome[i] = x;
		System.out.println("Valor " + x + "inserido na célula de índice" + i);
	} 

	
	//fazendo uso dos métodos
	somaCelulas (tipo nome[]);
	
	int valor_para_busca = 1,618;
	indice_retornado = buscaIndice (valor_para_busca, nome[]); //buscou o índice do valor 1,618
	indice_removido = removeIndice (indice_retornado, nome[]); //removeu esse índice, ou seja, removeu o próprio valor 1,618
	
	valor_para_remocao = valor_para_busca;
	valor_removido = removeValor (valor_para_remocao, tipo nome[]); //removeu o valr 1,618 sem precisar buscar o índice (o preocedimendo fez isso)
	
	insereValor (valor_removido, indice_retornado, nome[]); //insere novamente o valor 1,618 que foi removido
	
}