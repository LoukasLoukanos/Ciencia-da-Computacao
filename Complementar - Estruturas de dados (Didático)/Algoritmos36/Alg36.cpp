/*
♦ Algoritmo 36: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Largura (Breadth-First Search - BFS).
*/


#include <iostream>
#include <list>
#include <queue>

using namespace std;

class Grafo {
    int V; // Número de vértices
    list<int> *adj; // Lista de adjacência

public:
    // Construtor
    Grafo(int v) {
        V = v;
        adj = new list<int>[v];
    }

    // Destrutor
    ~Grafo() {
        delete[] adj;
    }

    // Adiciona uma aresta ao grafo
    void adicionarAresta(int v, int w) {
        adj[v].push_back(w);
    }

    // Executa a busca em largura a partir de um vértice inicial
    void BFS(int s) {
        // Marca todos os vértices como não visitados
        bool *visitados = new bool[V];
        for (int i = 0; i < V; ++i)
            visitados[i] = false;

        // Cria uma fila para o BFS
        queue<int> fila;

        // Marca o vértice atual como visitado e o adiciona à fila
        visitados[s] = true;
        fila.push(s);

        while (!fila.empty()) {
            // Remove um vértice da fila e imprime
            s = fila.front();
            cout << s << " ";
            fila.pop();

            // Obtém todos os vértices adjacentes do vértice removido da fila
            for (auto i = adj[s].begin(); i != adj[s].end(); ++i) {
                int n = *i;
                // Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
                if (!visitados[n]) {
                    visitados[n] = true;
                    fila.push(n);
                }
            }
        }

        delete[] visitados;
    }
};

int main() {
    Grafo g(4);

    g.adicionarAresta(0, 1);
    g.adicionarAresta(0, 2);
    g.adicionarAresta(1, 2);
    g.adicionarAresta(2, 0);
    g.adicionarAresta(2, 3);
    g.adicionarAresta(3, 3);

    cout << "Busca em Largura (BFS) a partir do vértice 2:" << endl;
    g.BFS(2);

    return 0;
}
