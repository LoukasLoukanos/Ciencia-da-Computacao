'''
♦ Algoritmo 39: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Bellman-Ford.
'''


class Aresta:
    def __init__(self, destino, peso):
        self.destino = destino
        self.peso = peso

    def getDestino(self):
        return self.destino

    def getPeso(self):
        return self.peso

class No:
    def __init__(self, valor):
        self.valor = valor
        self.arestas = []

    def getValor(self):
        return self.valor

    def getArestas(self):
        return self.arestas

    def adicionarAresta(self, destino, peso):
        self.arestas.append(Aresta(destino, peso))

class Grafo:
    def __init__(self):
        self.nos = {}

    def adicionarNo(self, valor):
        if valor not in self.nos:
            self.nos[valor] = No(valor)

    def adicionarAresta(self, origem, destino, peso):
        self.adicionarNo(origem)
        self.adicionarNo(destino)
        self.nos[origem].adicionarAresta(self.nos[destino], peso)

    def bellmanFord(self, origem):
        distancias = {valor: float('inf') for valor in self.nos.keys()}
        distancias[origem] = 0

        # Relaxamento de arestas repetido |V| - 1 vezes
        for _ in range(len(self.nos) - 1):
            for no in self.nos.values():
                for aresta in no.getArestas():
                    u = no.getValor()
                    v = aresta.getDestino().getValor()
                    peso = aresta.getPeso()
                    if distancias[u] != float('inf') and distancias[u] + peso < distancias[v]:
                        distancias[v] = distancias[u] + peso

        # Detecção de ciclos negativos
        for _ in range(len(self.nos) - 1):
            for no in self.nos.values():
                for aresta in no.getArestas():
                    u = no.getValor()
                    v = aresta.getDestino().getValor()
                    peso = aresta.getPeso()
                    if distancias[u] != float('inf') and distancias[u] + peso < distancias[v]:
                        raise RuntimeError("Ciclo negativo detectado")

        return distancias

grafo = Grafo()

grafo.adicionarAresta('A', 'B', 10)
grafo.adicionarAresta('A', 'C', 15)
grafo.adicionarAresta('B', 'D', 12)
grafo.adicionarAresta('B', 'F', 15)
grafo.adicionarAresta('C', 'E', 10)
grafo.adicionarAresta('D', 'E', 2)
grafo.adicionarAresta('D', 'F', 1)
grafo.adicionarAresta('F', 'E', 5)

try:
    distancias = grafo.bellmanFord('A')
    for vertice, distancia in distancias.items():
        print(f"Distância de A até {vertice}: {distancia}")
except RuntimeError as e:
    print(e)
