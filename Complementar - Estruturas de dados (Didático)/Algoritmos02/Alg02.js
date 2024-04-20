/*
♦ Algoritmo 02: Estrutura de Dados Linear Estática de Fila Circular e Não-Circular: Queue (Fila).

obs: Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços 
    livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.

obs: Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços 
    livres, caso haja, no início da fila.
*/

class FilaCircular {
    constructor(capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Array(capacidade);
        this.tamanho = 0;
        this.frente = 0;
        this.traseira = -1;
    }

    // Verificar se a fila está vazia
    isEmpty() {
        return this.tamanho === 0;
    }

    // Verificar se a fila está cheia
    isFull() {
        return this.tamanho === this.capacidade;
    }

    // Adicionar elementos à fila (enqueue)
    enqueue(elemento) {
        if (this.isFull()) {
            throw new Error("A fila está cheia");
        }

        this.traseira = (this.traseira + 1) % this.capacidade;
        this.elementos[this.traseira] = elemento;
        this.tamanho++;
    }

    // Remover o elemento da frente da fila (dequeue)
    dequeue() {
        if (this.isEmpty()) {
            throw new Error("A fila está vazia");
        }

        const elementoRemovido = this.elementos[this.frente];
        this.elementos[this.frente] = null;
        this.frente = (this.frente + 1) % this.capacidade;
        this.tamanho--;

        return elementoRemovido;
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

        return this.elementos[this.frente];
    }

    // Mostrar elementos da fila
    showQueue() {
        let index = this.frente;
        for (let i = 0; i < this.tamanho; i++) {
            console.log(this.elementos[index] + " ");
            index = (index + 1) % this.capacidade;
        }
        console.log();
    }
}

const fila = new FilaCircular(5);
fila.enqueue(1);
fila.enqueue(2);
fila.enqueue(3);

fila.showQueue();

console.log("Frente da fila: " + fila.front());
console.log("Tamanho da fila: " + fila.size());

fila.dequeue();
fila.showQueue();
