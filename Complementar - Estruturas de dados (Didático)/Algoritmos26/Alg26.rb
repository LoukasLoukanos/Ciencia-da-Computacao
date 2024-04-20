=begin
♦ Algoritmo 26: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Largura (Breadth-First Search - BFS).
=end


# Classe para representar um grafo não direcionado usando listas de adjacência
class Grafo
  def initialize
    @adjacencias = Hash.new { |hash, key| hash[key] = [] }
  end

  # Método para adicionar uma aresta ao grafo
  def adicionarAresta(origem, destino)
    @adjacencias[origem] << destino
    @adjacencias[destino] << origem # Se o grafo é não direcionado, adicione a aresta em ambas as direções
  end

  # Algoritmo de busca em largura a partir de um vértice "inicio"
  def bfs(inicio)
    # Conjunto para marcar vértices visitados
    visitados = Set.new

    # Fila para a BFS
    fila = []

    # Marca o vértice inicial como visitado e o adiciona à fila
    visitados << inicio
    fila << inicio

    while !fila.empty?
      # Remove um vértice da fila e imprime
      vertice = fila.shift
      print vertice.to_s + " "

      # Obtém todos os vértices adjacentes ao vértice desenfileirado
      # Se um vértice adjacente não foi visitado, marca-o como visitado e o adiciona à fila
      @adjacencias[vertice].each do |adjacente|
        if !visitados.include?(adjacente)
          visitados << adjacente
          fila << adjacente
        end
      end
    end
  end
end

# Criação do grafo de exemplo
grafo = Grafo.new
grafo.adicionarAresta(0, 1)
grafo.adicionarAresta(0, 2)
grafo.adicionarAresta(1, 2)
grafo.adicionarAresta(2, 0)
grafo.adicionarAresta(2, 3)
grafo.adicionarAresta(3, 3)

# Executa a busca em largura a partir do vértice 2
puts "Busca em Largura (BFS) começando do vértice 2:"
grafo.bfs(2)
