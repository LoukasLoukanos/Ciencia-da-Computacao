/* Estrutura de dados linear de um array (de regra de acesso FIFO) unidimensional (vetor) de tipo genérico */

#include <iostream>
#include <array>
#include <string>

template <typename T>
class Alg01 {
private:
    std::array<T, 1> elementos;

public:
    Alg01() {
        std::cout << "Tamanho: ";
        int tamanho;
        std::cin >> tamanho;
        assert(tamanho > 0 && "O tamanho do vetor precisa ser maior que zero!");

        std::cout << "Tipo de dados: digite 'p' para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' para não primitivos → [string] ...";
        std::string tipo_de_dado;
        std::cin >> tipo_de_dado;
        assert((tipo_de_dado == "p" || tipo_de_dado == "np") && "Aceita-se 'p' ou 'np' como parâmetro!");

        if (tipo_de_dado == "p") {
            std::cout << "Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ";
            std::string tipo;
            std::cin >> tipo;

            if (tipo == "byte" || tipo == "short" || tipo == "int" || tipo == "long" || tipo == "float" || tipo == "double" || tipo == "char" || tipo == "boolean") {
                try {
                    this->elementos.fill(T());
                    std::cout << "Vetor do tipo de dados " << tipo << " de " << tamanho << " células alocadas." << std::endl;
                } catch (...) {
                    std::cout << "Tipo de dado inválido!" << std::endl;
                }
            } else {
                std::cout << "Tipo de dado inválido!" << std::endl;
            }
        } else if (tipo_de_dado == "np") {
            this->elementos.fill(T());
            std::cout << "Vetor do tipo de dados String de " << tamanho << " células alocadas." << std::endl;
        } else {
            std::cout << "Tipo de dado inválido!" << std::endl;
        }
    }

    void inserir(int indice, T valor) {
        this->elementos[indice] = valor;
    }

    T valor(int indice) {
        return this->elementos[indice];
    }
};

int main() {
    // Código adicional, se necessário
    Alg01<int> vetor;
    return 0;
}
