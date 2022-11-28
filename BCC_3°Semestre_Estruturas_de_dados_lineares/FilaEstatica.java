import java.util.Scanner; // importação da classe Scanner do pacote java.util

//Gera uma Fila Estática para Alocação Estática na memória:
public class FilaEstatica {
	public static void main(String a[]) {

		Scanner sc = new Scanner(System.in); // Prepara entrada de dados criando o objeto leitor sc para uso das ENTRADAS FORMATADAS.

		System.out.print("Defina a quantidade de células da fila: "); // SAÍDA COMUM sem finalizar a linha de exibição (sem quebra de linha).

		int tamanho = sc.nextInt(); // ENTRADA FORMATADA. O método nextInt() realiza a leitura ("input") de um valor inteiro armazenando numa variável de tipo apropriado(int).
	
		System.out.printf("Fila de", tamanho, "células alocada na memória"); // SAÍDA FORMATADA.

		sc.close(); // Fecha objeto leitor sc, evitando a perda de recursos e impedindo o uso posterior do dispositivo de entrada.
	}
}