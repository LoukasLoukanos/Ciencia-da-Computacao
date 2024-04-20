/*
♦ Algoritmo 12: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada): Linked List (Lista Ligada).
*/

class Nodo {
    constructor(valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class ListaLigada {
    constructor() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    addList(valor) {
        const novoNodo = new Nodo(valor);
        novoNodo.proximo = this.primeiro;
        this.primeiro = novoNodo;
        this.tamanho++;
    }

    removeList(valor) {
        if (this.primeiro === null) {
            return;
        }

        if (this.primeiro.valor === valor) {
            this.primeiro = this.primeiro.proximo;
            this.tamanho--;
            return;
        }

        let nodoAtual = this.primeiro;
        while (nodoAtual.proximo !== null) {
            if (nodoAtual.proximo.valor === valor) {
                nodoAtual.proximo = nodoAtual.proximo.proximo;
                this.tamanho--;
                return;
            }
            nodoAtual = nodoAtual.proximo;
        }
    }

    size() {
        return this.tamanho;
    }

    showList() {
        let nodoAtual = this.primeiro;
        while (nodoAtual !== null) {
            console.log(nodoAtual.valor + " ");
            nodoAtual = nodoAtual.proximo;
        }
        console.log();
    }
}

const lista = new ListaLigada();
lista.addList(10);
lista.addList(20);
lista.addList(30);

console.log("Tamanho da lista: " + lista.size());
console.log("Elementos da lista: ");
lista.showList();

lista.removeList(20);

console.log("Tamanho da lista após remoção: " + lista.size());
console.log("Elementos da lista após remoção: ");
lista.showList();
