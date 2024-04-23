'''
♦ Algoritmo 31: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Prim.
'''


from typing import TypeVar, List, Dict, Set
from heapq import heappush, heappop

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
        self.adjacencia: Dict[Vertice, List[Aresta]] = {}

    # Adiciona uma aresta ao grafo
    def addAresta(self, origem: Vertice, destino: Vertice, peso: float):
        self.adjacencia.setdefault(origem, []).append(Aresta(destino, peso))
        self.adjacencia.setdefault(destino, []).append(Aresta(origem, peso)) # Para grafos não direcionados

    # Algoritmo de Prim para encontrar a árvore geradora mínima
    def prim(self, origem: Vertice) -> List[Aresta]:
        visitados: Set[Vertice] = set()
        arvoreGeradoraMinima: List[Aresta] = []
        filaPrioridade: List[Aresta] = []

        visitados.add(origem)
        self.adicionarArestasAdjacentes(origem, filaPrioridade, visitados)

        while filaPrioridade:
            aresta = heappop(filaPrioridade)
            destino = aresta.destino

            if destino not in visitados:
                visitados.add(destino)
                arvoreGeradoraMinima.append(aresta)
                self.adicionarArestasAdjacentes(destino, filaPrioridade, visitados)

        return arvoreGeradoraMinima

    def adicionarArestasAdjacentes(self, vertice: Vertice, filaPrioridade: List[Aresta], visitados: Set[Vertice]):
        for aresta in self.adjacencia.get(vertice, []):
            if aresta.destino not in visitados:
                heappush(filaPrioridade, aresta)

# Classe principal
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
    grafo.addAresta(A, B, 4)
    grafo.addAresta(A, C, 1)
    grafo.addAresta(B, C, 2)
    grafo.addAresta(B, D, 5)
    grafo.addAresta(C, D, 8)
    grafo.addAresta(C, E, 10)
    grafo.addAresta(D, E, 2)

    # Executando o algoritmo de Prim a partir do vértice A
    arvoreGeradoraMinima = grafo.prim(A)

    # Imprimindo a árvore geradora mínima
    for aresta in arvoreGeradoraMinima:
        print(f"Aresta: {aresta.destino.valor}, Peso: {aresta.peso}")

# Executando a função principal
if __name__ == "__main__":
    main()
