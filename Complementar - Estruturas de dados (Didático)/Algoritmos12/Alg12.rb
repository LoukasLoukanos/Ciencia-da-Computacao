=begin
 Algoritmo da Estrutura de dados linear dinâmica (não estática) 
 ListaLigada de Lista Ligada, também conhecida como Lista Encadeada 
=end

class ListaLigada
    class No
      attr_accessor :dado, :proximo
  
      def initialize(dado)
        @dado = dado
        @proximo = nil
      end
    end
  
    def initialize
      @cabeca = nil
    end
  
    # Adicionar um elemento no final da lista
    def addList(dado)
      novo_no = No.new(dado)
      if @cabeca.nil?
        @cabeca = novo_no
      else
        atual = @cabeca
        while atual.proximo
          atual = atual.proximo
        end
        atual.proximo = novo_no
      end
    end
  
    # Remover um elemento da lista
    def removeList(dado)
      return if @cabeca.nil?
  
      if @cabeca.dado == dado
        @cabeca = @cabeca.proximo
        return
      end
  
      atual = @cabeca
      anterior = nil
      while atual && atual.dado != dado
        anterior = atual
        atual = atual.proximo
      end
  
      return if atual.nil?
  
      anterior.proximo = atual.proximo
    end
  
    # Imprimir a lista
    def showList
      atual = @cabeca
      while atual
        print "#{atual.dado} "
        atual = atual.proximo
      end
      puts
    end
end
  
lista = ListaLigada.new
lista.addList(1)
lista.addList(2)
lista.addList(3)
lista.showList

lista.removeList(2)
lista.showList
