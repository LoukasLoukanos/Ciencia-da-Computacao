'''
♦ Algoritmo 04: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Bubble Sort (Ordanação por Bolhas).
'''

def bubbleSort(array):
    n = len(array)
    
    for i in range(n - 1):
        troca = False
        
        for j in range(n - i - 1):
            if array[j] > array[j + 1]:
                # Troca os elementos
                array[j], array[j + 1] = array[j + 1], array[j]
                troca = True
        
        # Se não houve trocas na passagem atual, a lista está ordenada
        if not troca:
            break

array = [64, 34, 25, 12, 22, 11, 90]

bubbleSort(array)

print("Lista ordenada:")
for elemento in array:
    print(elemento, end=" ")
