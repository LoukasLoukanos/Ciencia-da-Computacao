/*
♦ Algoritmo 37: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
*/


// Classe para representar um nó do grafo genérico
class No {
    constructor(valor) {
        this.valor = valor;
        this.vizinhos = [];
    }

    adicionarVizinho(vizinho) {
        this.vizinhos.push(vizinho);
    }
}

// Classe para representar o Grafo Genérico
class Grafo {
    constructor() {
        this.nos = new Map();
    }

    adicionarNo(valor) {
        if (!this.nos.has(valor)) {
            this.nos.set(valor, new No(valor));
        }
    }

    adicionarAresta(origem, destino) {
        if (!this.nos.has(origem)) {
            this.adicionarNo(origem);
        }
        if (!this.nos.has(destino)) {
            this.adicionarNo(destino);
        }
        this.nos.get(origem).adicionarVizinho(this.nos.get(destino));
    }

    // Método de busca em profundidade (DFS)
    DFS(inicio) {
        const visitados = new Set();
        this.DFSRecursivo(this.nos.get(inicio), visitados);
    }

    DFSRecursivo(no, visitados) {
        visitados.add(no.valor);
        process.stdout.write(no.valor + " ");

        for (const vizinho of no.vizinhos) {
            if (!visitados.has(vizinho.valor)) {
                this.DFSRecursivo(vizinho, visitados);
            }
        }
    }
}

// Função principal para teste
function main() {
    const grafo = new Grafo();

    grafo.adicionarAresta(0, 1);
    grafo.adicionarAresta(0, 2);
    grafo.adicionarAresta(1, 2);
    grafo.adicionarAresta(2, 0);
    grafo.adicionarAresta(2, 3);
    grafo.adicionarAresta(3, 3);

    console.log("Busca em Profundidade (DFS) a partir do vértice 2:");
    grafo.DFS(2);
}

main();
