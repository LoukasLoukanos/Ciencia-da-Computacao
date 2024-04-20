/*
♦ Algoritmo 09: Algoritmo de Pesquisa/Busca para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Busca Sequencial (sem a utilização de variável/sentinela).
*/

public class Alg09 {
    
    public static int buscaSequencial(int[] array, int valorProcurado) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valorProcurado) {
                return i; // Retorna o índice do valor procurado
            }
        }
        return -1; // Retorna -1 se o valor não foi encontrado
    }

    public static void main(String[] args) {
        int[] array = {10, 5, 2, 8, 3, 7, 1, 6, 9, 4};
        int valorProcurado = 7;
        
        int indiceEncontrado = buscaSequencial(array, valorProcurado);
        
        if (indiceEncontrado != -1) {
            System.out.println("Valor " + valorProcurado + " encontrado no índice: " + indiceEncontrado);
        } else {
            System.out.println("Valor " + valorProcurado + " não encontrado no array.");
        }
    }
}
