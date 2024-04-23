/*
♦ Algoritmo 34: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore AVL.
*/


class No {
    constructor(valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }
}

class ArvoreAVL {
    constructor() {
        this.raiz = null;
    }

    altura(no) {
        return no ? no.altura : 0;
    }

    balanceamento(no) {
        if (!no) return 0;
        return this.altura(no.esquerda) - this.altura(no.direita);
    }

    rotacaoDireita(y) {
        const x = y.esquerda;
        const T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(this.altura(y.esquerda), this.altura(y.direita)) + 1;
        x.altura = Math.max(this.altura(x.esquerda), this.altura(x.direita)) + 1;

        return x;
    }

    rotacaoEsquerda(x) {
        const y = x.direita;
        const T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(this.altura(x.esquerda), this.altura(x.direita)) + 1;
        y.altura = Math.max(this.altura(y.esquerda), this.altura(y.direita)) + 1;

        return y;
    }

    inserir(valor) {
        this.raiz = this.inserirRecursivo(this.raiz, valor);
    }

    inserirRecursivo(no, valor) {
        if (!no) return new No(valor);

        if (valor < no.valor)
            no.esquerda = this.inserirRecursivo(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = this.inserirRecursivo(no.direita, valor);
        else
            return no;

        no.altura = 1 + Math.max(this.altura(no.esquerda), this.altura(no.direita));

        const balanceamento = this.balanceamento(no);

        if (balanceamento > 1 && valor < no.esquerda.valor)
            return this.rotacaoDireita(no);

        if (balanceamento < -1 && valor > no.direita.valor)
            return this.rotacaoEsquerda(no);

        if (balanceamento > 1 && valor > no.esquerda.valor) {
            no.esquerda = this.rotacaoEsquerda(no.esquerda);
            return this.rotacaoDireita(no);
        }

        if (balanceamento < -1 && valor < no.direita.valor) {
            no.direita = this.rotacaoDireita(no.direita);
            return this.rotacaoEsquerda(no);
        }

        return no;
    }

    imprimirEmOrdemRecursivo(no) {
        if (no) {
            this.imprimirEmOrdemRecursivo(no.esquerda);
            console.log(no.valor + " ");
            this.imprimirEmOrdemRecursivo(no.direita);
        }
    }

    imprimirEmOrdem() {
        this.imprimirEmOrdemRecursivo(this.raiz);
    }
}

// Teste
const arvore = new ArvoreAVL();
arvore.inserir(10);
arvore.inserir(5);
arvore.inserir(20);
arvore.inserir(3);
arvore.inserir(8);
arvore.inserir(15);

console.log("Em Ordem:");
arvore.imprimirEmOrdem();
