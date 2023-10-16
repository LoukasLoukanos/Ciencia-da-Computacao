=begin
♦ Algoritmo 17: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação em tempo linear Counting Sort (Ordenação por Contagem).
=end

def counting_sort(arr)
    max = find_max_value(arr)
    min = find_min_value(arr)
  
    range = max - min + 1
    count_array = Array.new(range, 0)
    output_array = Array.new(arr.length)
  
    # Inicializa o array de contagem
    arr.each { |num| count_array[num - min] += 1 }
  
    # Atualiza o array de contagem para ter a soma acumulativa
    (1...range).each { |i| count_array[i] += count_array[i - 1] }
  
    # Constrói o array de saída
    (arr.length - 1).downto(0) do |i|
      output_array[count_array[arr[i] - min] - 1] = arr[i]
      count_array[arr[i] - min] -= 1
    end
  
    # Copia o array ordenado de volta para o array original
    arr.replace(output_array)
end
  
def find_max_value(arr)
  arr.max
end

def find_min_value(arr)
  arr.min
end

def print_array(arr)
  puts arr.join(' ')
end

arr = [4, 2, 2, 8, 3, 3, 1]
puts "Array original:"
print_array(arr)

counting_sort(arr)

puts "Array ordenado:"
print_array(arr)
