=begin
 Algoritmo da Estrutura de dados linear de Classificação/Ordenação estática (não dinâmica) de divisão e 
 conquista QuickSort, também conhecida como Ordenação pelo Método (Recursivo) Rápido 
=end

def trocar(array, indice1, indice2)
    temp = array[indice1]
    array[indice1] = array[indice2]
    array[indice2] = temp
end

def partition(array, inicio, fim)
    pivo = array[fim]
    i = inicio - 1

    for j in inicio...fim
        if array[j] < pivo
            i += 1
            trocar(array, i, j)
        end
    end

    trocar(array, i + 1, fim)
    return i + 1
end

def quicksort(array, inicio, fim)
    if inicio < fim
        indicePivo = partition(array, inicio, fim)
        quicksort(array, inicio, indicePivo - 1)
        quicksort(array, indicePivo + 1, fim)
    end
end

array = [64, 34, 25, 12, 22, 11, 90]
n = array.length

quicksort(array, 0, n - 1)

puts "Array ordenado:"
puts array.join(" ")
