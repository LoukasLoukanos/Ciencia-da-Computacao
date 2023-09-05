/* Algoritmo da Estrutura de dados linear estática (não dinâmica) de Pesquisa/Busca 
   buscaSequencial para pesquisa sequencial com a utilização de sentinela */

public class Alg10 {

    public static int buscaSequencialComSentinela(int[] array, int valorProcurado) {
        int tamanhoArray = array.length;
        
        // Adiciona o valor procurado como sentinela na última posição do array
        int valorAnterior = array[tamanhoArray - 1];
        array[tamanhoArray - 1] = valorProcurado;

        int i = 0;
        // Percorre o array até encontrar o valor procurado ou a sentinela
        while (array[i] != valorProcurado) {
            i++;
        }

        // Restaura o valor anterior da última posição do array
        array[tamanhoArray - 1] = valorAnterior;

        if (i < tamanhoArray - 1 || array[tamanhoArray - 1] == valorProcurado) {
            return i; // Retorna o índice do valor procurado
        } else {
            return -1; // Retorna -1 se o valor não foi encontrado
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 5, 2, 8, 3, 7, 1, 6, 9, 4};
        int valorProcurado = 7;
        
        int indiceEncontrado = buscaSequencialComSentinela(array, valorProcurado);
        
        if (indiceEncontrado != -1) {
            System.out.println("Valor " + valorProcurado + " encontrado no índice: " + indiceEncontrado);
        } else {
            System.out.println("Valor " + valorProcurado + " não encontrado no array.");
        }
    }
}
