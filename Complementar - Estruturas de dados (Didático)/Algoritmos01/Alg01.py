'''
♦ Implementação de um array unidimensional (vetor) de tipo genérico (considerando uma estrutura de dados que armazena, a princípio, dados primitivos desde que sejam do mesmo tipo — estrutura homogênea — ): Algoritmo 01.
'''

class Alg01:
    def __init__(self, tamanho):
        self.elementos = [None] * tamanho
        self.tamanho = tamanho
        self.tamanhoAtual = 0

        print("Tamanho: ")
        tamanho_input = int(input())
        if tamanho_input > 0:
            self.tamanho = tamanho_input
            print('Tipo de dados: digite "p" para primitivos ou "np" para não primitivos: ')
            tipo_de_dado = input().strip()
            if tipo_de_dado == "p":
                print('Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ')
                tipo = input().strip()
                if tipo in ["byte", "short", "int", "long", "float", "double", "char", "boolean"]:
                    self.elementos = [None] * tamanho
                    print(f"Vetor do tipo de dados {tipo} de {tamanho} células alocadas.")
                else:
                    print("Tipo de dado inválido!")
            elif tipo_de_dado == "np":
                self.elementos = [None] * tamanho
                print(f"Vetor do tipo de dados String de {tamanho} células alocadas.")
            else:
                print("Tipo de dado inválido!")
        else:
            print("O tamanho do vetor precisa ser maior que zero!")

    def is_empty(self):
        return self.tamanhoAtual == 0

    def is_full(self):
        return self.tamanhoAtual == self.tamanho

    def add_element(self, indice, valor):
        if indice < 0 or indice >= self.tamanho:
            raise ValueError("Índice fora dos limites do vetor.")

        if self.is_full():
            raise ValueError("O vetor está cheio.")

        self.elementos[indice] = valor
        self.tamanhoAtual += 1

    def remove_element(self, indice):
        if indice < 0 or indice >= self.tamanho:
            raise ValueError("Índice fora dos limites do vetor.")

        if self.is_empty():
            raise ValueError("O vetor está vazio.")

        self.elementos[indice] = None
        self.tamanhoAtual -= 1

    def size_array(self):
        return self.tamanhoAtual

    def access_element(self, indice):
        if indice < 0 or indice >= self.tamanho:
            raise ValueError("Índice fora dos limites do vetor.")

        if self.is_empty():
            raise ValueError("O vetor está vazio.")

        return self.elementos[indice]

    def show_queue(self):
        print("Elementos do vetor:", end=" ")
        for elemento in self.elementos:
            if elemento is not None:
                print(elemento, end=" ")
        print()

# Exemplo de criação de um vetor de inteiros
vetor_int = Alg01(10)

# Verificar se o vetor está vazio
print("O vetor está vazio?", "Sim" if vetor_int.is_empty() else "Não")

# Adicionar elementos
vetor_int.add_element(0, 10)
vetor_int.add_element(1, 20)
vetor_int.add_element(2, 30)

# Verificar o tamanho atual do vetor
print("Tamanho atual do vetor:", vetor_int.size_array())

# Acessar um elemento
print("Elemento no índice 1:", vetor_int.access_element(1))

# Remover um elemento
vetor_int.remove_element(1)

# Verificar se o vetor está vazio novamente
print("O vetor está vazio?", "Sim" if vetor_int.is_empty() else "Não")

# Verificar se o vetor está cheio
print("O vetor está cheio?", "Sim" if vetor_int.is_full() else "Não")

# Mostrar todos os elementos
vetor_int.show_queue()
