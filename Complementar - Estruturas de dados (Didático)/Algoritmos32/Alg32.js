/*
♦ Algoritmo 32: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Floyd-Warshall.
*/


// Classe para representar o grafo
class Grafo {
    constructor() {
        this.adjacencia = new Map();
    }

    // Adiciona uma aresta ao grafo
    addAresta(origem, destino, peso) {
        if (!this.adjacencia.has(origem)) {
            this.adjacencia.set(origem, new Map());
        }
        this.adjacencia.get(origem).set(destino, peso);
    }

    // Algoritmo de Floyd-Warshall para encontrar os menores caminhos entre todos os pares de vértices
    floydWarshall() {
        const distancias = new Map(this.adjacencia);

        // Inicializa a diagonal com 0 e as outras posições com infinito
        for (let vertice1 of this.adjacencia.keys()) {
            for (let vertice2 of this.adjacencia.keys()) {
                if (vertice1 !== vertice2 && !distancias.get(vertice1).has(vertice2)) {
                    distancias.get(vertice1).set(vertice2, Number.POSITIVE_INFINITY);
                }
            }
        }

        // Algoritmo de Floyd-Warshall
        for (let k of this.adjacencia.keys()) {
            for (let i of this.adjacencia.keys()) {
                for (let j of this.adjacencia.keys()) {
                    let distanciaIJ = distancias.get(i).get(j);
                    let distanciaIK = distancias.get(i).get(k) || Number.POSITIVE_INFINITY;
                    let distanciaKJ = distancias.get(k).get(j) || Number.POSITIVE_INFINITY;

                    if (distanciaIK + distanciaKJ < distanciaIJ) {
                        distancias.get(i).set(j, distanciaIK + distanciaKJ);
                    }
                }
            }
        }

        return distancias;
    }
}

// Função principal
function main() {
    // Criando um grafo
    const grafo = new Grafo();

    // Adicionando arestas ao grafo
    grafo.addAresta("A", "B", 3);
    grafo.addAresta("A", "C", 6);
    grafo.addAresta("B", "C", 2);
    grafo.addAresta("B", "D", 1);
    grafo.addAresta("C", "B", 4);
    grafo.addAresta("C", "D", 5);
    grafo.addAresta("D", "A", 3);

    // Executando o algoritmo de Floyd-Warshall
    const distancias = grafo.floydWarshall();

    // Imprimindo as distâncias mínimas entre todos os pares de vértices
    for (let [vertice1, distanciasVertice1] of distancias) {
        for (let [vertice2, distancia] of distanciasVertice1) {
            console.log(`Distância de ${vertice1} para ${vertice2}: ${distancia}`);
        }
    }
}

// Chamando a função principal
main();
