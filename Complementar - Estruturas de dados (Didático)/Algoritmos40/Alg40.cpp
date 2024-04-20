/*
♦ Algoritmo 40: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Floyd-Warshall.
*/


#include <iostream>
#include <unordered_map>
#include <map>
#include <vector>
#include <limits>

template <typename T>
class FloydWarshall {
private:
    std::unordered_map<T, std::unordered_map<T, int>> distancias;
    std::unordered_map<T, std::unordered_map<T, T>> predecessores;

public:
    FloydWarshall() {}

    void adicionarVertice(T vertice) {
        if (distancias.find(vertice) == distancias.end()) {
            distancias[vertice] = {};
            predecessores[vertice] = {};
        }
    }

    void adicionarAresta(T origem, T destino, int peso) {
        adicionarVertice(origem);
        adicionarVertice(destino);

        distancias[origem][destino] = peso;
        predecessores[origem][destino] = origem;

        distancias[destino][origem] = peso;
        predecessores[destino][origem] = destino;
    }

    void floydWarshall() {
        for (auto& kvp_k : distancias) {
            for (auto& kvp_i : distancias) {
                for (auto& kvp_j : distancias) {
                    T k = kvp_k.first;
                    T i = kvp_i.first;
                    T j = kvp_j.first;

                    if (distancias[i].count(k) && distancias[k].count(j)) {
                        int novoPeso = distancias[i][k] + distancias[k][j];
                        if (!distancias[i].count(j) || novoPeso < distancias[i][j]) {
                            distancias[i][j] = novoPeso;
                            predecessores[i][j] = predecessores[k][j];
                        }
                    }
                }
            }
        }
    }

    std::unordered_map<T, std::unordered_map<T, int>> obterDistancias() {
        return distancias;
    }

    std::unordered_map<T, std::unordered_map<T, T>> obterPredecessores() {
        return predecessores;
    }
};

int main() {
    FloydWarshall<char> floydWarshall;

    floydWarshall.adicionarAresta('A', 'B', 10);
    floydWarshall.adicionarAresta('A', 'C', 15);
    floydWarshall.adicionarAresta('B', 'D', 12);
    floydWarshall.adicionarAresta('B', 'F', 15);
    floydWarshall.adicionarAresta('C', 'E', 10);
    floydWarshall.adicionarAresta('D', 'E', 2);
    floydWarshall.adicionarAresta('D', 'F', 1);
    floydWarshall.adicionarAresta('F', 'E', 5);

    floydWarshall.floydWarshall();

    auto distancias = floydWarshall.obterDistancias();
    auto predecessores = floydWarshall.obterPredecessores();

    for (auto& kvp_u : distancias) {
        for (auto& kvp_v : kvp_u.second) {
            std::cout << "Distância de " << kvp_u.first << " até " << kvp_v.first << ": " << kvp_v.second << std::endl;
        }
    }

    for (auto& kvp_u : predecessores) {
        for (auto& kvp_v : kvp_u.second) {
            std::cout << "Predecessor de " << kvp_v.first << " no caminho de " << kvp_u.first << " até " << kvp_v.first << ": " << kvp_v.second << std::endl;
        }
    }

    return 0;
}
