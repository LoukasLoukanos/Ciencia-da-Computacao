/*
♦ Algoritmo 37: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
*/


#include <iostream>
#include <unordered_map>
#include <vector>
#include <unordered_set>

using namespace std;

// Classe para representar um nó do grafo genérico
template<typename T>
class No {
public:
    T valor;
    vector<No<T>*> vizinhos;

    No(T valor) : valor(valor) {}
    
    void adicionarVizinho(No<T>* vizinho) {
        vizinhos.push_back(vizinho);
    }
};

// Classe para representar o Grafo Genérico
template<typename T>
class Grafo {
private:
    unordered_map<T, No<T>*> nos;

public:
    Grafo() {}

    void adicionarNo(T valor) {
        if (nos.find(valor) == nos.end()) {
            nos[valor] = new No<T>(valor);
        }
    }

    void adicionarAresta(T origem, T destino) {
        adicionarNo(origem);
        adicionarNo(destino);
        nos[origem]->adicionarVizinho(nos[destino]);
    }

    // Método de busca em profundidade (DFS)
    void DFS(T inicio) {
        unordered_set<T> visitados;
        DFSRecursivo(nos[inicio], visitados);
    }

private:
    void DFSRecursivo(No<T>* no, unordered_set<T>& visitados) {
        visitados.insert(no->valor);
        cout << no->valor << " ";

        for (No<T>* vizinho : no->vizinhos) {
            if (visitados.find(vizinho->valor) == visitados.end()) {
                DFSRecursivo(vizinho, visitados);
            }
        }
    }
};

// Função principal para teste
int main() {
    Grafo<int> grafo;

    grafo.adicionarAresta(0, 1);
    grafo.adicionarAresta(0, 2);
    grafo.adicionarAresta(1, 2);
    grafo.adicionarAresta(2, 0);
    grafo.adicionarAresta(2, 3);
    grafo.adicionarAresta(3, 3);

    cout << "Busca em Profundidade (DFS) a partir do vértice 2:" << endl;
    grafo.DFS(2);

    return 0;
}
