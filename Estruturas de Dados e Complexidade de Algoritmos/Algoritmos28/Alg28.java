/*
♦ Algoritmo 28: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Dijkstra.
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
    }

    // Algoritmo de Dijkstra para encontrar os menores caminhos a partir de um vértice origem
    public Map<Vertice<T>, Double> dijkstra(Vertice<T> origem) {
        Map<Vertice<T>, Double> distancia = new HashMap<>();
        PriorityQueue<Vertice<T>> filaPrioridade = new PriorityQueue<>(Comparator.comparingDouble(distancia::get));

        // Inicialização das distâncias
        for (Vertice<T> v : adjacencia.keySet()) {
            if (v.equals(origem)) {
                distancia.put(v, 0.0);
            } else {
                distancia.put(v, Double.POSITIVE_INFINITY);
            }
            filaPrioridade.add(v);
        }

        while (!filaPrioridade.isEmpty()) {
            Vertice<T> u = filaPrioridade.poll();
            for (Aresta<T> aresta : adjacencia.getOrDefault(u, Collections.emptyList())) {
                Vertice<T> v = aresta.destino;
                double novaDistancia = distancia.get(u) + aresta.peso;
                if (novaDistancia < distancia.get(v)) {
                    distancia.put(v, novaDistancia);
                    filaPrioridade.remove(v);
                    filaPrioridade.add(v);
                }
            }
        }

        return distancia;
    }
}

// Classe principal
public class Alg28 {
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
        grafo.addAresta(A, B, 10);
        grafo.addAresta(A, C, 15);
        grafo.addAresta(B, D, 12);
        grafo.addAresta(B, E, 15);
        grafo.addAresta(C, D, 10);
        grafo.addAresta(C, E, 5);
        grafo.addAresta(D, E, 10);

        // Executando o algoritmo de Dijkstra a partir do vértice A
        Map<Vertice<String>, Double> menoresCaminhos = grafo.dijkstra(A);

        // Imprimindo os menores caminhos
        for (Vertice<String> v : menoresCaminhos.keySet()) {
            System.out.println("Menor caminho de A para " + v.valor + ": " + menoresCaminhos.get(v));
        }
    }
}
