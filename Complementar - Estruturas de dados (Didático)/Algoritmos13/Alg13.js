/*
♦ Algoritmo 13: Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada de tipo de dados genérico.
→ Operações:
    • addList: inserção em uma Lista Duplamente Ligada;
    • removeList: remoção em uma Lista Duplamente Ligada;
    • size - obter o tamanho atual da Lista Duplamente Ligada;
    • showList: exibição dos elementos da Lista Duplamente Ligada.
*/

class Nodo {
    constructor(valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDuplamenteLigada {
    constructor() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    addList(valor) {
        const novoNodo = new Nodo(valor);
        if (this.primeiro === null) {
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        } else {
            novoNodo.anterior = this.ultimo;
            this.ultimo.proximo = novoNodo;
            this.ultimo = novoNodo;
        }
        this.tamanho++;
    }

    removeList(valor) {
        let nodoAtual = this.primeiro;
        while (nodoAtual !== null) {
            if (nodoAtual.valor === valor) {
                if (nodoAtual === this.primeiro) {
                    this.primeiro = nodoAtual.proximo;
                    if (this.primeiro !== null) {
                        this.primeiro.anterior = null;
                    }
                } else if (nodoAtual === this.ultimo) {
                    this.ultimo = nodoAtual.anterior;
                    if (this.ultimo !== null) {
                        this.ultimo.proximo = null;
                    }
                } else {
                    const anterior = nodoAtual.anterior;
                    const proximo = nodoAtual.proximo;
                    anterior.proximo = proximo;
                    proximo.anterior = anterior;
                }
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

const lista = new ListaDuplamenteLigada();
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
