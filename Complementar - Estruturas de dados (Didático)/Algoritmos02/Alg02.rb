=begin
Estrutura de dados linear de uma fila (de regra de acesso FIFO) circular/não-circular estática genérica utilizando um array unidimensional (vetor)

→ Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços 
  livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.

→ Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços 
  livres, caso haja, no início da fila.

Métodos:
 isEmpty - verificar se a fila está vazia; 
 isFull - verificar se a fila está cheia;
 enqueue - adicionar elementos;
 dequeue - remover o elemento da frente da fila;
 size - obter o tamanho atual da fila;
 front - acessar o elemento da frente da fila sem removê-lo;
 showQueue - mostar elementos da fila.
*/
=end

class Alg02
    def initialize(capacidade)
      @capacidade = capacidade
      @elementos = Array.new(capacidade)
      @tamanho = 0
      @inicio = 0
      @fim = -1
    end
  
    def isEmpty()
      @tamanho == 0
    end
  
    def isFull()
      @tamanho == @capacidade
    end
  
    def enqueue(elemento)
      if isFull()
        puts "A fila está cheia. Não é possível adicionar mais elementos."
        return
      end
  
      @fim = (@fim + 1) % @capacidade
      @elementos[@fim] = elemento
      @tamanho += 1
    end
  
    def dequeue()
      if isEmpty()
        puts "A fila está vazia. Não é possível remover elementos."
        return nil
      end
  
      elementoRemovido = @elementos[@inicio]
      @elementos[@inicio] = nil
      @inicio = (@inicio + 1) % @capacidade
      @tamanho -= 1
      return elementoRemovido
    end
  
    def front()
      if isEmpty()
        puts "A fila está vazia. Não há elementos para retornar."
        return nil
      end
  
      return @elementos[@inicio]
    end
  
    def size()
      return @tamanho
    end
  
    def showQueue()
      if isEmpty()
        puts "A fila está vazia."
        return
      end
      puts "Elementos da fila:"
      for i in 0..@tamanho
        puts @elementos[i]
      end
    end
  end
  
  fila = Alg02.new(5)
  fila.enqueue(10)
  fila.enqueue(20)
  fila.enqueue(30)
  puts "Tamanho da fila: #{fila.size()}"
  puts "Elemento na frente da fila: #{fila.front()}"
  puts "Removendo elemento da fila: #{fila.dequeue()}"
  puts "Tamanho da fila após remoção: #{fila.size()}"
  
  fila.showQueue()
  