=begin
♦ Algoritmo 32: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Floyd-Warshall.
=end


class Grafo
  def initialize
    @adjacencia = {}
  end

  def addAresta(origem, destino, peso)
    @adjacencia[origem] ||= {}
    @adjacencia[origem][destino] = peso
  end

  def floydWarshall
    distancias = @adjacencia.clone

    # Inicializa a diagonal com 0 e as outras posições com infinito
    @adjacencia.keys.each do |vertice1|
      @adjacencia.keys.each do |vertice2|
        unless vertice1 == vertice2 || distancias[vertice1].key?(vertice2)
          distancias[vertice1][vertice2] = Float::INFINITY
        end
      end
    end

    # Algoritmo de Floyd-Warshall
    @adjacencia.keys.each do |k|
      @adjacencia.keys.each do |i|
        @adjacencia.keys.each do |j|
          distancia_ij = distancias[i][j]
          distancia_ik = distancias[i][k] || Float::INFINITY
          distancia_kj = distancias[k][j] || Float::INFINITY

          if distancia_ik + distancia_kj < distancia_ij
            distancias[i][j] = distancia_ik + distancia_kj
          end
        end
      end
    end

    distancias
  end
end

# Função principal
def main
  # Criando um grafo
  grafo = Grafo.new

  # Adicionando arestas ao grafo
  grafo.addAresta("A", "B", 3)
  grafo.addAresta("A", "C", 6)
  grafo.addAresta("B", "C", 2)
  grafo.addAresta("B", "D", 1)
  grafo.addAresta("C", "B", 4)
  grafo.addAresta("C", "D", 5)
  grafo.addAresta("D", "A", 3)

  # Executando o algoritmo de Floyd-Warshall
  distancias = grafo.floydWarshall

  # Imprimindo as distâncias mínimas entre todos os pares de vértices
  distancias.each do |vertice1, distancias_vertice1|
    distancias_vertice1.each do |vertice2, distancia|
      puts "Distância de #{vertice1} para #{vertice2}: #{distancia}"
    end
  end
end

# Chamando a função principal
main
