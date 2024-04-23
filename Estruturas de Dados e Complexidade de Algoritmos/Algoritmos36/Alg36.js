/*
♦ Algoritmo 36: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Largura (Breadth-First Search - BFS).
*/


class Grafo {
    constructor(v) {
        this.V = v; // Número de vértices
        this.adj = new Array(v).fill().map(() => new LinkedList()); // Lista de adjacência
    }

    // Adiciona uma aresta ao grafo
    adicionarAresta(v, w) {
        this.adj[v].add(w);
    }

    // Executa a busca em largura a partir de um vértice inicial
    BFS(s) {
        // Marca todos os vértices como não visitados
        const visitados = new Array(this.V).fill(false);

        // Cria uma fila para o BFS
        const fila = [];

        // Marca o vértice atual como visitado e o adiciona à fila
        visitados[s] = true;
        fila.push(s);

        while (fila.length !== 0) {
            // Remove um vértice da fila e imprime
            s = fila.shift();
            process.stdout.write(s + " ");

            // Obtém todos os vértices adjacentes do vértice removido da fila
            const iter = this.adj[s][Symbol.iterator]();
            let n = iter.next();
            while (!n.done) {
                n = n.value;
                // Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
                if (!visitados[n]) {
                    visitados[n] = true;
                    fila.push(n);
                }
                n = iter.next();
            }
        }
    }
}

const g = new Grafo(4);

g.adicionarAresta(0, 1);
g.adicionarAresta(0, 2);
g.adicionarAresta(1, 2);
g.adicionarAresta(2, 0);
g.adicionarAresta(2, 3);
g.adicionarAresta(3, 3);

process.stdout.write("Busca em Largura (BFS) a partir do vértice 2:\n");
g.BFS(2);
