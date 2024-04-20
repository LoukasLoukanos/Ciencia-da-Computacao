'''
♦ Algoritmo 29: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Bellman-Ford.
'''


class Aresta:
    def __init__(self, origem, destino, peso):
        self.origem = origem
        self.destino = destino
        self.peso = peso

class Grafo:
    def __init__(self, V, E):
        self.V = V  # Número de vértices
        self.E = E  # Número de arestas
        self.arestas = []

    # Adiciona uma aresta ao grafo
    def addAresta(self, origem, destino, peso):
        self.arestas.append(Aresta(origem, destino, peso))

    # Algoritmo de Bellman-Ford para encontrar o caminho mais curto
    def BellmanFord(self, origem):
        # Inicializa as distâncias de todos os vértices como infinito
        distancia = [float('inf')] * self.V
        distancia[origem] = 0

        # Relaxamento das arestas
        for _ in range(self.V - 1):
            for aresta in self.arestas:
                u = aresta.origem
                v = aresta.destino
                peso = aresta.peso
                if distancia[u] != float('inf') and distancia[u] + peso < distancia[v]:
                    distancia[v] = distancia[u] + peso

        # Verifica ciclos de peso negativo
        for aresta in self.arestas:
            u = aresta.origem
            v = aresta.destino
            peso = aresta.peso
            if distancia[u] != float('inf') and distancia[u] + peso < distancia[v]:
                print("O grafo contém um ciclo de peso negativo!")
                return

        # Imprime as distâncias mais curtas
        for i in range(self.V):
            print(f"Distância do vértice {origem} ao vértice {i} é {distancia[i]}")

# Função principal
def main():
    # Criando um grafo com 5 vértices e 8 arestas
    grafo = Grafo(5, 8)

    # Adicionando as arestas ao grafo
    grafo.addAresta(0, 1, 6.0)
    grafo.addAresta(0, 2, 7.0)
    grafo.addAresta(1, 2, 8.0)
    grafo.addAresta(1, 3, -4.0)
    grafo.addAresta(1, 4, 5.0)
    grafo.addAresta(2, 3, 9.0)
    grafo.addAresta(2, 4, -3.0)
    grafo.addAresta(3, 4, 7.0)

    # Executando o algoritmo de Bellman-Ford a partir do vértice 0
    grafo.BellmanFord(0)

# Chamando a função principal
if __name__ == "__main__":
    main()
