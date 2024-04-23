/*
♦ Algoritmo 30: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Kruskal.
*/


import java.util.*;

// Classe para representar uma aresta em um grafo ponderado
class Aresta<T> implements Comparable<Aresta<T>> {
    int origem, destino;
    T peso;

    public Aresta(int origem, int destino, T peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    // Método para comparar arestas com base em seus pesos
    @Override
    public int compareTo(Aresta<T> outra) {
        if (this.peso instanceof Comparable) {
            return ((Comparable<T>) this.peso).compareTo(outra.peso);
        } else {
            throw new UnsupportedOperationException("Tipo de peso não suportado para comparação.");
        }
    }
}

// Classe para representar um grafo ponderado usando lista de adjacência
class Grafo<T> {
    int V; // Número de vértices
    List<Aresta<T>> arestas;

    public Grafo(int V) {
        this.V = V;
        arestas = new ArrayList<>();
    }

    // Adiciona uma aresta ao grafo
    public void addAresta(int origem, int destino, T peso) {
        arestas.add(new Aresta<>(origem, destino, peso));
    }

    // Algoritmo de Kruskal para encontrar a árvore geradora mínima
    public List<Aresta<T>> kruskal() {
        // Ordena as arestas por peso
        Collections.sort(arestas);

        List<Aresta<T>> arvoreGeradoraMinima = new ArrayList<>();
        UnionFind uf = new UnionFind(V);

        for (Aresta<T> aresta : arestas) {
            if (!uf.connected(aresta.origem, aresta.destino)) {
                arvoreGeradoraMinima.add(aresta);
                uf.union(aresta.origem, aresta.destino);
            }
        }

        return arvoreGeradoraMinima;
    }
}

// Classe Union-Find para representar uma estrutura de dados para detecção de ciclos
class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Encontra o representante (raiz) do conjunto ao qual o elemento pertence
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Une os conjuntos que contêm os elementos x e y
    public void union(int x, int y) {
        int raizX = find(x);
        int raizY = find(y);
        if (raizX == raizY) return;
        if (rank[raizX] < rank[raizY]) {
            parent[raizX] = raizY;
        } else if (rank[raizX] > rank[raizY]) {
            parent[raizY] = raizX;
        } else {
            parent[raizY] = raizX;
            rank[raizX]++;
        }
    }

    // Verifica se dois elementos estão no mesmo conjunto
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

// Classe principal
public class Alg30 {
    public static void main(String[] args) {
        // Criando um grafo com 4 vértices
        Grafo<Integer> grafo = new Grafo<>(4);

        // Adicionando as arestas ao grafo com seus pesos
        grafo.addAresta(0, 1, 10);
        grafo.addAresta(0, 2, 6);
        grafo.addAresta(0, 3, 5);
        grafo.addAresta(1, 3, 15);
        grafo.addAresta(2, 3, 4);

        // Executando o algoritmo de Kruskal
        List<Aresta<Integer>> arvoreGeradoraMinima = grafo.kruskal();

        // Imprimindo a árvore geradora mínima
        for (Aresta<Integer> aresta : arvoreGeradoraMinima) {
            System.out.println("Aresta: " + aresta.origem + " - " + aresta.destino + ", Peso: " + aresta.peso);
        }
    }
}
