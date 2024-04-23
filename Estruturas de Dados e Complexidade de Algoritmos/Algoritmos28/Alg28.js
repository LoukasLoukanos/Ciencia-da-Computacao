/*
♦ Algoritmo 28: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Dijkstra.
*/


// Classe para representar um vértice no grafo
class Vertice {
    constructor(indice, valor) {
        this.indice = indice;
        this.valor = valor;
    }

    // Método para comparar vértices com base em seus valores
    compareTo(outro) {
        if (typeof this.valor === 'object' && typeof this.valor.compareTo === 'function') {
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
        if (!this.adjacencia.has(origem)) {
            this.adjacencia.set(origem, []);
        }
        this.adjacencia.get(origem).push(new Aresta(destino, peso));
    }

    // Algoritmo de Dijkstra para encontrar os menores caminhos a partir de um vértice origem
    dijkstra(origem) {
        const distancia = new Map();
        const filaPrioridade = new PriorityQueue((a, b) => distancia.get(a) - distancia.get(b));

        // Inicialização das distâncias
        for (let [v] of this.adjacencia) {
            if (v === origem) {
                distancia.set(v, 0.0);
            } else {
                distancia.set(v, Number.POSITIVE_INFINITY);
            }
            filaPrioridade.enqueue(v);
        }

        while (!filaPrioridade.isEmpty()) {
            const u = filaPrioridade.dequeue();
            for (const aresta of this.adjacencia.get(u) || []) {
                const v = aresta.destino;
                const novaDistancia = distancia.get(u) + aresta.peso;
                if (novaDistancia < distancia.get(v)) {
                    distancia.set(v, novaDistancia);
                    filaPrioridade.remove(v);
                    filaPrioridade.enqueue(v);
                }
            }
        }

        return distancia;
    }
}

// Implementação de PriorityQueue
class PriorityQueue {
    constructor(comparator) {
        this.queue = [];
        this.comparator = comparator || ((a, b) => a - b);
    }

    enqueue(item) {
        this.queue.push(item);
        this.queue.sort(this.comparator);
    }

    dequeue() {
        return this.queue.shift();
    }

    remove(item) {
        const index = this.queue.indexOf(item);
        if (index !== -1) {
            this.queue.splice(index, 1);
            this.queue.sort(this.comparator);
        }
    }

    isEmpty() {
        return this.queue.length === 0;
    }
}

// Função principal
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
    grafo.addAresta(A, B, 10);
    grafo.addAresta(A, C, 15);
    grafo.addAresta(B, D, 12);
    grafo.addAresta(B, E, 15);
    grafo.addAresta(C, D, 10);
    grafo.addAresta(C, E, 5);
    grafo.addAresta(D, E, 10);

    // Executando o algoritmo de Dijkstra a partir do vértice A
    const menoresCaminhos = grafo.dijkstra(A);

    // Imprimindo os menores caminhos
    for (const [v, dist] of menoresCaminhos.entries()) {
        console.log(`Menor caminho de A para ${v.valor}: ${dist}`);
    }
}

// Chamando a função principal
main();
