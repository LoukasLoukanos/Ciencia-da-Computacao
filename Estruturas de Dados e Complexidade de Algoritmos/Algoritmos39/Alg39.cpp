/*
♦ Algoritmo 39: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Bellman-Ford.
*/


#include <iostream>
#include <vector>
#include <unordered_map>
#include <limits>

template<typename T>
class No;

template<typename T>
class Aresta {
private:
    No<T>* destino;
    int peso;

public:
    Aresta(No<T>* destino, int peso) : destino(destino), peso(peso) {}

    No<T>* getDestino() {
        return destino;
    }

    int getPeso() {
        return peso;
    }
};

template<typename T>
class No {
private:
    T valor;
    std::vector<Aresta<T>> arestas;

public:
    No(T valor) : valor(valor) {}

    T getValor() {
        return valor;
    }

    std::vector<Aresta<T>>& getArestas() {
        return arestas;
    }

    void adicionarAresta(No<T>* destino, int peso) {
        arestas.push_back(Aresta<T>(destino, peso));
    }
};

template<typename T>
class Grafo {
private:
    std::unordered_map<T, No<T>*> nos;

public:
    Grafo() {}

    void adicionarNo(T valor) {
        if (nos.find(valor) == nos.end()) {
            nos[valor] = new No<T>(valor);
        }
    }

    void adicionarAresta(T origem, T destino, int peso) {
        adicionarNo(origem);
        adicionarNo(destino);
        nos[origem]->adicionarAresta(nos[destino], peso);
    }

    std::unordered_map<T, int> bellmanFord(T origem) {
        std::unordered_map<T, int> distancias;
        for (auto& it : nos) {
            distancias[it.first] = std::numeric_limits<int>::max();
        }
        distancias[origem] = 0;

        // Relaxamento de arestas repetido |V| - 1 vezes
        for (size_t i = 0; i < nos.size() - 1; i++) {
            for (auto& it : nos) {
                for (auto& aresta : it.second->getArestas()) {
                    T u = it.first;
                    T v = aresta.getDestino()->getValor();
                    int peso = aresta.getPeso();
                    if (distancias[u] != std::numeric_limits<int>::max() && distancias[u] + peso < distancias[v]) {
                        distancias[v] = distancias[u] + peso;
                    }
                }
            }
        }

        // Detecção de ciclos negativos
        for (size_t i = 0; i < nos.size() - 1; i++) {
            for (auto& it : nos) {
                for (auto& aresta : it.second->getArestas()) {
                    T u = it.first;
                    T v = aresta.getDestino()->getValor();
                    int peso = aresta.getPeso();
                    if (distancias[u] != std::numeric_limits<int>::max() && distancias[u] + peso < distancias[v]) {
                        throw std::runtime_error("Ciclo negativo detectado");
                    }
                }
            }
        }

        return distancias;
    }
};

int main() {
    Grafo<char> grafo;

    grafo.adicionarAresta('A', 'B', 10);
    grafo.adicionarAresta('A', 'C', 15);
    grafo.adicionarAresta('B', 'D', 12);
    grafo.adicionarAresta('B', 'F', 15);
    grafo.adicionarAresta('C', 'E', 10);
    grafo.adicionarAresta('D', 'E', 2);
    grafo.adicionarAresta('D', 'F', 1);
    grafo.adicionarAresta('F', 'E', 5);

    try {
        std::unordered_map<char, int> distancias = grafo.bellmanFord('A');
        for (auto& vertice : distancias) {
            std::cout << "Distância de A até " << vertice.first << ": " << vertice.second << std::endl;
        }
    } catch (std::runtime_error& e) {
        std::cout << e.what() << std::endl;
    }

    return 0;
}
