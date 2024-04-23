/*
♦ Algoritmo 32: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Floyd-Warshall.
*/


import java.util.*;

// Classe para representar o grafo
class Grafo<T> {
    private final Map<T, Map<T, Double>> adjacencia;

    // Construtor
    public Grafo() {
        adjacencia = new HashMap<>();
    }

    // Adiciona uma aresta ao grafo
    public void addAresta(T origem, T destino, double peso) {
        adjacencia.computeIfAbsent(origem, k -> new HashMap<>()).put(destino, peso);
    }

    // Algoritmo de Floyd-Warshall para encontrar os menores caminhos entre todos os pares de vértices
    public Map<T, Map<T, Double>> floydWarshall() {
        Map<T, Map<T, Double>> distancias = new HashMap<>(adjacencia);

        // Inicializa a diagonal com 0 e as outras posições com infinito
        for (T vertice1 : adjacencia.keySet()) {
            for (T vertice2 : adjacencia.keySet()) {
                if (!vertice1.equals(vertice2) && !distancias.get(vertice1).containsKey(vertice2)) {
                    distancias.get(vertice1).put(vertice2, Double.POSITIVE_INFINITY);
                }
            }
        }

        // Algoritmo de Floyd-Warshall
        for (T k : adjacencia.keySet()) {
            for (T i : adjacencia.keySet()) {
                for (T j : adjacencia.keySet()) {
                    double distanciaIJ = distancias.get(i).get(j);
                    double distanciaIK = distancias.get(i).getOrDefault(k, Double.POSITIVE_INFINITY);
                    double distanciaKJ = distancias.getOrDefault(k, new HashMap<>()).getOrDefault(j, Double.POSITIVE_INFINITY);

                    if (distanciaIK + distanciaKJ < distanciaIJ) {
                        distancias.get(i).put(j, distanciaIK + distanciaKJ);
                    }
                }
            }
        }

        return distancias;
    }
}

// Classe principal
public class Alg32 {
    public static void main(String[] args) {
        // Criando um grafo
        Grafo<String> grafo = new Grafo<>();

        // Adicionando arestas ao grafo
        grafo.addAresta("A", "B", 3);
        grafo.addAresta("A", "C", 6);
        grafo.addAresta("B", "C", 2);
        grafo.addAresta("B", "D", 1);
        grafo.addAresta("C", "B", 4);
        grafo.addAresta("C", "D", 5);
        grafo.addAresta("D", "A", 3);

        // Executando o algoritmo de Floyd-Warshall
        Map<String, Map<String, Double>> distancias = grafo.floydWarshall();

        // Imprimindo as distâncias mínimas entre todos os pares de vértices
        for (String vertice1 : distancias.keySet()) {
            for (String vertice2 : distancias.get(vertice1).keySet()) {
                System.out.println("Distância de " + vertice1 + " para " + vertice2 + ": " + distancias.get(vertice1).get(vertice2));
            }
        }
    }
}
