/*
♦ Algoritmo 38: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Dijkstra.
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

    dijkstra(origem) {
        let distancias = new Map();
        let filaPrioridade = [];

        this.nos.forEach((no, valor) => {
            distancias.set(valor, Number.MAX_SAFE_INTEGER);
        });

        distancias.set(origem, 0);
        filaPrioridade.push({ no: this.nos.get(origem), distancia: 0 });

        while (filaPrioridade.length > 0) {
            filaPrioridade.sort((a, b) => distancias.get(a.no.valor) - distancias.get(b.no.valor));
            let { noAtual, distanciaAtual } = filaPrioridade.shift();

            noAtual.arestas.forEach(aresta => {
                let vizinho = aresta.destino;
                let novaDistancia = distanciaAtual + aresta.peso;

                if (novaDistancia < distancias.get(vizinho.valor)) {
                    distancias.set(vizinho.valor, novaDistancia);
                    filaPrioridade.push({ no: vizinho, distancia: novaDistancia });
                }
            });
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

const distancias = grafo.dijkstra('A');
distancias.forEach((distancia, vertice) => {
    console.log(`Distância de A até ${vertice}: ${distancia}`);
});
