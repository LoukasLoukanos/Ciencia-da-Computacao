/*
♦ Algoritmo 39: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Bellman-Ford.
*/


class Aresta {
    constructor(destino, peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

class No {
    constructor(valor) {
        this.valor = valor;
        this.arestas = [];
    }

    adicionarAresta(destino, peso) {
        this.arestas.push(new Aresta(destino, peso));
    }
}

class Grafo {
    constructor() {
        this.nos = new Map();
    }

    adicionarNo(valor) {
        if (!this.nos.has(valor)) {
            this.nos.set(valor, new No(valor));
        }
    }

    adicionarAresta(origem, destino, peso) {
        this.adicionarNo(origem);
        this.adicionarNo(destino);
        this.nos.get(origem).adicionarAresta(this.nos.get(destino), peso);
    }

    bellmanFord(origem) {
        const distancias = new Map();
        for (let [valor, _] of this.nos) {
            distancias.set(valor, Number.MAX_SAFE_INTEGER);
        }
        distancias.set(origem, 0);

        // Relaxamento de arestas repetido |V| - 1 vezes
        for (let i = 0; i < this.nos.size - 1; i++) {
            for (let [_, no] of this.nos) {
                for (let aresta of no.arestas) {
                    const u = no.valor;
                    const v = aresta.destino.valor;
                    const peso = aresta.peso;
                    if (distancias.get(u) !== Number.MAX_SAFE_INTEGER && distancias.get(u) + peso < distancias.get(v)) {
                        distancias.set(v, distancias.get(u) + peso);
                    }
                }
            }
        }

        // Detecção de ciclos negativos
        for (let i = 0; i < this.nos.size - 1; i++) {
            for (let [_, no] of this.nos) {
                for (let aresta of no.arestas) {
                    const u = no.valor;
                    const v = aresta.destino.valor;
                    const peso = aresta.peso;
                    if (distancias.get(u) !== Number.MAX_SAFE_INTEGER && distancias.get(u) + peso < distancias.get(v)) {
                        throw new Error("Ciclo negativo detectado");
                    }
                }
            }
        }

        return distancias;
    }
}

const grafo = new Grafo();

grafo.adicionarAresta('A', 'B', 10);
grafo.adicionarAresta('A', 'C', 15);
grafo.adicionarAresta('B', 'D', 12);
grafo.adicionarAresta('B', 'F', 15);
grafo.adicionarAresta('C', 'E', 10);
grafo.adicionarAresta('D', 'E', 2);
grafo.adicionarAresta('D', 'F', 1);
grafo.adicionarAresta('F', 'E', 5);

try {
    const distancias = grafo.bellmanFord('A');
    for (let [vertice, distancia] of distancias) {
        console.log(`Distância de A até ${vertice}: ${distancia}`);
    }
} catch (e) {
    console.log(e.message);
}
