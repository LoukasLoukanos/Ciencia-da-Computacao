=begin
 Algoritmo da Estrutura de dados linear dinâmica (não estática) ListaDuplamenteLigada 
 de Lista Duplamente Ligada, também conhecida como Lista Duplamente Encadeada */
=end

class ListaDuplamenteLigada
    class Nodo
      attr_accessor :dado, :proximo, :anterior
  
      def initialize(dado)
        @dado = dado
        @proximo = nil
        @anterior = nil
      end
    end
  
    def initialize
      @cabeca = nil
      @cauda = nil
      @tamanho = 0
    end
  
    # Inserir um elemento no final da lista
    def add_list(dado)
      novo_nodo = Nodo.new(dado)
      if @cabeca.nil?
        @cabeca = novo_nodo
        @cauda = novo_nodo
      else
        novo_nodo.anterior = @cauda
        @cauda.proximo = novo_nodo
        @cauda = novo_nodo
      end
      @tamanho += 1
    end
  
    # Remover um elemento da lista
    def remove_list(dado)
      atual = @cabeca
      while !atual.nil?
        if atual.dado == dado
          if atual == @cabeca
            @cabeca = atual.proximo
            @cabeca.anterior = nil unless @cabeca.nil?
          elsif atual == @cauda
            @cauda = atual.anterior
            @cauda.proximo = nil unless @cauda.nil?
          else
            atual.anterior.proximo = atual.proximo
            atual.proximo.anterior = atual.anterior
          end
          @tamanho -= 1
          return
        end
        atual = atual.proximo
      end
    end
  
    # Exibir os elementos da lista
    def show_list
      atual = @cabeca
      while !atual.nil?
        print "#{atual.dado} "
        atual = atual.proximo
      end
      puts
    end
end
  
lista = ListaDuplamenteLigada.new
lista.add_list(1)
lista.add_list(2)
lista.add_list(3)
lista.show_list

lista.remove_list(2)
lista.show_list
  