import array as arr

class Alg01:
    def __init__(self, elementos):
        self.elementos = elementos

        print("Tamanho: ")
        tamanho = int(input())
        assert tamanho > 0, "O tamanho do vetor precisa ser maior que zero!"

        print("Tipo de dados: digite 'p' para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' para não primitivos → [string] ...")
        tipo_de_dado = input()
        assert tipo_de_dado == "p" or tipo_de_dado == "np", "Aceita-se 'p' ou 'np' como parâmetro!"

        if tipo_de_dado == "p":
            print("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ")
            tipo = input()

            if tipo in ["byte", "short", "int", "long", "float", "double", "char", "boolean"]:
                try:
                    clazz = getattr(__import__("builtins"), tipo.capitalize())
                    self.elementos = arr.array(clazz, [0] * tamanho)
                    vetor = Alg01(self.elementos)
                    print(f"Vetor do tipo de dados {tipo} de {tamanho} células alocadas.")
                except AttributeError:
                    print("Tipo de dado inválido!")
            else:
                print("Tipo de dado inválido!")

        elif tipo_de_dado == "np":
            self.elementos = [None] * tamanho
            vetor = Alg01(self.elementos)
            print(f"Vetor do tipo de dados String de {tamanho} células alocadas.")
        else:
            print("Tipo de dado inválido!")

    def inserir(self, indice, valor):
        self.elementos[indice] = valor

    def valor(self, indice):
        return self.elementos[indice]

if __name__ == "__main__":
    # Código adicional, se necessário
    pass
