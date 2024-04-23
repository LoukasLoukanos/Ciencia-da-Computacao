=begin
♦ Algoritmo 39: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Bellman-Ford.
=end


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
    @nos[valor] ||= No.new(valor)
  end

  def adicionar_aresta(origem, destino, peso)
    adicionar_no(origem)
    adicionar_no(destino)
    @nos[origem].adicionar_aresta(@nos[destino], peso)
  end

  def bellman_ford(origem)
    distancias = {}
    @nos.keys.each { |valor| distancias[valor] = Float::INFINITY }
    distancias[origem] = 0

    # Relaxamento de arestas repetido |V| - 1 vezes
    (@nos.size - 1).times do
      @nos.values.each do |no|
        no.arestas.each do |aresta|
          u = no.valor
          v = aresta.destino.valor
          peso = aresta.peso
          if distancias[u] != Float::INFINITY && distancias[u] + peso < distancias[v]
            distancias[v] = distancias[u] + peso
          end
        end
      end
    end

    # Detecção de ciclos negativos
    (@nos.size - 1).times do
      @nos.values.each do |no|
        no.arestas.each do |aresta|
          u = no.valor
          v = aresta.destino.valor
          peso = aresta.peso
          if distancias[u] != Float::INFINITY && distancias[u] + peso < distancias[v]
            raise "Ciclo negativo detectado"
          end
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

begin
  distancias = grafo.bellman_ford('A')
  distancias.each do |vertice, distancia|
    puts "Distância de A até #{vertice}: #{distancia}"
  end
rescue => e
  puts e.message
end
