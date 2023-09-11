/*
♦ Algoritmo 08: Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação de Divisão e Conquista Merge Sort (Ordenação pelo Método (Recursivo) de Mistura/Mesclagem).
*/

public class Alg08 {
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        
        int meio = array.length / 2;
        int[] metadeEsquerda = new int[meio];
        int[] metadeDireita = new int[array.length - meio];
        
        // Preencher as duas metades
        for (int i = 0; i < meio; i++) {
            metadeEsquerda[i] = array[i];
        }
        for (int i = meio; i < array.length; i++) {
            metadeDireita[i - meio] = array[i];
        }
        
        // Recursivamente ordenar as duas metades
        mergeSort(metadeEsquerda);
        mergeSort(metadeDireita);
        
        // Mesclar as metades ordenadas
        merge(metadeEsquerda, metadeDireita, array);
    }
    
    private static void merge(int[] metadeEsquerda, int[] metadeDireita, int[] array) {
        int i = 0; // Índice para a metade esquerda
        int j = 0; // Índice para a metade direita
        int k = 0; // Índice para o array final
        
        while (i < metadeEsquerda.length && j < metadeDireita.length) {
            if (metadeEsquerda[i] <= metadeDireita[j]) {
                array[k] = metadeEsquerda[i];
                i++;
            } else {
                array[k] = metadeDireita[j];
                j++;
            }
            k++;
        }
        
        // Copiar os elementos restantes da metade esquerda
        while (i < metadeEsquerda.length) {
            array[k] = metadeEsquerda[i];
            i++;
            k++;
        }
        
        // Copiar os elementos restantes da metade direita
        while (j < metadeDireita.length) {
            array[k] = metadeDireita[j];
            j++;
            k++;
        }
    }
    
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        mergeSort(array);
        
        System.out.println("Array ordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
