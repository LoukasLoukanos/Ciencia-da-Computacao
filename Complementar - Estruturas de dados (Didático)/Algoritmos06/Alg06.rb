=begin
 Algoritmo da Estrutura de dados linear de Classificação/Ordenação estatica (não dinâmica)
 SelectionSort, também conhecida como Ordenação pelo Método (Iterativo) de Seleção
=end

def selection_sort(array)
    n = array.length
  
    for i in 0..n-2
      indice_menor = i
  
      for j in i+1..n-1
        if array[j] < array[indice_menor]
          indice_menor = j
        end
      end
  
      array[indice_menor], array[i] = array[i], array[indice_menor]
    end
  
    return array
  end
  
  array = [64, 34, 25, 12, 22, 11, 90]
  
  array_ordenado = selection_sort(array)
  
  puts "Array ordenado:"
  puts array_ordenado.join(" ")
  