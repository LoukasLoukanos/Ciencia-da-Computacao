/*
♦ Algoritmo 27: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
*/


import java.util.*;

class Grafo<T> {
    private Map<T, List<T>> adjacencias;

    Grafo() {
        adjacencias = new HashMap<>();
    }

    void adicionarAresta(T origem, T destino) {
        adjacencias.putIfAbsent(origem, new ArrayList<>());
        adjacencias.putIfAbsent(destino, new ArrayList<>());
        adjacencias.get(origem).add(destino);
        adjacencias.get(destino).add(origem); // Se o grafo é não direcionado, adicione a aresta em ambas as direções
    }

    void DFS(T inicio) {
        Set<T> visitados = new HashSet<>();
        Stack<T> pilha = new Stack<>();
        
        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            T vertice = pilha.pop();

            if (!visitados.contains(vertice)) {
                System.out.print(vertice + " ");
                visitados.add(vertice);

                for (T adjacente : adjacencias.getOrDefault(vertice, new ArrayList<>())) {
                    if (!visitados.contains(adjacente)) {
                        pilha.push(adjacente);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<>();
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 0);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 3);

        System.out.println("Busca em Profundidade (DFS) começando do vértice 2:");
        grafo.DFS(2);
    }
}
