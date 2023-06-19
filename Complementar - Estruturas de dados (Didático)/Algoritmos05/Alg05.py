'''
 Estrutura de dados linear de Classificação/Ordenação estatica 
 InsertionSort ou Método (Iterativo) de Ordenação por inserção
'''

def insertionSort(array):
    n = len(array)
    
    for i in range(1, n):
        chave = array[i]
        j = i - 1
        
        while j >= 0 and array[j] > chave:
            array[j + 1] = array[j]
            j -= 1
        
        array[j + 1] = chave

array = [64, 34, 25, 12, 22, 11, 90]

insertionSort(array)

print("Array ordenado:")
for elemento in array:
    print(elemento, end=" ")
