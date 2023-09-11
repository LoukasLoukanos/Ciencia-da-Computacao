=begin
♦ Algoritmo 15: Estrutura de Dados Linear Dinâmica (não Estática) de Pilha (regra de acesso LIFO) de tipo de dados genérico.
→ Operações:
    • isEmpty - verificar se a pilha está vazia;
    • push - inserir elementos no topo da pilha;
    • pop - remover elementos do dopo da pilha;
    • size - obter o tamanho atual da pilha;
    • front - acessar o elemento do topo da pilha sem removê-lo;
    • showStack - mostar elementos da pilha (do topo para base).
=end

class PilhaDinamica
  def initialize
    @pilha = []
  end

  def is_empty
    @pilha.empty?
  end

  def push(elemento)
    @pilha.unshift(elemento)
  end

  def pop
    if is_empty
      raise "A pilha está vazia"
    end
    @pilha.shift
  end

  def size
    @pilha.length
  end

  def front
    if is_empty
      raise "A pilha está vazia"
    end
    @pilha.first
  end

  def show_stack
    puts @pilha.join(" ")
  end
end

pilha = PilhaDinamica.new

pilha.push(1)
pilha.push(2)
pilha.push(3)

pilha.show_stack

puts "Tamanho da pilha: #{pilha.size}"
puts "Topo da pilha: #{pilha.front}"

pilha.pop
pilha.show_stack
