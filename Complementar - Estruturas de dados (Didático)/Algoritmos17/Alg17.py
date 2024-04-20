'''
♦ Algoritmo 17: Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Dinâmicas (não Estáticas): Counting Sort (Ordenação por Contagem).
'''

def counting_sort(arr):
    max_value = max(arr)
    min_value = min(arr)

    range_size = max_value - min_value + 1
    count_array = [0] * range_size
    output_array = [0] * len(arr)

    # Inicializa o array de contagem
    for num in arr:
        count_array[num - min_value] += 1

    # Atualiza o array de contagem para ter a soma acumulativa
    for i in range(1, range_size):
        count_array[i] += count_array[i - 1]

    # Constrói o array de saída
    for i in range(len(arr) - 1, -1, -1):
        output_array[count_array[arr[i] - min_value] - 1] = arr[i]
        count_array[arr[i] - min_value] -= 1

    # Copia o array ordenado de volta para o array original
    for i in range(len(arr)):
        arr[i] = output_array[i]

def print_array(arr):
    print(' '.join(map(str, arr)))

arr = [4, 2, 2, 8, 3, 3, 1]
print("Array original:")
print_array(arr)

counting_sort(arr)

print("Array ordenado:")
print_array(arr)
