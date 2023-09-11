'''
♦ Algoritmo 10: Estrutura de Dados Linear Estática (não Dinâmica) de Pesquisa/Busca Busca Sequencial com Sentinela.
'''

def busca_sequencial_com_sentinela(array, valor_procurado):
    tamanho_array = len(array)

    # Adiciona o valor procurado como sentinela na última posição do array
    valor_anterior = array[tamanho_array - 1]
    array[tamanho_array - 1] = valor_procurado

    i = 0
    # Percorre o array até encontrar o valor procurado ou a sentinela
    while array[i] != valor_procurado:
        i += 1

    # Restaura o valor anterior da última posição do array
    array[tamanho_array - 1] = valor_anterior

    if i < tamanho_array - 1 or array[tamanho_array - 1] == valor_procurado:
        return i  # Retorna o índice do valor procurado
    else:
        return -1  # Retorna -1 se o valor não foi encontrado


array = [10, 5, 2, 8, 3, 7, 1, 6, 9, 4]
valor_procurado = 7

indice_encontrado = busca_sequencial_com_sentinela(array, valor_procurado)

if indice_encontrado != -1:
    print(f"Valor {valor_procurado} encontrado no índice: {indice_encontrado}")
else:
    print(f"Valor {valor_procurado} não encontrado no array.")
