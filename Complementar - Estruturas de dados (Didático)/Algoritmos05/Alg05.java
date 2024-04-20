/*
♦ Algoritmo 05: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Insertion Sort (Ordenação por Inserção).
*/

public class Alg05 {
    public static void insertionSort(int[] array) {
        int n = array.length;
        
        for (int i = 1; i < n; i++) {
            int chave = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j--;
            }
            
            array[j + 1] = chave;
        }
    }
    
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        insertionSort(array);
        
        System.out.println("Array ordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
