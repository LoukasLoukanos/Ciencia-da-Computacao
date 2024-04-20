/*
♦ Algoritmo 31: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Prim.
*/


#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>

using namespace std;

// Classe para representar um vértice no grafo
template<typename T>
class Vertice {
public:
    int indice;
    T valor;

    Vertice(int indice, T valor) : indice(indice), valor(valor) {}

    // Método para comparar vértices com base em seus valores
    bool operator<(const Vertice<T>& outro) const {
        return valor < outro.valor;
    }
};

// Classe para representar uma aresta no grafo ponderado
template<typename T>
class Aresta {
public:
    Vertice<T>* destino;
    double peso;

    Aresta(Vertice<T>* destino, double peso) : destino(destino), peso(peso) {}
};

// Classe para representar um grafo ponderado usando lista de adjacência
template<typename T>
class Grafo {
public:
    unordered_map<Vertice<T>*, vector<Aresta<T>>> adjacencia;

    // Adiciona uma aresta ao grafo
    void addAresta(Vertice<T>* origem, Vertice<T>* destino, double peso) {
        adjacencia[origem].emplace_back(destino, peso);
        adjacencia[destino].emplace_back(origem, peso); // Para grafos não direcionados
    }

    // Algoritmo de Prim para encontrar a árvore geradora mínima
    vector<Aresta<T>> prim(Vertice<T>* origem) {
        unordered_set<Vertice<T>*> visitados;
        vector<Aresta<T>> arvoreGeradoraMinima;
        priority_queue<Aresta<T>, vector<Aresta<T>>, function<bool(Aresta<T>, Aresta<T>)>> filaPrioridade(
            [](const Aresta<T>& a, const Aresta<T>& b) {
                return a.peso > b.peso;
            }
        );

        visitados.insert(origem);
        adicionarArestasAdjacentes(origem, filaPrioridade, visitados);

        while (!filaPrioridade.empty()) {
            Aresta<T> aresta = filaPrioridade.top();
            filaPrioridade.pop();
            Vertice<T>* destino = aresta.destino;

            if (visitados.find(destino) == visitados.end()) {
                visitados.insert(destino);
                arvoreGeradoraMinima.push_back(aresta);
                adicionarArestasAdjacentes(destino, filaPrioridade, visitados);
            }
        }

        return arvoreGeradoraMinima;
    }

private:
    void adicionarArestasAdjacentes(Vertice<T>* vertice, priority_queue<Aresta<T>, vector<Aresta<T>>, function<bool(Aresta<T>, Aresta<T>)>>& filaPrioridade, unordered_set<Vertice<T>*>& visitados) {
        for (Aresta<T>& aresta : adjacencia[vertice]) {
            if (visitados.find(aresta.destino) == visitados.end()) {
                filaPrioridade.push(aresta);
            }
        }
    }
};

// Classe principal
int main() {
    // Criando um grafo
    Grafo<string> grafo;

    // Criando vértices
    Vertice<string> A(0, "A");
    Vertice<string> B(1, "B");
    Vertice<string> C(2, "C");
    Vertice<string> D(3, "D");
    Vertice<string> E(4, "E");

    // Adicionando arestas ao grafo
    grafo.addAresta(&A, &B, 4);
    grafo.addAresta(&A, &C, 1);
    grafo.addAresta(&B, &C, 2);
    grafo.addAresta(&B, &D, 5);
    grafo.addAresta(&C, &D, 8);
    grafo.addAresta(&C, &E, 10);
    grafo.addAresta(&D, &E, 2);

    // Executando o algoritmo de Prim a partir do vértice A
    vector<Aresta<string>> arvoreGeradoraMinima = grafo.prim(&A);

    // Imprimindo a árvore geradora mínima
    for (const Aresta<string>& aresta : arvoreGeradoraMinima) {
        cout << "Aresta: " << aresta.destino->valor << ", Peso: " << aresta.peso << endl;
    }

    return 0;
}
