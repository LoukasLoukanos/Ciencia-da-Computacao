=begin
♦ Algoritmo 13: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada: Doubly Linked List (Lista Duplamente Ligada).
=end

class Nodo
  attr_accessor :valor, :anterior, :proximo

  def initialize(valor)
    @valor = valor
    @anterior = nil
    @proximo = nil
  end
end

class ListaDuplamenteLigada
  def initialize
    @primeiro = nil
    @ultimo = nil
    @tamanho = 0
  end

  def add_list(valor)
    novo_nodo = Nodo.new(valor)
    if @primeiro.nil?
      @primeiro = novo_nodo
      @ultimo = novo_nodo
    else
      novo_nodo.anterior = @ultimo
      @ultimo.proximo = novo_nodo
      @ultimo = novo_nodo
    end
    @tamanho += 1
  end

  def remove_list(valor)
    nodo_atual = @primeiro
    while nodo_atual
      if nodo_atual.valor == valor
        if nodo_atual == @primeiro
          @primeiro = nodo_atual.proximo
          @primeiro.anterior = nil if @primeiro
        elsif nodo_atual == @ultimo
          @ultimo = nodo_atual.anterior
          @ultimo.proximo = nil if @ultimo
        else
          anterior = nodo_atual.anterior
          proximo = nodo_atual.proximo
          anterior.proximo = proximo
          proximo.anterior = anterior
        end
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
      print "#{nodo_atual.valor} "
      nodo_atual = nodo_atual.proximo
    end
    puts
  end
end

lista = ListaDuplamenteLigada.new
lista.add_list(10)
lista.add_list(20)
lista.add_list(30)

puts "Tamanho da lista: #{lista.size}"
print "Elementos da lista: "
lista.show_list

lista.remove_list(20)

puts "Tamanho da lista após remoção: #{lista.size}"
print "Elementos da lista após remoção: "
lista.show_list
