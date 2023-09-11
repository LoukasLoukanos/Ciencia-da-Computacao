/*
♦ Algoritmo 15: Estrutura de Dados Linear Dinâmica (não Estática) de Pilha (regra de acesso LIFO) de tipo de dados genérico.
→ Operações:
    • isEmpty - verificar se a pilha está vazia;
    • push - inserir elementos no topo da pilha;
    • pop - remover elementos do dopo da pilha;
    • size - obter o tamanho atual da pilha;
    • front - acessar o elemento do topo da pilha sem removê-lo;
    • showStack - mostar elementos da pilha (do topo para base).
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
