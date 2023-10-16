/*
♦ Algoritmo 19: Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 12: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada) de tipo de dados genérico].
→ Operações:
    • Busca de um valor em uma Lista Ligada Simples;
    • Identificar o menor valor em uma Lista Ligada Simples;
    • Identificar o maior valor em uma Lista Ligada Simples;
    • Retornar o sucessor de um valor em uma Lista Ligada Simples;
    • Retornar o predecessor de um valor em uma Lista Ligada Simples.
*/

class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    insert(value) {
        const newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    remove(value) {
        if (this.head === null) {
            return;
        }

        if (this.head.value === value) {
            this.head = this.head.next;
            this.size--;
            return;
        }

        let current = this.head;
        let prev = null;

        while (current !== null) {
            if (current.value === value) {
                prev.next = current.next;
                this.size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    getSize() {
        return this.size;
    }

    display() {
        let current = this.head;
        while (current !== null) {
            process.stdout.write(current.value + " ");
            current = current.next;
        }
        console.log();
    }

    search(value) {
        let current = this.head;
        while (current !== null) {
            if (current.value === value) {
                return true; // Valor encontrado
            }
            current = current.next;
        }
        return false; // Valor não encontrado
    }

    findMinimum() {
        if (this.head === null) {
            return null;
        }

        let current = this.head;
        let min = current.value;

        while (current !== null) {
            if (current.value < min) {
                min = current.value;
            }
            current = current.next;
        }
        return min;
    }

    findMaximum() {
        if (this.head === null) {
            return null;
        }

        let current = this.head;
        let max = current.value;

        while (current !== null) {
            if (current.value > max) {
                max = current.value;
            }
            current = current.next;
        }
        return max;
    }

    getSuccessor(value) {
        let current = this.head;
        while (current !== null) {
            if (current.value === value) {
                if (current.next !== null) {
                    return current.next.value;
                }
                break; // Último elemento, não há sucessor
            }
            current = current.next;
        }
        return null; // Valor não encontrado ou é o último
    }

    getPredecessor(value) {
        if (this.head === null || this.head.value === value) {
            return null; // Valor não encontrado ou é o primeiro
        }

        let current = this.head;
        while (current !== null && current.next !== null) {
            if (current.next.value === value) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Valor não encontrado
    }
}

const list = new LinkedList();
list.insert(10);
list.insert(20);
list.insert(30);

console.log("Tamanho da lista: " + list.getSize());
process.stdout.write("Elementos da lista: ");
list.display();

console.log("Buscar 20: " + list.search(20));
console.log("Menor valor: " + list.findMinimum());
console.log("Maior valor: " + list.findMaximum());
console.log("Sucessor de 20: " + list.getSuccessor(20));
console.log("Predecessor de 20: " + list.getPredecessor(20));

list.remove(20);

console.log("Tamanho da lista após remoção: " + list.getSize());
process.stdout.write("Elementos da lista após remoção: ");
list.display();
