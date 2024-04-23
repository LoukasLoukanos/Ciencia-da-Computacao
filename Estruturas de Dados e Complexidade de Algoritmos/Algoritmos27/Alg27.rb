=begin
♦ Algoritmo 27: Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
=end


class Grafo
  def initialize
    @adjacencias = {}
  end

  def adicionar_aresta(origem, destino)
    @adjacencias[origem] ||= []
    @adjacencias[destino] ||= []
    @adjacencias[origem] << destino
    @adjacencias[destino] << origem # Se o grafo é não direcionado, adicione a aresta em ambas as direções
  end

  def dfs(inicio)
    visitados = Set.new
    pilha = []

    pilha.push(inicio)

    until pilha.empty?
      vertice = pilha.pop

      unless visitados.include?(vertice)
        print "#{vertice} "
        visitados.add(vertice)

        (@adjacencias[vertice] || []).each do |adjacente|
          pilha.push(adjacente) unless visitados.include?(adjacente)
        end
      end
    end
  end
end

grafo = Grafo.new
grafo.adicionar_aresta(0, 1)
grafo.adicionar_aresta(0, 2)
grafo.adicionar_aresta(1, 2)
grafo.adicionar_aresta(2, 0)
grafo.adicionar_aresta(2, 3)
grafo.adicionar_aresta(3, 3)

puts "Busca em Profundidade (DFS) começando do vértice 2:"
grafo.dfs(2)
