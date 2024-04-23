/*
♦ Algoritmo 14: Estrutura de Dados Linear Dinâmica (não Estática) de Fila: Queue (Fila).
*/

class FilaDinamica {
    constructor() {
        this.fila = [];
    }

    isEmpty() {
        return this.fila.length === 0;
    }

    enqueue(elemento) {
        this.fila.push(elemento);
    }

    dequeue() {
        if (this.isEmpty()) {
            throw new Error("A fila está vazia");
        }
        this.fila.shift();
    }

    size() {
        return this.fila.length;
    }

    front() {
        if (this.isEmpty()) {
            throw new Error("A fila está vazia");
        }
        return this.fila[0];
    }

    showQueue() {
        console.log(this.fila.join(' '));
    }
}

const fila = new FilaDinamica();

fila.enqueue(1);
fila.enqueue(2);
fila.enqueue(3);

fila.showQueue();

console.log("Tamanho da fila: " + fila.size());
console.log("Frente da fila: " + fila.front());

fila.dequeue();
fila.showQueue();
