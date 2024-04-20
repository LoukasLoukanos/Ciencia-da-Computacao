/*
♦ Algoritmo 26: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Largura (Breadth-First Search - BFS).
*/


import java.util.*;

// Classe para representar um grafo não direcionado usando listas de adjacência
class Grafo<T> {
    private Map<T, List<T>> adjacencias;

    // Construtor
    Grafo() {
        adjacencias = new HashMap<>();
    }

    // Método para adicionar uma aresta ao grafo
    void adicionarAresta(T origem, T destino) {
        adjacencias.putIfAbsent(origem, new ArrayList<>());
        adjacencias.putIfAbsent(destino, new ArrayList<>());
        adjacencias.get(origem).add(destino);
        adjacencias.get(destino).add(origem); // Se o grafo é não direcionado, adicione a aresta em ambas as direções
    }

    // Algoritmo de busca em largura a partir de um vértice "inicio"
    void BFS(T inicio) {
        // Conjunto para marcar vértices visitados
        Set<T> visitados = new HashSet<>();

        // Fila para a BFS
        Queue<T> fila = new LinkedList<>();
        
        // Marca o vértice inicial como visitado e o adiciona à fila
        visitados.add(inicio);
        fila.add(inicio);

        while (!fila.isEmpty()) {
            // Remove um vértice da fila e imprime
            T vertice = fila.poll();
            System.out.print(vertice + " ");

            // Obtém todos os vértices adjacentes ao vértice desenfileirado
            // Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
            for (T adjacente : adjacencias.getOrDefault(vertice, new ArrayList<>())) {
                if (!visitados.contains(adjacente)) {
                    visitados.add(adjacente);
                    fila.add(adjacente);
                }
            }
        }
    }

    // Método principal para testar o algoritmo BFS
    public static void main(String[] args) {
        // Criação do grafo de exemplo
        Grafo<Integer> grafo = new Grafo<>();
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 0);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 3);

        // Executa a busca em largura a partir do vértice 2
        System.out.println("Busca em Largura (BFS) começando do vértice 2:");
        grafo.BFS(2);
    }
}
