/*
♦ Algoritmo 15: Estrutura de Dados Linear Dinâmica (não Estática) de Pilha: Stack (Pilha).
*/

class PilhaDinamica {
    constructor() {
        this.pilha = [];
    }

    isEmpty() {
        return this.pilha.length === 0;
    }

    push(elemento) {
        this.pilha.unshift(elemento);
    }

    pop() {
        if (this.isEmpty()) {
            throw new Error("A pilha está vazia");
        }
        this.pilha.shift();
    }

    size() {
        return this.pilha.length;
    }

    front() {
        if (this.isEmpty()) {
            throw new Error("A pilha está vazia");
        }
        return this.pilha[0];
    }

    showStack() {
        console.log(this.pilha.join(' '));
    }
}

const pilha = new PilhaDinamica();

pilha.push(1);
pilha.push(2);
pilha.push(3);

pilha.showStack();

console.log("Tamanho da pilha: " + pilha.size());
console.log("Topo da pilha: " + pilha.front());

pilha.pop();
pilha.showStack();
