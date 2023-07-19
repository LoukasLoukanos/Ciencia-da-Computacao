''' 
 Algoritmo da Estrutura de dados linear estática (não dinâmica) de Pesquisa/Busca 
 buscaSequencial para pesquisa sequencial sem a utilização de sentinela
'''

def busca_sequencial(array, valor_procurado):
    for i in range(len(array)):
        if array[i] == valor_procurado:
            return i  # Retorna o índice do valor procurado
    return -1  # Retorna -1 se o valor não foi encontrado

array = [10, 5, 2, 8, 3, 7, 1, 6, 9, 4]
valor_procurado = 7

indice_encontrado = busca_sequencial(array, valor_procurado)

if indice_encontrado != -1:
    print(f"Valor {valor_procurado} encontrado no índice: {indice_encontrado}")
else:
    print(f"Valor {valor_procurado} não encontrado no array.")
