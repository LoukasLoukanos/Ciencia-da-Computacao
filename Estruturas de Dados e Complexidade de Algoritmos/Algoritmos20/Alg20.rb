=begin
♦ Algoritmo 20: Algoritmo de Pesquisa/Busca para a Estrutura de Dados Linear Dinâmica (não Estática) Lista Duplamente Ligada (ou Duplamente Encadeada): Busca em Lista Duplamente Ligada.
=end

class Node
    attr_accessor :value, :previous, :next
  
    def initialize(value)
      @value = value
      @previous = nil
      @next = nil
    end
  end
  
  class DoublyLinkedList
    def initialize
      @first = nil
    end
  
    def search_list(value)
      current_node = @first
      while current_node != nil
        return true if current_node.value == value
        current_node = current_node.next
      end
      false
    end
  
    def find_minimum
      return nil if @first.nil?
  
      current_node = @first
      min = current_node.value
  
      while current_node != nil
        min = current_node.value if current_node.value < min
        current_node = current_node.next
      end
  
      min
    end
  
    def find_maximum
      return nil if @first.nil?
  
      current_node = @first
      max = current_node.value
  
      while current_node != nil
        max = current_node.value if current_node.value > max
        current_node = current_node.next
      end
  
      max
    end
  
    def get_successor(value)
      current_node = @first
      while current_node != nil
        if current_node.value == value
          return current_node.next.value if current_node.next != nil
          break
        end
        current_node = current_node.next
      end
  
      nil
    end
  
    def get_predecessor(value)
      return nil if @first.nil? || @first.value == value
  
      current_node = @first
      while current_node != nil && current_node.next != nil
        if current_node.next.value == value
          return current_node.value
        end
        current_node = current_node.next
      end
  
      nil
    end
  end
  
  # Exemplo de uso:
  linked_list = DoublyLinkedList.new
  linked_list.search_list(10)
  linked_list.find_minimum
  linked_list.find_maximum
  linked_list.get_successor(10)
  linked_list.get_predecessor(10)
  