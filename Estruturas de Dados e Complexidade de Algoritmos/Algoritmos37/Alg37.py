'''
♦ Algoritmo 37: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
'''


# Classe para representar um nó do grafo genérico
class No:
    def __init__(self, valor):
        self.valor = valor
        self.vizinhos = []

    def adicionarVizinho(self, vizinho):
        self.vizinhos.append(vizinho)

# Classe para representar o Grafo Genérico
class Grafo:
    def __init__(self):
        self.nos = {}

    def adicionarNo(self, valor):
        if valor not in self.nos:
            self.nos[valor] = No(valor)

    def adicionarAresta(self, origem, destino):
        if origem not in self.nos:
            self.adicionarNo(origem)
        if destino not in self.nos:
            self.adicionarNo(destino)
        self.nos[origem].adicionarVizinho(self.nos[destino])

    # Método de busca em profundidade (DFS)
    def DFS(self, inicio):
        visitados = set()
        self.DFSRecursivo(self.nos[inicio], visitados)

    def DFSRecursivo(self, no, visitados):
        visitados.add(no.valor)
        print(no.valor, end=" ")

        for vizinho in no.vizinhos:
            if vizinho.valor not in visitados:
                self.DFSRecursivo(vizinho, visitados)

# Função principal para teste
def main():
    grafo = Grafo()

    grafo.adicionarAresta(0, 1)
    grafo.adicionarAresta(0, 2)
    grafo.adicionarAresta(1, 2)
    grafo.adicionarAresta(2, 0)
    grafo.adicionarAresta(2, 3)
    grafo.adicionarAresta(3, 3)

    print("Busca em Profundidade (DFS) a partir do vértice 2:")
    grafo.DFS(2)

if __name__ == "__main__":
    main()
