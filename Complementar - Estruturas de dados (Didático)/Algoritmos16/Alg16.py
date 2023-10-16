'''
♦ Algoritmo 16: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Insertion Sort (Ordenação por Inserção).
'''

def insertionSort(arr):
    n = len(arr)
    for i in range(1, n):
        key = arr[i]
        j = i - 1
        
        # Move os elementos do arr[0..i-1] que são maiores que a chave
        # para uma posição à frente de sua posição atual
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        
        arr[j + 1] = key

def printArray(arr):
    for i in arr:
        print(i, end=" ")
    print()

arr = [12, 11, 13, 5, 6]
print("Array original:")
printArray(arr)

insertionSort(arr)

print("Array ordenado:")
printArray(arr)
