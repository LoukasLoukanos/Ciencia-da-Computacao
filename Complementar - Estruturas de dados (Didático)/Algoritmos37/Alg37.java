/*
♦ Algoritmo 37: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
*/


import java.util.*;

// Classe para representar um nó do grafo genérico
class No<T> {
    T valor;
    List<No<T>> vizinhos;

    public No(T valor) {
        this.valor = valor;
        this.vizinhos = new ArrayList<>();
    }

    public void adicionarVizinho(No<T> vizinho) {
        this.vizinhos.add(vizinho);
    }
}

// Classe para representar o Grafo Genérico
class Grafo<T> {
    private Map<T, No<T>> nos;

    public Grafo() {
        this.nos = new HashMap<>();
    }

    public void adicionarNo(T valor) {
        if (!nos.containsKey(valor)) {
            nos.put(valor, new No<>(valor));
        }
    }

    public void adicionarAresta(T origem, T destino) {
        if (!nos.containsKey(origem)) {
            adicionarNo(origem);
        }
        if (!nos.containsKey(destino)) {
            adicionarNo(destino);
        }
        nos.get(origem).adicionarVizinho(nos.get(destino));
    }

    // Método de busca em profundidade (DFS)
    public void DFS(T inicio) {
        Set<T> visitados = new HashSet<>();
        DFSRecursivo(nos.get(inicio), visitados);
    }

    private void DFSRecursivo(No<T> no, Set<T> visitados) {
        visitados.add(no.valor);
        System.out.print(no.valor + " ");

        for (No<T> vizinho : no.vizinhos) {
            if (!visitados.contains(vizinho.valor)) {
                DFSRecursivo(vizinho, visitados);
            }
        }
    }
}

// Classe principal para teste
public class Alg37 {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<>();

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 0);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 3);

        System.out.println("Busca em Profundidade (DFS) a partir do vértice 2:");
        grafo.DFS(2);
    }
}
