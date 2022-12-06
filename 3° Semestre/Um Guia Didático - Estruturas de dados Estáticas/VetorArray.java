import java.util.Scanner; // importação da classe Scanner do pacote java.util

//Declaração, alocação e operações de Vetor (ou Array) — de forma estática na memória —:
public class VetorArray {
	Scanner sc = new Scanner(System.in);

	//Declara e aloca estaticamente um vetor/array arranjo (arrangement) na memória:
	public static void arrangement() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        
        System.out.print("Tipo (float, int, byte, long, boolean, double ou String): ");
        String tipo = sc.nextLine();
        
		System.out.print("Tamanho: ");
		int tamanho = sc.nextInt();
		assert tamanho>0;
		tipo nome[] = new int[tamanho];
		System.out.printf("Arranjo ", nome, " do tipo de dados ", tipo, " de " tamanho, " células alocado.");

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
    
    //fazendo uso dos métodos
    arrangement();
    fillArrangement(nome, tipo);



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

	//terminar________________↓
	//Remove o índice(r) da fila(f) de tamanho (t)
	public static void remove (int r, void f[], int t) {
		if ! IsEmpty () {
			int x = f[r];
			for (int i=r+1; i<t; i++) {
				f[i-1] = f[i];
			}
			return x;
		} else
	}
	//terminar________________↑

	sc.close(); // Fecha objeto leitor sc, evitando a perda de recursos e impedindo o uso posterior do dispositivo de entrada.   
}