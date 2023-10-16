/*
♦ Algoritmo 16: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Insertion Sort (Ordenação por Inserção).
*/

public class Alg16 {
    public static void Alg16(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move os elementos do arr[0..i-1] que são maiores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Array original:");
        printArray(arr);
        
        Alg16(arr);
        
        System.out.println("Array ordenado:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
