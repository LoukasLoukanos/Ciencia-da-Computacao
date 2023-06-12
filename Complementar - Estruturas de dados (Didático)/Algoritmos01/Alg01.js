class Alg01 {
    constructor() {
        this.elementos = [];
        this.sc = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
        });

        this.sc.question('Tamanho: ', (tamanho) => {
            assert(tamanho > 0, 'O tamanho do Vetor precisa ser maior que zero!');
    
            this.sc.question("Tipo de dados: digite 'p' para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' para não primitivos → [string] ...", (tipo_de_dado) => {
                assert(tipo_de_dado === 'p' || tipo_de_dado === 'np', "Aceita-se 'p' ou 'np' como parâmetro!");
    
                if (tipo_de_dado === 'p') {
                    this.sc.question("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ", (tipo) => {
                        if (['byte', 'short', 'int', 'long', 'float', 'double', 'char', 'boolean'].includes(tipo)) {
                            try {
                                const clazz = eval('java.lang.' + tipo.charAt(0).toUpperCase() + tipo.slice(1));
                                this.elementos = Array(tamanho).fill(clazz);
                                const vetor = new Alg01(this.elementos);
                                console.log(`Vetor do tipo de dados ${tipo} de ${tamanho} células alocadas.`);
                                this.sc.close();
                            } catch (e) {
                                console.log('Tipo de dado inválido!');
                            }
                        } else {
                            console.log('Tipo de dado inválido!');
                        }
                    });
                } else if (tipo_de_dado === 'np') {
                    this.elementos = Array(tamanho).fill('');
                    const vetor = new Alg01(this.elementos);
                    console.log(`Vetor do tipo de dados String de ${tamanho} células alocadas.`);
                    this.sc.close();
                } else {
                    console.log('Tipo de dado inválido!');
                }
            });
        });
    }

    inserir(indice, valor) {
        this.elementos[indice] = valor;
    }

    valor(indice) {
        return this.elementos[indice];
    }
}

// Código adicional, se necessário
