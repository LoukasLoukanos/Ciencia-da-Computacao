=begin
♦ Algoritmo 38: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Dijkstra.
=end


require 'set'
require 'priority_queue'

class Aresta
  attr_reader :destino, :peso
  
  def initialize(destino, peso)
    @destino = destino
    @peso = peso
  end
end

class No
  attr_reader :valor, :arestas
  
  def initialize(valor)
    @valor = valor
    @arestas = []
  end
  
  def adicionar_aresta(destino, peso)
    @arestas << Aresta.new(destino, peso)
  end
end

class Grafo
  def initialize
    @nos = {}
  end
  
  def adicionar_no(valor)
    @nos[valor] = No.new(valor) unless @nos.key?(valor)
  end
  
  def adicionar_aresta(origem, destino, peso)
    adicionar_no(origem)
    adicionar_no(destino)
    @nos[origem].adicionar_aresta(@nos[destino], peso)
  end
  
  def dijkstra(origem)
    distancias = Hash.new(Float::INFINITY)
    fila_prioridade = Containers::PriorityQueue.new { |a, b| distancias[a.valor] < distancias[b.valor] }
    
    @nos.keys.each { |valor| distancias[valor] = Float::INFINITY }
    
    distancias[origem] = 0
    fila_prioridade.push(@nos[origem])
    
    until fila_prioridade.empty?
      no_atual = fila_prioridade.pop
      distancia_atual = distancias[no_atual.valor]
      
      no_atual.arestas.each do |aresta|
        vizinho = aresta.destino
        nova_distancia = distancia_atual + aresta.peso
        
        if nova_distancia < distancias[vizinho.valor]
          distancias[vizinho.valor] = nova_distancia
          fila_prioridade.push(vizinho)
        end
      end
    end
    
    distancias
  end
end

grafo = Grafo.new

grafo.adicionar_aresta('A', 'B', 10)
grafo.adicionar_aresta('A', 'C', 15)
grafo.adicionar_aresta('B', 'D', 12)
grafo.adicionar_aresta('B', 'F', 15)
grafo.adicionar_aresta('C', 'E', 10)
grafo.adicionar_aresta('D', 'E', 2)
grafo.adicionar_aresta('D', 'F', 1)
grafo.adicionar_aresta('F', 'E', 5)

distancias = grafo.dijkstra('A')
distancias.each do |vertice, distancia|
  puts "Distância de A até #{vertice}: #{distancia}"
end
