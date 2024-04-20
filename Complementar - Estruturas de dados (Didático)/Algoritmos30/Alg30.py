'''
♦ Algoritmo 30: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Kruskal.
'''


from typing import TypeVar, List

# Classe para representar uma aresta em um grafo ponderado
class Aresta:
    def __init__(self, origem: int, destino: int, peso: T):
        self.origem = origem
        self.destino = destino
        self.peso = peso

# Classe para representar um grafo ponderado usando lista de adjacência
class Grafo:
    def __init__(self, V: int):
        self.V = V
        self.arestas = []

    # Adiciona uma aresta ao grafo
    def addAresta(self, origem: int, destino: int, peso: T):
        self.arestas.append(Aresta(origem, destino, peso))

    # Algoritmo de Kruskal para encontrar a árvore geradora mínima
    def kruskal(self) -> List[Aresta]:
        # Ordena as arestas por peso
        self.arestas.sort(key=lambda aresta: aresta.peso)

        arvoreGeradoraMinima = []
        uf = UnionFind(self.V)

        for aresta in self.arestas:
            if not uf.connected(aresta.origem, aresta.destino):
                arvoreGeradoraMinima.append(aresta)
                uf.union(aresta.origem, aresta.destino)

        return arvoreGeradoraMinima

# Classe Union-Find para representar uma estrutura de dados para detecção de ciclos
class UnionFind:
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.rank = [0] * n

    # Encontra o representante (raiz) do conjunto ao qual o elemento pertence
    def find(self, x: int) -> int:
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    # Une os conjuntos que contêm os elementos x e y
    def union(self, x: int, y: int):
        raizX = self.find(x)
        raizY = self.find(y)
        if raizX == raizY:
            return
        if self.rank[raizX] < self.rank[raizY]:
            self.parent[raizX] = raizY
        elif self.rank[raizX] > self.rank[raizY]:
            self.parent[raizY] = raizX
        else:
            self.parent[raizY] = raizX
            self.rank[raizX] += 1

    # Verifica se dois elementos estão no mesmo conjunto
    def connected(self, x: int, y: int) -> bool:
        return self.find(x) == self.find(y)

# Função principal
def main():
    # Criando um grafo com 4 vértices
    grafo = Grafo(4)

    # Adicionando as arestas ao grafo com seus pesos
    grafo.addAresta(0, 1, 10)
    grafo.addAresta(0, 2, 6)
    grafo.addAresta(0, 3, 5)
    grafo.addAresta(1, 3, 15)
    grafo.addAresta(2, 3, 4)

    # Executando o algoritmo de Kruskal
    arvoreGeradoraMinima = grafo.kruskal()

    # Imprimindo a árvore geradora mínima
    for aresta in arvoreGeradoraMinima:
        print(f"Aresta: {aresta.origem} - {aresta.destino}, Peso: {aresta.peso}")

# Chamando a função principal
if __name__ == "__main__":
    main()
