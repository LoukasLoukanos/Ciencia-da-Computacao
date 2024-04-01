/*
♦ Algoritmo 25: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Não-Binária - Árvore B+.
→ Operações:
    • Inserção de Elementos;
    • Remoção de Elementos;
    • Divisão de Nós;
    • Fusão de Nós.
*/


#include <iostream>
#include <vector>

template <typename T>
class ArvoreBmais {
private:
    static const int ORDEM = 3;

    struct No {
        std::vector<T> chaves;
        std::vector<No*> filhos;
        bool folha;

        No(bool folha) : folha(folha) {}
    };

    No* raiz;

    void inserirNaArvore(No* no, T chave) {
        if (no->chaves.size() == ORDEM - 1) {
            No* novoNo = new No(false);
            novoNo->filhos.push_back(no);
            dividirNo(novoNo, 0, no);
            int i = 0;
            if (novoNo->chaves[0] < chave) {
                i++;
            }
            inserirEmNoNaoCheio(novoNo->filhos[i], chave);
            raiz = novoNo;
        } else {
            inserirEmNoNaoCheio(no, chave);
        }
    }

    void inserirEmNoNaoCheio(No* no, T chave) {
        int i = no->chaves.size() - 1;
        if (no->folha) {
            no->chaves.push_back(chave);
            while (i >= 0 && no->chaves[i] > chave) {
                no->chaves[i + 1] = no->chaves[i];
                i--;
            }
            no->chaves[i + 1] = chave;
        } else {
            while (i >= 0 && no->chaves[i] > chave) {
                i--;
            }
            i++;
            if (no->filhos[i]->chaves.size() == ORDEM - 1) {
                dividirNo(no, i, no->filhos[i]);
                if (no->chaves[i] < chave) {
                    i++;
                }
            }
            inserirEmNoNaoCheio(no->filhos[i], chave);
        }
    }

    void dividirNo(No* pai, int indiceFilho, No* filho) {
        No* novoNo = new No(filho->folha);
        for (int j = 0; j < ORDEM / 2 - 1; j++) {
            novoNo->chaves.push_back(filho->chaves[ORDEM / 2]);
            filho->chaves.pop_back();
        }
        if (!filho->folha) {
            for (int j = 0; j < ORDEM / 2; j++) {
                novoNo->filhos.push_back(filho->filhos[ORDEM / 2]);
                filho->filhos.pop_back();
            }
        }
        pai->chaves.insert(pai->chaves.begin() + indiceFilho, filho->chaves[ORDEM / 2 - 1]);
        pai->filhos.insert(pai->filhos.begin() + indiceFilho + 1, novoNo);
    }

    void removerNaArvore(No* no, T chave) {
        // Implemente a remoção aqui
    }

    void fundirNos(No* pai, int indiceFilho) {
        // Implemente a fusão de nós aqui
    }

public:
    ArvoreBmais() {
        raiz = new No(true);
    }

    void inserir(T chave) {
        inserirNaArvore(raiz, chave);
    }

    void remover(T chave) {
        removerNaArvore(raiz, chave);
    }

    // Outros métodos necessários

    ~ArvoreBmais() {
        // Implemente a deleção dos nós
    }
};

int main() {
    ArvoreBmais<int> arvore;
    arvore.inserir(10);
    arvore.inserir(20);
    arvore.inserir(5);
    arvore.inserir(15);
    arvore.inserir(25);
    arvore.remover(15); // Exemplo de remoção
    // Imprimir árvore ou realizar outras operações para testar

    return 0;
}
