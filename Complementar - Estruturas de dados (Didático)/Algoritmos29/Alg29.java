/*
♦ Algoritmo 29: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Bellman-Ford.
*/


import java.util.*;

// Classe para representar uma aresta em um grafo ponderado
class Aresta<T> {
    int origem, destino;
    T peso;

    public Aresta(int origem, int destino, T peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}

// Classe para representar um grafo ponderado usando matriz de adjacência
class Grafo<T> {
    int V, E; // Número de vértices e arestas
    ArrayList<Aresta<T>> arestas;

    public Grafo(int V, int E) {
        this.V = V;
        this.E = E;
        arestas = new ArrayList<>();
    }

    // Adiciona uma aresta ao grafo
    public void addAresta(int origem, int destino, T peso) {
        arestas.add(new Aresta<>(origem, destino, peso));
    }

    // Algoritmo de Bellman-Ford para encontrar o caminho mais curto
    public void BellmanFord(int origem) {
        // Inicializa as distâncias de todos os vértices como infinito
        T[] distancia = (T[]) new Object[V];
        for (int i = 0; i < V; ++i)
            distancia[i] = (T) Double.MAX_VALUE;

        // A distância do vértice de origem para ele mesmo é 0
        distancia[origem] = (T) Double.valueOf(0);

        // Relaxamento das arestas
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = arestas.get(j).origem;
                int v = arestas.get(j).destino;
                T peso = arestas.get(j).peso;
                if ((Double) distancia[u] != Double.MAX_VALUE && ((Double) distancia[u] + (Double) peso < (Double) distancia[v])) {
                    distancia[v] = (T) ((Double) distancia[u] + (Double) peso);
                }
            }
        }

        // Verifica ciclos de peso negativo
        for (int i = 0; i < E; ++i) {
            int u = arestas.get(i).origem;
            int v = arestas.get(i).destino;
            T peso = arestas.get(i).peso;
            if ((Double) distancia[u] != Double.MAX_VALUE && ((Double) distancia[u] + (Double) peso < (Double) distancia[v])) {
                System.out.println("O grafo contém um ciclo de peso negativo!");
                return;
            }
        }

        // Imprime as distâncias mais curtas
        for (int i = 0; i < V; ++i) {
            System.out.println("Distância do vértice " + origem + " ao vértice " + i + " é " + distancia[i]);
        }
    }
}

// Classe principal
public class Alg29 {
    public static void main(String[] args) {
        // Criando um grafo com 5 vértices e 8 arestas
        Grafo<Double> grafo = new Grafo<>(5, 8);

        // Adicionando as arestas ao grafo
        grafo.addAresta(0, 1, 6.0);
        grafo.addAresta(0, 2, 7.0);
        grafo.addAresta(1, 2, 8.0);
        grafo.addAresta(1, 3, -4.0);
        grafo.addAresta(1, 4, 5.0);
        grafo.addAresta(2, 3, 9.0);
        grafo.addAresta(2, 4, -3.0);
        grafo.addAresta(3, 4, 7.0);

        // Executando o algoritmo de Bellman-Ford a partir do vértice 0
        grafo.BellmanFord(0);
    }
}
