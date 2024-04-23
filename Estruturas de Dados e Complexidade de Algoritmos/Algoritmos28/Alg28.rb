=begin
♦ Algoritmo 28: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Dijkstra.
=end


require 'set'

# Classe para representar um vértice no grafo
class Vertice
  include Comparable
  attr_reader :indice, :valor

  def initialize(indice, valor)
    @indice = indice
    @valor = valor
  end

  # Método para comparar vértices com base em seus valores
  def <=>(outro)
    if @valor.is_a?(Comparable)
      @valor <=> outro.valor
    else
      raise NotImplementedError.new("Tipo de valor não suportado para comparação.")
    end
  end
end

# Classe para representar uma aresta no grafo ponderado
class Aresta
  attr_reader :destino, :peso

  def initialize(destino, peso)
    @destino = destino
    @peso = peso
  end
end

# Classe para representar um grafo ponderado usando lista de adjacência
class Grafo
  def initialize
    @adjacencia = {}
  end

  # Adiciona uma aresta ao grafo
  def add_aresta(origem, destino, peso)
    @adjacencia[origem] ||= []
    @adjacencia[origem] << Aresta.new(destino, peso)
  end

  # Algoritmo de Dijkstra para encontrar os menores caminhos a partir de um vértice origem
  def dijkstra(origem)
    distancia = {}
    fila_prioridade = SortedSet.new

    # Inicialização das distâncias
    @adjacencia.keys.each do |v|
      if v == origem
        distancia[v] = 0.0
      else
        distancia[v] = Float::INFINITY
      end
      fila_prioridade.add(v)
    end

    until fila_prioridade.empty?
      u = fila_prioridade.first
      fila_prioridade.delete(u)
      @adjacencia[u]&.each do |aresta|
        v = aresta.destino
        nova_distancia = distancia[u] + aresta.peso
        if nova_distancia < distancia[v]
          fila_prioridade.delete(v)
          distancia[v] = nova_distancia
          fila_prioridade.add(v)
        end
      end
    end

    distancia
  end
end

# Classe principal
class Main
  def self.run
    # Criando um grafo
    grafo = Grafo.new

    # Criando vértices
    A = Vertice.new(0, "A")
    B = Vertice.new(1, "B")
    C = Vertice.new(2, "C")
    D = Vertice.new(3, "D")
    E = Vertice.new(4, "E")

    # Adicionando arestas ao grafo
    grafo.add_aresta(A, B, 10)
    grafo.add_aresta(A, C, 15)
    grafo.add_aresta(B, D, 12)
    grafo.add_aresta(B, E, 15)
    grafo.add_aresta(C, D, 10)
    grafo.add_aresta(C, E, 5)
    grafo.add_aresta(D, E, 10)

    # Executando o algoritmo de Dijkstra a partir do vértice A
    menores_caminhos = grafo.dijkstra(A)

    # Imprimindo os menores caminhos
    menores_caminhos.each do |v, dist|
      puts "Menor caminho de A para #{v.valor}: #{dist}"
    end
  end
end

# Chamando a função principal
Main.run
