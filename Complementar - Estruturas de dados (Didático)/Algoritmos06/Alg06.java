/* Algoritmo da Estrutura de dados linear de Classificação/Ordenação estatica (não dinâmica)
   SelectionSort, também conhecida como Ordenação pelo Método (Iterativo) de Seleção */

public class Alg06 {
    public static void selectionSort(int[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            
            int temp = array[indiceMenor];
            array[indiceMenor] = array[i];
            array[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        selectionSort(array);
        
        System.out.println("Array ordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
