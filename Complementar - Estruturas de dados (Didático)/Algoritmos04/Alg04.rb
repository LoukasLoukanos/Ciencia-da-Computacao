=begin
 Estrutura de dados linear de Classificação/Ordenação estatica BubbleSort 
 ou Método BubbleSort (Iterativo): Ordenação pelo método de bolhas.
=end

def bubble_sort(array)
    n = array.length
    troca = false

    for i in 0..n-2
        troca = false

        for j in 0..n-i-2
            if array[j] > array[j + 1]
                # Troca os elementos
                array[j], array[j + 1] = array[j + 1], array[j]
                troca = true
            end
        end

        # Se não houve trocas na passagem atual, o array está ordenado
        break unless troca
    end
end

array = [64, 34, 25, 12, 22, 11, 90]

bubble_sort(array)

puts "Array ordenado:"
puts array.join(" ")
