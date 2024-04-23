=begin
♦ Algoritmo 36: Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Largura (Breadth-First Search - BFS).
=end


require 'set'

class Grafo
  def initialize(v)
    @V = v  # Número de vértices
    @adj = Array.new(v) { [] }  # Lista de adjacência
  end

  # Adiciona uma aresta ao grafo
  def adicionarAresta(v, w)
    @adj[v] << w
  end

  # Executa a busca em largura a partir de um vértice inicial
  def bfs(s)
    # Marca todos os vértices como não visitados
    visitados = Array.new(@V, false)

    # Cria uma fila para o BFS
    fila = Queue.new

    # Marca o vértice atual como visitado e o adiciona à fila
    visitados[s] = true
    fila.push(s)

    while !fila.empty?
      # Remove um vértice da fila e imprime
      s = fila.pop
      print "#{s} "

      # Obtém todos os vértices adjacentes do vértice removido da fila
      @adj[s].each do |n|
        # Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
        if !visitados[n]
          visitados[n] = true
          fila.push(n)
        end
      end
    end
  end
end

# Função principal
def main
  g = Grafo.new(4)

  g.adicionarAresta(0, 1)
  g.adicionarAresta(0, 2)
  g.adicionarAresta(1, 2)
  g.adicionarAresta(2, 0)
  g.adicionarAresta(2, 3)
  g.adicionarAresta(3, 3)

  puts "Busca em Largura (BFS) a partir do vértice 2:"
  g.bfs(2)
end

main
