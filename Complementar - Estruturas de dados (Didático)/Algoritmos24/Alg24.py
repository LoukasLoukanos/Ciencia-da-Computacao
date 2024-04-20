'''
♦ Algoritmo 24: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Não-Binária: Árvore B.
'''


class ArvoreB:
    ORDEM = 3  # Ordem da árvore B

    class No:
        def __init__(self, folha):
            self.chaves = []
            self.filhos = []
            self.folha = folha

    def __init__(self):
        self.raiz = self.No(True)

    def inserir(self, chave):
        self.inserir_na_arvore(self.raiz, chave)

    def inserir_na_arvore(self, no, chave):
        if len(no.chaves) == self.ORDEM - 1:
            novo_no = self.No(False)
            novo_no.filhos.append(no)
            self.dividir_no(novo_no, 0, no)
            i = 0
            if novo_no.chaves[0] < chave:
                i += 1
            self.inserir_em_no_nao_cheio(novo_no.filhos[i], chave)
            self.raiz = novo_no
        else:
            self.inserir_em_no_nao_cheio(no, chave)

    def inserir_em_no_nao_cheio(self, no, chave):
        i = len(no.chaves) - 1
        if no.folha:
            no.chaves.append(chave)
            while i >= 0 and no.chaves[i] > chave:
                no.chaves[i + 1] = no.chaves[i]
                i -= 1
            no.chaves[i + 1] = chave
        else:
            while i >= 0 and no.chaves[i] > chave:
                i -= 1
            i += 1
            if len(no.filhos[i].chaves) == self.ORDEM - 1:
                self.dividir_no(no, i, no.filhos[i])
                if no.chaves[i] < chave:
                    i += 1
            self.inserir_em_no_nao_cheio(no.filhos[i], chave)

    def dividir_no(self, pai, indice_filho, filho):
        novo_no = self.No(filho.folha)
        for _ in range(self.ORDEM // 2 - 1):
            novo_no.chaves.append(filho.chaves.pop(self.ORDEM // 2))
        if not filho.folha:
            for _ in range(self.ORDEM // 2):
                novo_no.filhos.append(filho.filhos.pop(self.ORDEM // 2))
        pai.chaves.insert(indice_filho, filho.chaves[self.ORDEM // 2 - 1])
        pai.filhos.insert(indice_filho + 1, novo_no)

    def remover(self, chave):
        self.remover_na_arvore(self.raiz, chave)

    def remover_na_arvore(self, no, chave):
        # Implemente a remoção aqui
        pass

    def fundir_nos(self, pai, indice_filho):
        # Implemente a fusão de nós aqui
        pass

    # Outros métodos necessários


# Teste
arvore = ArvoreB()  # Exemplo de ordem 3
arvore.inserir(10)
arvore.inserir(20)
arvore.inserir(5)
arvore.inserir(15)
arvore.inserir(25)
arvore.remover(15)  # Exemplo de remoção
# Imprimir árvore ou realizar outras operações para testar
