#Objetivo: deverá retornar para o usuário qual foi o critério e o preço do desconto que obteve.

#PARA ANÁLISE: 
#RELAÇÃO DE ENTRADA X CÁLCULO DOS CRITÉRIOS. →OBS: •=(MENOR VALOR OU ÚNICO DIFERENTE RETORNADO PELAS CONDIÇÕES)
#A entrada de:  2 = 8     /   5 = 8,75  /  de  6 = 9     /  de  7 = 9,25   /  de 20 =  12,5   / de 21 = •12,75
#B entrada de:  2 = 3,5   /   5 = 5     /  de  6 = 5,5   /  de  7 =•6      /  de 20 =  12,5   / de 21 =  13,0
#C entrada de:  2 = •2,8  /   5 = •4,75 /  de  6 = •5,4  /  de  7 = 6,05   /  de 20 = •14,5   / de 21 =  15,15

from tkinter import *
import pygame.mixer

root = Tk()
root.title("CALCULADOR DE DESCONTOS PARA BOLETO")
root.geometry('800x445+250+120')
root.configure(background="#0f003a", padx=5)

photo = PhotoImage(file='img.png')
l1 = Label(root, 
           text="Informe a quantidade de livros que irá adquirir por meio de pagamento com boleto para obter descontos:",
           font="arial 11 bold italic", #arial(formato), 9(tamanho), bold(negrito), italic...
           fg="#ffffff", #fg "de Font_Ground?" (cor do texto)
           bg="#0f003a", #bg de Back_Graund (cor do fundo)
           padx=0, #(X)para expansão laterais de preenchimento  
           pady=18, #(Y)para expansão superior e inferior de preenchimento 
           image=photo, 
           compound='bottom'
           )
l1.pack(side='top')

l2 = Label(root, 
           text='Quantidade:', 
           font="arial 11 bold italic", #arial(formato), 10(tamanho), bold(negrito), italic...
           fg="#ffffff", #fg "de Font_Ground?" (cor do texto)
           bg="#0f003a", #bg de Back_Graund (cor do fundo)
           )
l2.pack(side='top')

#caixa de entrada
entry = Entry(root, 
              font="arial 10 bold", #arial(formato), 9(tamanho), bold(negrito)
              fg="#000000", #fg "de Font_Ground?" (cor do texto)
              bg="#ffffff", #bg de Back_Graund (cor do fundo)
              width=12#largura da caixa de texto, diferente de padx(para expansão laterais(eixoX) de preenchimento)
              )
entry.pack(side='top',
           pady=1 #(Y)para expansão superior e inferior de preenchimento
           )

#-------------------------------------------------------------------------------
#envia a entrada do usuário para a função critérios para receber um retorno dela
def send_to_funcion_criterions():
    entry_user = int(entry.get()) #'get' pega o retorno de 'entry', ou seja, o que foi inserido na caixa de entrada(entry). Isto é atribuido '=' a entrada do usuário(entry_user)
    amount_books = entry_user #quantidade de livros(amount_books) é = a entrada da usuário(entry_user)
    response_to_the_user = criterions(amount_books) #a resposta ao usuário(response_to_the_user) é = o retorno da função critérions(que recebe 'amount_books' como parâmetro e retorna um valor)

    if  amount_books > 0:
        sounds = pygame.mixer #objeto'sounds' criado para a biblioteca 'pygame.mixer'
        sounds.init() #inicia o objeto
        correct_s = sounds.Sound("1.wav") #atribui a música.wav às configurações da biblioteca pygame. Isto é = correct_s
        correct_s.play() #liga a música

        appearAnswer = IntVar() #variável inteiro
        appearAnswer.set(response_to_the_user)#insere o valor(respponse_to_the_user), obtido pelo retorno da função criterions(), à variável 'apperAnswer'
        l3 = Label(root,
                   font="arial 8 bold italic", #arial(formato), 8(tamanho), bold(negrito), italic...
                   fg="#ffffff", #fg "de Font_Ground?" (cor do texto)
                   height=2,#altura da caixa de texto dos caracteres, não dos caracteres
                   bg="#0f003a", #bg de Back_Graund (cor do fundo da caixa de texto)
                   textvariable=appearAnswer, #associa '=' à 'appearAnswer'(valor obtido pelo retorno da função criterions())
                   width=110, #borda x
                   padx=10, #borda y
                   pady=10
                   )
        l3.place(x=0, y=370) # lugar x,y ...

    else: #se for = 0 ou -(valores negaticos)
        sounds = pygame.mixer #objeto'sounds' criado para a biblioteca 'pygame.mixer'
        sounds.init() #inicia o objeto
        correct_s = sounds.Sound("0.wav") #atribui a música.wav às configurações da biblioteca pygame. Isto é = correct_s
        correct_s.play() #liga a música

        appearAnswer = IntVar() #variável inteiro
        appearAnswer.set(response_to_the_user)#insere o valor(respponse_to_the_user), obtido pelo retorno da função criterions(), à variável 'apperAnswer'
        l4 = Label(root,
                   font="arial 8 bold italic", #arial(formato), 8(tamanho), bold(negrito), italic...
                   fg="#ffffff", #fg "de Font_Ground?" (cor do texto)
                   height=2,#altura da caixa de texto dos caracteres, não dos caracteres
                   bg="#0f003a", #bg de Back_Graund (cor do fundo da caixa de texto)
                   textvariable=appearAnswer, #associa '=' à 'appearAnswer'(valor obtido pelo retorno da função criterions())
                   width=110,#largura da caixa de texto dos caracteres, não dos caracteres
                   padx=10, #borda x
                   pady=10 #borda y
                   )
        l4.place(x=0, y=370) # lugar x,y ...
#---------------------------------------------------------------------------------------------

#'command=send_to_funcion_criterions'  →  executa a função 'send_to_funcion_criterions' quando este botão de nome 'CALCULAR' é cliclado 
button = Button(root, 
                text='CALCULAR', 
                font="arial 8 bold", #arial(formato), 9(tamanho), bold(negrito)
                fg="#ffffff", #cor dos caracteres
                height=1,#altura  
                width=11,#largura 
                bg="#3e3260", #bg de Back_Graund (cor do fundo)
                command=send_to_funcion_criterions)
button.pack(side='top',  
            pady=3)

#---------------------------------------------------------------------------------------------
def criterions(amount_books):
    if amount_books < 0:
        msg1 = str("Informe a quantidade corretamente.")
        return(msg1)
    else:
        if amount_books == 0:
            msg2 = str("Não há desconto.")
            return(msg2)
        else:
            if amount_books > 0:
                criterion_A = float(0.25) * int(amount_books)
                criterion_A = criterion_A + float(7.5)

                criterion_B = float(0.5) * int(amount_books)
                criterion_B = criterion_B + float(2.5)

                criterion_C = float(0.65) * int(amount_books)
                criterion_C = criterion_C + float(1.5)
                
                #caso coloque espaços dentro de'' o retorno é gerado com'{}' ao ser enviado para tkinter e 
                #associado à IntVar e não é possível formatar o valor após retornado, mesmo que crie função 
                #para isso, pois é o 'textvariable' do Label do tkinter que gera'{}' por ser associado à InteVar, 
                #portanto foi criado uma string sem espaços para cada palavra para todas serem enviadas corretamente...
                a = str('Pelos')
                b = str('critérios')
                c = str('estabelecidos,')
                d = str('esta')
                e = str('quantidade')
                f = str('é')
                g = str('multiplicada')
                h = str('por')
                i1 = str('0.25')#(criterion_A)
                i2 = str('0.5') #(criterion_B)
                i3 = str('0.65')#(criterion_C)
                j = str('e')
                k = str('somada')
                l = str('a')
                m1 = str('7.5')#(criterion_A)
                m2 = str('2.5')#(criterion_B)
                m3 = str('1.5')#(criterion_C)
                n = str('.')
                o = str('Portanto,')
                p = str('você')
                q = str('obterá')
                #valor obtido no critério(criterion_A)
                #valor obtido no critério(criterion_B)
                #valor obtido no critério(criterion_C)
                r = str('reais')
                s = str('de')
                t = str('desconto.')

                if criterion_A == criterion_B:#entrada de '20' = 14,5  → para testar
                    return(a,b,c,d,e,f,g,h,i3,j,k,l,m3,n,o,p,q,criterion_C,r,s,t)#(criterion_C)
                else:
                    if criterion_A == criterion_C:
                        return(a,b,c,d,e,f,g,h,i2,j,k,l,m2,n,o,p,q,criterion_B,r,s,t)#(criterion_B)
                    else:
                        if criterion_B == criterion_C:
                            return(a,b,c,d,e,f,g,h,i1,j,k,l,m1,n,o,p,q,criterion_A,r,s,t)#(criterion_A)
                        else:
                            if float(criterion_A) < float(criterion_B) < float(criterion_C):#entrada de '21' = 12,75  → para testar
                                return(a,b,c,d,e,f,g,h,i1,j,k,l,m1,n,o,p,q,criterion_A,r,s,t)#(criterion_A)
                            else:
                                if float(criterion_B) < float(criterion_C) < float(criterion_A):#entrada de '7' = 6  → para testar
                                    return(a,b,c,d,e,f,g,h,i2,j,k,l,m2,n,o,p,q,criterion_B,r,s,t)#(criterion_B)
                                else:
                                    if float(criterion_C) < float(criterion_A) < float(criterion_B):#entrada de '2' = 2,8  → para testar
                                        return(a,b,c,d,e,f,g,h,i3,j,k,l,m3,n,o,p,q,criterion_C,r,s,t)#(criterion_C)
                                    else:
                                        if float(criterion_A) > float(criterion_B) > float(criterion_C):#entrada de '2' = 2,8  → para testar
                                            return(a,b,c,d,e,f,g,h,i3,j,k,l,m3,n,o,p,q,criterion_C,r,s,t)#(criterion_C)
                                        else:
                                            if float(criterion_B) > float(criterion_C) > float(criterion_A):#entrada de '21' = 12,75  → para testar
                                                return(a,b,c,d,e,f,g,h,i1,j,k,l,m1,n,o,p,q,criterion_A,r,s,t)#(criterion_A)
                                            else:
                                                if float(criterion_C) > float(criterion_A) > float(criterion_B):#entrada de '7' = 6  → para testar
                                                    return(a,b,c,d,e,f,g,h,i2,j,k,l,m2,n,o,p,q,criterion_B,r,s,t)#(criterion_B)
#----------------------------------------------------------------------------------------------------------------

root.mainloop()
