=begin 
♦ Algoritmo 02: Estrutura de Dados Linear Estática de Fila Circular e Não-Circular: Queue (Fila).

obs: Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços 
    livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.

obs: Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços 
    livres, caso haja, no início da fila.
=end

class FilaCircular
  def initialize(capacidade)
    @capacidade = capacidade
    @elementos = Array.new(capacidade)
    @tamanho = 0
    @frente = 0
    @traseira = -1
  end

  # Verificar se a fila está vazia
  def is_empty?
    @tamanho == 0
  end

  # Verificar se a fila está cheia
  def is_full?
    @tamanho == @capacidade
  end

  # Adicionar elementos à fila (enqueue)
  def enqueue(elemento)
    if is_full?
      raise "A fila está cheia"
    end

    @traseira = (@traseira + 1) % @capacidade
    @elementos[@traseira] = elemento
    @tamanho += 1
  end

  # Remover o elemento da frente da fila (dequeue)
  def dequeue
    if is_empty?
      raise "A fila está vazia"
    end

    elemento_removido = @elementos[@frente]
    @elementos[@frente] = nil
    @frente = (@frente + 1) % @capacidade
    @tamanho -= 1

    elemento_removido
  end

  # Obter o tamanho atual da fila
  def size
    @tamanho
  end

  # Acessar o elemento da frente da fila sem removê-lo
  def front
    if is_empty?
      raise "A fila está vazia"
    end

    @elementos[@frente]
  end

  # Mostrar elementos da fila
  def show_queue
    index = @frente
    @tamanho.times do
      print "#{@elementos[index]} "
      index = (index + 1) % @capacidade
    end
    puts
  end
end

# Exemplo de uso
fila = FilaCircular.new(5)
fila.enqueue(1)
fila.enqueue(2)
fila.enqueue(3)

fila.show_queue

puts "Frente da fila: #{fila.front}"
puts "Tamanho da fila: #{fila.size}"

fila.dequeue
fila.show_queue
