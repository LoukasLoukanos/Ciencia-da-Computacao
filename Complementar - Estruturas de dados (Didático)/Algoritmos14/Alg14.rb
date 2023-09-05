=begin
 Algoritmo da Estrutura de dados linear dinâmica (não estática) 
 Alg14 de Fila (regra de acesso FIFO) Dinâmica
=end

class FilaDinamica
    class Nodo
      attr_accessor :dado, :proximo
  
      def initialize(dado)
        @dado = dado
        @proximo = nil
      end
    end
  
    def initialize
      @cabeca = nil
      @cauda = nil
      @tamanho = 0
    end
  
    # Verificar se a fila está vazia
    def empty?
      @tamanho == 0
    end
  
    # Adicionar elementos à fila (enqueue)
    def enqueue(dado)
      novo_nodo = Nodo.new(dado)
      if empty?
        @cabeca = novo_nodo
        @cauda = novo_nodo
      else
        @cauda.proximo = novo_nodo
        @cauda = novo_nodo
      end
      @tamanho += 1
    end
  
    # Remover o elemento da frente da fila (dequeue)
    def dequeue
      if empty?
        raise "A fila está vazia"
      end
  
      dado_removido = @cabeca.dado
      @cabeca = @cabeca.proximo
      @tamanho -= 1
  
      if empty?
        @cauda = nil
      end
  
      dado_removido
    end
  
    # Obter o tamanho atual da fila
    def size
      @tamanho
    end
  
    # Acessar o elemento da frente da fila sem removê-lo
    def front
      if empty?
        raise "A fila está vazia"
      end
  
      @cabeca.dado
    end
  
    # Mostrar elementos da fila
    def show_queue
      atual = @cabeca
      while atual
        print atual.dado.to_s + " "
        atual = atual.proximo
      end
      puts
    end
end
  
# Exemplo de uso
fila = FilaDinamica.new
fila.enqueue(1)
fila.enqueue(2)
fila.enqueue(3)

fila.show_queue

puts "Frente da fila: #{fila.front}"
puts "Tamanho da fila: #{fila.size}"

fila.dequeue
fila.show_queue
  