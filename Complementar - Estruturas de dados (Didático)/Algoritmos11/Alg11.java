/* 
♦ Algoritmo 11: Estrutura de Dados Linear Estática (não Dinâmica) de Pesquisa/Busca Busca Binária.
*/

public class Alg11 {

    public static int buscaBinaria(int[] array, int valorProcurado) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (array[meio] == valorProcurado) {
                return meio; // Retorna o índice do valor procurado
            } else if (array[meio] < valorProcurado) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; // Retorna -1 se o valor não foi encontrado
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int valorProcurado = 11;

        int indiceEncontrado = buscaBinaria(array, valorProcurado);

        if (indiceEncontrado != -1) {
            System.out.println("Valor " + valorProcurado + " encontrado no índice: " + indiceEncontrado);
        } else {
            System.out.println("Valor " + valorProcurado + " não encontrado no array.");
        }
    }
}
