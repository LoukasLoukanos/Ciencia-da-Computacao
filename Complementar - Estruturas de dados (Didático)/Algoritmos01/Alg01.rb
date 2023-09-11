=begin
♦ Implementação de um array unidimensional (vetor) de tipo genérico (considerando uma estrutura de dados que armazena, a princípio, dados primitivos desde que sejam do mesmo tipo — estrutura homogênea — ): Algoritmo 01.
=end

class Alg01
  def initialize(tamanho)
    @elementos = Array.new(tamanho)
    @tamanho = tamanho
    @tamanho_atual = 0

    print 'Tamanho: '
    tamanho_input = gets.chomp.to_i
    if tamanho_input > 0
      @tamanho = tamanho_input
      print 'Tipo de dados: digite "p" para primitivos ou "np" para não primitivos: '
      tipo_de_dado = gets.chomp.strip
      if tipo_de_dado == 'p'
        print 'Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): '
        tipo = gets.chomp.strip
        if %w[byte short int long float double char boolean].include?(tipo)
          @elementos = Array.new(@tamanho)
          puts "Vetor do tipo de dados #{tipo} de #{@tamanho} células alocadas."
        else
          puts 'Tipo de dado inválido!'
        end
      elsif tipo_de_dado == 'np'
        @elementos = Array.new(@tamanho)
        puts "Vetor do tipo de dados String de #{@tamanho} células alocadas."
      else
        puts 'Tipo de dado inválido!'
      end
    else
      puts 'O tamanho do vetor precisa ser maior que zero!'
    end
  end

  def is_empty
    @tamanho_atual == 0
  end

  def is_full
    @tamanho_atual == @tamanho
  end

  def add_element(indice, valor)
    if indice < 0 || indice >= @tamanho
      raise 'Índice fora dos limites do vetor.'
    end

    if is_full
      raise 'O vetor está cheio.'
    end

    @elementos[indice] = valor
    @tamanho_atual += 1
  end

  def remove_element(indice)
    if indice < 0 || indice >= @tamanho
      raise 'Índice fora dos limites do vetor.'
    end

    if is_empty
      raise 'O vetor está vazio.'
    end

    @elementos[indice] = nil
    @tamanho_atual -= 1
  end

  def size_array
    @tamanho_atual
  end

  def access_element(indice)
    if indice < 0 || indice >= @tamanho
      raise 'Índice fora dos limites do vetor.'
    end

    if is_empty
      raise 'O vetor está vazio.'
    end

    @elementos[indice]
  end

  def show_queue
    print 'Elementos do vetor: '
    @elementos.each do |elemento|
      print "#{elemento} " unless elemento.nil?
    end
    puts
  end
end

# Exemplo de criação de um vetor de inteiros
vetor_int = Alg01.new(10)

# Verificar se o vetor está vazio
puts 'O vetor está vazio?', vetor_int.is_empty ? 'Sim' : 'Não'

# Adicionar elementos
vetor_int.add_element(0, 10)
vetor_int.add_element(1, 20)
vetor_int.add_element(2, 30)

# Verificar o tamanho atual do vetor
puts 'Tamanho atual do vetor:', vetor_int.size_array

# Acessar um elemento
puts 'Elemento no índice 1:', vetor_int.access_element(1)

# Remover um elemento
vetor_int.remove_element(1)

# Verificar se o vetor está vazio novamente
puts 'O vetor está vazio?', vetor_int.is_empty ? 'Sim' : 'Não'

# Verificar se o vetor está cheio
puts 'O vetor está cheio?', vetor_int.is_full ? 'Sim' : 'Não'

# Mostrar todos os elementos
vetor_int.show_queue
