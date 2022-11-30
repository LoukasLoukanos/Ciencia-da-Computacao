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
    }

	//Preenche as células de um vetor/array arranjo (arrangement)
	public static void fillArrangement(nome, tipo, tamanho) {
		for (int i=0; i<tamanho; i++) {
			System.out.print("Defina o elemento da célula de índice ", i, " : ");
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
		}
    }
    
    //fazendo uso dos métodos
    arrangement();
    fillArrangement(nome, tipo, tamanho);



    //↓↓↓terminar_____________________________________________
    public static void soma(nome, tipo, tamanho) {
		int soma = 0; 
		for (int i=0; i<a.length; i++) {
			System.out.println("a[" + i + "] = "+ a[i]);
			soma += a[i];
		}
		System.out.println("Soma = "+ soma);
	}

	//Remove o índice(r) da fila(f) de tamanho (t)
	public static int remove (int r, int f[], int t) {
		if ! IsEmpty () {
			int x = f[r];
			for (int i=r+1; i<t; i++) {
				f[i-1] = f[i];
			}
			return x;
		} else

		
	}
    //↑↑↑terminar_____________________________________________


	sc.close(); // Fecha objeto leitor sc, evitando a perda de recursos e impedindo o uso posterior do dispositivo de entrada.   
}