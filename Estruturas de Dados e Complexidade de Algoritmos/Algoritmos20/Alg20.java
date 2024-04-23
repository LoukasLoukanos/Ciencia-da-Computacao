/*
♦ Algoritmo 20: Algoritmo de Pesquisa/Busca para a Estrutura de Dados Linear Dinâmica (não Estática) Lista Duplamente Ligada (ou Duplamente Encadeada): Busca em Lista Duplamente Ligada.
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
