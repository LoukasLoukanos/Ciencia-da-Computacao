=begin
♦ Algoritmo 29: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Bellman-Ford.
=end


# Classe para representar uma aresta em um grafo ponderado
class Aresta
    attr_accessor :origem, :destino, :peso
    
    def initialize(origem, destino, peso)
      @origem = origem
      @destino = destino
      @peso = peso
    end
  end
  
  # Classe para representar um grafo ponderado usando matriz de adjacência
  class Grafo
    attr_accessor :V, :E, :arestas
    
    def initialize(V, E)
      @V = V
      @E = E
      @arestas = []
    end
    
    # Adiciona uma aresta ao grafo
    def addAresta(origem, destino, peso)
      @arestas << Aresta.new(origem, destino, peso)
    end
    
    # Algoritmo de Bellman-Ford para encontrar o caminho mais curto
    def bellman_ford(origem)
      # Inicializa as distâncias de todos os vértices como infinito
      distancia = Array.new(V, Float::INFINITY)
      distancia[origem] = 0
      
      # Relaxamento das arestas
      (1...V).each do
        arestas.each do |aresta|
          u = aresta.origem
          v = aresta.destino
          peso = aresta.peso
          if distancia[u] != Float::INFINITY && distancia[u] + peso < distancia[v]
            distancia[v] = distancia[u] + peso
          end
        end
      end
      
      # Verifica ciclos de peso negativo
      arestas.each do |aresta|
        u = aresta.origem
        v = aresta.destino
        peso = aresta.peso
        if distancia[u] != Float::INFINITY && distancia[u] + peso < distancia[v]
          puts "O grafo contém um ciclo de peso negativo!"
          return
        end
      end
      
      # Imprime as distâncias mais curtas
      (0...V).each do |i|
        puts "Distância do vértice #{origem} ao vértice #{i} é #{distancia[i]}"
      end
    end
  end
  
  # Função principal
  def main
    # Criando um grafo com 5 vértices e 8 arestas
    grafo = Grafo.new(5, 8)
  
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
    grafo.bellman_ford(0)
  end
  
  # Chamando a função principal
  main
  