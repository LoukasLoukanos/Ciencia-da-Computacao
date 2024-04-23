'''
♦ Algoritmo 38: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Dijkstra.
'''


import heapq
from collections import defaultdict

class Aresta:
    def __init__(self, destino, peso):
        self.destino = destino
        self.peso = peso

class No:
    def __init__(self, valor):
        self.valor = valor
        self.arestas = []

    def adicionar_aresta(self, destino, peso):
        self.arestas.append(Aresta(destino, peso))

class Grafo:
    def __init__(self):
        self.nos = {}

    def adicionar_no(self, valor):
        if valor not in self.nos:
            self.nos[valor] = No(valor)

    def adicionar_aresta(self, origem, destino, peso):
        self.adicionar_no(origem)
        self.adicionar_no(destino)
        self.nos[origem].adicionar_aresta(self.nos[destino], peso)

    def dijkstra(self, origem):
        distancias = defaultdict(lambda: float('inf'))
        fila_prioridade = [(0, self.nos[origem])]
        heapq.heapify(fila_prioridade)

        distancias[origem] = 0

        while fila_prioridade:
            distancia_atual, no_atual = heapq.heappop(fila_prioridade)

            for aresta in no_atual.arestas:
                vizinho = aresta.destino
                nova_distancia = distancia_atual + aresta.peso

                if nova_distancia < distancias[vizinho.valor]:
                    distancias[vizinho.valor] = nova_distancia
                    heapq.heappush(fila_prioridade, (nova_distancia, vizinho))

        return dict(distancias)

grafo = Grafo()

grafo.adicionar_aresta('A', 'B', 10)
grafo.adicionar_aresta('A', 'C', 15)
grafo.adicionar_aresta('B', 'D', 12)
grafo.adicionar_aresta('B', 'F', 15)
grafo.adicionar_aresta('C', 'E', 10)
grafo.adicionar_aresta('D', 'E', 2)
grafo.adicionar_aresta('D', 'F', 1)
grafo.adicionar_aresta('F', 'E', 5)

distancias = grafo.dijkstra('A')
for vertice, distancia in distancias.items():
    print(f"Distância de A até {vertice}: {distancia}")
