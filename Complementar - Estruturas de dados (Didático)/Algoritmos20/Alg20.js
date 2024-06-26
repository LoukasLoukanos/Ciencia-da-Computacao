/*
♦ Algoritmo 20: Algoritmo de Pesquisa/Busca para a Estrutura de Dados Linear Dinâmica (não Estática) Lista Duplamente Ligada (ou Duplamente Encadeada): Busca em Lista Duplamente Ligada.
*/

class Node {
    constructor(value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    constructor() {
        this.first = null;
    }

    searchList(value) {
        let currentNode = this.first;
        while (currentNode !== null) {
            if (currentNode.value === value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    findMinimum() {
        if (this.first === null) {
            return null;
        }

        let currentNode = this.first;
        let min = currentNode.value;

        while (currentNode !== null) {
            if (currentNode.value < min) {
                min = currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return min;
    }

    findMaximum() {
        if (this.first === null) {
            return null;
        }

        let currentNode = this.first;
        let max = currentNode.value;

        while (currentNode !== null) {
            if (currentNode.value > max) {
                max = currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return max;
    }

    getSuccessor(value) {
        let currentNode = this.first;
        while (currentNode !== null) {
            if (currentNode.value === value) {
                if (currentNode.next !== null) {
                    return currentNode.next.value;
                }
                break;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    getPredecessor(value) {
        if (this.first === null || this.first.value === value) {
            return null;
        }

        let currentNode = this.first;
        while (currentNode !== null && currentNode.next !== null) {
            if (currentNode.next.value === value) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
}

// Exemplo de uso:
const list = new DoublyLinkedList();
list.searchList(10);
list.findMinimum();
list.findMaximum();
list.getSuccessor(10);
list.getPredecessor(10);
