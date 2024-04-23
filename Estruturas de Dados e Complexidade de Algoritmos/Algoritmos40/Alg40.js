/*
♦ Algoritmo 40: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Floyd-Warshall.
*/


class FloydWarshall {
    constructor() {
        this.distancias = new Map();
        this.predecessores = new Map();
    }

    adicionarVertice(vertice) {
        if (!this.distancias.has(vertice)) {
            this.distancias.set(vertice, new Map());
            this.predecessores.set(vertice, new Map());
        }
    }

    adicionarAresta(origem, destino, peso) {
        this.adicionarVertice(origem);
        this.adicionarVertice(destino);

        this.distancias.get(origem).set(destino, peso);
        this.predecessores.get(origem).set(destino, origem);

        this.distancias.get(destino).set(origem, peso);
        this.predecessores.get(destino).set(origem, destino);
    }

    floydWarshall() {
        for (let k of this.distancias.keys()) {
            for (let i of this.distancias.keys()) {
                for (let j of this.distancias.keys()) {
                    if (this.distancias.get(i).has(k) && this.distancias.get(k).has(j)) {
                        let novoPeso = this.distancias.get(i).get(k) + this.distancias.get(k).get(j);
                        if (!this.distancias.get(i).has(j) || novoPeso < this.distancias.get(i).get(j)) {
                            this.distancias.get(i).set(j, novoPeso);
                            this.predecessores.get(i).set(j, this.predecessores.get(k).get(j));
                        }
                    }
                }
            }
        }
    }

    obterDistancias() {
        return this.distancias;
    }

    obterPredecessores() {
        return this.predecessores;
    }
}

const floydWarshall = new FloydWarshall();

floydWarshall.adicionarAresta('A', 'B', 10);
floydWarshall.adicionarAresta('A', 'C', 15);
floydWarshall.adicionarAresta('B', 'D', 12);
floydWarshall.adicionarAresta('B', 'F', 15);
floydWarshall.adicionarAresta('C', 'E', 10);
floydWarshall.adicionarAresta('D', 'E', 2);
floydWarshall.adicionarAresta('D', 'F', 1);
floydWarshall.adicionarAresta('F', 'E', 5);

floydWarshall.floydWarshall();

const distancias = floydWarshall.obterDistancias();
const predecessores = floydWarshall.obterPredecessores();

for (let [u, value_u] of distancias) {
    for (let [v, peso] of value_u) {
        console.log(`Distância de ${u} até ${v}: ${peso}`);
    }
}

for (let [u, value_u] of predecessores) {
    for (let [v, predecessor] of value_u) {
        console.log(`Predecessor de ${v} no caminho de ${u} até ${v}: ${predecessor}`);
    }
}
