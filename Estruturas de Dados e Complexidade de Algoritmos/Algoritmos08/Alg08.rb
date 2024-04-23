=begin
♦ Algoritmo 08: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Merge Sort (Ordenação por Mistura/Mesclagem).
=end

def merge_sort(array)
  return array if array.length <= 1
  
  meio = array.length / 2
  metade_esquerda = array[0...meio]
  metade_direita = array[meio..-1]
  
  metade_esquerda = merge_sort(metade_esquerda)
  metade_direita = merge_sort(metade_direita)
  
  merge(metade_esquerda, metade_direita, array)
end

def merge(metade_esquerda, metade_direita, array)
  i = 0  # Índice para a metade esquerda
  j = 0  # Índice para a metade direita
  k = 0  # Índice para o array final
  
  while i < metade_esquerda.length && j < metade_direita.length
    if metade_esquerda[i] <= metade_direita[j]
      array[k] = metade_esquerda[i]
      i += 1
    else
      array[k] = metade_direita[j]
      j += 1
    end
    k += 1
  end
  
  while i < metade_esquerda.length
    array[k] = metade_esquerda[i]
    i += 1
    k += 1
  end
  
  while j < metade_direita.length
    array[k] = metade_direita[j]
    j += 1
    k += 1
  end
end

array = [64, 34, 25, 12, 22, 11, 90]
merge_sort(array)

puts "Array ordenado:"
puts array.join(" ")
