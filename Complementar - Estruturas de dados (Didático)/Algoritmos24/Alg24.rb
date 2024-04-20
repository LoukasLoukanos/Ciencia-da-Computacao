=begin
♦ Algoritmo 24: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Não-Binária: Árvore B.
=end


class ArvoreB
    ORDEM = 3  # Ordem da árvore B
  
    class No
      attr_accessor :chaves, :filhos, :folha
  
      def initialize(folha)
        @chaves = []
        @filhos = []
        @folha = folha
      end
    end
  
    def initialize
      @raiz = No.new(true)
    end
  
    def inserir(chave)
      inserir_na_arvore(@raiz, chave)
    end
  
    def inserir_na_arvore(no, chave)
      if no.chaves.size == ORDEM - 1
        novo_no = No.new(false)
        novo_no.filhos << no
        dividir_no(novo_no, 0, no)
        i = 0
        if novo_no.chaves[0] < chave
          i += 1
        end
        inserir_em_no_nao_cheio(novo_no.filhos[i], chave)
        @raiz = novo_no
      else
        inserir_em_no_nao_cheio(no, chave)
      end
    end
  
    def inserir_em_no_nao_cheio(no, chave)
      i = no.chaves.size - 1
      if no.folha
        no.chaves << chave
        while i >= 0 && no.chaves[i] > chave
          no.chaves[i + 1] = no.chaves[i]
          i -= 1
        end
        no.chaves[i + 1] = chave
      else
        while i >= 0 && no.chaves[i] > chave
          i -= 1
        end
        i += 1
        if no.filhos[i].chaves.size == ORDEM - 1
          dividir_no(no, i, no.filhos[i])
          if no.chaves[i] < chave
            i += 1
          end
        end
        inserir_em_no_nao_cheio(no.filhos[i], chave)
      end
    end
  
    def dividir_no(pai, indice_filho, filho)
      novo_no = No.new(filho.folha)
      (ORDEM / 2 - 1).times do
        novo_no.chaves << filho.chaves.delete_at(ORDEM / 2)
      end
      if !filho.folha
        (ORDEM / 2).times do
          novo_no.filhos << filho.filhos.delete_at(ORDEM / 2)
        end
      end
      pai.chaves.insert(indice_filho, filho.chaves[ORDEM / 2 - 1])
      pai.filhos.insert(indice_filho + 1, novo_no)
    end
  
    def remover(chave)
      remover_na_arvore(@raiz, chave)
    end
  
    def remover_na_arvore(no, chave)
      # Implemente a remoção aqui
    end
  
    def fundir_nos(pai, indice_filho)
      # Implemente a fusão de nós aqui
    end
  
    # Outros métodos necessários
  end
  
  # Teste
  arvore = ArvoreB.new  # Exemplo de ordem 3
  arvore.inserir(10)
  arvore.inserir(20)
  arvore.inserir(5)
  arvore.inserir(15)
  arvore.inserir(25)
  arvore.remover(15)  # Exemplo de remoção
  # Imprimir árvore ou realizar outras operações para testar
  