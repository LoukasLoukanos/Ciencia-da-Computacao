/* Algoritmo da Estrutura de dados linear estática (não dinâmica) genérica de 
 uma pilha (de regra de acesso LIFO) utilizando um array unidimensional (vetor)
 
Métodos:
 isEmpty - verificar se a pilha está vazia; 
 isFull - verificar se a pilha está cheia;
 push - inserir elementos no topo da pilha;
 pop - remover elementos do dopo da pilha;
 size - obter o tamanho atual da pilha;
 front - acessar o elemento do topo da pilha sem removê-lo;
 showStack - mostar elementos da pilha (do topo para base).
*/

class Alg03 {
    constructor(tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.topo = -1;
        this.elementos = new Array(tamanhoMaximo);
    }

    isEmpty() {
        return this.topo === -1;
    }

    isFull() {
        return this.topo === this.tamanhoMaximo - 1;
    }

    push(elemento) {
        if (this.isFull()) {
            console.log("A pilha está cheia. Não é possível empilhar o elemento.");
            return;
        }
        this.topo++;
        this.elementos[this.topo] = elemento;
    }

    pop() {
        if (this.isEmpty()) {
            console.log("A pilha está vazia. Não é possível desempilhar um elemento.");
            return null;
        }
        const elemento = this.elementos[this.topo];
        this.topo--;
        return elemento;
    }

    front() {
        if (this.isEmpty()) {
            console.log("A pilha está vazia. Não há elemento no topo.");
            return null;
        }
        return this.elementos[this.topo];
    }

    size() {
        return this.topo + 1;
    }

    showStack() {
        if (this.isEmpty()) {
            console.log("A pilha está vazia.");
            return;
        }
        console.log("Elementos da pilha (do topo para base):");
        for (let i = this.topo; i >= 0; i--) {
            console.log(this.elementos[i]);
        }
    }
}

const pilha = new Alg03(5);

pilha.push(10);
pilha.push(20);
pilha.push(30);

console.log("Tamanho da pilha: " + pilha.size());
console.log("Elemento no topo: " + pilha.front());

pilha.pop();

console.log("Tamanho da pilha: " + pilha.size());
console.log("Elemento no topo: " + pilha.front());

pilha.showStack();
