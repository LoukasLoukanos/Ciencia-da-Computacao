=begin
 Estrutura de dados linear de Classificação/Ordenação estatica 
 InsertionSort ou Método (Iterativo) de Ordenação por inserção
=end

def insertion_sort(array)
    n = array.length
    
    for i in 1..n-1
        chave = array[i]
        j = i - 1
        
        while j >= 0 && array[j] > chave
            array[j + 1] = array[j]
            j -= 1
        end
        
        array[j + 1] = chave
    end
end

array = [64, 34, 25, 12, 22, 11, 90]

insertion_sort(array)

puts "Array ordenado:"
puts array.join(" ")
