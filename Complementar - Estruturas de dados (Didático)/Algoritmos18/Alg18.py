'''
♦ Algoritmo 18: Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Bucket Sort (Ordenação por Balde).
'''

def bucketSort(arr):
    n = len(arr)
    
    # Crie uma lista de baldes
    buckets = [[] for _ in range(n)]

    # Coloque os elementos nos baldes
    for i in range(n):
        bucketIndex = int(n * arr[i])
        buckets[bucketIndex].append(arr[i])

    # Ordene os baldes e combine-os de volta no array original
    for i in range(n):
        buckets[i].sort()

    index = 0
    for i in range(n):
        for j in range(len(buckets[i])):
            arr[index] = buckets[i][j]
            index += 1

def printArray(arr):
    n = len(arr)
    for i in range(n):
        print(arr[i], end=" ")
    print()

arr = [0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51]
print("Array original:")
printArray(arr)

bucketSort(arr)

print("Array ordenado:")
printArray(arr)
