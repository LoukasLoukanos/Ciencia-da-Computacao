=begin
♦ Algoritmo 15: Estrutura de Dados Linear Dinâmica (não Estática) de Pilha: Stack (Pilha).
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
