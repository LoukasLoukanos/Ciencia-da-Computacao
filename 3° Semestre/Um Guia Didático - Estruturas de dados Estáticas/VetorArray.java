import java.util.Scanner; // importação da classe Scanner do pacote java.util

//Declaração, alocação e operações de Vetor (ou Array) — de forma estática na memória —:
public class VetorArray {
	
	public VetorArray () {
		arrangement();
	}
	
	
	//Declara e aloca estaticamente um vetor/array arranjo (arrangement) na memória:
	public static void arrangement () {
		Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        
        System.out.print("Tipo (float, int, byte, long, boolean, double ou String): ");
        String tipo = sc.nextLine();
        
		System.out.print("Tamanho: ");
		int tamanho = sc.nextInt();
		assert tamanho>0;
		
		tipo nome[] = new int[tamanho];
		System.out.printf("Arranjo ", nome, " do tipo de dados ", tipo, " de " tamanho, " células alocado.");

		sc.close(); 

		return nome[];
    }
	

	//Preenche as células de um vetor/array arranjo (arrangement)
	public static void fillArrangement(nome, tipo) {
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
	
 
    //Soma os valores das células
    public static void soma (nome, tipo) {
		try {
			int soma = 0; 
			for (int i=0; i<nome.length; i++) {
				System.out.println(nome+"["+i+"] = "+ nome[i]);
				soma += nome[i];
			}
			System.out.println("Soma = "+ soma);

		} catch (Exception e) {
			System.out.println("Vetor/Array de tipo de dados inválido para esta operação.");
		}
	}
	
	
	//Busca o índice k de um valor x em um vetor v de tamanho t
	public static void busca (int x, tipo v[], int t) {
		for (int k=0; k<t; k++) {
			if (v[k] == x) {
				System.out.println("O índice procurado do valor " + x + " é " + k);
				return k;
			} else {
				System.out.println("Não existe índice correspondente, pois não há nenhuma célula com o valor" + x);
				return null;
			}
		}
	}
	
	
	//Remove o índice k do vetor v de tamanho t
	public static void remove (int k, tipo v[], int t) {
		int x = v[k];
		for (int i=k+1; i<t; i++) {
			v[i-1] = v[i];
		}
		System.out.println("Valor " + x + "da célula de índice" + k + "removido.");
		return x;
	}
	
	
	//Insere o valor x no índice k do vetor v de tamanho t
	public static void insere (int x, int k, tipo v[], int t) {
		for (int i = t - 1; i > k; i--) {
			v[i] = v[-1];
		}
		v[k] = x;
		System.out.println("Valor " + x + "inserido na célula de índice" + k);
		return x;
	} 


	//fazendo uso dos métodos
    fillArrangement (nome, tipo);
	soma (nome, tipo);
}