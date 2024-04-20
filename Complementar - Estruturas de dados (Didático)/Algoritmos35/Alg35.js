/*
♦ Algoritmo 35: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore Rubro-Negra.
*/


class No {
    constructor(valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.vermelho = true; // Por padrão, os nós são vermelhos quando adicionados à árvore
    }
}

class ArvoreRubroNegra {
    constructor() {
        this.raiz = null;
        this.VERMELHO = true;
        this.PRETO = false;
    }

    // Verifica se um nó é vermelho
    isVermelho(no) {
        if (no === null) return false;
        return no.vermelho === this.VERMELHO;
    }

    // Realiza uma rotação para a esquerda em torno do nó dado
    rotacaoEsquerda(no) {
        let temp = no.direita;
        no.direita = temp.esquerda;
        temp.esquerda = no;
        temp.vermelho = no.vermelho;
        no.vermelho = this.VERMELHO;
        return temp;
    }

    // Realiza uma rotação para a direita em torno do nó dado
    rotacaoDireita(no) {
        let temp = no.esquerda;
        no.esquerda = temp.direita;
        temp.direita = no;
        temp.vermelho = no.vermelho;
        no.vermelho = this.VERMELHO;
        return temp;
    }

    // Inverte as cores do nó e de seus filhos
    inverterCores(no) {
        no.vermelho = !no.vermelho;
        no.esquerda.vermelho = !no.esquerda.vermelho;
        no.direita.vermelho = !no.direita.vermelho;
    }

    // Insere um novo nó na árvore Rubro-Negra
    inserir(valor) {
        this.raiz = this.inserirRecursivo(this.raiz, valor);
        this.raiz.vermelho = this.PRETO; // A raiz sempre será preta
    }

    // Método auxiliar recursivo para inserção
    inserirRecursivo(no, valor) {
        if (no === null) return new No(valor);

        // Inserção normal como em uma árvore de busca binária
        if (valor < no.valor)
            no.esquerda = this.inserirRecursivo(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = this.inserirRecursivo(no.direita, valor);
        else
            return no; // Valor já existe na árvore

        // Correção da propriedade de cor após a inserção
        if (this.isVermelho(no.direita) && !this.isVermelho(no.esquerda))
            no = this.rotacaoEsquerda(no);
        if (this.isVermelho(no.esquerda) && this.isVermelho(no.esquerda.esquerda))
            no = this.rotacaoDireita(no);
        if (this.isVermelho(no.esquerda) && this.isVermelho(no.direita))
            this.inverterCores(no);

        return no;
    }

    // Método para imprimir a árvore em ordem
    imprimirEmOrdem() {
        this.imprimirEmOrdemRecursivo(this.raiz);
    }

    // Método auxiliar recursivo para impressão em ordem
    imprimirEmOrdemRecursivo(no) {
        if (no !== null) {
            this.imprimirEmOrdemRecursivo(no.esquerda);
            console.log(no.valor);
            this.imprimirEmOrdemRecursivo(no.direita);
        }
    }

    // Método para verificar se a árvore Rubro-Negra está vazia
    estaVazia() {
        return this.raiz === null;
    }
}

// Teste
let arvore = new ArvoreRubroNegra();
arvore.inserir(10);
arvore.inserir(5);
arvore.inserir(20);
arvore.inserir(3);
arvore.inserir(8);
arvore.inserir(15);

console.log("Em Ordem:");
arvore.imprimirEmOrdem();
