/* Algoritmo da Estrutura de dados linear dinâmica (não estática) 
ListaLigada de Lista Ligada, também conhecida como Lista Encadeada */

class ListaLigada {
    constructor() {
        this.cabeca = null;

        class No {
            constructor(dado) {
                this.dado = dado;
                this.proximo = null;
            }
        }

        this.No = No;
    }

    // Adicionar um elemento no final da lista
    addList(dado) {
        const novoNo = new this.No(dado);
        if (this.cabeca === null) {
            this.cabeca = novoNo;
        } else {
            let atual = this.cabeca;
            while (atual.proximo !== null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    // Remover um elemento da lista
    removeList(dado) {
        if (this.cabeca === null) {
            return;
        }

        if (this.cabeca.dado === dado) {
            this.cabeca = this.cabeca.proximo;
            return;
        }

        let atual = this.cabeca;
        let anterior = null;
        while (atual !== null && atual.dado !== dado) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual === null) {
            return;
        }

        anterior.proximo = atual.proximo;
    }

    // Imprimir a lista
    showList() {
        let atual = this.cabeca;
        while (atual !== null) {
            console.log(atual.dado + " ");
            atual = atual.proximo;
        }
        console.log();
    }
}

const lista = new ListaLigada();
lista.addList(1);
lista.addList(2);
lista.addList(3);
lista.showList();

lista.removeList(2);
lista.showList();
