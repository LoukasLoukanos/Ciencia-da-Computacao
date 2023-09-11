'''
♦ Algoritmo 08: Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação de Divisão e Conquista Merge Sort (Ordenação pelo Método (Recursivo) de Mistura/Mesclagem).
'''

def mergeSort(array):
    if len(array) <= 1:
        return array
    
    meio = len(array) // 2
    metadeEsquerda = array[:meio]
    metadeDireita = array[meio:]
    
    metadeEsquerda = mergeSort(metadeEsquerda)
    metadeDireita = mergeSort(metadeDireita)
    
    return merge(metadeEsquerda, metadeDireita)

def merge(metadeEsquerda, metadeDireita):
    array = []
    i = 0  # Índice para a metade esquerda
    j = 0  # Índice para a metade direita
    
    while i < len(metadeEsquerda) and j < len(metadeDireita):
        if metadeEsquerda[i] <= metadeDireita[j]:
            array.append(metadeEsquerda[i])
            i += 1
        else:
            array.append(metadeDireita[j])
            j += 1
    
    while i < len(metadeEsquerda):
        array.append(metadeEsquerda[i])
        i += 1
    
    while j < len(metadeDireita):
        array.append(metadeDireita[j])
        j += 1
    
    return array

array = [64, 34, 25, 12, 22, 11, 90]
sortedArray = mergeSort(array)

print("Array ordenado:")
print(*sortedArray)
