'''
♦ Algoritmo 07: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Quick Sort (Ordenação Rápida).
'''

def trocar(array, indice1, indice2):
    temp = array[indice1]
    array[indice1] = array[indice2]
    array[indice2] = temp

def partition(array, inicio, fim):
    pivo = array[fim]
    i = inicio - 1
    
    for j in range(inicio, fim):
        if array[j] < pivo:
            i += 1
            trocar(array, i, j)
    
    trocar(array, i + 1, fim)
    return i + 1

def quicksort(array, inicio, fim):
    if inicio < fim:
        indicePivo = partition(array, inicio, fim)
        quicksort(array, inicio, indicePivo - 1)
        quicksort(array, indicePivo + 1, fim)

array = [64, 34, 25, 12, 22, 11, 90]
n = len(array)

quicksort(array, 0, n - 1)

print("Array ordenado:")
for i in range(n):
    print(array[i], end=" ")
