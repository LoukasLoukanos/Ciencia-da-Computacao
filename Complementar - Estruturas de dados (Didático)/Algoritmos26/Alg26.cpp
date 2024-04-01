/*
♦ Algoritmo 26: Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo - Busca em Largura (Breadth-First Search - BFS).
*/


#include <iostream>
#include <unordered_map>
#include <vector>
#include <queue>
#include <unordered_set>

template <typename T>
class Grafo {
private:
    std::unordered_map<T, std::vector<T>> adjacencias;

public:
    // Construtor
    Grafo() {}

    // Método para adicionar uma aresta ao grafo
    void adicionarAresta(T origem, T destino) {
        adjacencias[origem].push_back(destino);
        adjacencias[destino].push_back(origem); // Se o grafo é não direcionado, adicione a aresta em ambas as direções
    }

    // Algoritmo de busca em largura a partir de um vértice "inicio"
    void BFS(T inicio) {
        // Conjunto para marcar vértices visitados
        std::unordered_set<T> visitados;

        // Fila para a BFS
        std::queue<T> fila;

        // Marca o vértice inicial como visitado e o adiciona à fila
        visitados.insert(inicio);
        fila.push(inicio);

        while (!fila.empty()) {
            // Remove um vértice da fila e imprime
            T vertice = fila.front();
            fila.pop();
            std::cout << vertice << " ";

            // Obtém todos os vértices adjacentes ao vértice desenfileirado
            // Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
            for (const T& adjacente : adjacencias[vertice]) {
                if (visitados.find(adjacente) == visitados.end()) {
                    visitados.insert(adjacente);
                    fila.push(adjacente);
                }
            }
        }
    }
};

// Função principal para testar o algoritmo BFS
int main() {
    // Criação do grafo de exemplo
    Grafo<int> grafo;
    grafo.adicionarAresta(0, 1);
    grafo.adicionarAresta(0, 2);
    grafo.adicionarAresta(1, 2);
    grafo.adicionarAresta(2, 0);
    grafo.adicionarAresta(2, 3);
    grafo.adicionarAresta(3, 3);

    // Executa a busca em largura a partir do vértice 2
    std::cout << "Busca em Largura (BFS) começando do vértice 2:\n";
    grafo.BFS(2);

    return 0;
}
