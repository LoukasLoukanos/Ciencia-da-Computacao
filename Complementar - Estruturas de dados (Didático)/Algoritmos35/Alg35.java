/*
♦ Algoritmo 35: Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore Rubro-Negra.
*/


public class No<T extends Comparable<T>> {
    T valor;
    No<T> esquerda, direita;
    boolean vermelho;

    public No(T valor) {
        this.valor = valor;
        this.esquerda = this.direita = null;
        this.vermelho = true; // Por padrão, os nós são vermelhos quando adicionados à árvore
    }
}

public class Alg35<T extends Comparable<T>> {
    private No<T> raiz;
    private static final boolean VERMELHO = true;
    private static final boolean PRETO = false;

    // Verifica se um nó é vermelho
    private boolean isVermelho(No<T> no) {
        if (no == null) return false;
        return no.vermelho == VERMELHO;
    }

    // Realiza uma rotação para a esquerda em torno do nó dado
    private No<T> rotacaoEsquerda(No<T> no) {
        No<T> temp = no.direita;
        no.direita = temp.esquerda;
        temp.esquerda = no;
        temp.vermelho = no.vermelho;
        no.vermelho = VERMELHO;
        return temp;
    }

    // Realiza uma rotação para a direita em torno do nó dado
    private No<T> rotacaoDireita(No<T> no) {
        No<T> temp = no.esquerda;
        no.esquerda = temp.direita;
        temp.direita = no;
        temp.vermelho = no.vermelho;
        no.vermelho = VERMELHO;
        return temp;
    }

    // Inverte as cores do nó e de seus filhos
    private void inverterCores(No<T> no) {
        no.vermelho = !no.vermelho;
        no.esquerda.vermelho = !no.esquerda.vermelho;
        no.direita.vermelho = !no.direita.vermelho;
    }

    // Insere um novo nó na árvore Rubro-Negra
    public void inserir(T valor) {
        raiz = inserirRecursivo(raiz, valor);
        raiz.vermelho = PRETO; // A raiz sempre será preta
    }

    // Método auxiliar recursivo para inserção
    private No<T> inserirRecursivo(No<T> no, T valor) {
        if (no == null) return new No<>(valor);

        // Inserção normal como em uma árvore de busca binária
        if (valor.compareTo(no.valor) < 0)
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = inserirRecursivo(no.direita, valor);
        else
            return no; // Valor já existe na árvore

        // Correção da propriedade de cor após a inserção
        if (isVermelho(no.direita) && !isVermelho(no.esquerda))
            no = rotacaoEsquerda(no);
        if (isVermelho(no.esquerda) && isVermelho(no.esquerda.esquerda))
            no = rotacaoDireita(no);
        if (isVermelho(no.esquerda) && isVermelho(no.direita))
            inverterCores(no);

        return no;
    }

    // Método para imprimir a árvore em ordem
    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }

    // Método auxiliar recursivo para impressão em ordem
    private void imprimirEmOrdemRecursivo(No<T> no) {
        if (no != null) {
            imprimirEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdemRecursivo(no.direita);
        }
    }

    // Método para verificar se a árvore Rubro-Negra está vazia
    public boolean estaVazia() {
        return raiz == null;
    }

    public static void main(String[] args) {
        Alg35<Integer> arvore = new Alg35<>();
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(20);
        arvore.inserir(3);
        arvore.inserir(8);
        arvore.inserir(15);

        System.out.println("Em Ordem:");
        arvore.imprimirEmOrdem();
    }
}
