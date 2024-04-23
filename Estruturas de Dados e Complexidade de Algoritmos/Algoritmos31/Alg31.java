/*
♦ Algoritmo 31: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Prim.
*/


import java.util.*;

// Classe para representar um vértice no grafo
class Vertice<T> implements Comparable<Vertice<T>> {
    int indice;
    T valor;

    public Vertice(int indice, T valor) {
        this.indice = indice;
        this.valor = valor;
    }

    // Método para comparar vértices com base em seus valores
    @Override
    public int compareTo(Vertice<T> outro) {
        if (this.valor instanceof Comparable) {
            return ((Comparable<T>) this.valor).compareTo(outro.valor);
        } else {
            throw new UnsupportedOperationException("Tipo de valor não suportado para comparação.");
        }
    }
}

// Classe para representar uma aresta no grafo ponderado
class Aresta<T> {
    Vertice<T> destino;
    double peso;

    public Aresta(Vertice<T> destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

// Classe para representar um grafo ponderado usando lista de adjacência
class Grafo<T> {
    Map<Vertice<T>, List<Aresta<T>>> adjacencia;

    public Grafo() {
        adjacencia = new HashMap<>();
    }

    // Adiciona uma aresta ao grafo
    public void addAresta(Vertice<T> origem, Vertice<T> destino, double peso) {
        adjacencia.computeIfAbsent(origem, k -> new ArrayList<>()).add(new Aresta<>(destino, peso));
        adjacencia.computeIfAbsent(destino, k -> new ArrayList<>()).add(new Aresta<>(origem, peso)); // Para grafos não direcionados
    }

    // Algoritmo de Prim para encontrar a árvore geradora mínima
    public List<Aresta<T>> prim(Vertice<T> origem) {
        Set<Vertice<T>> visitados = new HashSet<>();
        List<Aresta<T>> arvoreGeradoraMinima = new ArrayList<>();
        PriorityQueue<Aresta<T>> filaPrioridade = new PriorityQueue<>(Comparator.comparingDouble(a -> a.peso));

        visitados.add(origem);
        adicionarArestasAdjacentes(origem, filaPrioridade, visitados);

        while (!filaPrioridade.isEmpty()) {
            Aresta<T> aresta = filaPrioridade.poll();
            Vertice<T> destino = aresta.destino;

            if (!visitados.contains(destino)) {
                visitados.add(destino);
                arvoreGeradoraMinima.add(aresta);
                adicionarArestasAdjacentes(destino, filaPrioridade, visitados);
            }
        }

        return arvoreGeradoraMinima;
    }

    private void adicionarArestasAdjacentes(Vertice<T> vertice, PriorityQueue<Aresta<T>> filaPrioridade, Set<Vertice<T>> visitados) {
        for (Aresta<T> aresta : adjacencia.getOrDefault(vertice, Collections.emptyList())) {
            if (!visitados.contains(aresta.destino)) {
                filaPrioridade.add(aresta);
            }
        }
    }
}

// Classe principal
public class Alg31 {
    public static void main(String[] args) {
        // Criando um grafo
        Grafo<String> grafo = new Grafo<>();

        // Criando vértices
        Vertice<String> A = new Vertice<>(0, "A");
        Vertice<String> B = new Vertice<>(1, "B");
        Vertice<String> C = new Vertice<>(2, "C");
        Vertice<String> D = new Vertice<>(3, "D");
        Vertice<String> E = new Vertice<>(4, "E");

        // Adicionando arestas ao grafo
        grafo.addAresta(A, B, 4);
        grafo.addAresta(A, C, 1);
        grafo.addAresta(B, C, 2);
        grafo.addAresta(B, D, 5);
        grafo.addAresta(C, D, 8);
        grafo.addAresta(C, E, 10);
        grafo.addAresta(D, E, 2);

        // Executando o algoritmo de Prim a partir do vértice A
        List<Aresta<String>> arvoreGeradoraMinima = grafo.prim(A);

        // Imprimindo a árvore geradora mínima
        for (Aresta<String> aresta : arvoreGeradoraMinima) {
            System.out.println("Aresta: " + aresta.destino.valor + ", Peso: " + aresta.peso);
        }
    }
}
