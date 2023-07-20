'''
 Algoritmo da Estrutura de dados linear estática (não dinâmica)
 de Pesquisa/Busca buscaBinaria para realização de busca binária
'''

def busca_binaria(array, valor_procurado):
    inicio = 0
    fim = len(array) - 1

    while inicio <= fim:
        meio = inicio + (fim - inicio) // 2

        if array[meio] == valor_procurado:
            return meio  # Retorna o índice do valor procurado
        elif array[meio] < valor_procurado:
            inicio = meio + 1
        else:
            fim = meio - 1

    return -1  # Retorna -1 se o valor não foi encontrado


array = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
valor_procurado = 11

indice_encontrado = busca_binaria(array, valor_procurado)

if indice_encontrado != -1:
    print(f"Valor {valor_procurado} encontrado no índice: {indice_encontrado}")
else:
    print(f"Valor {valor_procurado} não encontrado no array.")
