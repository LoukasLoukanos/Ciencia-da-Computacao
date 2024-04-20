=begin
♦ Algoritmo 35: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore Rubro-Negra.
=end


class No
  attr_accessor :valor, :esquerda, :direita, :vermelho

  def initialize(valor)
    @valor = valor
    @esquerda = nil
    @direita = nil
    @vermelho = true # Por padrão, os nós são vermelhos quando adicionados à árvore
  end
end

class ArvoreRubroNegra
  VERMELHO = true
  PRETO = false

  def initialize
    @raiz = nil
  end

  # Verifica se um nó é vermelho
  def is_vermelho(no)
    return false if no.nil?

    no.vermelho == VERMELHO
  end

  # Realiza uma rotação para a esquerda em torno do nó dado
  def rotacao_esquerda(no)
    temp = no.direita
    no.direita = temp.esquerda
    temp.esquerda = no
    temp.vermelho = no.vermelho
    no.vermelho = VERMELHO
    temp
  end

  # Realiza uma rotação para a direita em torno do nó dado
  def rotacao_direita(no)
    temp = no.esquerda
    no.esquerda = temp.direita
    temp.direita = no
    temp.vermelho = no.vermelho
    no.vermelho = VERMELHO
    temp
  end

  # Inverte as cores do nó e de seus filhos
  def inverter_cores(no)
    no.vermelho = !no.vermelho
    no.esquerda.vermelho = !no.esquerda.vermelho
    no.direita.vermelho = !no.direita.vermelho
  end

  # Insere um novo nó na árvore Rubro-Negra
  def inserir(valor)
    @raiz = inserir_recursivo(@raiz, valor)
    @raiz.vermelho = PRETO # A raiz sempre será preta
  end

  # Método auxiliar recursivo para inserção
  def inserir_recursivo(no, valor)
    return No.new(valor) if no.nil?

    # Inserção normal como em uma árvore de busca binária
    if valor < no.valor
      no.esquerda = inserir_recursivo(no.esquerda, valor)
    elsif valor > no.valor
      no.direita = inserir_recursivo(no.direita, valor)
    else
      return no # Valor já existe na árvore
    end

    # Correção da propriedade de cor após a inserção
    if is_vermelho(no.direita) && !is_vermelho(no.esquerda)
      no = rotacao_esquerda(no)
    end
    if is_vermelho(no.esquerda) && is_vermelho(no.esquerda.esquerda)
      no = rotacao_direita(no)
    end
    if is_vermelho(no.esquerda) && is_vermelho(no.direita)
      inverter_cores(no)
    end

    no
  end

  # Método para imprimir a árvore em ordem
  def imprimir_em_ordem
    imprimir_em_ordem_recursivo(@raiz)
  end

  # Método auxiliar recursivo para impressão em ordem
  def imprimir_em_ordem_recursivo(no)
    return if no.nil?

    imprimir_em_ordem_recursivo(no.esquerda)
    print "#{no.valor} "
    imprimir_em_ordem_recursivo(no.direita)
  end

  # Método para verificar se a árvore Rubro-Negra está vazia
  def esta_vazia?
    @raiz.nil?
  end
end

# Teste
arvore = ArvoreRubroNegra.new
arvore.inserir(10)
arvore.inserir(5)
arvore.inserir(20)
arvore.inserir(3)
arvore.inserir(8)
arvore.inserir(15)

puts "Em Ordem:"
arvore.imprimir_em_ordem
