=begin
♦ Estrutura de Dados Linear Estática (não Dinâmica) de Pilha (regra de acesso LIFO) de tipo de dados genérico: Algoritmo 03.
→ Operações:
    • isEmpty - verificar se a pilha está vazia;
    • isFull - verificar se a pilha está cheia;
    • push - inserir elementos no topo da pilha;
    • pop - remover elementos do dopo da pilha;
    • size - obter o tamanho atual da pilha;
    • front - acessar o elemento do topo da pilha sem removê-lo;
    • showStack - mostar elementos da pilha (do topo para base).
=end

class Pilha
  def initialize(capacidade)
    @capacidade = capacidade
    @elementos = Array.new(capacidade)
    @topo = -1
  end

  # Verificar se a pilha está vazia
  def isEmpty
    @topo == -1
  end

  # Verificar se a pilha está cheia
  def isFull
    @topo == @capacidade - 1
  end

  # Inserir elementos no topo da pilha
  def push(elemento)
    if isFull
      raise "A pilha está cheia"
    end

    @topo += 1
    @elementos[@topo] = elemento
  end

  # Remover elementos do topo da pilha
  def pop
    if isEmpty
      raise "A pilha está vazia"
    end

    elemento_removido = @elementos[@topo]
    @elementos[@topo] = nil
    @topo -= 1

    return elemento_removido
  end

  # Obter o tamanho atual da pilha
  def size
    @topo + 1
  end

  # Acessar o elemento do topo da pilha sem removê-lo
  def front
    if isEmpty
      raise "A pilha está vazia"
    end

    @elementos[@topo]
  end

  # Mostrar elementos da pilha (do topo para base)
  def showStack
    for i in @topo.downto(0)
      print "#{@elementos[i]} "
    end
    puts
  end
end

pilha = Pilha.new(5)
pilha.push(1)
pilha.push(2)
pilha.push(3)

pilha.showStack

puts "Topo da pilha: #{pilha.front}"
puts "Tamanho da pilha: #{pilha.size}"

pilha.pop
pilha.showStack
