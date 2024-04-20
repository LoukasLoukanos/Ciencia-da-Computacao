/*
♦ Algoritmo 32: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Floyd-Warshall.
*/


#include <iostream>
#include <unordered_map>
#include <map>
#include <vector>

using namespace std;

// Classe para representar o grafo
template<typename T>
class Grafo {
private:
    unordered_map<T, map<T, double>> adjacencia;

public:
    // Construtor
    Grafo() {}

    // Adiciona uma aresta ao grafo
    void addAresta(T origem, T destino, double peso) {
        adjacencia[origem][destino] = peso;
    }

    // Algoritmo de Floyd-Warshall para encontrar os menores caminhos entre todos os pares de vértices
    unordered_map<T, map<T, double>> floydWarshall() {
        unordered_map<T, map<T, double>> distancias = adjacencia;

        // Inicializa a diagonal com 0 e as outras posições com infinito
        for (auto &par1 : adjacencia) {
            for (auto &par2 : adjacencia) {
                T vertice1 = par1.first;
                T vertice2 = par2.first;
                if (vertice1 != vertice2 && distancias[vertice1].find(vertice2) == distancias[vertice1].end()) {
                    distancias[vertice1][vertice2] = numeric_limits<double>::infinity();
                }
            }
        }

        // Algoritmo de Floyd-Warshall
        for (auto &k : adjacencia) {
            for (auto &i : adjacencia) {
                for (auto &j : adjacencia) {
                    T verticeK = k.first;
                    T verticeI = i.first;
                    T verticeJ = j.first;
                    double distanciaIK = distancias[verticeI][verticeK];
                    double distanciaKJ = distancias[verticeK][verticeJ];
                    double distanciaIJ = distancias[verticeI][verticeJ];

                    if (distanciaIK + distanciaKJ < distanciaIJ) {
                        distancias[verticeI][verticeJ] = distanciaIK + distanciaKJ;
                    }
                }
            }
        }

        return distancias;
    }
};

// Função principal
int main() {
    // Criando um grafo
    Grafo<string> grafo;

    // Adicionando arestas ao grafo
    grafo.addAresta("A", "B", 3);
    grafo.addAresta("A", "C", 6);
    grafo.addAresta("B", "C", 2);
    grafo.addAresta("B", "D", 1);
    grafo.addAresta("C", "B", 4);
    grafo.addAresta("C", "D", 5);
    grafo.addAresta("D", "A", 3);

    // Executando o algoritmo de Floyd-Warshall
    auto distancias = grafo.floydWarshall();

    // Imprimindo as distâncias mínimas entre todos os pares de vértices
    for (auto &par1 : distancias) {
        for (auto &par2 : par1.second) {
            cout << "Distância de " << par1.first << " para " << par2.first << ": " << par2.second << endl;
        }
    }

    return 0;
}
