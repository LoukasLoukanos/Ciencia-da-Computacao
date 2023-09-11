/*
♦ Implementação de um array unidimensional (vetor) de tipo genérico (considerando uma estrutura de dados que armazena, a princípio, dados primitivos desde que sejam do mesmo tipo — estrutura homogênea — ): Algoritmo 01.
*/

class Alg01 {
    constructor(tamanho) {
        this.elementos = new Array(tamanho);
        this.tamanho = tamanho;
        this.tamanhoAtual = 0;
        const readline = require('readline');
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });

        rl.question('Tamanho: ', (tamanhoInput) => {
            this.tamanho = parseInt(tamanhoInput);
            if (this.tamanho > 0) {
                rl.question('Tipo de dados: digite "p" para primitivos ou "np" para não primitivos: ', (tipo_de_dado) => {
                    if (tipo_de_dado === "p") {
                        rl.question('Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ', (tipo) => {
                            if (["byte", "short", "int", "long", "float", "double", "char", "boolean"].includes(tipo)) {
                                console.log(`Vetor do tipo de dados ${tipo} de ${this.tamanho} células alocadas.`);
                                rl.close();
                            } else {
                                console.log('Tipo de dado inválido!');
                                rl.close();
                            }
                        });
                    } else if (tipo_de_dado === "np") {
                        this.elementos = new Array(this.tamanho);
                        console.log(`Vetor do tipo de dados String de ${this.tamanho} células alocadas.`);
                        rl.close();
                    } else {
                        console.log('Tipo de dado inválido!');
                        rl.close();
                    }
                });
            } else {
                console.log('O tamanho do vetor precisa ser maior que zero!');
                rl.close();
            }
        });
    }

    isEmpty() {
        return this.tamanhoAtual === 0;
    }

    isFull() {
        return this.tamanhoAtual === this.tamanho;
    }

    addElement(indice, valor) {
        if (indice < 0 || indice >= this.tamanho) {
            throw new Error('Índice fora dos limites do vetor.');
        }

        if (this.isFull()) {
            throw new Error('O vetor está cheio.');
        }

        this.elementos[indice] = valor;
        this.tamanhoAtual++;
    }

    removeElement(indice) {
        if (indice < 0 || indice >= this.tamanho) {
            throw new Error('Índice fora dos limites do vetor.');
        }

        if (this.isEmpty()) {
            throw new Error('O vetor está vazio.');
        }

        this.elementos[indice] = null;
        this.tamanhoAtual--;
    }

    sizeArray() {
        return this.tamanhoAtual;
    }

    accessElement(indice) {
        if (indice < 0 || indice >= this.tamanho) {
            throw new Error('Índice fora dos limites do vetor.');
        }

        if (this.isEmpty()) {
            throw new Error('O vetor está vazio.');
        }

        return this.elementos[indice];
    }

    showQueue() {
        console.log('Elementos do vetor: ' + this.elementos.join(' '));
    }
}

const vetorInt = new Alg01(10);

// Verificar se o vetor está vazio
console.log('O vetor está vazio? ' + vetorInt.isEmpty());

// Adicionar elementos
vetorInt.addElement(0, 10);
vetorInt.addElement(1, 20);
vetorInt.addElement(2, 30);

// Verificar o tamanho atual do vetor
console.log('Tamanho atual do vetor: ' + vetorInt.sizeArray());

// Acessar um elemento
console.log('Elemento no índice 1: ' + vetorInt.accessElement(1));

// Remover um elemento
vetorInt.removeElement(1);

// Verificar se o vetor está vazio novamente
console.log('O vetor está vazio? ' + vetorInt.isEmpty());

// Verificar se o vetor está cheio
console.log('O vetor está cheio? ' + vetorInt.isFull());

// Mostrar todos os elementos
vetorInt.showQueue();
