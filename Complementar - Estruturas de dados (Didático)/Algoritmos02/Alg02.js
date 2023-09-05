/* Estrutura de dados linear de uma fila (de regra de acesso FIFO) circular/não-circular 
  estática genérica utilizando um array unidimensional (vetor)

→ Em uma fila circular é necessário administrar os elementos na fila em relação à exclusão de espaços 
  livres do início, para obter, de forma circular, mais espaços no fim, para adição de novos elementos.

→ Para implementar uma fila não-circular, basta apenas deixar a fila encher sem utilizar os espaços 
  livres, caso haja, no início da fila.

Métodos:
 isEmpty - verificar se a fila está vazia; 
 isFull - verificar se a fila está cheia;
 enqueue - adicionar elementos;
 dequeue - remover o elemento da frente da fila;
 size - obter o tamanho atual da fila;
 front - acessar o elemento da frente da fila sem removê-lo;
 showQueue - mostar elementos da fila.
*/

class Alg02 {
    constructor(capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Array(capacidade);
        this.tamanho = 0;
        this.inicio = 0;
        this.fim = -1;
    }

    isEmpty() {
        return this.tamanho === 0;
    }

    isFull() {
        return this.tamanho === this.capacidade;
    }

    enqueue(elemento) {
        if (this.isFull()) {
            console.log("A fila está cheia. Não é possível adicionar mais elementos.");
            return;
        }

        this.fim = (this.fim + 1) % this.capacidade;
        this.elementos[this.fim] = elemento;
        this.tamanho++;
    }

    dequeue() {
        if (this.isEmpty()) {
            console.log("A fila está vazia. Não é possível remover elementos.");
            return null;
        }

        const elementoRemovido = this.elementos[this.inicio];
        this.elementos[this.inicio] = null;
        this.inicio = (this.inicio + 1) % this.capacidade;
        this.tamanho--;
        return elementoRemovido;
    }

    front() {
        if (this.isEmpty()) {
            console.log("A fila está vazia. Não há elementos para retornar.");
            return null;
        }

        return this.elementos[this.inicio];
    }

    size() {
        return this.tamanho;
    }

    showQueue() {
        if (this.isEmpty()) {
            console.log("A fila está vazia.");
            return;
        }
        console.log("Elementos da fila:");
        for (let i = 0; i < this.tamanho; i++) {
            console.log(this.elementos[i]);
        }
    }
}

const fila = new Alg02(5);
fila.enqueue(10);
fila.enqueue(20);
fila.enqueue(30);
console.log("Tamanho da fila: " + fila.size());
console.log("Elemento na frente da fila: " + fila.front());
console.log("Removendo elemento da fila: " + fila.dequeue());
console.log("Tamanho da fila após remoção: " + fila.size());

fila.showQueue();
