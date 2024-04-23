/*
♦ Algoritmo 38: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Dijkstra.
*/


#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>
#include <limits>

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

    std::unordered_map<T, int> dijkstra(T origem) {
        std::unordered_map<T, int> distancias;
        std::priority_queue<No<T>*, std::vector<No<T>*>, ComparadorDistancia<T>> filaPrioridade;

        for (const auto& par : nos) {
            distancias[par.first] = std::numeric_limits<int>::max();
        }

        distancias[origem] = 0;
        filaPrioridade.push(nos[origem]);

        while (!filaPrioridade.empty()) {
            No<T>* noAtual = filaPrioridade.top();
            filaPrioridade.pop();
            int distanciaAtual = distancias[noAtual->getValor()];

            for (const auto& aresta : noAtual->getArestas()) {
                No<T>* vizinho = aresta.getDestino();
                int novaDistancia = distanciaAtual + aresta.getPeso();

                if (novaDistancia < distancias[vizinho->getValor()]) {
                    distancias[vizinho->getValor()] = novaDistancia;
                    filaPrioridade.push(vizinho);
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

    auto distancias = grafo.dijkstra('A');
    for (const auto& par : distancias) {
        std::cout << "Distância de A até " << par.first << ": " << par.second << std::endl;
    }

    return 0;
}
