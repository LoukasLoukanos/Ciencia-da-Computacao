/*
♦ Algoritmo 03: Estrutura de Dados Linear Estática (não Dinâmica) de Pilha: Stack (Pilha).
*/

class Pilha {
    constructor(capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Array(capacidade);
        this.topo = -1;
    }

    // Verificar se a pilha está vazia
    isEmpty() {
        return this.topo === -1;
    }

    // Verificar se a pilha está cheia
    isFull() {
        return this.topo === this.capacidade - 1;
    }

    // Inserir elementos no topo da pilha
    push(elemento) {
        if (this.isFull()) {
            throw new Error("A pilha está cheia");
        }

        this.topo++;
        this.elementos[this.topo] = elemento;
    }

    // Remover elementos do topo da pilha
    pop() {
        if (this.isEmpty()) {
            throw new Error("A pilha está vazia");
        }

        const elementoRemovido = this.elementos[this.topo];
        this.elementos[this.topo] = null;
        this.topo--;

        return elementoRemovido;
    }

    // Obter o tamanho atual da pilha
    size() {
        return this.topo + 1;
    }

    // Acessar o elemento do topo da pilha sem removê-lo
    front() {
        if (this.isEmpty()) {
            throw new Error("A pilha está vazia");
        }

        return this.elementos[this.topo];
    }

    // Mostrar elementos da pilha (do topo para base)
    showStack() {
        for (let i = this.topo; i >= 0; i--) {
            console.log(this.elementos[i]);
        }
    }
}

const pilha = new Pilha(5);
pilha.push(1);
pilha.push(2);
pilha.push(3);

pilha.showStack();

console.log("Topo da pilha: " + pilha.front());
console.log("Tamanho da pilha: " + pilha.size());

pilha.pop();
pilha.showStack();
