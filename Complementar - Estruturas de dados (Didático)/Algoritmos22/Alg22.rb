=begin
♦ Algoritmo 22: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária: Árvore AVL.
=end

class Node
    attr_accessor :data, :left, :right, :height
  
    def initialize(data)
      @data = data
      @left = nil
      @right = nil
      @height = 1
    end
end
  
class AVLTree
    def initialize
      @root = nil
    end
  
    def height(node)
      return 0 if node.nil?
  
      node.height
    end
  
    def balance_factor(node)
      return 0 if node.nil?
  
      height(node.left) - height(node.right)
    end
  
    def rotate_right(y)
      x = y.left
      t2 = x.right
  
      x.right = y
      y.left = t2
  
      y.height = [height(y.left), height(y.right)].max + 1
      x.height = [height(x.left), height(x.right)].max + 1
  
      x
    end
  
    def rotate_left(x)
      y = x.right
      t2 = y.left
  
      y.left = x
      x.right = t2
  
      x.height = [height(x.left), height(x.right)].max + 1
      y.height = [height(y.left), height(y.right)].max + 1
  
      y
    end
  
    def insert(data)
      @root = insert_node(@root, data)
    end
  
    def insert_node(node, data)
      return Node.new(data) if node.nil?
  
      if data < node.data
        node.left = insert_node(node.left, data)
      elsif data > node.data
        node.right = insert_node(node.right, data)
      else
        return node # Duplicatas não são permitidas
      end
  
      node.height = [height(node.left), height(node.right)].max
  
      balance = balance_factor(node)
  
      # Casos de desequilíbrio
      if balance > 1
        if data < node.left.data
          # Rotação simples à direita
          return rotate_right(node)
        else
          # Rotação dupla à esquerda-direita
          node.left = rotate_left(node.left)
          return rotate_right(node)
        end
      end
  
      if balance < -1
        if data > node.right.data
          # Rotação simples à esquerda
          return rotate_left(node)
        else
          # Rotação dupla à direita-esquerda
          node.right = rotate_right(node.right)
          return rotate_left(node)
        end
      end
  
      node
    end
  
    def remove(data)
      @root = remove_node(@root, data)
    end
  
    def remove_node(node, data)
      return node if node.nil?
  
      if data < node.data
        node.left = remove_node(node.left, data)
      elsif data > node.data
        node.right = remove_node(node.right, data)
      else
        if node.left.nil? || node.right.nil?
          temp = node.left.nil? ? node.right : node.left
  
          return temp.nil? ? node : temp
        else
          temp = find_min(node.right)
          node.data = temp.data
          node.right = remove_node(node.right, temp.data)
        end
      end
  
      return node if node.nil?
  
      node.height = [height(node.left), height(node.right)].max
  
      balance = balance_factor(node)
  
      # Casos de desequilíbrio
      if balance > 1
        if balance_factor(node.left) >= 0
          # Rotação simples à direita
          return rotate_right(node)
        else
          # Rotação dupla à esquerda-direita
          node.left = rotate_left(node.left)
          return rotate_right(node)
        end
      end
  
      if balance < -1
        if balance_factor(node.right) <= 0
          # Rotação simples à esquerda
          return rotate_left(node)
        else
          # Rotação dupla à direita-esquerda
          node.right = rotate_right(node.right)
          return rotate_left(node)
        end
      end
  
      node
    end
  
    def find_min(node)
      while node.left
        node = node.left
      end
      node
    end
  
    def inorder
      inorder_traversal(@root)
      puts
    end
  
    def inorder_traversal(node)
      return if node.nil?
  
      inorder_traversal(node.left)
      print "#{node.data} "
      inorder_traversal(node.right)
    end
end
  
if __FILE__ == $PROGRAM_NAME
    tree = AVLTree.new
  
    tree.insert(10)
    tree.insert(20)
    tree.insert(30)
    tree.insert(40)
    tree.insert(50)
  
    puts "Árvore AVL In-Order:"
    tree.inorder
  
    tree.remove(30)
    tree.remove(40)
  
    puts "Árvore AVL In-Order após a remoção de 30 e 40:"
    tree.inorder
end
  