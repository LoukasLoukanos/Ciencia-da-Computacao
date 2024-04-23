'''
♦ Algoritmo 32: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Floyd-Warshall.
'''


class Grafo:
    def __init__(self):
        self.adjacencia = {}

    def addAresta(self, origem, destino, peso):
        if origem not in self.adjacencia:
            self.adjacencia[origem] = {}
        self.adjacencia[origem][destino] = peso

    def floydWarshall(self):
        distancias = {vertice: {v: float('inf') for v in self.adjacencia} for vertice in self.adjacencia}

        # Inicializa a diagonal com 0 e as outras posições com infinito
        for vertice1 in self.adjacencia:
            for vertice2 in self.adjacencia:
                if vertice1 != vertice2 and vertice2 not in distancias[vertice1]:
                    distancias[vertice1][vertice2] = float('inf')

        # Algoritmo de Floyd-Warshall
        for k in self.adjacencia:
            for i in self.adjacencia:
                for j in self.adjacencia:
                    distanciaIJ = distancias[i][j]
                    distanciaIK = distancias[i].get(k, float('inf'))
                    distanciaKJ = distancias.get(k, {}).get(j, float('inf'))

                    if distanciaIK + distanciaKJ < distanciaIJ:
                        distancias[i][j] = distanciaIK + distanciaKJ

        return distancias

# Função principal
def main():
    # Criando um grafo
    grafo = Grafo()

    # Adicionando arestas ao grafo
    grafo.addAresta("A", "B", 3)
    grafo.addAresta("A", "C", 6)
    grafo.addAresta("B", "C", 2)
    grafo.addAresta("B", "D", 1)
    grafo.addAresta("C", "B", 4)
    grafo.addAresta("C", "D", 5)
    grafo.addAresta("D", "A", 3)

    # Executando o algoritmo de Floyd-Warshall
    distancias = grafo.floydWarshall()

    # Imprimindo as distâncias mínimas entre todos os pares de vértices
    for vertice1 in distancias:
        for vertice2, distancia in distancias[vertice1].items():
            print(f"Distância de {vertice1} para {vertice2}: {distancia}")

# Chamando a função principal
if __name__ == "__main__":
    main()
