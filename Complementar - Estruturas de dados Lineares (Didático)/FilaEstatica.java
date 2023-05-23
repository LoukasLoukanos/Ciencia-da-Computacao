import java.util.Scanner; // importação da classe Scanner do pacote java.util

//Operações de Filas Estáticas com Alocações Estáticas na memória:
public class FilaEstatica {
	//testa a ocorrência de queue-overflow (estouro de fila cheia)

	
	//teste queue-underflow (estouro de fila vazia)
	public static void IsEmpty (void f[], int t) {
		head = f[t-t];
		tail = f[t];
		if (head == tail) {
			return true;
		} else {
			return false;
		}
	}
	
	//teste queue-overflow (estouro de fila cheia) 			
	public static void IsFull (fila[]) {
		se count = |V|
            retorna VERDADEIRO
        senão
            retorna FALSO
			
		if (this.tail = fila.length) {
		}
	}

	//teste queue-underflow (estouro de fila vazia)

	//Inserção-Enqueue (Enfileirar)

	//Remoção-Dequeue (Desenfileirar)


	Scanner sc = new Scanner(System.in); // Prepara entrada de dados criando o objeto leitor sc para uso das ENTRADAS FORMATADAS.


	//Declara e aloca estaticamente uma Fila Estática na memória:
	public static void newQueue() {
		System.out.print("Defina o tamanho da fila: "); // SAÍDA COMUM sem finalizar a linha de exibição (sem quebra de linha).
		int tamanho = sc.nextInt(); // ENTRADA FORMATADA. O método nextInt() realiza a leitura ("input") de um valor inteiro armazenando numa variável de tipo apropriado(int).
		assert tamanho>0;
		int fila[] = new int[tamanho]; // declara e aloca a fila do tipo de dados inteiro
		System.out.printf("Fila de", tamanho, "células alocada na memória"); // SAÍDA FORMATADA.
	

	//Cria uma nova fila e preenche-a do início ao fim
	public static void fillIn() {
		newQueue();
		for (int i=0; i<tamanho; i++) {
			System.out.print("Defina o elemento da célula de índice ", i, " da fila: ");
			fila[i] = sc.nextInt();
		}
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
	

	sc.close(); // Fecha objeto leitor sc, evitando a perda de recursos e impedindo o uso posterior do dispositivo de entrada.
	    
}