=begin
♦ Algoritmo 37: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
=end


# Classe para representar um nó do grafo genérico
class No
  attr_accessor :valor, :vizinhos

  def initialize(valor)
    @valor = valor
    @vizinhos = []
  end

  def adicionar_vizinho(vizinho)
    @vizinhos << vizinho
  end
end

# Classe para representar o Grafo Genérico
class Grafo
  def initialize
    @nos = {}
  end

  def adicionar_no(valor)
    @nos[valor] ||= No.new(valor)
  end

  def adicionar_aresta(origem, destino)
    adicionar_no(origem)
    adicionar_no(destino)
    @nos[origem].adicionar_vizinho(@nos[destino])
  end

  # Método de busca em profundidade (DFS)
  def dfs(inicio)
    visitados = Set.new
    dfs_recursivo(@nos[inicio], visitados)
  end

  private

  def dfs_recursivo(no, visitados)
    visitados.add(no.valor)
    print "#{no.valor} "

    no.vizinhos.each do |vizinho|
      dfs_recursivo(vizinho, visitados) unless visitados.include?(vizinho.valor)
    end
  end
end

# Função principal para teste
def main
  grafo = Grafo.new

  grafo.adicionar_aresta(0, 1)
  grafo.adicionar_aresta(0, 2)
  grafo.adicionar_aresta(1, 2)
  grafo.adicionar_aresta(2, 0)
  grafo.adicionar_aresta(2, 3)
  grafo.adicionar_aresta(3, 3)

  puts "Busca em Profundidade (DFS) a partir do vértice 2:"
  grafo.dfs(2)
end

main
