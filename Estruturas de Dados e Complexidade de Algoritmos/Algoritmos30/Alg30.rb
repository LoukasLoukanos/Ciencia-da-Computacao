=begin
♦ Algoritmo 30: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Kruskal.
=end


# Classe para representar uma aresta em um grafo ponderado
class Aresta
  include Comparable

  attr_reader :origem, :destino, :peso

  def initialize(origem, destino, peso)
    @origem = origem
    @destino = destino
    @peso = peso
  end

  # Método para comparar arestas com base em seus pesos
  def <=>(outra)
    if @peso.respond_to?(:<=>)
      @peso <=> outra.peso
    else
      raise "Tipo de peso não suportado para comparação."
    end
  end
end

# Classe para representar um grafo ponderado usando lista de adjacência
class Grafo
  attr_reader :V, :arestas

  def initialize(V)
    @V = V
    @arestas = []
  end

  # Adiciona uma aresta ao grafo
  def add_aresta(origem, destino, peso)
    @arestas << Aresta.new(origem, destino, peso)
  end

  # Algoritmo de Kruskal para encontrar a árvore geradora mínima
  def kruskal
    # Ordena as arestas por peso
    @arestas.sort!

    arvore_geradora_minima = []
    uf = UnionFind.new(@V)

    @arestas.each do |aresta|
      unless uf.connected(aresta.origem, aresta.destino)
        arvore_geradora_minima << aresta
        uf.union(aresta.origem, aresta.destino)
      end
    end

    arvore_geradora_minima
  end
end

# Classe Union-Find para representar uma estrutura de dados para detecção de ciclos
class UnionFind
  def initialize(n)
    @parent = (0...n).to_a
    @rank = Array.new(n, 0)
  end

  # Encontra o representante (raiz) do conjunto ao qual o elemento pertence
  def find(x)
    @parent[x] = find(@parent[x]) if x != @parent[x]
    @parent[x]
  end

  # Une os conjuntos que contêm os elementos x e y
  def union(x, y)
    raiz_x = find(x)
    raiz_y = find(y)
    return if raiz_x == raiz_y

    if @rank[raiz_x] < @rank[raiz_y]
      @parent[raiz_x] = raiz_y
    elsif @rank[raiz_x] > @rank[raiz_y]
      @parent[raiz_y] = raiz_x
    else
      @parent[raiz_y] = raiz_x
      @rank[raiz_x] += 1
    end
  end

  # Verifica se dois elementos estão no mesmo conjunto
  def connected(x, y)
    find(x) == find(y)
  end
end

# Função principal
def main
  # Criando um grafo com 4 vértices
  grafo = Grafo.new(4)

  # Adicionando as arestas ao grafo com seus pesos
  grafo.add_aresta(0, 1, 10)
  grafo.add_aresta(0, 2, 6)
  grafo.add_aresta(0, 3, 5)
  grafo.add_aresta(1, 3, 15)
  grafo.add_aresta(2, 3, 4)

  # Executando o algoritmo de Kruskal
  arvore_geradora_minima = grafo.kruskal

  # Imprimindo a árvore geradora mínima
  arvore_geradora_minima.each do |aresta|
    puts "Aresta: #{aresta.origem} - #{aresta.destino}, Peso: #{aresta.peso}"
  end
end

# Chamando a função principal
main
