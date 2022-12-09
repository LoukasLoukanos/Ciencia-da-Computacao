import java.util.Scanner; // importação da classe Scanner do pacote java.util

//Declaração, alocação e operações de Vetor (ou Array) — de forma estática na memória —:
public class VetorArray {
	
	public VetorArray () {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome: ");
        String nome = sc.nextLine();
        
		System.out.print("Tamanho: ");
		int tamanho = sc.nextInt();

		System.out.print("Tipo de dados: digite 'p' (para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' (para não primitivos → [string] ...");
		String tipo_de_dado = sc.nextLine();
		
		if (tipo_de_dado == "p") {
			System.out.print("Tipo (byte, short, int, long, float, double, char, boolean): ");
        	String tipo = sc.nextLine();
		} else if (tipo_de_dado == "np") {
			String tipo = "String";
		}

		var_vetor = arranjo(nome, tamanho, tipo);

	}
	
	
	//Subrotina função
	//Declara e aloca estaticamente um vetor/array arranjo (arrangement) na memória:
	public static tipo arranjo (String nomeString, int tamanho, String tipoString) {
		assert tamanho>0;
		tipo nome[] = new int[tamanho];
		System.out.printf("Arranjo ", nome, " do tipo de dados ", tipo, " de ", tamanho, " células alocado.");

		return vetor;
    }
	
	
	//Subrotina procedimento
	//Preenche todas as células de um vetor/array arranjo (arrangement)
	public static void fillArrangement (tipo nome[]) {
		for (int i=0; i<nome.length; i++) {
			System.out.printf("Defina o elemento da célula de índice ", i, " : ");
            if (tipo == "float") {
                nome[i] = sc.nextFloat();
            } else if (tipo == "int") {
                nome[i] = sc.nextInt();
            } else if (tipo == "byte") {
                nome[i] = sc.nextByte();
            } else if (tipo == "long") {
                nome[i] = sc.nextLong();
            } else if (tipo == "boolean") {
                nome[i] = sc.nextBoolean();
            } else if (tipo == "double") {
                nome[i] = sc.nextDouble();
            } else if (tipo == "String") {
                nome[i] = sc.nextLine();
            }
			if (i == nome.length-1) {
				System.out.print("Arranjo definido, todas as células foram preenchidas.");
			}
		}
    }
	
 
    //Subrotina função
    //Soma os valores das células
    public static void somaCelulas (nome[], tipo) {
		try {
			int soma = 0; 
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
	//Busca o índice i de um valor x em um vetor v de tamanho t
	public static void buscaIndice (int x, tipo v[], int t) {
		for (int i=0; i<t; i++) {
			if (v[i] == x) {
				System.out.println("O índice procurado do valor " + x + " é " + i);
				return i;
			} else {
				System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor" + x);
				return null;
			}
		}
	}
	
	
	//Subrotina função
	//Remove o índice i do vetor v de tamanho t
	public static void removeIndice (int i, tipo v[], int t) {
		int valor_indice = v[i];
		for (int j=i+1; j<t; j++) {
			v[j-1] = v[j];
		}
		System.out.println("Valor " + valor_indice + "da célula de índice" + i + "removido.");
		return valor_indice;
	}
	
	
	//Subrotina procedimento (chama subrotinas função)
	//Remove o valor x em qualquer indice i que for encontrad no vetor v
	public static void removeValor (int x, tipo v[], int t) {
		i = buscaIndice (x, v[], t)
		removeIndice (i. v[], t)
	}	
	
	
	//Subrotina procedimento
	//Insere o valor x no índice i do vetor v de tamanho t
	public static void insereValor (int x, int i, tipo v[], int t) {
		for (int j = t - 1; j > i; j--) {
			v[j] = v[-1];
		}
		v[i] = x;
		System.out.println("Valor " + x + "inserido na célula de índice" + i);
	} 


	
	//fazendo uso dos métodos
    fillArrangement (nome, tipo);
	soma (nome, tipo);

	sc.close(); 
}