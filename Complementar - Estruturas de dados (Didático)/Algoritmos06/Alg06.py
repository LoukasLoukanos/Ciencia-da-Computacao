'''
♦ Algoritmo 06: Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação Selection Sort (Ordenação pelo Método (Iterativo) de Seleção).
'''

def selectionSort(array):
    n = len(array)
    
    for i in range(n - 1):
        indiceMenor = i
        
        for j in range(i + 1, n):
            if array[j] < array[indiceMenor]:
                indiceMenor = j
        
        array[indiceMenor], array[i] = array[i], array[indiceMenor]

array = [64, 34, 25, 12, 22, 11, 90]

selectionSort(array)

print("Array ordenado:")
for element in array:
    print(element, end=" ")
