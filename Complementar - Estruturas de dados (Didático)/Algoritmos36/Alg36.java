/*
♦ Algoritmo 36: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Largura (Breadth-First Search - BFS).
*/


import java.util.*;

public class Alg36 {
    private int V; // Número de vértices
    private LinkedList<Integer> adj[]; // Lista de adjacência

    // Construtor
    Alg36(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Adiciona uma aresta ao grafo
    void adicionarAresta(int v, int w) {
        adj[v].add(w);
    }

    // Executa a busca em largura a partir de um vértice inicial
    void BFS(int s) {
        // Marca todos os vértices como não visitados
        boolean visitados[] = new boolean[V];

        // Cria uma fila para o BFS
        LinkedList<Integer> fila = new LinkedList<Integer>();

        // Marca o vértice atual como visitado e o adiciona à fila
        visitados[s] = true;
        fila.add(s);

        while (fila.size() != 0) {
            // Remove um vértice da fila e imprime
            s = fila.poll();
            System.out.print(s + " ");

            // Obtém todos os vértices adjacentes do vértice removido da fila
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                // Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
                if (!visitados[n]) {
                    visitados[n] = true;
                    fila.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Alg36 g = new Alg36(4);

        g.adicionarAresta(0, 1);
        g.adicionarAresta(0, 2);
        g.adicionarAresta(1, 2);
        g.adicionarAresta(2, 0);
        g.adicionarAresta(2, 3);
        g.adicionarAresta(3, 3);

        System.out.println("Busca em Largura (BFS) a partir do vértice 2:");
        g.BFS(2);
    }
}
