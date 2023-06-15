=begin
Estrutura de dados linear de uma pilha (de regra de acesso LIFO) estática genérica utilizando um array unidimensional (vetor)

Métodos:
 isEmpty - verificar se a pilha está vazia; 
 isFull - verificar se a pilha está cheia;
 push - inserir elementos no topo da pilha;
 pop - remover elementos do dopo da pilha;
 size - obter o tamanho atual da pilha;
 front - acessar o elemento do topo da pilha sem removê-lo;
 showStack - mostar elementos da pilha (do topo para base).
=end

class Alg03
    def initialize(tamanhoMaximo)
      @tamanhoMaximo = tamanhoMaximo
      @topo = -1
      @elementos = Array.new(tamanhoMaximo)
    end
  
    def isEmpty()
      @topo == -1
    end
  
    def isFull()
      @topo == @tamanhoMaximo - 1
    end
  
    def push(elemento)
      if isFull()
        puts "A pilha está cheia. Não é possível empilhar o elemento."
        return
      end
      @topo += 1
      @elementos[@topo] = elemento
    end
  
    def pop()
      if isEmpty()
        puts "A pilha está vazia. Não é possível desempilhar um elemento."
        return nil
      end
      elemento = @elementos[@topo]
      @topo -= 1
      return elemento
    end
  
    def front()
      if isEmpty()
        puts "A pilha está vazia. Não há elemento no topo."
        return nil
      end
      return @elementos[@topo]
    end
  
    def size()
      return @topo + 1
    end
  
    def showStack()
      if isEmpty()
        puts "A pilha está vazia."
        return
      end
      puts "Elementos da pilha (do topo para base):"
      for i in @topo.downto(0)
        puts @elementos[i]
      end
    end
  end
  
  pilha = Alg03.new(5)
  
  pilha.push(10)
  pilha.push(20)
  pilha.push(30)
  
  puts "Tamanho da pilha: #{pilha.size()}"
  puts "Elemento no topo: #{pilha.front()}"
  
  pilha.pop()
  
  puts "Tamanho da pilha: #{pilha.size()}"
  puts "Elemento no topo: #{pilha.front()}"
  
  pilha.showStack()
  