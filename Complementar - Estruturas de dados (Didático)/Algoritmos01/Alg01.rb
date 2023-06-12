class Alg01
    def initialize
      @elementos = []
      @sc = Scanner.new($stdin)
  
      print 'Tamanho: '
      tamanho = @sc.nextInt
      raise 'O tamanho do Vetor precisa ser maior que zero!' unless tamanho > 0
  
      print "Tipo de dados: digite 'p' para primitivos → [byte, short, int, long, float, double, char, boolean] ou 'np' para não primitivos → [string] ..."
      @sc.nextLine
      tipo_de_dado = @sc.nextLine
      raise "Aceita-se 'p' ou 'np' como parâmetro!" unless tipo_de_dado == 'p' || tipo_de_dado == 'np'
  
      if tipo_de_dado == 'p'
        print 'Defina o tipo primitivo (byte, short, int, long, float, double, char, boolean): '
        tipo = @sc.nextLine
  
        if %w[byte short int long float double char boolean].include?(tipo)
          begin
            clazz = Object.const_get("Java::JavaLang::#{tipo.capitalize}")
            @elementos = Array.new(tamanho, clazz)
            vetor = Alg01.new(@elementos)
            puts "Vetor do tipo de dados #{tipo} de #{tamanho} células alocadas."
          rescue NameError
            puts 'Tipo de dado inválido!'
          end
        else
          puts 'Tipo de dado inválido!'
        end
      elsif tipo_de_dado == 'np'
        @elementos = Array.new(tamanho, '')
        vetor = Alg01.new(@elementos)
        puts "Vetor do tipo de dados String de #{tamanho} células alocadas."
      else
        puts 'Tipo de dado inválido!'
      end
    end
  
    def inserir(indice, valor)
      @elementos[indice] = valor
    end
  
    def valor(indice)
      @elementos[indice]
    end
  end
  
  # Código adicional, se necessário
  