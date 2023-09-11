# **Algoritmos de Estruturas de Dados Lineares**

- ## **Estruturas de Dados Estáticas**

  - ### ***Array unidimensional (Vetor)***
    - #### **Algoritmo 01:** 
      Implementação de um array unidimensional (vetor) de tipo genérico (considerando uma estrutura de dados que armazena, a princípio, dados primitivos desde que sejam do mesmo tipo — estrutura homogênea — )

      <img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg">*Repositórios:*
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-line.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-plain-wordmark.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-plain.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-plain.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original-wordmark.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-plain-wordmark.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>
      
      <details>
      <summary><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></summary>

      ```cpp
      #include <iostream>
      #include <cassert>
      #include <cstring>

      template <typename T>
      class Alg01 {
      private:
          T* elementos;
          int tamanho;
          int tamanhoAtual;

      public:
          Alg01(int tamanho) : tamanho(tamanho), tamanhoAtual(0) {
              elementos = new T[tamanho];
          }

          ~Alg01() {
              delete[] elementos;
          }

          bool isEmpty() const {
              return tamanhoAtual == 0;
          }

          bool isFull() const {
              return tamanhoAtual == tamanho;
          }

          void addElement(int indice, const T& valor) {
              if (indice < 0 || indice >= tamanho) {
                  throw std::out_of_range("Índice fora dos limites do vetor.");
              }

              if (isFull()) {
                  throw std::runtime_error("O vetor está cheio.");
              }

              elementos[indice] = valor;
              tamanhoAtual++;
          }

          void removeElement(int indice) {
              if (indice < 0 || indice >= tamanho) {
                  throw std::out_of_range("Índice fora dos limites do vetor.");
              }

              if (isEmpty()) {
                  throw std::runtime_error("O vetor está vazio.");
              }

              elementos[indice] = T(); // Define o elemento como um valor padrão (0 para tipos numéricos).
              tamanhoAtual--;
          }

          int sizeArray() const {
              return tamanhoAtual;
          }

          T accessElement(int indice) const {
              if (indice < 0 || indice >= tamanho) {
                  throw std::out_of_range("Índice fora dos limites do vetor.");
              }

              if (isEmpty()) {
                  throw std::runtime_error("O vetor está vazio.");
              }

              return elementos[indice];
          }

          void showQueue() const {
              for (int i = 0; i < tamanhoAtual; i++) {
                  std::cout << elementos[i] << " ";
              }
              std::cout << std::endl;
          }
      };

      int main() {
          // Exemplo de criação de um vetor de inteiros
          Alg01<int> vetorInt(10);

          // Verificar se o vetor está vazio
          std::cout << "O vetor está vazio? " << (vetorInt.isEmpty() ? "Sim" : "Não") << std::endl;

          // Adicionar elementos
          vetorInt.addElement(0, 10);
          vetorInt.addElement(1, 20);
          vetorInt.addElement(2, 30);

          // Verificar o tamanho atual do vetor
          std::cout << "Tamanho atual do vetor: " << vetorInt.sizeArray() << std::endl;

          // Acessar um elemento
          std::cout << "Elemento no índice 1: " << vetorInt.accessElement(1) << std::endl;

          // Remover um elemento
          vetorInt.removeElement(1);

          // Verificar se o vetor está vazio novamente
          std::cout << "O vetor está vazio? " << (vetorInt.isEmpty() ? "Sim" : "Não") << std::endl;

          // Verificar se o vetor está cheio
          std::cout << "O vetor está cheio? " << (vetorInt.isFull() ? "Sim" : "Não") << std::endl;

          // Mostrar todos os elementos
          std::cout << "Elementos do vetor: ";
          vetorInt.showQueue();

          return 0;
      }

      ```
      </details>

      <!------------------------------------------------------------------------------>
      
      <details>
      <summary><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></summary>

      ```java
      import java.lang.reflect.Array;
      import java.util.Scanner;

      public class Alg01<T> {
          private T[] elementos;
          private int tamanho;
          private int tamanhoAtual;
          Scanner sc = new Scanner(System.in);

          public Alg01(T[] elementos) {
              this.elementos = elementos;
              this.tamanhoAtual = 0;

              System.out.print("Tamanho: ");
              tamanho = sc.nextInt();
              assert (tamanho > 0) : "O tamanho do Vetor precisa ser maior que zero!";
              this.elementos = (T[]) new Object[tamanho];

              System.out.print("Tipo de dados: digite 'p' para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' para não primitivos → [string] ...");
              sc.nextLine();
              String tipo_de_dado = sc.nextLine();
              assert (tipo_de_dado.equals("p") || tipo_de_dado.equals("np")) : "Aceita-se 'p' ou 'np' como parâmetro!";

              if (tipo_de_dado.equals("p")) {
                  System.out.print("Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ");
                  String tipo = sc.nextLine();

                  if (tipo.equals("byte") || tipo.equals("short") || tipo.equals("int") || tipo.equals("long") ||
                          tipo.equals("float") || tipo.equals("double") || tipo.equals("char") || tipo.equals("boolean")) {
                      try {
                          Class<?> clazz = Class.forName("java.lang." + tipo.substring(0, 1).toUpperCase() + tipo.substring(1));
                          this.elementos = (T[]) Array.newInstance(clazz, tamanho);
                          System.out.printf("Vetor do tipo de dados %s de %d células alocadas.\n", tipo, tamanho);
                      } catch (ClassNotFoundException e) {
                          System.out.println("Tipo de dado inválido!");
                      }
                  } else {
                      System.out.println("Tipo de dado inválido!");
                  }
              } else if (tipo_de_dado.equals("np")) {
                  this.elementos = (T[]) new String[tamanho];
                  System.out.printf("Vetor do tipo de dados String de %d células alocadas.\n", tamanho);
              } else {
                  System.out.println("Tipo de dado inválido!");
              }
          }

          public boolean isEmpty() {
              return tamanhoAtual == 0;
          }

          public boolean isFull() {
              return tamanhoAtual == tamanho;
          }

          public void addElement(int indice, T valor) {
              if (indice < 0 || indice >= tamanho) {
                  throw new IllegalArgumentException("Índice fora dos limites do vetor.");
              }

              if (isFull()) {
                  throw new IllegalStateException("O vetor está cheio.");
              }

              elementos[indice] = valor;
              tamanhoAtual++;
          }

          public void removeElement(int indice) {
              if (indice < 0 || indice >= tamanho) {
                  throw new IllegalArgumentException("Índice fora dos limites do vetor.");
              }

              if (isEmpty()) {
                  throw new IllegalStateException("O vetor está vazio.");
              }

              elementos[indice] = null;
              tamanhoAtual--;
          }

          public int sizeArray() {
              return tamanhoAtual;
          }

          public T accessElement(int indice) {
              if (indice < 0 || indice >= tamanho) {
                  throw new IllegalArgumentException("Índice fora dos limites do vetor.");
              }

              if (isEmpty()) {
                  throw new IllegalStateException("O vetor está vazio.");
              }

              return elementos[indice];
          }

          public void showQueue() {
              for (T elemento : elementos) {
                  System.out.print(elemento + " ");
              }
              System.out.println();
          }

          public static void main(String[] args) {
              // Exemplo de criação de um vetor de inteiros
              Alg01<Integer> vetorInt = new Alg01<>(new Integer[10]);

              // Verificar se o vetor está vazio
              System.out.println("O vetor está vazio? " + vetorInt.isEmpty());

              // Adicionar elementos
              vetorInt.addElement(0, 10);
              vetorInt.addElement(1, 20);
              vetorInt.addElement(2, 30);

              // Verificar o tamanho atual do vetor
              System.out.println("Tamanho atual do vetor: " + vetorInt.sizeArray());

              // Acessar um elemento
              System.out.println("Elemento no índice 1: " + vetorInt.accessElement(1));

              // Remover um elemento
              vetorInt.removeElement(1);

              // Verificar se o vetor está vazio novamente
              System.out.println("O vetor está vazio? " + vetorInt.isEmpty());

              // Verificar se o vetor está cheio
              System.out.println("O vetor está cheio? " + vetorInt.isFull());

              // Mostrar todos os elementos
              System.out.print("Elementos do vetor: ");
              vetorInt.showQueue();
          }

      }

      ```
      </details>
      
      <!------------------------------------------------------------------------------>
      
      <details>
      <summary><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></summary>
      
      ```javascript
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

      ```
      </details>
      
      <!------------------------------------------------------------------------------>
      
      <details>
      <summary><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></summary>

      ```php
      class Alg01 {
          private $elementos;
          private $tamanho;
          private $tamanhoAtual;

          public function __construct($tamanho) {
              $this->elementos = array();
              $this->tamanho = $tamanho;
              $this->tamanhoAtual = 0;

              echo "Tamanho: ";
              $tamanhoInput = intval(fgets(STDIN));
              if ($tamanhoInput > 0) {
                  $this->tamanho = $tamanhoInput;
                  echo 'Tipo de dados: digite "p" para primitivos ou "np" para não primitivos: ';
                  $tipo_de_dado = trim(fgets(STDIN));
                  if ($tipo_de_dado === "p") {
                      echo 'Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ';
                      $tipo = trim(fgets(STDIN));
                      if (in_array($tipo, array("byte", "short", "int", "long", "float", "double", "char", "boolean"))) {
                          $this->elementos = array_fill(0, $this->tamanho, null);
                          echo "Vetor do tipo de dados $tipo de $this->tamanho células alocadas.\n";
                      } else {
                          echo "Tipo de dado inválido!\n";
                      }
                  } else if ($tipo_de_dado === "np") {
                      $this->elementos = array_fill(0, $this->tamanho, null);
                      echo "Vetor do tipo de dados String de $this->tamanho células alocadas.\n";
                  } else {
                      echo "Tipo de dado inválido!\n";
                  }
              } else {
                  echo "O tamanho do vetor precisa ser maior que zero!\n";
              }
          }

          public function isEmpty() {
              return $this->tamanhoAtual == 0;
          }

          public function isFull() {
              return $this->tamanhoAtual == $this->tamanho;
          }

          public function addElement($indice, $valor) {
              if ($indice < 0 || $indice >= $this->tamanho) {
                  throw new InvalidArgumentException("Índice fora dos limites do vetor.");
              }

              if ($this->isFull()) {
                  throw new RuntimeException("O vetor está cheio.");
              }

              $this->elementos[$indice] = $valor;
              $this->tamanhoAtual++;
          }

          public function removeElement($indice) {
              if ($indice < 0 || $indice >= $this->tamanho) {
                  throw new InvalidArgumentException("Índice fora dos limites do vetor.");
              }

              if ($this->isEmpty()) {
                  throw new RuntimeException("O vetor está vazio.");
              }

              $this->elementos[$indice] = null;
              $this->tamanhoAtual--;
          }

          public function sizeArray() {
              return $this->tamanhoAtual;
          }

          public function accessElement($indice) {
              if ($indice < 0 || $indice >= $this->tamanho) {
                  throw new InvalidArgumentException("Índice fora dos limites do vetor.");
              }

              if ($this->isEmpty()) {
                  throw new RuntimeException("O vetor está vazio.");
              }

              return $this->elementos[$indice];
          }

          public function showQueue() {
              echo "Elementos do vetor: " . implode(" ", $this->elementos) . "\n";
          }
      }

      // Exemplo de criação de um vetor de inteiros
      $vetorInt = new Alg01(10);

      // Verificar se o vetor está vazio
      echo "O vetor está vazio? " . ($vetorInt->isEmpty() ? "Sim" : "Não") . "\n";

      // Adicionar elementos
      $vetorInt->addElement(0, 10);
      $vetorInt->addElement(1, 20);
      $vetorInt->addElement(2, 30);

      // Verificar o tamanho atual do vetor
      echo "Tamanho atual do vetor: " . $vetorInt->sizeArray() . "\n";

      // Acessar um elemento
      echo "Elemento no índice 1: " . $vetorInt->accessElement(1) . "\n";

      // Remover um elemento
      $vetorInt->removeElement(1);

      // Verificar se o vetor está vazio novamente
      echo "O vetor está vazio? " . ($vetorInt->isEmpty() ? "Sim" : "Não") . "\n";

      // Verificar se o vetor está cheio
      echo "O vetor está cheio? " . ($vetorInt->isFull() ? "Sim" : "Não") . "\n";

      // Mostrar todos os elementos
      echo "Elementos do vetor: ";
      $vetorInt->showQueue();

      ?>

      ```
      </details>
      
      <!------------------------------------------------------------------------------>
      
      <details>
      <summary><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></summary>

      ```python
      class Alg01:
          def __init__(self, tamanho):
              self.elementos = [None] * tamanho
              self.tamanho = tamanho
              self.tamanhoAtual = 0

              print("Tamanho: ")
              tamanho_input = int(input())
              if tamanho_input > 0:
                  self.tamanho = tamanho_input
                  print('Tipo de dados: digite "p" para primitivos ou "np" para não primitivos: ')
                  tipo_de_dado = input().strip()
                  if tipo_de_dado == "p":
                      print('Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): ')
                      tipo = input().strip()
                      if tipo in ["byte", "short", "int", "long", "float", "double", "char", "boolean"]:
                          self.elementos = [None] * tamanho
                          print(f"Vetor do tipo de dados {tipo} de {tamanho} células alocadas.")
                      else:
                          print("Tipo de dado inválido!")
                  elif tipo_de_dado == "np":
                      self.elementos = [None] * tamanho
                      print(f"Vetor do tipo de dados String de {tamanho} células alocadas.")
                  else:
                      print("Tipo de dado inválido!")
              else:
                  print("O tamanho do vetor precisa ser maior que zero!")

          def is_empty(self):
              return self.tamanhoAtual == 0

          def is_full(self):
              return self.tamanhoAtual == self.tamanho

          def add_element(self, indice, valor):
              if indice < 0 or indice >= self.tamanho:
                  raise ValueError("Índice fora dos limites do vetor.")

              if self.is_full():
                  raise ValueError("O vetor está cheio.")

              self.elementos[indice] = valor
              self.tamanhoAtual += 1

          def remove_element(self, indice):
              if indice < 0 or indice >= self.tamanho:
                  raise ValueError("Índice fora dos limites do vetor.")

              if self.is_empty():
                  raise ValueError("O vetor está vazio.")

              self.elementos[indice] = None
              self.tamanhoAtual -= 1

          def size_array(self):
              return self.tamanhoAtual

          def access_element(self, indice):
              if indice < 0 or indice >= self.tamanho:
                  raise ValueError("Índice fora dos limites do vetor.")

              if self.is_empty():
                  raise ValueError("O vetor está vazio.")

              return self.elementos[indice]

          def show_queue(self):
              print("Elementos do vetor:", end=" ")
              for elemento in self.elementos:
                  if elemento is not None:
                      print(elemento, end=" ")
              print()

      # Exemplo de criação de um vetor de inteiros
      vetor_int = Alg01(10)

      # Verificar se o vetor está vazio
      print("O vetor está vazio?", "Sim" if vetor_int.is_empty() else "Não")

      # Adicionar elementos
      vetor_int.add_element(0, 10)
      vetor_int.add_element(1, 20)
      vetor_int.add_element(2, 30)

      # Verificar o tamanho atual do vetor
      print("Tamanho atual do vetor:", vetor_int.size_array())

      # Acessar um elemento
      print("Elemento no índice 1:", vetor_int.access_element(1))

      # Remover um elemento
      vetor_int.remove_element(1)

      # Verificar se o vetor está vazio novamente
      print("O vetor está vazio?", "Sim" if vetor_int.is_empty() else "Não")

      # Verificar se o vetor está cheio
      print("O vetor está cheio?", "Sim" if vetor_int.is_full() else "Não")

      # Mostrar todos os elementos
      vetor_int.show_queue()

      ```
      
      </details>
      
      <!------------------------------------------------------------------------------>
      
      <details>
      <summary><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></summary>
      
      ```ruby
      class Alg01
        def initialize(tamanho)
          @elementos = Array.new(tamanho)
          @tamanho = tamanho
          @tamanho_atual = 0

          print 'Tamanho: '
          tamanho_input = gets.chomp.to_i
          if tamanho_input > 0
            @tamanho = tamanho_input
            print 'Tipo de dados: digite "p" para primitivos ou "np" para não primitivos: '
            tipo_de_dado = gets.chomp.strip
            if tipo_de_dado == 'p'
              print 'Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): '
              tipo = gets.chomp.strip
              if %w[byte short int long float double char boolean].include?(tipo)
                @elementos = Array.new(@tamanho)
                puts "Vetor do tipo de dados #{tipo} de #{@tamanho} células alocadas."
              else
                puts 'Tipo de dado inválido!'
              end
            elsif tipo_de_dado == 'np'
              @elementos = Array.new(@tamanho)
              puts "Vetor do tipo de dados String de #{@tamanho} células alocadas."
            else
              puts 'Tipo de dado inválido!'
            end
          else
            puts 'O tamanho do vetor precisa ser maior que zero!'
          end
        end

        def is_empty
          @tamanho_atual == 0
        end

        def is_full
          @tamanho_atual == @tamanho
        end

        def add_element(indice, valor)
          if indice < 0 || indice >= @tamanho
            raise 'Índice fora dos limites do vetor.'
          end

          if is_full
            raise 'O vetor está cheio.'
          end

          @elementos[indice] = valor
          @tamanho_atual += 1
        end

        def remove_element(indice)
          if indice < 0 || indice >= @tamanho
            raise 'Índice fora dos limites do vetor.'
          end

          if is_empty
            raise 'O vetor está vazio.'
          end

          @elementos[indice] = nil
          @tamanho_atual -= 1
        end

        def size_array
          @tamanho_atual
        end

        def access_element(indice)
          if indice < 0 || indice >= @tamanho
            raise 'Índice fora dos limites do vetor.'
          end

          if is_empty
            raise 'O vetor está vazio.'
          end

          @elementos[indice]
        end

        def show_queue
          print 'Elementos do vetor: '
          @elementos.each do |elemento|
            print "#{elemento} " unless elemento.nil?
          end
          puts
        end
      end

      # Exemplo de criação de um vetor de inteiros
      vetor_int = Alg01.new(10)

      # Verificar se o vetor está vazio
      puts 'O vetor está vazio?', vetor_int.is_empty ? 'Sim' : 'Não'

      # Adicionar elementos
      vetor_int.add_element(0, 10)
      vetor_int.add_element(1, 20)
      vetor_int.add_element(2, 30)

      # Verificar o tamanho atual do vetor
      puts 'Tamanho atual do vetor:', vetor_int.size_array

      # Acessar um elemento
      puts 'Elemento no índice 1:', vetor_int.access_element(1)

      # Remover um elemento
      vetor_int.remove_element(1)

      # Verificar se o vetor está vazio novamente
      puts 'O vetor está vazio?', vetor_int.is_empty ? 'Sim' : 'Não'

      # Verificar se o vetor está cheio
      puts 'O vetor está cheio?', vetor_int.is_full ? 'Sim' : 'Não'

      # Mostrar todos os elementos
      vetor_int.show_queue

      ```
      </details>
      
      <!------------------------------------------------------------------------------>
      
  </br></br>


  - ### ***Fila Estática Circular e Não-Circular***
    - #### **Algoritmo 02:**
      Estrutura de Dados Linear Estática de Fila Circular e Não-Circular (regra de acesso FIFO) de tipo de dados genérico.</br>
      Operações:</br>
      • isEmpty - verificar se a fila está vazia;</br>
      • isFull - verificar se a fila está cheia;</br>
      • enqueue - adicionar elementos;</br>
      • dequeue - remover o elemento da frente da fila;</br>
      • size - obter o tamanho atual da fila;</br>
      • front - acessar o elemento da frente da fila sem removê-lo;</br>
      • showQueue - mostar elementos da fila.

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.cpp">C++</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.java">Java</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.js">JavaScript</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.php">PHP</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.py">Python</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.rb">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


  - ### ***Pilha Estática***
    - #### **Algoritmo 03:**
      Estrutura de Dados Linear Estática (não Dinâmica) de Pilha (regra de acesso LIFO) de tipo de dados genérico.</br>
      Operações:</br>
      • isEmpty - verificar se a pilha está vazia;</br>
      • isFull - verificar se a pilha está cheia;</br>
      • push - inserir elementos no topo da pilha;</br>
      • pop - remover elementos do dopo da pilha;</br>
      • size - obter o tamanho atual da pilha;</br>
      • front - acessar o elemento do topo da pilha sem removê-lo;</br>
      • showStack - mostar elementos da pilha (do topo para base).

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.cpp">C++</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.java">Java</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.js">JavaScript</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.php">PHP</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.py">Python</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.rb">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


  - ### ***Classificação/Ordenação***
    - #### **Algoritmo 04:**
      Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação Bubble Sort (Ordanação pelo Método (Iterativo) de Bolhas).

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.cpp">C++</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.java">Java</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.js">JavaScript</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.php">PHP</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.py">Python</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.rb">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

    - #### **Algoritmo 05:**
      Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação Insertion Sort (Ordenação pelo Método (Iterativo) de Inserção).
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.cpp">C++</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.java">Java</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.js">JavaScript</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.php">PHP</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.py">Python</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.rb">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

    - #### **Algoritmo 06:**
      Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação Selection Sort (Ordenação pelo Método (Iterativo) de Seleção).

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.cpp">C++</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.java">Java</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.js">JavaScript</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.php">PHP</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.py">Python</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.rb">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

    - #### **Algoritmo 07:**
      Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação de Divisão e Conquista Quick Sort (Ordenação pelo Método (Recursivo) Rápido).

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.cpp">C++</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.java">Java</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.js">JavaScript</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.php">PHP</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.py">Python</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.rb">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

    - #### **Algoritmo 08:**
      Estrutura de Dados Linear Estática (não Dinâmica) de Classificação/Ordenação de Divisão e Conquista Merge Sort (Ordenação pelo Método (Recursivo) de Mistura/Mesclagem).
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.cpp">C++</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.java">Java</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.js">JavaScript</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.php">PHP</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.py">Python</a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.rb">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


  - ### Pesquisa/Busca
    - #### **Algoritmo 09:**
      Estrutura de Dados Linear Estática (não Dinâmica) de Pesquisa/Busca Pesquisa Sequencial (sem a utilização de variável/sentinela).

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

    - #### **Algoritmo 10:**
      Estrutura de Dados Linear Estática (não Dinâmica) de Pesquisa/Busca Busca Sequencial com Sentinela.

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

    - #### **Algoritmo 11:**
      Estrutura de Dados Linear Estática (não Dinâmica) de Pesquisa/Busca Busca Binária.

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


- ## Estruturas de Dados Dinâmicas
  - ### Lista Ligada (ou Encadeada) Simples
    - #### **Algoritmo 12:**
      Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada) de tipo de dados genérico.</br>
      Operações:</br>
      • addList: inserção em uma Lista Ligada Simples;</br>
      • removeList: remoção em uma Lista Ligada Simples;</br>
      • size - obter o tamanho atual da Lista Ligada Simples;</br>
      • showList: exibição dos elementos da Lista Ligada Simples.
      
      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


  - ### Lista Duplamente Ligada (ou Duplamente Encadeada)
    - #### **Algoritmo 13:**
      Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada de tipo de dados genérico.</br>
      Operações:</br>
      • addList: inserção em uma Lista Duplamente Ligada;</br>
      • removeList: remoção em uma Lista Duplamente Ligada;</br>
      • size - obter o tamanho atual da Lista Duplamente Ligada;</br>
      • showList: exibição dos elementos da Lista Duplamente Ligada.

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


  - ### Fila Dinâmica
    - #### **Algoritmo 14:**
      Estrutura de Dados Linear Dinâmica (não Estática) de Fila (regra de acesso FIFO) de tipo de dados genérico.</br>
      Operações:</br>
      • isEmpty - verificar se a fila está vazia;</br>
      • enqueue - adicionar elementos;</br>
      • dequeue - remover o elemento da frente da fila;</br>
      • size - obter o tamanho atual da fila;</br>
      • front - acessar o elemento da frente da fila sem removê-lo;</br>
      • showQueue - mostar elementos da fila.
      
      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


  - ### Pilha Dinâmica
    - #### **Algoritmo 15:**
      Estrutura de Dados Linear Dinâmica (não Estática) de Pilha (regra de acesso LIFO) de tipo de dados genérico.</br>
      Operações:</br>
      • isEmpty - verificar se a pilha está vazia;</br>
      • push - inserir elementos no topo da pilha;</br>
      • pop - remover elementos do dopo da pilha;</br>
      • size - obter o tamanho atual da pilha;</br>
      • front - acessar o elemento do topo da pilha sem removê-lo;</br>
      • showStack - mostar elementos da pilha (do topo para base).

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


  - ### Classificação/Ordenação
    - #### **Algoritmo 16:**
      Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Insertion Sort (Ordenação por Inserção).

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


  - ### Classificação/Ordenação em tempo linear
    - #### **Algoritmo 17:**
      Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação em tempo linear Counting Sort (Ordenação por Contagem).

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

    - #### **Algoritmo 18:**
      Estrutura de Dados Linear Dinâmica (não Estática) de Classificação/Ordenação Bucket Sort (Ordenação por Balde).

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|
  </br></br>


  - ### Pesquisa/Busca:
    - #### **Algoritmo 19:**
      Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 12: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada) de tipo de dados genérico].</br>
      Operações:</br>
      • Busca de um valor em uma Lista Ligada Simples;</br>
      • Identificar o menor valor em uma Lista Ligada Simples;</br>
      • Identificar o maior valor em uma Lista Ligada Simples;</br>
      • Retornar o sucessor de um valor em uma Lista Ligada Simples;</br>
      • Retornar o predecessor de um valor em uma Lista Ligada Simples.

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

    - #### **Algoritmo 20:**
      Estrutura de Dados Linear Dinâmica (não Estática) de Pesquisa/Busca para Algoritmo 13: →[Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada de tipo de dados genérico].</br>
      Operações:</br>
      • Busca de um valor em uma Lista Duplamente Ligada;</br>
      • Identificar o menor valor em uma Lista Duplamente Ligada;</br>
      • Identificar o maior valor em uma Lista Duplamente Ligada;</br>
      • Retornar o sucessor de um valor em uma Lista Duplamente Ligada;</br>
      • Retornar o predecessor de um valor em uma Lista Duplamente Ligada.

      | <a href="#">C++</a> | <a href="#">Java</a> | <a href="#">JavaScript</a> | <a href="#">PHP</a> | <a href="#">Python</a> | <a href="#">Ruby</a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|

</br><hr></br>


# Algoritmos de Estruturas de Dados Não Lineares
</br>
