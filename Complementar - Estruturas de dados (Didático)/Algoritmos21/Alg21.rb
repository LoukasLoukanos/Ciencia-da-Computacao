=begin
♦ Algoritmo 21: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária - Busca Binária (Binary Search Tree - BST) de tipo de dados genérico.
→ Operações:
    • Inserção e Remoção de Elementos;
    • Busca (pesquisa) de Elementos;
    • Encontrar o Mínimo e o Máximo;
    • Travessias (in-order, pre-order, post-order);
    • Verificar se é uma BST válida.
=end

class BinarySearchTree
    class TreeNode
      attr_accessor :data, :left, :right
  
      def initialize(data)
        @data = data
        @left = nil
        @right = nil
      end
    end
  
    def initialize
      @root = nil
    end
  
    # Inserção de elementos
    def insert(data)
      @root = insert_rec(@root, data)
    end
  
    def insert_rec(root, data)
      if root.nil?
        return TreeNode.new(data)
      end
  
      if data < root.data
        root.left = insert_rec(root.left, data)
      elsif data > root.data
        root.right = insert_rec(root.right, data)
      end
  
      return root
    end
  
    # Remoção de elementos
    def delete(data)
      @root = delete_rec(@root, data)
    end
  
    def delete_rec(root, data)
      if root.nil?
        return root
      end
  
      if data < root.data
        root.left = delete_rec(root.left, data)
      elsif data > root.data
        root.right = delete_rec(root.right, data)
      else
        if root.left.nil?
          return root.right
        elsif root.right.nil?
          return root.left
        end
  
        root.data = min_value(root.right)
  
        root.right = delete_rec(root.right, root.data)
      end
  
      return root
    end
  
    def min_value(root)
      min_value = root.data
      while root.left
        min_value = root.left.data
        root = root.left
      end
      return min_value
    end
  
    # Busca de elementos
    def search(data)
      return search_rec(@root, data)
    end
  
    def search_rec(root, data)
      if root.nil?
        return false
      end
  
      if root.data == data
        return true
      end
  
      if data < root.data
        return search_rec(root.left, data)
      end
  
      return search_rec(root.right, data)
    end
  
    # Encontrar o Mínimo e o Máximo
    def find_min
      if @root.nil?
        return nil
      end
  
      current = @root
      while current.left
        current = current.left
      end
  
      return current.data
    end
  
    def find_max
      if @root.nil?
        return nil
      end
  
      current = @root
      while current.right
        current = current.right
      end
  
      return current.data
    end
  
    # Travessias (in-order, pre-order, post-order)
    def in_order
      in_order_rec(@root)
    end
  
    def in_order_rec(root)
      if root
        in_order_rec(root.left)
        print("#{root.data} ")
        in_order_rec(root.right)
      end
    end
  
    def pre_order
      pre_order_rec(@root)
    end
  
    def pre_order_rec(root)
      if root
        print("#{root.data} ")
        pre_order_rec(root.left)
        pre_order_rec(root.right)
      end
    end
  
    def post_order
      post_order_rec(@root)
    end
  
    def post_order_rec(root)
      if root
        post_order_rec(root.left)
        post_order_rec(root.right)
        print("#{root.data} ")
      end
    end
  
    # Verificar se é uma BST válida
    def is_valid_bst
      return is_valid_bst_rec(@root, nil, nil)
    end
  
    def is_valid_bst_rec(root, min, max)
      if root.nil?
        return true
      end
  
      if (min && root.data <= min) || (max && root.data >= max)
        return false
      end
  
      return is_valid_bst_rec(root.left, min, root.data) && is_valid_bst_rec(root.right, root.data, max)
    end
  end
  
  tree = BinarySearchTree.new
  tree.insert(50)
  tree.insert(30)
  tree.insert(20)
  tree.insert(40)
  tree.insert(70)
  tree.insert(60)
  tree.insert(80)
  
  puts "In-order traversal:"
  tree.in_order
  puts
  
  puts "Pre-order traversal:"
  tree.pre_order
  puts
  
  puts "Post-order traversal:"
  tree.post_order
  puts
  
  puts "Minimum value: #{tree.find_min}"
  puts "Maximum value: #{tree.find_max}"
  
  search_value = 40
  puts "Search for #{search_value}: #{tree.search(search_value)}"
  
  tree.delete(search_value)
  puts "After deleting #{search_value}:"
  tree.in_order
  
  puts "\nIs valid BST? #{tree.is_valid_bst}"
  