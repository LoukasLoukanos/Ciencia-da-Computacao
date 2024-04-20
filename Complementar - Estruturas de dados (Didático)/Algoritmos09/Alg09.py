''' 
♦ Algoritmo 09: Algoritmo de Pesquisa/Busca para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Busca Sequencial (sem a utilização de variável/sentinela).
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
