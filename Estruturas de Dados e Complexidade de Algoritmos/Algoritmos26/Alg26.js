/*
♦ Algoritmo 26: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Largura (Breadth-First Search - BFS).
*/


// Classe para representar um grafo não direcionado usando listas de adjacência
class Grafo {
    constructor() {
        this.adjacencias = new Map();
    }

    // Método para adicionar uma aresta ao grafo
    adicionarAresta(origem, destino) {
        if (!this.adjacencias.has(origem)) {
            this.adjacencias.set(origem, []);
        }
        if (!this.adjacencias.has(destino)) {
            this.adjacencias.set(destino, []);
        }
        this.adjacencias.get(origem).push(destino);
        this.adjacencias.get(destino).push(origem); // Se o grafo é não direcionado, adicione a aresta em ambas as direções
    }

    // Algoritmo de busca em largura a partir de um vértice "inicio"
    BFS(inicio) {
        // Conjunto para marcar vértices visitados
        const visitados = new Set();

        // Fila para a BFS
        const fila = [];

        // Marca o vértice inicial como visitado e o adiciona à fila
        visitados.add(inicio);
        fila.push(inicio);

        while (fila.length !== 0) {
            // Remove um vértice da fila e imprime
            const vertice = fila.shift();
            process.stdout.write(vertice + " ");

            // Obtém todos os vértices adjacentes ao vértice desenfileirado
            // Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
            for (const adjacente of this.adjacencias.get(vertice) || []) {
                if (!visitados.has(adjacente)) {
                    visitados.add(adjacente);
                    fila.push(adjacente);
                }
            }
        }
    }
}

// Criação do grafo de exemplo
const grafo = new Grafo();
grafo.adicionarAresta(0, 1);
grafo.adicionarAresta(0, 2);
grafo.adicionarAresta(1, 2);
grafo.adicionarAresta(2, 0);
grafo.adicionarAresta(2, 3);
grafo.adicionarAresta(3, 3);

// Executa a busca em largura a partir do vértice 2
process.stdout.write("Busca em Largura (BFS) começando do vértice 2:\n");
grafo.BFS(2);
