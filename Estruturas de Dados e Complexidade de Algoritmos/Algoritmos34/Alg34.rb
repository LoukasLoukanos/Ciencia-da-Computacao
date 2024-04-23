=begin
♦ Algoritmo 34: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore AVL.
=end


class No
  attr_accessor :valor, :esquerda, :direita, :altura

  def initialize(valor)
    @valor = valor
    @esquerda = nil
    @direita = nil
    @altura = 1
  end
end

class ArvoreAVL
  def initialize
    @raiz = nil
  end

  def altura(no)
    return 0 if no.nil?

    no.altura
  end

  def balanceamento(no)
    return 0 if no.nil?

    altura(no.esquerda) - altura(no.direita)
  end

  def rotacao_direita(y)
    x = y.esquerda
    t2 = x.direita

    x.direita = y
    y.esquerda = t2

    y.altura = [altura(y.esquerda), altura(y.direita)].max + 1
    x.altura = [altura(x.esquerda), altura(x.direita)].max + 1

    x
  end

  def rotacao_esquerda(x)
    y = x.direita
    t2 = y.esquerda

    y.esquerda = x
    x.direita = t2

    x.altura = [altura(x.esquerda), altura(x.direita)].max + 1
    y.altura = [altura(y.esquerda), altura(y.direita)].max + 1

    y
  end

  def inserir(valor)
    @raiz = inserir_recursivo(@raiz, valor)
  end

  def inserir_recursivo(no, valor)
    return No.new(valor) if no.nil?

    if valor < no.valor
      no.esquerda = inserir_recursivo(no.esquerda, valor)
    elsif valor > no.valor
      no.direita = inserir_recursivo(no.direita, valor)
    else
      return no
    end

    no.altura = [altura(no.esquerda), altura(no.direita)].max + 1

    balanceamento = balanceamento(no)

    if balanceamento > 1 && valor < no.esquerda.valor
      return rotacao_direita(no)
    end

    if balanceamento < -1 && valor > no.direita.valor
      return rotacao_esquerda(no)
    end

    if balanceamento > 1 && valor > no.esquerda.valor
      no.esquerda = rotacao_esquerda(no.esquerda)
      return rotacao_direita(no)
    end

    if balanceamento < -1 && valor < no.direita.valor
      no.direita = rotacao_direita(no.direita)
      return rotacao_esquerda(no)
    end

    no
  end

  def imprimir_em_ordem_recursivo(no)
    return if no.nil?

    imprimir_em_ordem_recursivo(no.esquerda)
    print "#{no.valor} "
    imprimir_em_ordem_recursivo(no.direita)
  end

  def imprimir_em_ordem
    imprimir_em_ordem_recursivo(@raiz)
  end
end

# Teste
arvore = ArvoreAVL.new
arvore.inserir(10)
arvore.inserir(5)
arvore.inserir(20)
arvore.inserir(3)
arvore.inserir(8)
arvore.inserir(15)

puts "Em Ordem:"
arvore.imprimir_em_ordem
