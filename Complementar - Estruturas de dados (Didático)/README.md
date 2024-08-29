# Estruturas de Dados e Complexidade de Algoritmos

#### As estruturas de dados podem ser classificadas em dois aspectos: **Linearidade** e **Alocação de memória (Estática ou Dinâmica)**

- **Linearidade:**
  - *Estruturas de dados lineares:* Os elementos são organizados em uma sequência linear, onde cada elemento tem um antecessor e/ou um sucessor, formando uma linha. → *`Arrays`, `Filas`, `Pilhas` e `Listas`.*
  - *Estruturas de dados não lineares:* Os elementos não são organizados em uma sequência linear. → *`Árvores` e `Grafos`.*

- **Alocação de memória:**
 - *Estruturas de dados estáticas:* A quantidade máxima de elementos que a estrutura pode conter é definida no momento da criação e não pode ser alterada. Elas são alocadas em tempo de compilação. → *`Arrays`, `Filas`, `Pilhas`, `Árvores` e `Grafos`.*
 - *Estruturas de dados dinâmicas:* Elas alocam memória conforme necessário durante a execução do programa. Isso permite que a estrutura cresça ou diminua conforme necessário. → *`Listas`, `Filas`, `Pilhas`, `Árvores` e `Grafos`.*

#### A Complexidade de Algoritmos pode ser classificada em dois aspectos: **Tempo** e **Espaço**

- **Complexidade de tempo:** Descreve quanto tempo um algoritmo leva para executar em função do tamanho da entrada.

- **Complexidade de espaço:** Descreve quanto espaço de memória um algoritmo consome em função do tamanho da entrada.

</br><hr></br>


# **Estruturas de Dados Lineares**

- ## *Estruturas de Dados Lineares* **Estáticas**

  - ### *Estrutura de **`Array unidimensional (Vetor)`***
    - #### **Algoritmo 01:** 
    Implementação de um array unidimensional (vetor) de tipo genérico para dados primitivos de estrutura homogênea.

    <!------------------------------------------------------------------------------>

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos01/Alg01.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>
    
    <details>
    <summary>História:</summary> 
      
    A história das estruturas de dados remonta aos primórdios da computação, quando os pioneiros da disciplina começaram a organizar dados de maneira eficiente para facilitar operações computacionais. Uma das estruturas mais fundamentais é o vetor, que é uma coleção de elementos de dados do mesmo tipo organizados de forma sequencial na memória. O conceito de vetores é essencial em linguagens de programação modernas e tem raízes na matemática e na teoria dos conjuntos.
      
    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
      
    Um vetor (ou array) é uma estrutura de dados que armazena uma coleção fixa de elementos do mesmo tipo, acessíveis por meio de um índice. Nesta implementação, o vetor é construído como uma classe genérica, permitindo a manipulação de qualquer tipo de dado.</br></br> 
    O algoritmo apresentado é uma implementação de vetor com recursos que permitem a criação dinâmica de um vetor genérico para tipos primitivos ou não primitivos. Essa flexibilidade reflete o avanço das técnicas de programação orientada a objetos e o uso de reflexão para criar vetores adaptáveis a diferentes tipos de dados:
  
    - **Inicialização do Vetor**: O vetor é inicializado com um tamanho específico, e o tipo de dados pode ser escolhido como primitivo (como `int`, `double`, etc.) ou não primitivo (como `String`).
    - **Operações Básicas**:
      - `isEmpty()`: Verifica se o vetor está vazio.
      - `isFull()`: Verifica se o vetor está cheio.
      - `addElement(int indice, T valor)`: Adiciona um elemento em uma posição específica do vetor.
      - `removeElement(int indice)`: Remove um elemento do vetor em uma posição específica.
      - `sizeArray()`: Retorna o número atual de elementos no vetor.
      - `accessElement(int indice)`: Acessa o elemento em uma posição específica do vetor.
      - `showQueue()`: Exibe todos os elementos do vetor.
      
    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
      
    A complexidade do tempo de cada operação do vetor é essencial para avaliar sua eficiência:
  
    - **Adicionar (`addElement`) e Remover (`removeElement`)**: Ambas as operações têm complexidade O(1), pois manipulam diretamente o vetor usando um índice.
    - **Acessar (`accessElement`)**: A operação de acesso também tem complexidade O(1) devido ao acesso direto por índice.
  
    Essas operações são altamente eficientes, pois não dependem do tamanho do vetor para executar.
      
    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
      
    A implementação do vetor apresentada é computacionalmente viável para uso geral, mas possui algumas limitações:
      
    - **Uso de Memória**: O vetor requer memória contígua para armazenar os elementos, o que pode ser um problema se o tamanho do vetor for muito grande.
    - **Flexibilidade de Tipos**: A flexibilidade para escolher entre tipos primitivos e não primitivos é poderosa, mas requer cuidado ao garantir a integridade dos dados.
    - **Complexidade de Reflexão**: O uso da reflexão para criar vetores genéricos pode adicionar alguma sobrecarga computacional, principalmente durante a inicialização.
       
    </br>
    </details>

  </br></br>


  - ### *Estrutura de **`Fila Estática (Circular e Não-Circular)`***
    - #### **Algoritmo 02:**
    Estrutura de Dados Linear Estática de Fila Circular e Não-Circular: Queue (Fila).
      
    <!------------------------------------------------------------------------------>

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos02/Alg02.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>

    <details>
    <summary>História:</summary>
      
    As filas são estruturas de dados fundamentais na ciência da computação, modelando o comportamento de uma fila na vida real, onde o primeiro a entrar é o primeiro a sair (FIFO - First-In-First-Out). A implementação de filas circulares e não-circulares oferece soluções eficientes para gerenciamento de dados em diversos cenários computacionais. A ideia de uma fila já era conhecida na década de 1950, quando os fundamentos das estruturas de dados começaram a ser formalizados. </br></br>

    A fila circular resolve o problema de gerenciamento de espaço em uma estrutura de dados limitada por uma capacidade fixa, reutilizando espaços liberados quando elementos são removidos da frente da fila. Essa técnica otimiza o uso de memória e simplifica as operações de inserção e remoção em uma fila limitada. </br></br>

    A implementação de filas circulares e não-circulares é essencial para a compreensão e aplicação das estruturas de dados em sistemas computacionais. Essas estruturas oferecem soluções eficientes para gerenciamento de dados em tempo real, comunicação entre processos e muitos outros cenários. A análise de complexidade e computabilidade demonstra a robustez dessas estruturas em termos de desempenho e eficiência. A compreensão desses conceitos é crucial para o desenvolvimento de software eficiente e escalável na ciência da computação.
      
    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
      
    O algoritmo apresentado implementa duas versões de fila - uma circular e outra não-circular - em Java.

    - **Fila Circular**:
      - Utiliza uma matriz (array) para armazenar os elementos da fila.
      - Os elementos são inseridos na `traseira` e removidos da `frente`.
      - Quando a `traseira` alcança o final da matriz, ela volta ao início (módulo da capacidade), permitindo uma fila circular.
      - Operações básicas:
        - `enqueue(T elemento)`: Adiciona um elemento à `traseira` da fila.
        - `dequeue()`: Remove o elemento da `frente` da fila.
        - `front()`: Retorna o elemento da `frente` sem removê-lo.
        - `isEmpty()`, `isFull()`, `size()`: Métodos para verificar o estado da fila.
    - **Fila Não-Circular**:
      - Os elementos são inseridos na `traseira` da fila, sem reutilização do espaço liberado na `frente`.
      - Após a capacidade máxima ser atingida, a fila não aceita mais elementos.

    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
      
    - **Fila Circular**:
      - `enqueue(T elemento)`: O(1) - A inserção ocorre em tempo constante, mesmo quando a `traseira` alcança o limite da capacidade.
      - `dequeue()`: O(1) - A remoção ocorre em tempo constante, com ajustes na posição da `frente`.
      - `front()`: O(1) - Acesso direto ao elemento da `frente`.
      - `isEmpty()`, `isFull()`, `size()`: O(1) - Verificações simples baseadas em variáveis de estado.
    - **Fila Não-Circular**:
      - `enqueue(T elemento)`: O(1) - Inserção direta na `traseira` da fila.
      - `dequeue()`: O(1) - Remoção direta da `frente` da fila.
      - `front()`: O(1) - Acesso ao elemento da `frente`.
      - `isEmpty()`, `isFull()`, `size()`: O(1) - Verificações simples baseadas em variáveis de estado.
      
    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
      
    A implementação das filas circular e não-circular em Java apresenta soluções eficientes para operações de fila, adequadas para sistemas que necessitam de estruturas de dados de alto desempenho.

    - **Eficiência de Memória**:
      - A fila circular reutiliza espaço liberado, otimizando o uso da matriz de elementos.
      - A fila não-circular requer uma matriz de tamanho fixo, utilizando memória de forma estática.
    - **Facilidade de Uso**:
      - Métodos simples e diretos para manipular a fila, facilitando a integração em diferentes sistemas.
      - As operações são tratadas de forma eficiente, mantendo a estrutura da fila organizada e fácil de entender.
    - **Adaptação a Requisitos Específicos**:
      - A escolha entre fila circular e não-circular permite adaptação a requisitos específicos de espaço e comportamento da fila.
      - A complexidade de tempo constante das operações permite a utilização da fila em sistemas com exigências de desempenho.
      
    </br>
    </details>

  </br></br>


  - ### *Estrutura de **`Pilha Estática`***
    - #### **Algoritmo 03:**
    Estrutura de Dados Linear Estática (não Dinâmica) de Pilha: Stack (Pilha).

    <!------------------------------------------------------------------------------>

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos03/Alg03.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>

    <details>
    <summary>História:</summary>
    
    A estrutura de dados chamada pilha (ou stack) é fundamental na ciência da computação e tem um papel crucial em muitas aplicações e algoritmos. A pilha segue o princípio LIFO (Last In, First Out), onde o último elemento inserido é o primeiro a ser removido. A ideia de uma pilha pode ser encontrada em práticas cotidianas, como em uma pilha de pratos: você sempre pega o prato de cima.</br></br>

    Historicamente, o conceito de pilha foi formalizado na década de 1960 com o advento das linguagens de programação e a necessidade de gerenciamento eficiente de dados. As pilhas são amplamente utilizadas em várias áreas, incluindo a avaliação de expressões aritméticas, gerenciamento de memória (chamadas de função), e algoritmos de backtracking (como o algoritmo de busca em profundidade - DFS).</br></br>

    A estrutura de pilha é uma das estruturas de dados mais fundamentais e úteis na ciência da computação. A implementação estática em Java apresentada é simples e eficiente para muitos casos de uso, proporcionando operações rápidas e constantes. No entanto, a escolha entre uma pilha estática e uma dinâmica deve ser baseada nos requisitos específicos do problema, considerando as vantagens e limitações de cada abordagem.

    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
    
    A implementação da pilha utiliza uma abordagem estática, onde a capacidade da pilha é definida no momento da criação. A estrutura da classe é genérica, permitindo a manipulação de qualquer tipo de dado.

    - **Atributos Principais**:
      - `capacidade`: O tamanho máximo da pilha.
      - `elementos`: Um array que armazena os elementos da pilha.
      - `topo`: Um índice que representa a posição do elemento no topo da pilha.
    - **Operações Básicas**:
      - `isEmpty()`: Verifica se a pilha está vazia.
      - `isFull()`: Verifica se a pilha está cheia.
      - `push(T elemento)`: Insere um elemento no topo da pilha.
      - `pop()`: Remove e retorna o elemento do topo da pilha.
      - `front()`: Retorna o elemento do topo da pilha sem removê-lo.
      - `size()`: Retorna o número atual de elementos na pilha.
      - `showStack()`: Exibe os elementos da pilha do topo para a base.
 
    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
    
    A complexidade temporal das operações na pilha é um aspecto crucial para sua eficiência:

    - **Inserir (`push`) e Remover (`pop`)**:
      - Ambas as operações possuem complexidade O(1). A inserção e remoção são realizadas diretamente no índice do topo da pilha, sem a necessidade de percorrer os elementos.
    - **Acessar (`front`)**:
      - Também possui complexidade O(1), pois o acesso é direto ao índice do topo.
    - **Verificar Estado (`isEmpty`, `isFull`, `size`)**:
      - Estas operações são O(1), pois dependem de variáveis de estado que são verificadas ou atualizadas diretamente.

    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
    
    A implementação da pilha apresentada é eficiente e prática para muitas aplicações, mas possui algumas considerações importantes:

    - **Memória**:
      - Como uma estrutura estática, a pilha reserva um espaço fixo na memória, definido pela capacidade. Isso pode ser uma limitação em termos de flexibilidade, especialmente se a capacidade máxima não for corretamente estimada.
    - **Eficiência**:
      - As operações de inserção, remoção e acesso são altamente eficientes (O(1)), tornando a pilha uma estrutura ideal para situações que requerem acesso rápido e constante aos elementos mais recentes.
    - **Limitações**:
      - A pilha estática não pode crescer além de sua capacidade inicial, o que pode levar a exceções se a capacidade for excedida.
      - Não há suporte para redimensionamento dinâmico, diferentemente de uma pilha implementada com uma estrutura de dados dinâmica como uma lista encadeada.

    </br>
    </details>

  </br></br>


  - ### *Algoritmos de **`Classificação/Ordenação`** de Estruturas Estáticas*
    - #### **Algoritmo 04:**
    Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Bubble Sort (Ordanação por Bolhas).

    <!------------------------------------------------------------------------------>

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos04/Alg04.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>

    <details>
    <summary>História:</summary>
    
    O Bubble Sort, ou ordenação por bolhas, é um dos algoritmos de ordenação mais simples e mais antigos, remontando à década de 1960. Ele foi assim nomeado devido à forma como os elementos "flutuam" para a sua posição correta, semelhante às bolhas de ar que sobem à superfície da água. Embora não seja eficiente para grandes conjuntos de dados, o Bubble Sort é frequentemente utilizado em contextos educacionais para introduzir os conceitos básicos de algoritmos de ordenação devido à sua simplicidade.</br></br>

    O Bubble Sort é um algoritmo de ordenação simples e direto, ideal para fins educativos e para conjuntos de dados pequenos ou parcialmente ordenados. Sua implementação fácil e a compreensão intuitiva fazem dele uma ferramenta útil para introduzir conceitos de algoritmos de ordenação. No entanto, para aplicações práticas com grandes conjuntos de dados, algoritmos mais eficientes como Merge Sort, Quick Sort ou Heap Sort são preferíveis devido às suas melhores performances em termos de complexidade temporal.
    
    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
    
    O Bubble Sort é um algoritmo de ordenação baseado em comparação que funciona repetidamente percorrendo a lista a ser ordenada, comparando elementos adjacentes e trocando-os se estiverem na ordem errada. Este processo é repetido até que a lista esteja ordenada. </br></br>
    
    - **Estrutura do Algoritmo**:
      - **Entrada**: Um array de inteiros.
      - **Saída**: O mesmo array de inteiros, mas ordenado em ordem crescente.
    - **Operações principais**:
      - **Comparação**: Verifica se dois elementos adjacentes estão fora de ordem.
      - **Troca**: Se estiverem, troca suas posições no array.
    
    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
    
    A análise de complexidade temporal do Bubble Sort é crucial para entender sua eficiência:

    - **Melhor Caso**: O(n)
      - Ocorre quando o array já está ordenado. O algoritmo faz uma única passagem pelo array, realizando comparações, mas sem trocas.
    - **Pior Caso**: O(n^2)
      - Ocorre quando o array está em ordem inversa. O algoritmo precisa fazer o número máximo de trocas em cada passagem.
    - **Caso Médio**: O(n^2)
      - Em média, o algoritmo ainda realiza um grande número de comparações e trocas.
    
    A complexidade quadrática torna o Bubble Sort ineficiente para grandes conjuntos de dados, sendo mais adequado para listas pequenas ou parcialmente ordenadas.
    
    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
    
    O algoritmo Bubble Sort é computacionalmente simples e fácil de implementar, mas não é eficiente para grandes conjuntos de dados devido à sua complexidade quadrática.

    - **Memória**: O(1)
      - O Bubble Sort é um algoritmo in-place, significando que ele requer apenas uma quantidade constante de espaço adicional para a troca de elementos.
    - **Eficiência**:
      - Embora não seja eficiente para grandes conjuntos de dados, é um bom ponto de partida para o ensino de algoritmos de ordenação.
    - **Limitações**:
      - Ineficiência para grandes conjuntos de dados devido à sua complexidade O(n^2).
      - Existe uma limitação de desempenho em comparação com algoritmos mais avançados como Merge Sort ou Quick Sort.
    
    </br>
    </details>

    - #### **Algoritmo 05:**
    Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Insertion Sort (Ordenação por Inserção).
      
    <!------------------------------------------------------------------------------>

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos05/Alg05.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>

    <details>
    <summary>História:</summary>
    
    O Insertion Sort, ou ordenação por inserção, é um algoritmo de ordenação simples e intuitivo, frequentemente ensinado como introdução a algoritmos de ordenação. Este algoritmo é inspirado na forma como as pessoas normalmente ordenam cartas em suas mãos. Desde sua concepção, o Insertion Sort tem sido utilizado para conjuntos de dados pequenos e parcialmente ordenados devido à sua simplicidade e eficiência relativa nestes contextos. O conceito básico do Insertion Sort pode ser traçado até os métodos manuais de organização de dados antes da era dos computadores.</br></br>

    O Insertion Sort é um algoritmo de ordenação simples e direto, ideal para fins educacionais e para conjuntos de dados pequenos ou parcialmente ordenados. Sua implementação fácil e a compreensão intuitiva fazem dele uma ferramenta útil para introduzir conceitos de algoritmos de ordenação. No entanto, para aplicações práticas com grandes conjuntos de dados, algoritmos mais eficientes como Merge Sort, Quick Sort ou Heap Sort são preferíveis devido às suas melhores performances em termos de complexidade temporal.

    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
    
    O Insertion Sort é um algoritmo de ordenação que constrói a lista ordenada de um array, um elemento por vez. Ele percorre a lista não ordenada e insere cada novo elemento na posição correta na lista ordenada, repetindo este processo até que toda a lista esteja ordenada.</br></br>
    
    **Funcionamento:**
    1. Começa com o segundo elemento do array (o primeiro elemento é considerado ordenado).
    2. Compara o segundo elemento com o primeiro e o insere na posição correta.
    3. Prossegue para o terceiro elemento, comparando-o com os elementos anteriores e inserindo-o na posição correta.
    4. Repete esse processo até que todos os elementos estejam na posição correta.
    
    **Estrutura do Algoritmo:**
    - **Entrada**: Um array de inteiros.
    - **Saída**: O mesmo array de inteiros, mas ordenado em ordem crescente.

    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
    
    A análise de complexidade temporal do Insertion Sort é fundamental para entender sua eficiência:
    - **Melhor Caso**: O(n)
      - Ocorre quando o array já está ordenado. O algoritmo percorre a lista uma vez, realizando comparações, mas sem trocas.
    - **Pior Caso**: O(n^2)
      - Ocorre quando o array está em ordem inversa. O algoritmo precisa fazer o número máximo de comparações e trocas em cada inserção.
    - **Caso Médio**: O(n^2)
      - Em média, o algoritmo realiza um número significativo de comparações e trocas, similar ao pior caso.
    
    A complexidade quadrática torna o Insertion Sort ineficiente para grandes conjuntos de dados, mas ele é bastante eficiente para listas pequenas ou parcialmente ordenadas.
    
    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
    
    O Insertion Sort é computacionalmente simples e fácil de implementar, o que o torna útil para conjuntos de dados pequenos e aplicações onde a simplicidade do código é crucial.
    - **Memória**: O(1)
      - O Insertion Sort é um algoritmo in-place, significando que ele requer apenas uma quantidade constante de espaço adicional para a inserção dos elementos.
    - **Eficiência**:
      - O Insertion Sort é mais eficiente do que algoritmos quadráticos em muitos casos práticos devido ao seu desempenho superior em listas pequenas e parcialmente ordenadas.
    - **Limitações**:
      - Ineficiência para grandes conjuntos de dados devido à sua complexidade O(n^2).
      - Não é adequado para listas muito grandes ou completamente desordenadas.
    
    </br>
    </details>

    - #### **Algoritmo 06:**
    Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Selection Sort (Ordenação por Seleção).
      
    <!------------------------------------------------------------------------------>

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos06/Alg06.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>

    <details>
    <summary>História:</summary>
    
    O Selection Sort, ou ordenação por seleção, é um algoritmo de ordenação que data da década de 1950 e é um dos algoritmos mais básicos estudados em ciência da computação. A ideia fundamental por trás do Selection Sort é simples e intuitiva: encontrar o menor (ou maior) elemento em uma lista e movê-lo para a posição correta. Apesar de sua simplicidade, o Selection Sort não é o mais eficiente para grandes conjuntos de dados devido à sua complexidade. No entanto, sua implementação fácil e a clareza do conceito fazem dele um bom ponto de partida para a compreensão de algoritmos de ordenação.</br></br>

    O Selection Sort é um algoritmo de ordenação simples e direto, ideal para fins educacionais e para conjuntos de dados pequenos. Embora seja ineficiente para grandes conjuntos de dados devido à sua complexidade quadrática, sua implementação fácil e a compreensão intuitiva fazem dele uma ferramenta útil para introduzir conceitos de algoritmos de ordenação. Para aplicações práticas com grandes conjuntos de dados, algoritmos mais avançados e eficientes como Quick Sort, Merge Sort ou Heap Sort são recomendados devido às suas melhores performances em termos de complexidade temporal.

    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
    
    O Selection Sort é um algoritmo de ordenação que opera selecionando repetidamente o menor (ou maior) elemento de uma lista não ordenada e movendo-o para a posição correta na lista ordenada.</br></br>

    **Funcionamento:**    
    1. O algoritmo percorre a lista inteira para encontrar o menor (ou maior) elemento.
    2. Troca esse elemento com o primeiro elemento da lista não ordenada.
    3. Reduz o problema para a sublista que resta, repetindo o processo até que toda a lista esteja ordenada.
    
    **Estrutura do Algoritmo:**
    - **Entrada**: Um array de inteiros.
    - **Saída**: O mesmo array de inteiros, mas ordenado em ordem crescente.

    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
    
    A análise de complexidade temporal do Selection Sort é importante para entender sua eficiência:
    - **Melhor Caso**: O(n^2)
      - Mesmo quando o array está já ordenado, o Selection Sort ainda faz O(n^2) comparações para encontrar o menor elemento a cada iteração.
    - **Pior Caso**: O(n^2)
      - O pior caso ocorre quando o array está em ordem inversa, e o algoritmo ainda precisa realizar O(n^2) comparações e trocas.
    - **Caso Médio**: O(n^2)
      - Em média, o número de comparações e trocas realizadas é O(n^2).
    
    O Selection Sort é ineficiente para grandes conjuntos de dados devido à sua complexidade quadrática. No entanto, ele é útil para conjuntos de dados pequenos e quando a simplicidade da implementação é mais importante do que a eficiência.
    
    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
    
    O Selection Sort é um algoritmo simples e fácil de entender, que utiliza um número constante de operações de troca e comparação para ordenar os dados.
    - **Memória**: O(1)
      - O Selection Sort é um algoritmo in-place, significando que ele requer apenas uma quantidade constante de espaço adicional para as trocas de elementos.
    - **Eficiência**:
      - Apesar de sua complexidade O(n^2), o Selection Sort pode ser adequado para listas pequenas ou situações onde a simplicidade é preferida.
    - **Limitações**:
      - Ineficiência para grandes conjuntos de dados devido à sua complexidade O(n^2).
      - Não é o algoritmo mais eficiente comparado a outros métodos como Quick Sort ou Merge Sort para listas maiores.
    
    </br>
    </details>

    - #### **Algoritmo 07:**
    Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Quick Sort (Ordenação Rápida).

    <!------------------------------------------------------------------------------>

      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos07/Alg07.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>

    <details>
    <summary>História:</summary>
    
    O Quick Sort, também conhecido como "Ordenação Rápida", foi desenvolvido por C.A.R. Hoare em 1959 e publicado em 1961. Ele é um dos algoritmos de ordenação mais populares e amplamente utilizados devido à sua eficiência e simplicidade. O Quick Sort revolucionou a forma como os dados eram ordenados na época, destacando-se por sua abordagem baseada em divisão e conquista (divide and conquer). Uma curiosidade interessante é que Hoare desenvolveu o Quick Sort enquanto trabalhava em um compilador de tradução de uma linguagem de programação e estava procurando uma maneira eficiente de classificar os dados.
    
    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
    
    O Quick Sort é um algoritmo de ordenação que utiliza o paradigma de divisão e conquista. Ele trabalha dividindo repetidamente um array em sub-arrays menores, que são então ordenados de forma independente.

    **Funcionamento:**
     - **Escolha do Pivô**: O algoritmo escolhe um elemento como pivô para particionar o array.
     - **Particionamento**: Os elementos menores que o pivô são movidos para a esquerda, e os maiores para a direita.
     - **Recursão**: O processo é então repetido recursivamente para os sub-arrays à esquerda e à direita do pivô, até que todos os sub-arrays tenham sido ordenados.

    **Estrutura do Algoritmo:**
     - **Entrada**: Um array de inteiros e os índices de início e fim do array.
     - **Saída**: O mesmo array de inteiros, mas ordenado em ordem crescente.
    
    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
    
    A análise da complexidade temporal do Quick Sort é fundamental para compreender sua eficiência:

    **Melhor Caso**: O(n log n)
     - O melhor caso ocorre quando o pivô divide o array em duas metades aproximadamente iguais, resultando em uma árvore de recursão balanceada.

    **Pior Caso**: O(n^2)
     - O pior caso ocorre quando o pivô escolhido é o menor ou maior elemento, causando uma divisão extremamente desbalanceada (e.g., quando o array já está ordenado ou em ordem inversa).

    **Caso Médio**: O(n log n)
     - Na média, o Quick Sort tende a criar divisões relativamente equilibradas, resultando em uma complexidade de tempo O(n log n).

    Comparado a outros algoritmos de ordenação, o Quick Sort é considerado eficiente para a maioria dos casos, especialmente quando implementado com otimizações como a escolha aleatória do pivô ou técnicas de mediana.
    
    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
    
    O Quick Sort é um algoritmo eficiente e amplamente utilizado na prática, devido às suas características de computabilidade:

    **Memória**: O(log n)
     - O Quick Sort é um algoritmo in-place, o que significa que ele ordena os dados no próprio array sem necessitar de espaço adicional significativo, exceto para a pilha de recursão.

    **Eficiência**:
     - O Quick Sort é frequentemente mais rápido na prática do que outros algoritmos de complexidade O(n log n) como Merge Sort, especialmente porque a constante associada ao Quick Sort é menor e ele possui melhor localidade de referência.

    **Paralelismo**:
     - O Quick Sort pode ser paralelizado, dividindo o trabalho de ordenação entre múltiplos processadores, o que o torna ainda mais atrativo para sistemas modernos.

    **Limitações**:
     - O pior caso de O(n^2) ainda é uma preocupação, embora mitigável por estratégias de escolha de pivô.
     - Como algoritmo recursivo, ele pode sofrer com problemas de pilha se a profundidade da recursão for muito grande.
    
    </br>
    </details>

    - #### **Algoritmo 08:**
    Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Merge Sort (Ordenação por Mistura/Mesclagem).
      
    <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos08/Alg08.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>

    <details>
    <summary>História:</summary>
    
    O Merge Sort, ou Ordenação por Mistura/Mesclagem, foi desenvolvido por John von Neumann em 1945. É um dos primeiros algoritmos de ordenação baseados no conceito de divisão e conquista. Von Neumann, um dos matemáticos mais influentes do século 20, foi um pioneiro na teoria dos algoritmos e na arquitetura dos computadores. O Merge Sort se destaca pela sua robustez e eficiência, especialmente em cenários que envolvem grandes quantidades de dados.</br></br>

    Uma curiosidade sobre o Merge Sort é que ele é uma das primeiras aplicações práticas do conceito de “divide and conquer” (dividir para conquistar), que se tornou um paradigma fundamental na ciência da computação. Além disso, é um dos algoritmos de ordenação que garantem uma complexidade de tempo estável no pior caso, o que o torna confiável em termos de desempenho.
    
    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
    
    O Merge Sort é um algoritmo de ordenação que utiliza o método de divisão e conquista para ordenar um array. </br></br>
    
    **O algoritmo segue os seguintes passos:**
      - **Divisão**: O array é dividido em duas metades.
      - **Conquista**: Cada metade é ordenada recursivamente.
      - **Mesclagem**: As duas metades ordenadas são mescladas para produzir um array ordenado.

    **Estrutura do Algoritmo**
      - **Divisão**: O array é dividido em duas partes aproximadamente iguais. Se o array tem tamanho 1 ou menor, ele já está ordenado.
      - **Ordenação Recursiva**: Cada metade do array é ordenada de forma recursiva.
      - **Mesclagem**: As metades ordenadas são combinadas em um array ordenado usando a função `merge`.
    
    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
    
    A análise da complexidade temporal do Merge Sort é crucial para entender sua eficiência:</br></br>

    - **Melhor Caso**: O(n log n)
      - O Merge Sort sempre realiza o mesmo número de operações, independentemente do estado inicial do array, resultando em uma complexidade de O(n log n) para o melhor caso.
    
    - **Pior Caso**: O(n log n)
      - O Merge Sort tem uma complexidade de O(n log n) também no pior caso, devido ao processo de divisão e mesclagem, que ocorre em todas as situações.
    
    - **Caso Médio**: O(n log n)
      - O Merge Sort mantém uma complexidade de O(n log n) no caso médio, proporcionando uma previsão de desempenho consistente.
    
    </br>

    O Merge Sort é frequentemente comparado a algoritmos como o Quick Sort. Embora o Quick Sort tenha uma complexidade média de O(n log n), ele pode ter um pior caso de O(n^2), enquanto o Merge Sort garante O(n log n) no pior caso.
        
    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
    
    O Merge Sort é um algoritmo estável e eficiente que se destaca em vários aspectos:</br></br>

    - **Memória**: O(n)
      - O Merge Sort não é um algoritmo in-place, pois requer espaço adicional para as metades do array durante o processo de mesclagem. O espaço extra necessário é O(n), onde n é o tamanho do array.
    
    - **Eficiência**:
      - A eficiência do Merge Sort o torna adequado para grandes conjuntos de dados e para aplicações onde a estabilidade (manter a ordem dos elementos iguais) é importante. 
    
    - **Paralelismo**:
      - O Merge Sort pode ser paralelizado eficientemente. As divisões do array podem ser feitas em paralelo, e a mesclagem pode ser distribuída entre múltiplos processadores.
    
    - **Limitações**:
      - O principal inconveniente do Merge Sort é o uso de memória adicional, o que pode ser uma limitação em sistemas com restrições de memória.
    
    </br>
    </details>
    
  </br></br>


  - ### *Algoritmos de **`Pesquisa/Busca`** de Estruturas Estáticas*
    - #### **Algoritmo 09:**
    Algoritmo de Pesquisa/Busca para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Busca Sequencial (sem a utilização de variável/sentinela).

    <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos09"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos09/Alg09.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos09/Alg09.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos09/Alg09.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos09/Alg09.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos09/Alg09.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos09/Alg09.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>

    <details>
    <summary>História:</summary>
    
    A busca sequencial, também conhecida como busca linear, é um dos algoritmos de busca mais simples e diretos. A história desse algoritmo remonta aos primórdios da ciência da computação, quando os primeiros computadores e algoritmos foram desenvolvidos. Sua simplicidade e facilidade de implementação o tornam um ponto de partida ideal para estudantes e profissionais que estão aprendendo sobre algoritmos de busca. </br></br>

    Curiosamente, a busca sequencial é frequentemente comparada à busca binária, que é mais eficiente para listas ordenadas. Enquanto a busca binária requer uma lista ordenada e uma abordagem mais complexa, a busca sequencial é extremamente flexível, podendo ser aplicada a listas desordenadas sem requisitos adicionais.
    
    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
    
    A busca sequencial é um algoritmo utilizado para localizar um valor em um array. Ela percorre o array do início ao fim, comparando cada elemento com o valor procurado até encontrar uma correspondência ou atingir o final do array.</br></br>

    **Funcionamento do Algoritmo**
      - **Percorrer o Array**: O algoritmo inicia na primeira posição do array e percorre cada elemento sequencialmente.
      - **Comparar Valores**: Para cada elemento, verifica se ele corresponde ao valor procurado.
      - **Retornar Índice**: Se encontrar uma correspondência, retorna o índice do elemento encontrado.
      - **Retornar Resultado**: Se o valor não for encontrado após percorrer todos os elementos, retorna -1 para indicar que o valor não está presente no array.

    
    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
    
    A análise da complexidade temporal da busca sequencial é fundamental para entender sua eficiência: </br></br>

    - **Melhor Caso**: O(1)
      - O melhor cenário ocorre quando o valor procurado está na primeira posição do array. Nesse caso, o algoritmo encontra o valor imediatamente.
    
    - **Pior Caso**: O(n)
      - O pior caso ocorre quando o valor procurado está na última posição do array ou não está presente no array. Nesse cenário, o algoritmo deve percorrer todo o array.
    
    - **Caso Médio**: O(n)
      - No caso médio, o valor procurado está em uma posição aleatória, e o algoritmo, em média, precisa percorrer metade do array.

    </br>

    **Comparação com Outros Algoritmos**
    A busca sequencial é menos eficiente em comparação com algoritmos de busca mais sofisticados, como a busca binária, que tem uma complexidade de O(log n) para arrays ordenados. No entanto, a busca sequencial não requer que o array esteja ordenado, o que a torna útil em muitos cenários práticos.
    
    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
    
    A busca sequencial é um algoritmo de fácil implementação e não requer estrutura de dados complexa: </br></br>

    - **Espaço**: O(1)
      - O algoritmo utiliza uma quantidade constante de espaço adicional, independentemente do tamanho do array. Apenas algumas variáveis são usadas durante a execução.
    
    - **Eficiência**:
      - Embora a busca sequencial não seja a mais eficiente para arrays grandes, ela é extremamente simples e eficaz para arrays pequenos ou em situações onde a ordenação dos dados não é possível.
    
    - **Flexibilidade**:
      - O algoritmo pode ser aplicado a qualquer tipo de array, independentemente de sua ordenação, tornando-o muito versátil.
    
    - **Limitações**:
      - A principal limitação da busca sequencial é sua ineficiência para grandes conjuntos de dados, onde algoritmos mais avançados, como a busca binária ou algoritmos de hashing, podem ser mais apropriados.
        
    </br>
    </details>

    - #### **Algoritmo 10:**
    Algoritmo de Pesquisa/Busca para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Busca Sequencial (com a utilização de variável/sentinela).

    <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos10"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos10/Alg10.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos10/Alg10.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos10/Alg10.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos10/Alg10.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos10/Alg10.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos10/Alg10.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

    <!------------------------------------------------------------------------------>

    <details>
    <summary>História:</summary>
    <!--linha branca-->
    Texto
    <!--linha branca-->
    </br>
    </details>
  
    <details>
    <summary>Definição:</summary>
    <!--linha branca-->
    Texto
    <!--linha branca-->
    </br>
    </details>
  
    <details>
    <summary>Complexidade:</summary>
    <!--linha branca-->
    Texto
    <!--linha branca-->
    </br>
    </details>
  
    <details>
    <summary>Computabilidade:</summary>
    <!--linha branca-->
    Texto
    <!--linha branca-->
    </br>
    </details>

    - #### **Algoritmo 11:**
    Algoritmo de Pesquisa/Busca para Estruturas de Dados Lineares Estáticas (não Dinâmicas): Busca Binária.

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos11"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos11/Alg11.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos11/Alg11.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos11/Alg11.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos11/Alg11.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos11/Alg11.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos11/Alg11.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

  </br></br>


- ## *Estruturas de Dados Lineares* **Dinâmicas**
 
  - ### *Estrutura de **`Lista Ligada (ou Encadeada) Simples`***
    - #### **Algoritmo 12:**
    Estrutura de Dados Linear Dinâmica (não Estática) de Lista Ligada/Encadeada Simples (não Duplamente Ligada): Linked List (Lista Ligada).
      
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos12"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos12/Alg12.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos12/Alg12.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos12/Alg12.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos12/Alg12.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos12/Alg12.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos12/Alg12.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

  </br></br>


  - ### *Estrutura de **`Lista Duplamente Ligada (ou Duplamente Encadeada)`***
    - #### **Algoritmo 13:**
    Estrutura de Dados Linear Dinâmica (não Estática) de Lista Duplamente Ligada/Encadeada: Doubly Linked List (Lista Duplamente Ligada).

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos13"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos13/Alg13.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos13/Alg13.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos13/Alg13.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos13/Alg13.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos13/Alg13.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos13/Alg13.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

  </br></br>


  - ### *Estrutura de **`Fila Dinâmica`***
    - #### **Algoritmo 14:**
    Estrutura de Dados Linear Dinâmica (não Estática) de Fila: Queue (Fila).
      
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos14"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos/Alg14.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos/Alg14.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos/Alg14.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos/Alg14.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos/Alg14.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos/Alg14.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

  </br></br>


  - ### *Estrutura de **`Pilha Dinâmica`***
    - #### **Algoritmo 15:**
    Estrutura de Dados Linear Dinâmica (não Estática) de Pilha: Stack (Pilha).

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos15"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos15/Alg15.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos15/Alg15.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos15/Alg15.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos15/Alg15.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos15/Alg15.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos15/Alg15.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

  </br></br>


  - ### *Algoritmos de **`Classificação/Ordenação`** de Estruturas Dinâmicas*
    - #### **Algoritmo 16:**
    Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Dinâmicas (não Estáticas): Insertion Sort (Ordenação por Inserção).

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos16"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos16/Alg16.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos16/Alg16.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos16/Alg16.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos16/Alg16.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos16/Alg16.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos16/Alg16.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 17:**
    Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Dinâmicas (não Estáticas): Counting Sort (Ordenação por Contagem).

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos17"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos17/Alg17.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos17/Alg17.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos17/Alg17.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos17/Alg17.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos17/Alg17.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos17/Alg17.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 18:**
    Algoritmo de Classificação/Ordenação para Estruturas de Dados Lineares Dinâmicas (não Estáticas): Bucket Sort (Ordenação por Balde).

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos18"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos18/Alg18.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos18/Alg18.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos18/Alg18.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos18/Alg18.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos18/Alg18.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos18/Alg18.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

  </br></br>


  - ### *Algoritmos de **`Pesquisa/Busca`** de Estruturas Dinâmicas*
    - #### **Algoritmo 19:**
    Algoritmo de Pesquisa/Busca para a Estrutura de Dados Linear Dinâmica (não Estática) Lista Ligada (ou Encadeada) Simples: Busca em Lista Ligada.

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos19"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos19/Alg19.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos19/Alg19.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos19/Alg19.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos19/Alg19.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos19/Alg19.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos19/Alg19.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 20:** 
    Algoritmo de Pesquisa/Busca para a Estrutura de Dados Linear Dinâmica (não Estática) Lista Duplamente Ligada (ou Duplamente Encadeada): Busca em Lista Duplamente Ligada.

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos20"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos20/Alg20.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos20/Alg20.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos20/Alg20.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos20/Alg20.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos20/Alg20.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos20/Alg20.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

</br><hr></br>


# **Algoritmos de Estruturas de Dados Não Lineares**

- ## *Estruturas de Dados Não Lineares* **Estáticas**
 
  - ### *Estruturas de **`Árvores Binárias`** Estáticas*
    - #### **Algoritmo 21:**
    Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).
      
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos21"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos21/Alg21.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos21/Alg21.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos21/Alg21.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos21/Alg21.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos21/Alg21.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos21/Alg21.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 22:** 
    Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária: Árvore AVL.
      
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos22"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos22/Alg22.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos22/Alg22.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos22/Alg22.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos22/Alg22.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos22/Alg22.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos22/Alg22.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 23:**
    Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Binária: Árvore Rubro-Negra.
      
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos23"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos23/Alg23.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos23/Alg23.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos23/Alg23.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos23/Alg23.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos23/Alg23.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos23/Alg23.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>
      
  </br></br>


  - ### *Estruturas de **`Árvores Não-Binárias`** Estáticas*
    - #### **Algoritmo 24:** 
    Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Não-Binária: Árvore B.
      
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos24"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos24/Alg24.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos24/Alg24.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos24/Alg24.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos24/Alg24.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos24/Alg24.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos24/Alg24.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 25:** 
    Estrutura de Dados Não Linear Estática (não Dinâmica) de Árvore Não-Binária: Árvore B+.

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos25"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos25/Alg25.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos25/Alg25.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos25/Alg25.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos25/Alg25.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos25/Alg25.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos25/Alg25.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>
      
  </br></br>


  - ### *Algoritmos de Estrutura de **`Grafo`** Estática*
    - #### **Algoritmo 26:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Largura (Breadth-First Search - BFS).
    
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos26"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos26/Alg26.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos26/Alg26.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos26/Alg26.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos26/Alg26.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos26/Alg26.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos26/Alg26.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 27:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Busca em Profundidade (Depth-First Search - DFS).
    
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos27"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos27/Alg27.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos27/Alg27.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos27/Alg27.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos27/Alg27.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos27/Alg27.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos27/Alg27.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 28:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Dijkstra.
    
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos28"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos28/Alg28.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos28/Alg28.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos28/Alg28.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos28/Alg28.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos28/Alg28.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos28/Alg28.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 29:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Bellman-Ford.
    
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos29"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos29/Alg29.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos29/Alg29.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos29/Alg29.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos29/Alg29.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos29/Alg29.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos29/Alg29.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 30:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Kruskal.
    
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos30"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos30/Alg30.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos30/Alg30.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos30/Alg30.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos30/Alg30.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos30/Alg30.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos30/Alg30.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 31:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Prim.
    
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos31"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos31/Alg31.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos31/Alg31.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos31/Alg31.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos31/Alg31.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos31/Alg31.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos31/Alg31.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 32:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Estática (não Dinâmica) de Grafo: Floyd-Warshall.
    
      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos32"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos32/Alg32.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos32/Alg32.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos32/Alg32.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos32/Alg32.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos32/Alg32.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos32/Alg32.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

  </br></br>


- ## *Estruturas de Dados Não Lineares* **Dinâmicas**
 
  - ### *Estruturas de **`Árvores Binárias`** Dinâmicas* 
    - #### **Algoritmo 33:** 
    Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore de Busca Binária (Binary Search Tree - BST).

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos33"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos33/Alg33.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos33/Alg33.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos33/Alg33.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos33/Alg33.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos33/Alg33.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos33/Alg33.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 34:** 
    Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore AVL.

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos34"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos34/Alg34.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos34/Alg34.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos34/Alg34.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos34/Alg34.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos34/Alg34.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos34/Alg34.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 35:** 
    Estrutura de Dados Não Linear Dinâmica (não Estática) de Árvore Binária: Árvore Rubro-Negra.

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos35"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos35/Alg35.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos35/Alg35.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos35/Alg35.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos35/Alg35.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos35/Alg35.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos35/Alg35.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>
  </br></br>


  - ### *Algoritmos de Estrutura de **`Grafo`** Dinâmica*
    - #### **Algoritmo 36:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Largura (Breadth-First Search - BFS).

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos36"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos36/Alg36.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos36/Alg36.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos36/Alg36.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos36/Alg36.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos36/Alg36.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos36/Alg36.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 37:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Busca em Profundidade (Depth-First Search - DFS).

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos37"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos37/Alg37.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos37/Alg37.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos37/Alg37.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos37/Alg37.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos37/Alg37.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos37/Alg37.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 38:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Dijkstra.

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos38"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos38/Alg38.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos38/Alg38.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos38/Alg38.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos38/Alg38.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos38/Alg38.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos38/Alg38.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 39:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Bellman-Ford.

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos39"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos39/Alg39.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos39/Alg39.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos39/Alg39.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos39/Alg39.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos39/Alg39.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos39/Alg39.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>

    - #### **Algoritmo 40:** 
    Algoritmo de implementação da Estrutura de Dados Não Linear Dinâmica (não Estática) de Grafo: Floyd-Warshall.

      <!------------------------------------------------------------------------------>
      
      | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/tree/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos40"><img align="center" alt="GitHub" width="35" src="https://github.com/devicons/devicon/blob/master/icons/github/github-original.svg"></a>*&nbsp;Repositórios:* | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos40/Alg40.cpp"><img align="center" alt="C++" width="35" src="https://github.com/devicons/devicon/blob/master/icons/c/c-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos40/Alg40.java"><img align="center" alt="Java" width="35" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos40/Alg40.js"><img align="center" alt="JavaScript" width="35" src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos40/Alg40.php"><img align="center" alt="PHP" width="35" src="https://github.com/devicons/devicon/blob/master/icons/php/php-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos40/Alg40.py"><img align="center" alt="Python" width="35" src="https://github.com/devicons/devicon/blob/master/icons/python/python-original.svg"></a> | <a href="https://github.com/LoukasLoukanos/Ciencia-da-Computacao/blob/master/Complementar%20-%20Estruturas%20de%20dados%20(Did%C3%A1tico)/Algoritmos40/Alg40.rb"><img align="center" alt="Ruby" width="35" src="https://github.com/devicons/devicon/blob/master/icons/ruby/ruby-original.svg"></a> |
      |:-:|:-:|:-:|:-:|:-:|:-:|:-:|

      <!------------------------------------------------------------------------------>
  </br></br>
