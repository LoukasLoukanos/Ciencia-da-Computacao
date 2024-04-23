/*
♦ Algoritmo 27: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
*/


class Grafo {
    constructor() {
        this.adjacencias = new Map();
    }

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

    DFS(inicio) {
        const visitados = new Set();
        const pilha = [inicio];

        while (pilha.length > 0) {
            const vertice = pilha.pop();

            if (!visitados.has(vertice)) {
                console.log(vertice);
                visitados.add(vertice);

                for (const adjacente of this.adjacencias.get(vertice) || []) {
                    if (!visitados.has(adjacente)) {
                        pilha.push(adjacente);
                    }
                }
            }
        }
    }
}

const grafo = new Grafo();
grafo.adicionarAresta(0, 1);
grafo.adicionarAresta(0, 2);
grafo.adicionarAresta(1, 2);
grafo.adicionarAresta(2, 0);
grafo.adicionarAresta(2, 3);
grafo.adicionarAresta(3, 3);

console.log("Busca em Profundidade (DFS) começando do vértice 2:");
grafo.DFS(2);
