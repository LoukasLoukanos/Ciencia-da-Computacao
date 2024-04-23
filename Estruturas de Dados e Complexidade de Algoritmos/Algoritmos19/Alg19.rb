=begin
♦ Algoritmo 19: Algoritmo de Pesquisa/Busca para a Estrutura de Dados Linear Dinâmica (não Estática) Lista Ligada (ou Encadeada) Simples: Busca em Lista Ligada.
=end

class Node
    attr_accessor :value, :next
  
    def initialize(value)
      @value = value
      @next = nil
    end
  end
  
  class LinkedList
    def initialize
      @head = nil
      @size = 0
    end
  
    def insert(value)
      new_node = Node.new(value)
      new_node.next = @head
      @head = new_node
      @size += 1
    end
  
    def remove(value)
      return if @head.nil?
  
      if @head.value == value
        @head = @head.next
        @size -= 1
        return
      end
  
      current = @head
      prev = nil
  
      while !current.nil?
        if current.value == value
          prev.next = current.next
          @size -= 1
          return
        end
        prev = current
        current = current.next
      end
    end
  
    def size
      @size
    end
  
    def display
      current = @head
      while !current.nil?
        print current.value.to_s + " "
        current = current.next
      end
      puts
    end
  
    def search(value)
      current = @head
      while !current.nil?
        return true if current.value == value
        current = current.next
      end
      false
    end
  
    def find_minimum
      return nil if @head.nil?
  
      current = @head
      min = current.value
  
      while !current.nil?
        min = current.value if current.value < min
        current = current.next
      end
      min
    end
  
    def find_maximum
      return nil if @head.nil?
  
      current = @head
      max = current.value
  
      while !current.nil?
        max = current.value if current.value > max
        current = current.next
      end
      max
    end
  
    def get_successor(value)
      current = @head
      while !current.nil?
        if current.value == value
          return current.next.value unless current.next.nil?
          break
        end
        current = current.next
      end
      nil
    end
  
    def get_predecessor(value)
      return nil if @head.nil? || @head.value == value
  
      current = @head
      while !current.nil? && !current.next.nil?
        return current.value if current.next.value == value
        current = current.next
      end
      nil
    end
end
  
# Exemplo de uso
list = LinkedList.new
list.insert(10)
list.insert(20)
list.insert(30)

puts "Tamanho da lista: #{list.size}"
print "Elementos da lista: "
list.display

puts "Buscar 20: #{list.search(20)}"
puts "Menor valor: #{list.find_minimum}"
puts "Maior valor: #{list.find_maximum}"
puts "Sucessor de 20: #{list.get_successor(20)}"
puts "Predecessor de 20: #{list.get_predecessor(20)}"

list.remove(20)

puts "Tamanho da lista após remoção: #{list.size}"
print "Elementos da lista após remoção: "
list.display
  