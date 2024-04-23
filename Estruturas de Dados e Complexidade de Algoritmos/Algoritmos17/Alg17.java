/*
♦ Algoritmo 17: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Dinâmicas (não Estáticas): Counting Sort (Ordenação por Contagem).
*/

public class Alg17 {
    public static void Alg17(int[] arr) {
        int max = findMaxValue(arr);
        int min = findMinValue(arr);

        int range = max - min + 1;
        int[] countArray = new int[range];
        int[] outputArray = new int[arr.length];

        // Inicializa o array de contagem
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min]++;
        }

        // Atualiza o array de contagem para ter a soma acumulativa
        for (int i = 1; i < range; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Constrói o array de saída
        for (int i = arr.length - 1; i >= 0; i--) {
            outputArray[countArray[arr[i] - min] - 1] = arr[i];
            countArray[arr[i] - min]--;
        }

        // Copia o array ordenado de volta para o array original
        for (int i = 0; i < arr.length; i++) {
            arr[i] = outputArray[i];
        }
    }

    public static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMinValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Array original:");
        printArray(arr);

        Alg17(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
