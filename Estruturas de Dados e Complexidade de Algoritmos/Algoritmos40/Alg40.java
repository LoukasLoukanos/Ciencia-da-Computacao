/*
♦ Algoritmo 40: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Floyd-Warshall.
*/


import java.util.HashMap;
import java.util.Map;

class FloydWarshall<T> {
    private Map<T, Map<T, Integer>> distancias;
    private Map<T, Map<T, T>> predecessores;

    public FloydWarshall() {
        distancias = new HashMap<>();
        predecessores = new HashMap<>();
    }

    public void adicionarVertice(T vertice) {
        if (!distancias.containsKey(vertice)) {
            distancias.put(vertice, new HashMap<>());
            predecessores.put(vertice, new HashMap<>());
        }
    }

    public void adicionarAresta(T origem, T destino, int peso) {
        adicionarVertice(origem);
        adicionarVertice(destino);

        distancias.get(origem).put(destino, peso);
        predecessores.get(origem).put(destino, origem);

        distancias.get(destino).put(origem, peso);
        predecessores.get(destino).put(origem, destino);
    }

    public void floydWarshall() {
        for (T k : distancias.keySet()) {
            for (T i : distancias.keySet()) {
                for (T j : distancias.keySet()) {
                    if (distancias.get(i).get(k) != null && distancias.get(k).get(j) != null) {
                        int novoPeso = distancias.get(i).get(k) + distancias.get(k).get(j);
                        if (distancias.get(i).get(j) == null || novoPeso < distancias.get(i).get(j)) {
                            distancias.get(i).put(j, novoPeso);
                            predecessores.get(i).put(j, predecessores.get(k).get(j));
                        }
                    }
                }
            }
        }
    }

    public Map<T, Map<T, Integer>> obterDistancias() {
        return distancias;
    }

    public Map<T, Map<T, T>> obterPredecessores() {
        return predecessores;
    }
}

public class Alg40 {
    public static void main(String[] args) {
        FloydWarshall<Character> floydWarshall = new FloydWarshall<>();

        floydWarshall.adicionarAresta('A', 'B', 10);
        floydWarshall.adicionarAresta('A', 'C', 15);
        floydWarshall.adicionarAresta('B', 'D', 12);
        floydWarshall.adicionarAresta('B', 'F', 15);
        floydWarshall.adicionarAresta('C', 'E', 10);
        floydWarshall.adicionarAresta('D', 'E', 2);
        floydWarshall.adicionarAresta('D', 'F', 1);
        floydWarshall.adicionarAresta('F', 'E', 5);

        floydWarshall.floydWarshall();

        Map<Character, Map<Character, Integer>> distancias = floydWarshall.obterDistancias();
        Map<Character, Map<Character, Character>> predecessores = floydWarshall.obterPredecessores();

        for (char u : distancias.keySet()) {
            for (char v : distancias.get(u).keySet()) {
                System.out.println("Distância de " + u + " até " + v + ": " + distancias.get(u).get(v));
            }
        }

        for (char u : predecessores.keySet()) {
            for (char v : predecessores.get(u).keySet()) {
                System.out.println("Predecessor de " + v + " no caminho de " + u + " até " + v + ": " + predecessores.get(u).get(v));
            }
        }
    }
}
