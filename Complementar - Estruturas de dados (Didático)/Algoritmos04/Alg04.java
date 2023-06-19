/* Algoritmo da Estrutura de dados linear de Classificação/Ordenação estática (não dinâmica) 
   BubbleSort, também conhecida como Ordanação pelo Método (Iterativo) de Bolhas. */
   
public class Alg04 {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean troca;
        
        for (int i = 0; i < n - 1; i++) {
            troca = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    troca = true;
                }
            }
            
            // Se não houve trocas na passagem atual, o array está ordenado
            if (!troca) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        bubbleSort(array);
        
        System.out.println("Array ordenado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
