/*
♦ Algoritmo 20: Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 13: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada de tipo de dados genérico].
→ Operações:
    • Busca de um valor em uma Lista Duplamente Ligada;
    • Identificar o menor valor em uma Lista Duplamente Ligada;
    • Identificar o maior valor em uma Lista Duplamente Ligada;
    • Retornar o sucessor de um valor em uma Lista Duplamente Ligada;
    • Retornar o predecessor de um valor em uma Lista Duplamente Ligada.
*/

public class Alg20<T extends Comparable<T>> {

    public boolean searchList(T valor) {
        Nodo<T> nodoAtual = primeiro;
        while (nodoAtual != null) {
            if (nodoAtual.getValor().equals(valor)) {
                return true;
            }
            nodoAtual = nodoAtual.getProximo();
        }
        return false;
    }

    public T findMinimum() {
        if (primeiro == null) {
            return null;
        }

        Nodo<T> nodoAtual = primeiro;
        T min = nodoAtual.getValor();

        while (nodoAtual != null) {
            if (nodoAtual.getValor().compareTo(min) < 0) {
                min = nodoAtual.getValor();
            }
            nodoAtual = nodoAtual.getProximo();
        }
        return min;
    }

    public T findMaximum() {
        if (primeiro == null) {
            return null;
        }

        Nodo<T> nodoAtual = primeiro;
        T max = nodoAtual.getValor();

        while (nodoAtual != null) {
            if (nodoAtual.getValor().compareTo(max) > 0) {
                max = nodoAtual.getValor();
            }
            nodoAtual = nodoAtual.getProximo();
        }
        return max;
    }

    public T getSuccessor(T valor) {
        Nodo<T> nodoAtual = primeiro;
        while (nodoAtual != null) {
            if (nodoAtual.getValor().equals(valor)) {
                if (nodoAtual.getProximo() != null) {
                    return nodoAtual.getProximo().getValor();
                }
                break;
            }
            nodoAtual = nodoAtual.getProximo();
        }
        return null;
    }

    public T getPredecessor(T valor) {
        if (primeiro == null || primeiro.getValor().equals(valor)) {
            return null;
        }

        Nodo<T> nodoAtual = primeiro;
        while (nodoAtual != null && nodoAtual.getProximo() != null) {
            if (nodoAtual.getProximo().getValor().equals(valor)) {
                return nodoAtual.getValor();
            }
            nodoAtual = nodoAtual.getProximo();
        }
        return null;
    }
