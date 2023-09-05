/* Algoritmo da Estrutura de dados linear dinâmica (não estática) ListaDuplamenteLigada 
de Lista Duplamente Ligada, também conhecida como Lista Duplamente Encadeada */

class ListaDuplamenteLigada {
    constructor() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;

        // Classe interna Nodo
        class Nodo {
            constructor(dado) {
                this.dado = dado;
                this.proximo = null;
                this.anterior = null;
            }
        }

        this.Nodo = Nodo;
    }

    // Inserir um elemento no final da lista
    addList(dado) {
        const novoNodo = new this.Nodo(dado);
        if (!this.cabeca) {
            this.cabeca = novoNodo;
            this.cauda = novoNodo;
        } else {
            novoNodo.anterior = this.cauda;
            this.cauda.proximo = novoNodo;
            this.cauda = novoNodo;
        }
        this.tamanho++;
    }

    // Remover um elemento da lista
    removeList(dado) {
        let atual = this.cabeca;
        while (atual) {
            if (atual.dado === dado) {
                if (atual === this.cabeca) {
                    this.cabeca = atual.proximo;
                    if (this.cabeca) {
                        this.cabeca.anterior = null;
                    }
                } else if (atual === this.cauda) {
                    this.cauda = atual.anterior;
                    if (this.cauda) {
                        this.cauda.proximo = null;
                    }
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
                this.tamanho--;
                return;
            }
            atual = atual.proximo;
        }
    }

    // Exibir os elementos da lista
    showList() {
        let atual = this.cabeca;
        while (atual) {
            process.stdout.write(atual.dado + " ");
            atual = atual.proximo;
        }
        console.log();
    }
}

const lista = new ListaDuplamenteLigada();
lista.addList(1);
lista.addList(2);
lista.addList(3);
lista.showList();

lista.removeList(2);
lista.showList();
