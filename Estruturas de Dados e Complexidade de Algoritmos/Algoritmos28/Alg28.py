'''
♦ Algoritmo 28: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Dijkstra.
'''


import heapq
from typing import TypeVar, List, Dict

# Classe para representar um vértice no grafo
class Vertice:
    def __init__(self, indice: int, valor: str):
        self.indice = indice
        self.valor = valor

    # Método para comparar vértices com base em seus valores
    def __lt__(self, outro):
        if isinstance(self.valor, Comparable):
            return self.valor < outro.valor
        else:
            raise NotImplementedError("Tipo de valor não suportado para comparação.")

# Classe para representar uma aresta no grafo ponderado
class Aresta:
    def __init__(self, destino: Vertice, peso: float):
        self.destino = destino
        self.peso = peso

# Classe para representar um grafo ponderado usando lista de adjacência
class Grafo:
    def __init__(self):
        self.adjacencia = {}

    # Adiciona uma aresta ao grafo
    def addAresta(self, origem: Vertice, destino: Vertice, peso: float):
        self.adjacencia.setdefault(origem, []).append(Aresta(destino, peso))

    # Algoritmo de Dijkstra para encontrar os menores caminhos a partir de um vértice origem
    def dijkstra(self, origem: Vertice) -> Dict[Vertice, float]:
        distancia = {v: float('inf') for v in self.adjacencia}
        distancia[origem] = 0.0
        fila_prioridade = [(0.0, origem)]

        while fila_prioridade:
            dist_u, u = heapq.heappop(fila_prioridade)
            if dist_u > distancia[u]:
                continue
            for aresta in self.adjacencia.get(u, []):
                v = aresta.destino
                nova_distancia = dist_u + aresta.peso
                if nova_distancia < distancia[v]:
                    distancia[v] = nova_distancia
                    heapq.heappush(fila_prioridade, (nova_distancia, v))

        return distancia

# Interface Comparable
Comparable = TypeVar('Comparable', bound=type)

# Função principal
def main():
    # Criando um grafo
    grafo = Grafo()

    # Criando vértices
    A = Vertice(0, "A")
    B = Vertice(1, "B")
    C = Vertice(2, "C")
    D = Vertice(3, "D")
    E = Vertice(4, "E")

    # Adicionando arestas ao grafo
    grafo.addAresta(A, B, 10)
    grafo.addAresta(A, C, 15)
    grafo.addAresta(B, D, 12)
    grafo.addAresta(B, E, 15)
    grafo.addAresta(C, D, 10)
    grafo.addAresta(C, E, 5)
    grafo.addAresta(D, E, 10)

    # Executando o algoritmo de Dijkstra a partir do vértice A
    menores_caminhos = grafo.dijkstra(A)

    # Imprimindo os menores caminhos
    for v, dist in menores_caminhos.items():
        print(f"Menor caminho de A para {v.valor}: {dist}")

# Chamando a função principal
if __name__ == "__main__":
    main()
