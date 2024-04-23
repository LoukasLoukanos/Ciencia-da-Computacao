/*
♦ Algoritmo 29: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Bellman-Ford.
*/


// Classe para representar uma aresta em um grafo ponderado
class Aresta {
    constructor(origem, destino, peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}

// Classe para representar um grafo ponderado usando matriz de adjacência
class Grafo {
    constructor(V, E) {
        this.V = V; // Número de vértices
        this.E = E; // Número de arestas
        this.arestas = [];
    }

    // Adiciona uma aresta ao grafo
    addAresta(origem, destino, peso) {
        this.arestas.push(new Aresta(origem, destino, peso));
    }

    // Algoritmo de Bellman-Ford para encontrar o caminho mais curto
    BellmanFord(origem) {
        // Inicializa as distâncias de todos os vértices como infinito
        let distancia = new Array(this.V).fill(Number.MAX_VALUE);
        distancia[origem] = 0;

        // Relaxamento das arestas
        for (let i = 1; i < this.V; ++i) {
            for (let j = 0; j < this.E; ++j) {
                let u = this.arestas[j].origem;
                let v = this.arestas[j].destino;
                let peso = this.arestas[j].peso;
                if (distancia[u] != Number.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                }
            }
        }

        // Verifica ciclos de peso negativo
        for (let i = 0; i < this.E; ++i) {
            let u = this.arestas[i].origem;
            let v = this.arestas[i].destino;
            let peso = this.arestas[i].peso;
            if (distancia[u] != Number.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                console.log("O grafo contém um ciclo de peso negativo!");
                return;
            }
        }

        // Imprime as distâncias mais curtas
        for (let i = 0; i < this.V; ++i) {
            console.log(`Distância do vértice ${origem} ao vértice ${i} é ${distancia[i]}`);
        }
    }
}

// Função principal
function main() {
    // Criando um grafo com 5 vértices e 8 arestas
    let grafo = new Grafo(5, 8);

    // Adicionando as arestas ao grafo
    grafo.addAresta(0, 1, 6.0);
    grafo.addAresta(0, 2, 7.0);
    grafo.addAresta(1, 2, 8.0);
    grafo.addAresta(1, 3, -4.0);
    grafo.addAresta(1, 4, 5.0);
    grafo.addAresta(2, 3, 9.0);
    grafo.addAresta(2, 4, -3.0);
    grafo.addAresta(3, 4, 7.0);

    // Executando o algoritmo de Bellman-Ford a partir do vértice 0
    grafo.BellmanFord(0);
}

// Chamando a função principal
main();
