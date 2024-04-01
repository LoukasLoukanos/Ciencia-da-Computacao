/*
♦ Algoritmo 25: Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Não-Binária - Árvore B+.
→ Operações:
    • Inserção de Elementos;
    • Remoção de Elementos;
    • Divisão de Nós;
    • Fusão de Nós.
*/

class ArvoreBmais {
    constructor() {
        this.ORDEM = 3;
        this.raiz = new No(true);
    }

    inserir(chave) {
        this.inserirNaArvore(this.raiz, chave);
    }

    inserirNaArvore(no, chave) {
        if (no.chaves.length === this.ORDEM - 1) {
            const novoNo = new No(false);
            novoNo.filhos.push(no);
            this.dividirNo(novoNo, 0, no);
            let i = 0;
            if (novoNo.chaves[0] < chave) {
                i++;
            }
            this.inserirEmNoNaoCheio(novoNo.filhos[i], chave);
            this.raiz = novoNo;
        } else {
            this.inserirEmNoNaoCheio(no, chave);
        }
    }

    inserirEmNoNaoCheio(no, chave) {
        let i = no.chaves.length - 1;
        if (no.folha) {
            no.chaves.push(chave);
            while (i >= 0 && no.chaves[i] > chave) {
                no.chaves[i + 1] = no.chaves[i];
                i--;
            }
            no.chaves[i + 1] = chave;
        } else {
            while (i >= 0 && no.chaves[i] > chave) {
                i--;
            }
            i++;
            if (no.filhos[i].chaves.length === this.ORDEM - 1) {
                this.dividirNo(no, i, no.filhos[i]);
                if (no.chaves[i] < chave) {
                    i++;
                }
            }
            this.inserirEmNoNaoCheio(no.filhos[i], chave);
        }
    }

    dividirNo(pai, indiceFilho, filho) {
        const novoNo = new No(filho.folha);
        for (let j = 0; j < this.ORDEM / 2 - 1; j++) {
            novoNo.chaves.push(filho.chaves[this.ORDEM / 2]);
            filho.chaves.splice(this.ORDEM / 2, 1);
        }
        if (!filho.folha) {
            for (let j = 0; j < this.ORDEM / 2; j++) {
                novoNo.filhos.push(filho.filhos[this.ORDEM / 2]);
                filho.filhos.splice(this.ORDEM / 2, 1);
            }
        }
        pai.chaves.splice(indiceFilho, 0, filho.chaves[this.ORDEM / 2 - 1]);
        pai.filhos.splice(indiceFilho + 1, 0, novoNo);
    }

    remover(chave) {
        this.removerNaArvore(this.raiz, chave);
    }

    removerNaArvore(no, chave) {
        // Implemente a remoção aqui
    }

    fundirNos(pai, indiceFilho) {
        // Implemente a fusão de nós aqui
    }
}

class No {
    constructor(folha) {
        this.chaves = [];
        this.filhos = [];
        this.folha = folha;
    }
}

// Exemplo de uso
const arvore = new ArvoreBmais(); // Exemplo de ordem 3
arvore.inserir(10);
arvore.inserir(20);
arvore.inserir(5);
arvore.inserir(15);
arvore.inserir(25);
arvore.remover(15); // Exemplo de remoção
// Imprimir árvore ou realizar outras operações para testar
