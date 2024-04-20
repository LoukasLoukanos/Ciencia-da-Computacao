/*
♦ Algoritmo 27: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
*/


#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <stack>

using namespace std;

template<typename T>
class Grafo {
private:
    unordered_map<T, vector<T>> adjacencias;

public:
    Grafo() {}

    void adicionarAresta(T origem, T destino) {
        adjacencias[origem].push_back(destino);
        adjacencias[destino].push_back(origem); // Se o grafo é não direcionado, adicione a aresta em ambas as direções
    }

    void DFS(T inicio) {
        unordered_set<T> visitados;
        stack<T> pilha;
        
        pilha.push(inicio);

        while (!pilha.empty()) {
            T vertice = pilha.top();
            pilha.pop();

            if (visitados.find(vertice) == visitados.end()) {
                cout << vertice << " ";
                visitados.insert(vertice);

                for (const T& adjacente : adjacencias[vertice]) {
                    if (visitados.find(adjacente) == visitados.end()) {
                        pilha.push(adjacente);
                    }
                }
            }
        }
    }
};

int main() {
    Grafo<int> grafo;
    grafo.adicionarAresta(0, 1);
    grafo.adicionarAresta(0, 2);
    grafo.adicionarAresta(1, 2);
    grafo.adicionarAresta(2, 0);
    grafo.adicionarAresta(2, 3);
    grafo.adicionarAresta(3, 3);

    cout << "Busca em Profundidade (DFS) começando do vértice 2:" << endl;
    grafo.DFS(2);

    return 0;
}
