/* Algoritmo da Estrutura de dados linear dinâmica (não estática) 
   Alg14 de Fila (regra de acesso FIFO) Dinâmica */

class Nodo {
    constructor(dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class FilaDinamica {
    constructor() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    // Verificar se a fila está vazia
    isEmpty() {
        return this.tamanho === 0;
    }

    // Adicionar elementos à fila (enqueue)
    enqueue(dado) {
        const novoNodo = new Nodo(dado);
        if (this.isEmpty()) {
            this.cabeca = novoNodo;
            this.cauda = novoNodo;
        } else {
            this.cauda.proximo = novoNodo;
            this.cauda = novoNodo;
        }
        this.tamanho++;
    }

    // Remover o elemento da frente da fila (dequeue)
    dequeue() {
        if (this.isEmpty()) {
            throw new Error("A fila está vazia");
        }

        const dadoRemovido = this.cabeca.dado;
        this.cabeca = this.cabeca.proximo;
        this.tamanho--;

        if (this.isEmpty()) {
            this.cauda = null;
        }

        return dadoRemovido;
    }

    // Obter o tamanho atual da fila
    size() {
        return this.tamanho;
    }

    // Acessar o elemento da frente da fila sem removê-lo
    front() {
        if (this.isEmpty()) {
            throw new Error("A fila está vazia");
        }

        return this.cabeca.dado;
    }

    // Mostrar elementos da fila
    showQueue() {
        let atual = this.cabeca;
        while (atual !== null) {
            process.stdout.write(atual.dado + " ");
            atual = atual.proximo;
        }
        console.log();
    }
}

const fila = new FilaDinamica();
fila.enqueue(1);
fila.enqueue(2);
fila.enqueue(3);

fila.showQueue();

console.log("Frente da fila: " + fila.front());
console.log("Tamanho da fila: " + fila.size());

fila.dequeue();
fila.showQueue();
