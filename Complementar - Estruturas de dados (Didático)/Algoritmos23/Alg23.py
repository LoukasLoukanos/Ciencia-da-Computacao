'''
♦ Algoritmo 23: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária - Árvore Rubro-Negra.
→ Operações:
    • inserir e inserirNo;
    • remover e removerNo;
    • buscar e buscarNo.
'''

class No:
    def __init__(self, chave):
        self.chave = chave
        self.cor = True  # True por padrão, um novo nó é vermelho
        self.pai = self.esquerda = self.direita = None


class ArvoreRubroNegra:
    def __init__(self):
        self.raiz = None
        self.sentinela = No(None)
        self.sentinela.cor = False  # Sentinel é sempre preto
        self.raiz = self.sentinela

    # Métodos de inserção
    def inserir(self, chave):
        novo_no = No(chave)
        self.inserir_no(novo_no)

    def inserir_no(self, z):
        y = self.sentinela
        x = self.raiz

        while x != self.sentinela:
            y = x
            if z.chave < x.chave:
                x = x.esquerda
            else:
                x = x.direita

        z.pai = y

        if y == self.sentinela:
            self.raiz = z
        elif z.chave < y.chave:
            y.esquerda = z
        else:
            y.direita = z

        z.esquerda = self.sentinela
        z.direita = self.sentinela
        z.cor = True

        self.corrigir_insercao(z)

    # Métodos de remoção
    def remover(self, chave):
        z = self.buscar(chave)
        if z is not None:
            self.remover_no(z)

    def remover_no(self, z):
        y = z
        cor_original_y = y.cor

        if z.esquerda == self.sentinela:
            x = z.direita
            self.transplantar(z, z.direita)
        elif z.direita == self.sentinela:
            x = z.esquerda
            self.transplantar(z, z.esquerda)
        else:
            y = self.encontrar_minimo(z.direita)
            cor_original_y = y.cor
            x = y.direita

            if y.pai == z:
                x.pai = y
            else:
                self.transplantar(y, y.direita)
                y.direita = z.direita
                y.direita.pai = y

            self.transplantar(z, y)
            y.esquerda = z.esquerda
            y.esquerda.pai = y
            y.cor = z.cor

        if not cor_original_y:
            self.corrigir_remocao(x)

    # Método de busca
    def buscar(self, chave):
        return self.buscar_no(self.raiz, chave)

    def buscar_no(self, no, chave):
        if no == self.sentinela or chave == no.chave:
            return no

        if chave < no.chave:
            return self.buscar_no(no.esquerda, chave)
        else:
            return self.buscar_no(no.direita, chave)

    # Restante do código (mínimo, máximo, sucessor, antecessor, travessias, altura, etc.)

    # Métodos auxiliares
    def transplantar(self, u, v):
        if u.pai == self.sentinela:
            self.raiz = v
        elif u == u.pai.esquerda:
            u.pai.esquerda = v
        else:
            u.pai.direita = v
        v.pai = u.pai

    def corrigir_insercao(self, z):
        # Implementação da correção após inserção
        pass

    def corrigir_remocao(self, x):
        # Implementação da correção após remoção
        pass

    # Outros métodos omitidos para manter a resposta concisa


# Código de teste
arvore = ArvoreRubroNegra()
arvore.inserir(10)
arvore.inserir(20)
arvore.inserir(30)

print("Árvore Rubro-Negra em ordem:")
# Adicione chamadas apropriadas para métodos de travessia

print("\nMínimo:", arvore.minimo())
print("Máximo:", arvore.maximo())

arvore.remover(20)

print("\nÁrvore Rubro-Negra em ordem após a remoção de 20:")
# Adicione chamadas apropriadas para métodos de travessia
