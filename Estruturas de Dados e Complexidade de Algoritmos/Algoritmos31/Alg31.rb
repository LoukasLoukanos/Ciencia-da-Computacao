=begin
♦ Algoritmo 31: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Prim.
=end


require 'set'

# Classe para representar um vértice no grafo
class Vertice
  include Comparable
  attr_accessor :indice, :valor

  def initialize(indice, valor)
    @indice = indice
    @valor = valor
  end

  # Método para comparar vértices com base em seus valores
  def <=>(outro)
    if @valor.is_a?(Comparable)
      @valor <=> outro.valor
    else
      raise NotImplementedError, "Tipo de valor não suportado para comparação."
    end
  end
end

# Classe para representar uma aresta no grafo ponderado
class Aresta
  attr_accessor :destino, :peso

  def initialize(destino, peso)
    @destino = destino
    @peso = peso
  end
end

# Classe para representar um grafo ponderado usando lista de adjacência
class Grafo
  attr_accessor :adjacencia

  def initialize
    @adjacencia = {}
  end

  # Adiciona uma aresta ao grafo
  def add_aresta(origem, destino, peso)
    @adjacencia[origem] ||= []
    @adjacencia[origem] << Aresta.new(destino, peso)

    @adjacencia[destino] ||= []
    @adjacencia[destino] << Aresta.new(origem, peso) # Para grafos não direcionados
  end

  # Algoritmo de Prim para encontrar a árvore geradora mínima
  def prim(origem)
    visitados = Set.new
    arvore_geradora_minima = []
    fila_prioridade = []

    visitados.add(origem)
    adicionar_arestas_adjacentes(origem, fila_prioridade, visitados)

    until fila_prioridade.empty?
      aresta = fila_prioridade.shift
      destino = aresta.destino

      unless visitados.include?(destino)
        visitados.add(destino)
        arvore_geradora_minima << aresta
        adicionar_arestas_adjacentes(destino, fila_prioridade, visitados)
      end
    end

    arvore_geradora_minima
  end

  private

  def adicionar_arestas_adjacentes(vertice, fila_prioridade, visitados)
    (@adjacencia[vertice] || []).each do |aresta|
      fila_prioridade << aresta unless visitados.include?(aresta.destino)
    end
  end
end

# Classe principal
class Main
  def self.main
    # Criando um grafo
    grafo = Grafo.new

    # Criando vértices
    a = Vertice.new(0, 'A')
    b = Vertice.new(1, 'B')
    c = Vertice.new(2, 'C')
    d = Vertice.new(3, 'D')
    e = Vertice.new(4, 'E')

    # Adicionando arestas ao grafo
    grafo.add_aresta(a, b, 4)
    grafo.add_aresta(a, c, 1)
    grafo.add_aresta(b, c, 2)
    grafo.add_aresta(b, d, 5)
    grafo.add_aresta(c, d, 8)
    grafo.add_aresta(c, e, 10)
    grafo.add_aresta(d, e, 2)

    # Executando o algoritmo de Prim a partir do vértice A
    arvore_geradora_minima = grafo.prim(a)

    # Imprimindo a árvore geradora mínima
    arvore_geradora_minima.each do |aresta|
      puts "Aresta: #{aresta.destino.valor}, Peso: #{aresta.peso}"
    end
  end
end

# Executando a função principal
Main.main
