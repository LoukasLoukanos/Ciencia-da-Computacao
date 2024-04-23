=begin
♦ Algoritmo 40: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Floyd-Warshall.
=end


class FloydWarshall
  def initialize
    @distancias = {}
    @predecessores = {}
  end

  def adicionar_vertice(vertice)
    @distancias[vertice] ||= {}
    @predecessores[vertice] ||= {}
  end

  def adicionar_aresta(origem, destino, peso)
    adicionar_vertice(origem)
    adicionar_vertice(destino)

    @distancias[origem][destino] = peso
    @predecessores[origem][destino] = origem

    @distancias[destino][origem] = peso
    @predecessores[destino][origem] = destino
  end

  def floyd_warshall
    @distancias.keys.each do |k|
      @distancias.keys.each do |i|
        @distancias.keys.each do |j|
          if @distancias[i][k] && @distancias[k][j]
            novo_peso = @distancias[i][k] + @distancias[k][j]
            if !@distancias[i][j] || novo_peso < @distancias[i][j]
              @distancias[i][j] = novo_peso
              @predecessores[i][j] = @predecessores[k][j]
            end
          end
        end
      end
    end
  end

  def obter_distancias
    @distancias
  end

  def obter_predecessores
    @predecessores
  end
end

floyd_warshall = FloydWarshall.new

floyd_warshall.adicionar_aresta('A', 'B', 10)
floyd_warshall.adicionar_aresta('A', 'C', 15)
floyd_warshall.adicionar_aresta('B', 'D', 12)
floyd_warshall.adicionar_aresta('B', 'F', 15)
floyd_warshall.adicionar_aresta('C', 'E', 10)
floyd_warshall.adicionar_aresta('D', 'E', 2)
floyd_warshall.adicionar_aresta('D', 'F', 1)
floyd_warshall.adicionar_aresta('F', 'E', 5)

floyd_warshall.floyd_warshall

distancias = floyd_warshall.obter_distancias
predecessores = floyd_warshall.obter_predecessores

distancias.each do |u, distancias_u|
  distancias_u.each do |v, distancia|
    puts "Distância de #{u} até #{v}: #{distancia}"
  end
end

predecessores.each do |u, predecessores_u|
  predecessores_u.each do |v, predecessor|
    puts "Predecessor de #{v} no caminho de #{u} até #{v}: #{predecessor}"
  end
end
