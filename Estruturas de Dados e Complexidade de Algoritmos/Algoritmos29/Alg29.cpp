/*
♦ Algoritmo 29: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Bellman-Ford.
*/


#include <iostream>
#include <vector>
#include <limits>

// Classe para representar uma aresta em um grafo ponderado
template <typename T>
class Aresta {
public:
    int origem, destino;
    T peso;

    Aresta(int origem, int destino, T peso) : origem(origem), destino(destino), peso(peso) {}
};

// Classe para representar um grafo ponderado usando matriz de adjacência
template <typename T>
class Grafo {
public:
    int V, E; // Número de vértices e arestas
    std::vector<Aresta<T>> arestas;

    Grafo(int V, int E) : V(V), E(E) {}

    // Adiciona uma aresta ao grafo
    void addAresta(int origem, int destino, T peso) {
        arestas.push_back(Aresta<T>(origem, destino, peso));
    }

    // Algoritmo de Bellman-Ford para encontrar o caminho mais curto
    void BellmanFord(int origem) {
        // Inicializa as distâncias de todos os vértices como infinito
        std::vector<T> distancia(V, std::numeric_limits<T>::max());
        
        // A distância do vértice de origem para ele mesmo é 0
        distancia[origem] = static_cast<T>(0);

        // Relaxamento das arestas
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = arestas[j].origem;
                int v = arestas[j].destino;
                T peso = arestas[j].peso;
                if (distancia[u] != std::numeric_limits<T>::max() && distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                }
            }
        }

        // Verifica ciclos de peso negativo
        for (int i = 0; i < E; ++i) {
            int u = arestas[i].origem;
            int v = arestas[i].destino;
            T peso = arestas[i].peso;
            if (distancia[u] != std::numeric_limits<T>::max() && distancia[u] + peso < distancia[v]) {
                std::cout << "O grafo contém um ciclo de peso negativo!" << std::endl;
                return;
            }
        }

        // Imprime as distâncias mais curtas
        for (int i = 0; i < V; ++i) {
            std::cout << "Distância do vértice " << origem << " ao vértice " << i << " é " << distancia[i] << std::endl;
        }
    }
};

// Função principal
int main() {
    // Criando um grafo com 5 vértices e 8 arestas
    Grafo<double> grafo(5, 8);

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

    return 0;
}
