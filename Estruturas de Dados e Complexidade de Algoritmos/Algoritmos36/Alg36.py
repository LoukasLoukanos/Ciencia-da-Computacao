'''
♦ Algoritmo 36: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Largura (Breadth-First Search - BFS).
'''


from collections import deque

class Grafo:
    def __init__(self, v):
        self.V = v  # Número de vértices
        self.adj = [deque() for _ in range(v)]  # Lista de adjacência

    # Adiciona uma aresta ao grafo
    def adicionarAresta(self, v, w):
        self.adj[v].append(w)

    # Executa a busca em largura a partir de um vértice inicial
    def BFS(self, s):
        # Marca todos os vértices como não visitados
        visitados = [False] * self.V

        # Cria uma fila para o BFS
        fila = deque()

        # Marca o vértice atual como visitado e o adiciona à fila
        visitados[s] = True
        fila.append(s)

        while fila:
            # Remove um vértice da fila e imprime
            s = fila.popleft()
            print(s, end=" ")

            # Obtém todos os vértices adjacentes do vértice removido da fila
            for n in self.adj[s]:
                # Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
                if not visitados[n]:
                    visitados[n] = True
                    fila.append(n)

# Função principal
def main():
    g = Grafo(4)

    g.adicionarAresta(0, 1)
    g.adicionarAresta(0, 2)
    g.adicionarAresta(1, 2)
    g.adicionarAresta(2, 0)
    g.adicionarAresta(2, 3)
    g.adicionarAresta(3, 3)

    print("Busca em Largura (BFS) a partir do vértice 2:")
    g.BFS(2)

if __name__ == "__main__":
    main()
