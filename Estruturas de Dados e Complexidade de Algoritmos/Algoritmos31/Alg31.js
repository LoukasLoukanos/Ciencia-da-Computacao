/*
♦ Algoritmo 31: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Prim.
*/


// Classe para representar um vértice no grafo
class Vertice {
    constructor(indice, valor) {
        this.indice = indice;
        this.valor = valor;
    }

    // Método para comparar vértices com base em seus valores
    compareTo(outro) {
        if (this.valor instanceof Comparable) {
            return this.valor.compareTo(outro.valor);
        } else {
            throw new Error("Tipo de valor não suportado para comparação.");
        }
    }
}

// Classe para representar uma aresta no grafo ponderado
class Aresta {
    constructor(destino, peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

// Classe para representar um grafo ponderado usando lista de adjacência
class Grafo {
    constructor() {
        this.adjacencia = new Map();
    }

    // Adiciona uma aresta ao grafo
    addAresta(origem, destino, peso) {
        this.adjacencia.set(origem, this.adjacencia.get(origem) || []);
        this.adjacencia.set(destino, this.adjacencia.get(destino) || []);
        this.adjacencia.get(origem).push(new Aresta(destino, peso));
        this.adjacencia.get(destino).push(new Aresta(origem, peso)); // Para grafos não direcionados
    }

    // Algoritmo de Prim para encontrar a árvore geradora mínima
    prim(origem) {
        const visitados = new Set();
        const arvoreGeradoraMinima = [];
        const filaPrioridade = new PriorityQueue((a, b) => a.peso - b.peso);

        visitados.add(origem);
        this.adicionarArestasAdjacentes(origem, filaPrioridade, visitados);

        while (!filaPrioridade.isEmpty()) {
            const aresta = filaPrioridade.poll();
            const destino = aresta.destino;

            if (!visitados.has(destino)) {
                visitados.add(destino);
                arvoreGeradoraMinima.push(aresta);
                this.adicionarArestasAdjacentes(destino, filaPrioridade, visitados);
            }
        }

        return arvoreGeradoraMinima;
    }

    adicionarArestasAdjacentes(vertice, filaPrioridade, visitados) {
        for (const aresta of this.adjacencia.get(vertice) || []) {
            if (!visitados.has(aresta.destino)) {
                filaPrioridade.add(aresta);
            }
        }
    }
}

// Implementação de uma fila de prioridade
class PriorityQueue {
    constructor(comparator) {
        this.comparator = comparator;
        this.elements = [];
    }

    add(element) {
        this.elements.push(element);
        this.elements.sort(this.comparator);
    }

    poll() {
        return this.elements.shift();
    }

    isEmpty() {
        return this.elements.length === 0;
    }
}

// Classe principal
function main() {
    // Criando um grafo
    const grafo = new Grafo();

    // Criando vértices
    const A = new Vertice(0, "A");
    const B = new Vertice(1, "B");
    const C = new Vertice(2, "C");
    const D = new Vertice(3, "D");
    const E = new Vertice(4, "E");

    // Adicionando arestas ao grafo
    grafo.addAresta(A, B, 4);
    grafo.addAresta(A, C, 1);
    grafo.addAresta(B, C, 2);
    grafo.addAresta(B, D, 5);
    grafo.addAresta(C, D, 8);
    grafo.addAresta(C, E, 10);
    grafo.addAresta(D, E, 2);

    // Executando o algoritmo de Prim a partir do vértice A
    const arvoreGeradoraMinima = grafo.prim(A);

    // Imprimindo a árvore geradora mínima
    for (const aresta of arvoreGeradoraMinima) {
        console.log("Aresta: " + aresta.destino.valor + ", Peso: " + aresta.peso);
    }
}

// Executando a função principal
main();
