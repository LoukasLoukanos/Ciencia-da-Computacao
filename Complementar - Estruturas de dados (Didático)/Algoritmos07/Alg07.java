/* Algoritmo da Estrutura de dados linear de Classificação/Ordenação estática (não dinâmica) de 
divisão e conquista QuickSort, também conhecida como Ordenação pelo Método (Recursivo) Rápido */

public class Alg07 {
    public static void quicksort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = partition(array, inicio, fim);
            quicksort(array, inicio, indicePivo - 1);
            quicksort(array, indicePivo + 1, fim);
        }
    }
    
    private static int partition(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int i = inicio - 1;
        
        for (int j = inicio; j < fim; j++) {
            if (array[j] < pivo) {
                i++;
                trocar(array, i, j);
            }
        }
        
        trocar(array, i + 1, fim);
        return i + 1;
    }
    
    private static void trocar(int[] array, int indice1, int indice2) {
        int temp = array[indice1];
        array[indice1] = array[indice2];
        array[indice2] = temp;
    }
    
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        int n = array.length;
        
        quicksort(array, 0, n - 1);
        
        System.out.println("Array ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
