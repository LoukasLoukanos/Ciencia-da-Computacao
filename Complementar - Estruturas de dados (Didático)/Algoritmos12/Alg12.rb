=begin
♦ Algoritmo 12: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada): Linked List (Lista Ligada).
=end

class Nodo
  attr_accessor :valor, :proximo

  def initialize(valor)
    @valor = valor
    @proximo = nil
  end
end

class ListaLigada
  def initialize
    @primeiro = nil
    @tamanho = 0
  end

  def add_list(valor)
    novo_nodo = Nodo.new(valor)
    novo_nodo.proximo = @primeiro
    @primeiro = novo_nodo
    @tamanho += 1
  end

  def remove_list(valor)
    return if @primeiro.nil?

    if @primeiro.valor == valor
      @primeiro = @primeiro.proximo
      @tamanho -= 1
      return
    end

    nodo_atual = @primeiro
    while nodo_atual.proximo
      if nodo_atual.proximo.valor == valor
        nodo_atual.proximo = nodo_atual.proximo.proximo
        @tamanho -= 1
        return
      end
      nodo_atual = nodo_atual.proximo
    end
  end

  def size
    @tamanho
  end

  def show_list
    nodo_atual = @primeiro
    while nodo_atual
      print nodo_atual.valor.to_s + ' '
      nodo_atual = nodo_atual.proximo
    end
    puts
  end
end

lista = ListaLigada.new
lista.add_list(10)
lista.add_list(20)
lista.add_list(30)

puts 'Tamanho da lista:', lista.size
print 'Elementos da lista: '
lista.show_list

lista.remove_list(20)

puts 'Tamanho da lista após remoção:', lista.size
print 'Elementos da lista após remoção: '
lista.show_list
