/*
♦ Algoritmo 38: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Dijkstra.
*/


import java.util.*;

class Aresta<T> {
    private No<T> destino;
    private int peso;

    public Aresta(No<T> destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public No<T> getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
}

class No<T> {
    private T valor;
    private List<Aresta<T>> arestas;

    public No(T valor) {
        this.valor = valor;
        this.arestas = new ArrayList<>();
    }

    public T getValor() {
        return valor;
    }

    public List<Aresta<T>> getArestas() {
        return arestas;
    }

    public void adicionarAresta(No<T> destino, int peso) {
        arestas.add(new Aresta<>(destino, peso));
    }
}

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

    public void adicionarAresta(T origem, T destino, int peso) {
        adicionarNo(origem);
        adicionarNo(destino);
        nos.get(origem).adicionarAresta(nos.get(destino), peso);
    }

    public Map<T, Integer> dijkstra(T origem) {
        Map<T, Integer> distancias = new HashMap<>();
        PriorityQueue<No<T>> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (T valor : nos.keySet()) {
            distancias.put(valor, Integer.MAX_VALUE);
        }

        distancias.put(origem, 0);
        filaPrioridade.add(nos.get(origem));

        while (!filaPrioridade.isEmpty()) {
            No<T> noAtual = filaPrioridade.poll();
            int distanciaAtual = distancias.get(noAtual.getValor());

            for (Aresta<T> aresta : noAtual.getArestas()) {
                No<T> vizinho = aresta.getDestino();
                int novaDistancia = distanciaAtual + aresta.getPeso();

                if (novaDistancia < distancias.get(vizinho.getValor())) {
                    distancias.put(vizinho.getValor(), novaDistancia);
                    filaPrioridade.add(vizinho);
                }
            }
        }

        return distancias;
    }
}

public class Alg38 {
    public static void main(String[] args) {
        Grafo<Character> grafo = new Grafo<>();

        grafo.adicionarAresta('A', 'B', 10);
        grafo.adicionarAresta('A', 'C', 15);
        grafo.adicionarAresta('B', 'D', 12);
        grafo.adicionarAresta('B', 'F', 15);
        grafo.adicionarAresta('C', 'E', 10);
        grafo.adicionarAresta('D', 'E', 2);
        grafo.adicionarAresta('D', 'F', 1);
        grafo.adicionarAresta('F', 'E', 5);

        Map<Character, Integer> distancias = grafo.dijkstra('A');
        for (Character vertice : distancias.keySet()) {
            System.out.println("Distância de A até " + vertice + ": " + distancias.get(vertice));
        }
    }
}
