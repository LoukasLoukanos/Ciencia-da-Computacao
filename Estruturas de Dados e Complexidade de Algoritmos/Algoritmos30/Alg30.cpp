/*
♦ Algoritmo 30: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Kruskal.
*/


#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Estrutura para representar uma aresta em um grafo ponderado
template<typename T>
struct Aresta {
    int origem, destino;
    T peso;

    Aresta(int origem, int destino, T peso) : origem(origem), destino(destino), peso(peso) {}

    // Sobrecarga do operador < para comparar arestas com base em seus pesos
    bool operator<(const Aresta<T>& outra) const {
        return peso < outra.peso;
    }
};

// Classe para representar um grafo ponderado usando lista de adjacência
template<typename T>
class Grafo {
public:
    int V; // Número de vértices
    vector<Aresta<T>> arestas;

    Grafo(int V) : V(V) {}

    // Adiciona uma aresta ao grafo
    void addAresta(int origem, int destino, T peso) {
        arestas.push_back(Aresta<T>(origem, destino, peso));
    }

    // Algoritmo de Kruskal para encontrar a árvore geradora mínima
    vector<Aresta<T>> kruskal() {
        // Ordena as arestas por peso
        sort(arestas.begin(), arestas.end());

        vector<Aresta<T>> arvoreGeradoraMinima;
        UnionFind uf(V);

        for (const Aresta<T>& aresta : arestas) {
            if (!uf.connected(aresta.origem, aresta.destino)) {
                arvoreGeradoraMinima.push_back(aresta);
                uf.unionSets(aresta.origem, aresta.destino);
            }
        }

        return arvoreGeradoraMinima;
    }
};

// Classe Union-Find para representar uma estrutura de dados para detecção de ciclos
class UnionFind {
private:
    vector<int> parent;
    vector<int> rank;

public:
    UnionFind(int n) {
        parent.resize(n);
        rank.resize(n);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Encontra o representante (raiz) do conjunto ao qual o elemento pertence
    int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Une os conjuntos que contêm os elementos x e y
    void unionSets(int x, int y) {
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
    bool connected(int x, int y) {
        return find(x) == find(y);
    }
};

// Função principal
int main() {
    // Criando um grafo com 4 vértices
    Grafo<int> grafo(4);

    // Adicionando as arestas ao grafo com seus pesos
    grafo.addAresta(0, 1, 10);
    grafo.addAresta(0, 2, 6);
    grafo.addAresta(0, 3, 5);
    grafo.addAresta(1, 3, 15);
    grafo.addAresta(2, 3, 4);

    // Executando o algoritmo de Kruskal
    vector<Aresta<int>> arvoreGeradoraMinima = grafo.kruskal();

    // Imprimindo a árvore geradora mínima
    for (const Aresta<int>& aresta : arvoreGeradoraMinima) {
        cout << "Aresta: " << aresta.origem << " - " << aresta.destino << ", Peso: " << aresta.peso << endl;
    }

    return 0;
}
