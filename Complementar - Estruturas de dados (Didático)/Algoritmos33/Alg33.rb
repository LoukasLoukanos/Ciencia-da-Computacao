=begin
♦ Algoritmo 33: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).
=end


class No
  attr_accessor :valor, :esquerda, :direita

  def initialize(valor)
    @valor = valor
    @esquerda = nil
    @direita = nil
  end
end

class ArvoreBinaria
  def initialize
    @raiz = nil
  end

  def inserir(valor)
    @raiz = inserir_recursivo(@raiz, valor)
  end

  def inserir_recursivo(no, valor)
    if no.nil?
      return No.new(valor)
    end

    if valor < no.valor
      no.esquerda = inserir_recursivo(no.esquerda, valor)
    elsif valor > no.valor
      no.direita = inserir_recursivo(no.direita, valor)
    end

    return no
  end

  def buscar(valor)
    buscar_recursivo(@raiz, valor)
  end

  def buscar_recursivo(no, valor)
    return false if no.nil?

    if valor == no.valor
      return true
    end

    if valor < no.valor
      return buscar_recursivo(no.esquerda, valor)
    else
      return buscar_recursivo(no.direita, valor)
    end
  end

  def imprimir_em_ordem
    imprimir_em_ordem_recursivo(@raiz)
  end

  def imprimir_em_ordem_recursivo(no)
    return if no.nil?

    imprimir_em_ordem_recursivo(no.esquerda)
    print "#{no.valor} "
    imprimir_em_ordem_recursivo(no.direita)
  end
end

arvore = ArvoreBinaria.new
arvore.inserir(10)
arvore.inserir(5)
arvore.inserir(20)
arvore.inserir(3)
arvore.inserir(8)
arvore.inserir(15)

puts "Em Ordem:"
arvore.imprimir_em_ordem

puts "\n\nBuscar 8: #{arvore.buscar(8)}"
puts "Buscar 12: #{arvore.buscar(12)}"
