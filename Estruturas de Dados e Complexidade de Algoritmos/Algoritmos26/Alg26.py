'''
♦ Algoritmo 26: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Largura (Breadth-First Search - BFS).
'''


from collections import defaultdict, deque

# Classe para representar um grafo não direcionado usando listas de adjacência
class Grafo:
    def __init__(self):
        self.adjacencias = defaultdict(list)

    # Método para adicionar uma aresta ao grafo
    def adicionarAresta(self, origem, destino):
        self.adjacencias[origem].append(destino)
        self.adjacencias[destino].append(origem)  # Se o grafo é não direcionado, adicione a aresta em ambas as direções

    # Algoritmo de busca em largura a partir de um vértice "inicio"
    def BFS(self, inicio):
        # Conjunto para marcar vértices visitados
        visitados = set()

        # Fila para a BFS
        fila = deque()

        # Marca o vértice inicial como visitado e o adiciona à fila
        visitados.add(inicio)
        fila.append(inicio)

        while fila:
            # Remove um vértice da fila e imprime
            vertice = fila.popleft()
            print(vertice, end=" ")

            # Obtém todos os vértices adjacentes ao vértice desenfileirado
            # Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
            for adjacente in self.adjacencias.get(vertice, []):
                if adjacente not in visitados:
                    visitados.add(adjacente)
                    fila.append(adjacente)

# Criação do grafo de exemplo
grafo = Grafo()
grafo.adicionarAresta(0, 1)
grafo.adicionarAresta(0, 2)
grafo.adicionarAresta(1, 2)
grafo.adicionarAresta(2, 0)
grafo.adicionarAresta(2, 3)
grafo.adicionarAresta(3, 3)

# Executa a busca em largura a partir do vértice 2
print("Busca em Largura (BFS) começando do vértice 2:")
grafo.BFS(2)
