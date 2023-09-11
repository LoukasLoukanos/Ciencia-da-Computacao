=begin
♦ Algoritmo 14: Estrutura de Dados Linear Dinâmica (não Estática) de Fila (regra de acesso FIFO) de tipo de dados genérico.
→ Operações:
    • isEmpty - verificar se a fila está vazia;
    • enqueue - adicionar elementos;
    • dequeue - remover o elemento da frente da fila;
    • size - obter o tamanho atual da fila;
    • front - acessar o elemento da frente da fila sem removê-lo;
    • showQueue - mostar elementos da fila.
=end

class FilaDinamica
  def initialize
    @fila = []
  end

  def empty?
    @fila.empty?
  end

  def enqueue(elemento)
    @fila.push(elemento)
  end

  def dequeue
    if empty?
      raise "A fila está vazia"
    end
    @fila.shift
  end

  def size
    @fila.size
  end

  def front
    if empty?
      raise "A fila está vazia"
    end
    @fila.first
  end

  def show_queue
    puts @fila.join(" ")
  end
end

fila = FilaDinamica.new

fila.enqueue(1)
fila.enqueue(2)
fila.enqueue(3)

fila.show_queue

puts "Tamanho da fila: #{fila.size}"
puts "Frente da fila: #{fila.front}"

fila.dequeue
fila.show_queue
