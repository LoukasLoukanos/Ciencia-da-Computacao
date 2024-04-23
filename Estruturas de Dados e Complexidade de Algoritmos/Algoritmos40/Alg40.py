'''
♦ Algoritmo 40: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Floyd-Warshall.
'''


class FloydWarshall:
    def __init__(self):
        self.distancias = {}
        self.predecessores = {}

    def adicionar_vertice(self, vertice):
        if vertice not in self.distancias:
            self.distancias[vertice] = {}
            self.predecessores[vertice] = {}

    def adicionar_aresta(self, origem, destino, peso):
        self.adicionar_vertice(origem)
        self.adicionar_vertice(destino)

        self.distancias[origem][destino] = peso
        self.predecessores[origem][destino] = origem

        self.distancias[destino][origem] = peso
        self.predecessores[destino][origem] = destino

    def floyd_warshall(self):
        for k in self.distancias.keys():
            for i in self.distancias.keys():
                for j in self.distancias.keys():
                    if self.distancias[i].get(k) is not None and self.distancias[k].get(j) is not None:
                        novo_peso = self.distancias[i][k] + self.distancias[k][j]
                        if self.distancias[i].get(j) is None or novo_peso < self.distancias[i][j]:
                            self.distancias[i][j] = novo_peso
                            self.predecessores[i][j] = self.predecessores[k][j]

    def obter_distancias(self):
        return self.distancias

    def obter_predecessores(self):
        return self.predecessores

floyd_warshall = FloydWarshall()

floyd_warshall.adicionar_aresta('A', 'B', 10)
floyd_warshall.adicionar_aresta('A', 'C', 15)
floyd_warshall.adicionar_aresta('B', 'D', 12)
floyd_warshall.adicionar_aresta('B', 'F', 15)
floyd_warshall.adicionar_aresta('C', 'E', 10)
floyd_warshall.adicionar_aresta('D', 'E', 2)
floyd_warshall.adicionar_aresta('D', 'F', 1)
floyd_warshall.adicionar_aresta('F', 'E', 5)

floyd_warshall.floyd_warshall()

distancias = floyd_warshall.obter_distancias()
predecessores = floyd_warshall.obter_predecessores()

for u in distancias:
    for v in distancias[u]:
        print(f"Distância de {u} até {v}: {distancias[u][v]}")

for u in predecessores:
    for v in predecessores[u]:
        print(f"Predecessor de {v} no caminho de {u} até {v}: {predecessores[u][v]}")
