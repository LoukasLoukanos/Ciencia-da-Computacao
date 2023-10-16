/*
♦ Algoritmo 19: Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 12: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada) de tipo de dados genérico].
→ Operações:
    • Busca de um valor em uma Lista Ligada Simples;
    • Identificar o menor valor em uma Lista Ligada Simples;
    • Identificar o maior valor em uma Lista Ligada Simples;
    • Retornar o sucessor de um valor em uma Lista Ligada Simples;
    • Retornar o predecessor de um valor em uma Lista Ligada Simples.
*/

#include <iostream>

template <typename T>
class Node {
public:
    T value;
    Node<T>* next;

    Node(T val) : value(val), next(nullptr) {}
};

template <typename T>
class LinkedList {
private:
    Node<T>* head;
    int size;

public:
    LinkedList() : head(nullptr), size(0) {}

    void insert(T value) {
        Node<T>* newNode = new Node<T>(value);
        newNode->next = head;
        head = newNode;
        size++;
    }

    void remove(T value) {
        if (head == nullptr) {
            return;
        }

        if (head->value == value) {
            Node<T>* temp = head;
            head = head->next;
            delete temp;
            size--;
            return;
        }

        Node<T>* current = head;
        Node<T>* prev = nullptr;

        while (current != nullptr) {
            if (current->value == value) {
                prev->next = current->next;
                delete current;
                size--;
                return;
            }
            prev = current;
            current = current->next;
        }
    }

    int getSize() const {
        return size;
    }

    void display() const {
        Node<T>* current = head;
        while (current != nullptr) {
            std::cout << current->value << " ";
            current = current->next;
        }
        std::cout << std::endl;
    }

    bool search(T value) const {
        Node<T>* current = head;
        while (current != nullptr) {
            if (current->value == value) {
                return true; // Valor encontrado
            }
            current = current->next;
        }
        return false; // Valor não encontrado
    }

    T findMinimum() const {
        if (head == nullptr) {
            return T();
        }

        Node<T>* current = head;
        T min = current->value;

        while (current != nullptr) {
            if (current->value < min) {
                min = current->value;
            }
            current = current->next;
        }
        return min;
    }

    T findMaximum() const {
        if (head == nullptr) {
            return T();
        }

        Node<T>* current = head;
        T max = current->value;

        while (current != nullptr) {
            if (current->value > max) {
                max = current->value;
            }
            current = current->next;
        }
        return max;
    }

    T getSuccessor(T value) const {
        Node<T>* current = head;
        while (current != nullptr) {
            if (current->value == value) {
                if (current->next != nullptr) {
                    return current->next->value;
                }
                break; // Último elemento, não há sucessor
            }
            current = current->next;
        }
        return T(); // Valor não encontrado ou é o último
    }

    T getPredecessor(T value) const {
        if (head == nullptr || head->value == value) {
            return T(); // Valor não encontrado ou é o primeiro
        }

        Node<T>* current = head;
        while (current != nullptr && current->next != nullptr) {
            if (current->next->value == value) {
                return current->value;
            }
            current = current->next;
        }
        return T(); // Valor não encontrado
    }

    ~LinkedList() {
        while (head != nullptr) {
            Node<T>* temp = head;
            head = head->next;
            delete temp;
        }
    }
};

int main() {
    LinkedList<int> list;
    list.insert(10);
    list.insert(20);
    list.insert(30);

    std::cout << "Tamanho da lista: " << list.getSize() << std::endl;
    std::cout << "Elementos da lista: ";
    list.display();

    std::cout << "Buscar 20: " << list.search(20) << std::endl;
    std::cout << "Menor valor: " << list.findMinimum() << std::endl;
    std::cout << "Maior valor: " << list.findMaximum() << std::endl;
    std::cout << "Sucessor de 20: " << list.getSuccessor(20) << std::endl;
    std::cout << "Predecessor de 20: " << list.getPredecessor(20) << std::endl;

    list.remove(20);

    std::cout << "Tamanho da lista após remoção: " << list.getSize() << std::endl;
    std::cout << "Elementos da lista após remoção: ";
    list.display();

    return 0;
}
