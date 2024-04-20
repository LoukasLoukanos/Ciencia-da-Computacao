'''
♦ Algoritmo 27: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
'''


class Grafo:
    def __init__(self):
        self.adjacencias = {}

    def adicionarAresta(self, origem, destino):
        if origem not in self.adjacencias:
            self.adjacencias[origem] = []
        if destino not in self.adjacencias:
            self.adjacencias[destino] = []
        self.adjacencias[origem].append(destino)
        self.adjacencias[destino].append(origem)  # Se o grafo é não direcionado, adicione a aresta em ambas as direções

    def DFS(self, inicio):
        visitados = set()
        pilha = [inicio]

        while pilha:
            vertice = pilha.pop()

            if vertice not in visitados:
                print(vertice, end=" ")
                visitados.add(vertice)

                for adjacente in self.adjacencias.get(vertice, []):
                    if adjacente not in visitados:
                        pilha.append(adjacente)


grafo = Grafo()
grafo.adicionarAresta(0, 1)
grafo.adicionarAresta(0, 2)
grafo.adicionarAresta(1, 2)
grafo.adicionarAresta(2, 0)
grafo.adicionarAresta(2, 3)
grafo.adicionarAresta(3, 3)

print("Busca em Profundidade (DFS) começando do vértice 2:")
grafo.DFS(2)
