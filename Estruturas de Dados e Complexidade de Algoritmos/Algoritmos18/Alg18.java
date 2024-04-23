/*
♦ Algoritmo 18: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Dinâmicas (não Estáticas): Bucket Sort (Ordenação por Balde).
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alg18 {
    public static void Alg18(double[] arr) {
        int n = arr.length;
        
        // Crie um array de baldes
        List<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Coloque os elementos nos baldes
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        // Ordene os baldes e combine-os de volta no array original
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index] = buckets[i].get(j);
                index++;
            }
        }
    }

    public static void printArray(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[] arr = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};
        System.out.println("Array original:");
        printArray(arr);

        Alg18(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
