/*
♦ Algoritmo 30: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Kruskal.
*/


// Classe para representar uma aresta em um grafo ponderado
class Aresta {
    constructor(origem, destino, peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}

// Classe para representar um grafo ponderado usando lista de adjacência
class Grafo {
    constructor(V) {
        this.V = V; // Número de vértices
        this.arestas = [];
    }

    // Adiciona uma aresta ao grafo
    addAresta(origem, destino, peso) {
        this.arestas.push(new Aresta(origem, destino, peso));
    }

    // Algoritmo de Kruskal para encontrar a árvore geradora mínima
    kruskal() {
        // Ordena as arestas por peso
        this.arestas.sort((a, b) => a.peso - b.peso);

        const arvoreGeradoraMinima = [];
        const uf = new UnionFind(this.V);

        for (const aresta of this.arestas) {
            if (!uf.connected(aresta.origem, aresta.destino)) {
                arvoreGeradoraMinima.push(aresta);
                uf.union(aresta.origem, aresta.destino);
            }
        }

        return arvoreGeradoraMinima;
    }
}

// Classe Union-Find para representar uma estrutura de dados para detecção de ciclos
class UnionFind {
    constructor(n) {
        this.parent = new Array(n).fill().map((_, i) => i);
        this.rank = new Array(n).fill(0);
    }

    // Encontra o representante (raiz) do conjunto ao qual o elemento pertence
    find(x) {
        if (x !== this.parent[x]) {
            this.parent[x] = this.find(this.parent[x]);
        }
        return this.parent[x];
    }

    // Une os conjuntos que contêm os elementos x e y
    union(x, y) {
        const raizX = this.find(x);
        const raizY = this.find(y);
        if (raizX === raizY) return;
        if (this.rank[raizX] < this.rank[raizY]) {
            this.parent[raizX] = raizY;
        } else if (this.rank[raizX] > this.rank[raizY]) {
            this.parent[raizY] = raizX;
        } else {
            this.parent[raizY] = raizX;
            this.rank[raizX]++;
        }
    }

    // Verifica se dois elementos estão no mesmo conjunto
    connected(x, y) {
        return this.find(x) === this.find(y);
    }
}

// Função principal
(function() {
    // Criando um grafo com 4 vértices
    const grafo = new Grafo(4);

    // Adicionando as arestas ao grafo com seus pesos
    grafo.addAresta(0, 1, 10);
    grafo.addAresta(0, 2, 6);
    grafo.addAresta(0, 3, 5);
    grafo.addAresta(1, 3, 15);
    grafo.addAresta(2, 3, 4);

    // Executando o algoritmo de Kruskal
    const arvoreGeradoraMinima = grafo.kruskal();

    // Imprimindo a árvore geradora mínima
    for (const aresta of arvoreGeradoraMinima) {
        console.log(`Aresta: ${aresta.origem} - ${aresta.destino}, Peso: ${aresta.peso}`);
    }
})();
