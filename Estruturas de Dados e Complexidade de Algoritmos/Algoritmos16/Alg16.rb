=begin
♦ Algoritmo 16: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Dinâmicas (não Estáticas): Insertion Sort (Ordenação por Inserção).
=end

def insertion_sort(arr)
    n = arr.length
    for i in 1..(n - 1)
      key = arr[i]
      j = i - 1
  
      # Move os elementos do arr[0..i-1] que são maiores que a chave
      # para uma posição à frente de sua posição atual
      while j >= 0 && arr[j] > key
        arr[j + 1] = arr[j]
        j -= 1
      end
  
      arr[j + 1] = key
    end
  end
  
  def print_array(arr)
    arr.each { |i| print i, " " }
    puts
  end
  
  arr = [12, 11, 13, 5, 6]
  puts "Array original:"
  print_array(arr)
  
  insertion_sort(arr)
  
  puts "Array ordenado:"
  print_array(arr)
  