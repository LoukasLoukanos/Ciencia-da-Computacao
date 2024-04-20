/*
♦ Algoritmo 28: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Dijkstra.
*/


#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <algorithm>
#include <limits>

using namespace std;

// Classe para representar um vértice no grafo
template <typename T>
class Vertice {
public:
    int indice;
    T valor;

    Vertice(int indice, T valor) : indice(indice), valor(valor) {}

    // Método para comparar vértices com base em seus valores
    int compareTo(const Vertice<T>& outro) const {
        if (std::is_base_of<std::Comparable<T>, T>::value) {
            return valor.compareTo(outro.valor);
        } else {
            throw std::runtime_error("Tipo de valor não suportado para comparação.");
        }
    }
};

// Classe para representar uma aresta no grafo ponderado
template <typename T>
class Aresta {
public:
    Vertice<T>* destino;
    double peso;

    Aresta(Vertice<T>* destino, double peso) : destino(destino), peso(peso) {}
};

// Classe para representar um grafo ponderado usando lista de adjacência
template <typename T>
class Grafo {
public:
    map<Vertice<T>*, vector<Aresta<T>>> adjacencia;

    // Adiciona uma aresta ao grafo
    void addAresta(Vertice<T>* origem, Vertice<T>* destino, double peso) {
        adjacencia[origem].push_back(Aresta<T>(destino, peso));
    }

    // Algoritmo de Dijkstra para encontrar os menores caminhos a partir de um vértice origem
    map<Vertice<T>*, double> dijkstra(Vertice<T>* origem) {
        map<Vertice<T>*, double> distancia;
        priority_queue<Vertice<T>*, vector<Vertice<T>*>, function<bool(Vertice<T>*, Vertice<T>*)>> filaPrioridade(
            [&](Vertice<T>* a, Vertice<T>* b) {
                return distancia[a] > distancia[b];
            }
        );

        // Inicialização das distâncias
        for (auto& par : adjacencia) {
            Vertice<T>* v = par.first;
            if (v == origem) {
                distancia[v] = 0.0;
            } else {
                distancia[v] = numeric_limits<double>::infinity();
            }
            filaPrioridade.push(v);
        }

        while (!filaPrioridade.empty()) {
            Vertice<T>* u = filaPrioridade.top();
            filaPrioridade.pop();
            for (Aresta<T>& aresta : adjacencia[u]) {
                Vertice<T>* v = aresta.destino;
                double novaDistancia = distancia[u] + aresta.peso;
                if (novaDistancia < distancia[v]) {
                    distancia[v] = novaDistancia;
                    filaPrioridade.push(v);
                }
            }
        }

        return distancia;
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
    grafo.addAresta(&A, &B, 10);
    grafo.addAresta(&A, &C, 15);
    grafo.addAresta(&B, &D, 12);
    grafo.addAresta(&B, &E, 15);
    grafo.addAresta(&C, &D, 10);
    grafo.addAresta(&C, &E, 5);
    grafo.addAresta(&D, &E, 10);

    // Executando o algoritmo de Dijkstra a partir do vértice A
    map<Vertice<string>*, double> menoresCaminhos = grafo.dijkstra(&A);

    // Imprimindo os menores caminhos
    for (auto& par : menoresCaminhos) {
        Vertice<string>* v = par.first;
        cout << "Menor caminho de A para " << v->valor << ": " << par.second << endl;
    }

    return 0;
}
