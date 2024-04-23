/*
♦ Algoritmo 33: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).
*/


class No {
    constructor(valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinaria {
    constructor() {
        this.raiz = null;
    }

    inserir(valor) {
        this.raiz = this.inserirRecursivo(this.raiz, valor);
    }

    inserirRecursivo(no, valor) {
        if (no === null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = this.inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = this.inserirRecursivo(no.direita, valor);
        }

        return no;
    }

    buscar(valor) {
        return this.buscarRecursivo(this.raiz, valor);
    }

    buscarRecursivo(no, valor) {
        if (no === null) {
            return false;
        }

        if (valor === no.valor) {
            return true;
        }

        return valor < no.valor ? this.buscarRecursivo(no.esquerda, valor) : this.buscarRecursivo(no.direita, valor);
    }

    imprimirEmOrdem() {
        this.imprimirEmOrdemRecursivo(this.raiz);
    }

    imprimirEmOrdemRecursivo(no) {
        if (no !== null) {
            this.imprimirEmOrdemRecursivo(no.esquerda);
            console.log(no.valor);
            this.imprimirEmOrdemRecursivo(no.direita);
        }
    }
}

const arvore = new ArvoreBinaria();
arvore.inserir(10);
arvore.inserir(5);
arvore.inserir(20);
arvore.inserir(3);
arvore.inserir(8);
arvore.inserir(15);

console.log("Em Ordem:");
arvore.imprimirEmOrdem();

console.log("\nBuscar 8: " + arvore.buscar(8));
console.log("Buscar 12: " + arvore.buscar(12));
