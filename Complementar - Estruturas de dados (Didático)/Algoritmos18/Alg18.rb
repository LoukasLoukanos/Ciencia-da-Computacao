=begin
♦ Algoritmo 18: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Bucket Sort (Ordenação por Balde).
=end

def bucket_sort(arr)
    n = arr.length
  
    # Crie um array de baldes como uma matriz
    buckets = Array.new(n) { [] }
  
    # Coloque os elementos nos baldes
    for i in 0..n-1 do
      bucket_index = (n * arr[i]).to_i
      buckets[bucket_index] << arr[i]
    end
  
    # Ordene os baldes e combine-os de volta no array original
    for i in 0..n-1 do
      buckets[i].sort!
    end

    index = 0
    for i in 0..n-1 do
      for j in 0..buckets[i].length-1 do
        arr[index] = buckets[i][j]
        index += 1
      end
    end
end
  
def print_array(arr)
  n = arr.length
  for i in 0..n-1 do
    print "#{arr[i]} "
  end
  puts
end

arr = [0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51]
puts "Array original:"
print_array(arr)

bucket_sort(arr)

puts "Array ordenado:"
print_array(arr)
  