from io import TextIOBase
from os import write
from tkinter import *
from tkinter import ttk
import tkinter.messagebox


tk = Tk()
tk.title("none")
tk.geometry('100x100+1000+1000')#largura x altura, +X(→) +Y(↓)
response = tkinter.messagebox.askyesnocancel(title="PIC-BCC ATIVIDADE 2", message="Deseja cadastrar novos cidadãos?\n\n\n'Sim' para novos cadastros e análise de estatísticas.\n'Não' para símples conferência.")
tk.destroy()

compulsory_votes = open("data_base_compulsory_votes.txt")
compulsory_votes = compulsory_votes.read()
compulsory_votes = int(compulsory_votes)
optional_votes = open("data_base_optional_votes.txt")
optional_votes = optional_votes.read()
optional_votes = int(optional_votes)
not_voter = open("data_base_not_voter.txt")
not_voter = not_voter.read()
not_voter = int(not_voter)

#SALVAR DADOS-------------------------------------
def save_data_base():
    #deletar e salvar no documento "data_base_compulsory_votes.txt"
    forr_delete_data_base_compulsory_votes = open("data_base_compulsory_votes.txt")
    forr_delete_data_base_compulsory_votes.close
    forr_delete_data_base_compulsory_votes = forr_delete_data_base_compulsory_votes.read()
    forr_delete_data_base_compulsory_votes = int(forr_delete_data_base_compulsory_votes)

    forr_delete_data_base_compulsory_votes = open("data_base_compulsory_votes.txt", "w")#"W" limpa o contreúdo do arquivo
    forr_delete_data_base_compulsory_votes.close

    for_new_data_base_compulsory_votes = open("data_base_compulsory_votes.txt", "a")
    for_new_data_base_compulsory_votes.write("%d" % (compulsory_votes))
    for_new_data_base_compulsory_votes.close

    #deletar e salvar no documento "data_base_optional_votes.txt"
    forr_delete_data_base_optional_votes = open("data_base_optional_votes.txt")
    forr_delete_data_base_optional_votes.close
    forr_delete_data_base_optional_votes = forr_delete_data_base_optional_votes.read()
    forr_delete_data_base_optional_votes = int(forr_delete_data_base_optional_votes)

    forr_delete_data_base_optional_votes = open("data_base_optional_votes.txt", "w")
    forr_delete_data_base_optional_votes.close

    for_new_data_base_optional_votes = open("data_base_optional_votes.txt", "a")
    for_new_data_base_optional_votes.write("%d" % (optional_votes))
    for_new_data_base_optional_votes.close

    #deletar e salvar no documento "data_base_not_voter.txt"
    forr_delete_data_base_not_voter = open("data_base_not_voter.txt")
    forr_delete_data_base_not_voter.close
    forr_delete_data_base_not_voter = forr_delete_data_base_not_voter.read()
    forr_delete_data_base_not_voter = int(forr_delete_data_base_not_voter)

    forr_delete_data_base_not_voter = open("data_base_not_voter.txt", "w")
    forr_delete_data_base_not_voter.close

    for_new_data_base_not_voter = open("data_base_not_voter.txt", "a")
    for_new_data_base_not_voter.write("%d" % (not_voter))
    for_new_data_base_not_voter.close


def main_function():
    new_register = Tk()
    new_register.title("PIC-BCC ATIVIDADE 2")
    new_register.geometry('600x590+350+70') #largura x altura, +X(→) +Y(↓)
    new_register.configure(background="#e7e7e7", padx=1, pady=1) #padx(X)para expansão laterais de preenchimento,  pady(Y)para expansão superior e inferior de preenchimento

#-------------------(em 'main_function()') → imagens-topo 
    photo1 = PhotoImage(file='img1.png')
    label_photo = Label(new_register, bg="#e7e7e7", image=photo1, compound='bottom')
    label_photo.place(x=180, y=18)# x e y do posicionamento do vértice superior esquerdo, sempre...

    photo2 = PhotoImage(file='img2.png')
    label_photo = Label(new_register, bg="#e7e7e7", image=photo2, compound='bottom')
    label_photo.place(x=318, y=63)

#-------------------(em 'main_function()') → frame-principal(encapsula todos os outros frames), frame-1(sem bordas com label"Controle de eleitores...")
    frame_label_main = Frame(new_register, borderwidth=1, relief="flat",background="#e7e7e7") #relief=flat,raised,sunke,solid(tipo de borda)
    frame_label_main.place(x=25, y=140, width=550) #width(largura do frame)

    label_main = Label(frame_label_main, text="Controle de eleitores do município de Curitiba, PR.", font="arial 15 bold italic", fg="#e00000", bg="#e7e7e7", padx=1, pady=3) #font='arial(formato),9(tamanho),bold(negrito), italic...',  fg de "Font_Ground"(cor do texto),  bg de "Back_Graund"(cor do fundo),  padx(X)para expansão laterais de preenchimento,  pady(Y)para expansão superior e inferior de preenchimentO.
                     
    label_main.pack(side='top')

    frame_main = Frame(new_register, borderwidth=1, relief="sunke",background="#e7e7e7")
    frame_main.place(x=25, y=186,height=360, width=550)

#-------------------(em 'main_function()') → sub-rotina'button_adc_age()' recebe a entrada do usuário e a envia como parâmetro para a função'criterions()' que retorna os números de cidadãos eleitores e não eleitores. Contém, também, as sub-rotinas e seus respectivos botões BUTTON-SAVE e BUTTON-RESET
    def button_adc_age():
        entry_user = int(entry_age.get()) #'get' pega o retorno de 'entry', ou seja, o que foi inserido na caixa de entrada(entry). Isto é atribuido '=' a entrada do usuário(entry_user)
        age_citizen = entry_user #a entrada do usuário é = idade do cidadão
        if age_citizen < 0 or age_citizen >= 117:
            tkinter.messagebox.showinfo(title="Idade inválida!", message="Informe a idade corretamente!")
        else:
            def forr_simple_statistics():
                check_criterions_and_retur_total_citizens = criterions(age_citizen)

                label_msg = Label(frame_statistics,                                            
                                  text="▪ População do município de Curitiba:   \n▪ Cidadãos no qual o voto é obrigatório:\n▪ Cidadãos no qual o voto é facultativo:  \n▪ Cidadãos no qual não são eleitores:   ", fg="#000000", font="arial 9", bg="#ffffff")
                label_msg.place(x=2, y=8)
                
                forr_label_total_citizens = StringVar()
                forr_label_total_citizens.set(check_criterions_and_retur_total_citizens)
                label_total_citizens = Label(frame_statistics, textvariable= forr_label_total_citizens, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
                label_total_citizens.place(x=218, y=9)

                forr_label_compulsory_votes = StringVar()
                forr_label_compulsory_votes.set(compulsory_votes)
                label_compulsory_votes = Label(frame_statistics, textvariable=forr_label_compulsory_votes, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
                label_compulsory_votes.place(x=218, y=24)

                forr_label_optional_votes = StringVar()
                forr_label_optional_votes.set(optional_votes)
                label_optional_votes = Label(frame_statistics, textvariable=forr_label_optional_votes, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
                label_optional_votes.place(x=218, y=39)

                forr_label_not_voter = StringVar()
                forr_label_not_voter.set(not_voter)
                label_not_voter = Label(frame_statistics, textvariable=forr_label_not_voter, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
                label_not_voter.place(x=218, y=54)
            
            def forr_advanced_statistics():
                check_criterions_and_retur_total_citizens = criterions(age_citizen)
                #ESTATÍSTICA:
                #       |VOTO(xi):  |FRENQUÊNCIA(fi):                         |FREQUÊNCIA RELATIVA(fri):            |PORCENTAGEM(fr%i):      |
                #       |-----------|-----------------------------------------|-------------------------------------|------------------------|
                #       |Obrigatório|compulsory_votes                         |relative__frequently_compulsory_votes|porcent_compulsory_votes|
                #       |Facultativo|optional_votes                           |relative__frequently_optional_votes  |porcent_optional_votes  |
                #       |Não vota   |not_votes                                |relative__frequently_not_voter       |porcent_not_voter       |
                #       |Total      |check_criterions-and_retur_total_citizens|1.0                                  |100                     |

                #FREQUÊNCIA RELATIVA(fri):
                relative__frequently_compulsory_votes = compulsory_votes/check_criterions_and_retur_total_citizens
                relative__frequently_optional_votes = optional_votes/check_criterions_and_retur_total_citizens
                relative__frequently_not_voter = not_voter/check_criterions_and_retur_total_citizens
                #|Total|                    = |1.0|

                #PORCENTAGEM(fr%i): 
                # regras de três:
                #                 ↑ check_criterions_and_retur_total_citizens       =       100(%)                      ↑
                #                 ↑                          compulsory_votes       =       porcent_compulsory_votes(%) ↑
                #                                                                   
                #      check_criterions_and_... * porcent_compulsory_votes(%)       =       compulsory_votes * 100(%)
                #                                                                   
                #                               → porcent_compulsory_votes(%)       =      (compulsory_votes * 100(%))/check_criterions_and_retur_total_citizens 
                porcent_compulsory_votes = (100*compulsory_votes)/check_criterions_and_retur_total_citizens
                porcent_optional_votes = (100*optional_votes)/check_criterions_and_retur_total_citizens
                porcent_not_voter = (100*not_voter)/check_criterions_and_retur_total_citizens

                #TABELA 'tree' no frame_advanced_statistics
                tree = ttk.Treeview(frame_advanced_statistics, selectmode="browse", column=("colum_n1", "colum_n2", "colum_n3", "colum_n4"), show='headings')
            
                tree.column("colum_n1", width=70, minwidth=70, stretch=NO)
                tree.heading("#1", text='Voto(xi)')# "#1" → para a coluna n°1, o texto(nome) 'Voto(xi)'

                tree.column("colum_n2", width=85, minwidth=30, stretch=NO)
                tree.heading("#2", text='Frequência (fi)')

                tree.column("colum_n3", width=85, minwidth=30, stretch=NO)
                tree.heading("#3", text='Frequência Relativa (fri)')

                tree.column("colum_n4", width=85, minwidth=30, stretch=NO)
                tree.heading("#4", text='Porcentagem (fr%_i)')
                
                line_1 = ["Obrigatório", compulsory_votes, relative__frequently_compulsory_votes, porcent_compulsory_votes]
                line_2 = ["Facultativo", optional_votes, relative__frequently_optional_votes, porcent_optional_votes]
                line_3 = ["Não vota", not_voter, relative__frequently_not_voter, porcent_not_voter]
                line_4 = ["Total", check_criterions_and_retur_total_citizens, 1.0, 100]

                tree.insert("", END, values=line_1, tag='1')#"tag='1'" → linha n°1,   "values=line_1" → para o array(line_1)
                tree.insert("", END, values=line_2, tag='2')
                tree.insert("", END, values=line_3, tag='3')
                tree.insert("", END, values=line_4, tag='4')
                tree.grid(row=0, column=0)



                #MÉDIA ARITMÉTICA
                #MODA:
                #    • Nenhuma moda – Amodal
                #    • Uma moda – Unimodal ou modal
                #    • Duas Modas – Bimodal
                #    • Mais de duas modas – Polimonal
                #MEDIANA(md)

            if not_appear_ask_again.get() == "off":
                ask_again = tkinter.messagebox.askquestion(title="Idade registrada com sucesso!", message="Deseja adicionar nova idade?\n\n'Sim' para um novo registro\n'Não' para mostrar estatísticas")
                if not_appear_ask_again.get() == "off" and advanced_or_simple_statistics.get() == "off" and ask_again == 'no':

                    #'frame_statistics'(aparecerá com valores) → para sobrepor o 'frame_statistics_false'(apareceria sem valores), o que deverá ocorrer nesta condicional.
                    frame_statistics = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff") #relief="flat,raised,sunke,solid"(tipo de borda)
                    frame_statistics.place(x=135, y=340, height=80, width=330)

                    #'frame_advanced_statistics_false'(aparecerá sem valores) → para sobrepor 'frame_advanced_statistics'(apareceria com valores), o que deverá ocorrer nesta condicional.
                    frame_advanced_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
                    frame_advanced_statistics_false.place(x=135, y=420, height=110, width=330)

                    forr_simple_statistics()#soma os valores e "gera-os" apenas no quadro de 'simple_statistics'.

                elif not_appear_ask_again.get() == "off" and advanced_or_simple_statistics.get() == "off" and ask_again == 'yes':

                    #'frame_statistics_false'(aparecerá sem valores) → para sobrepor 'frame_statistics'(apareceria com valores), o que deverá ocorrer nesta condicional.
                    frame_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff")
                    frame_statistics_false.place(x=135, y=340, height=80, width=330)

                    #'frame_advanced_statistics_false'(aparecerá sem valores) → para sobrepor 'frame_advanced_statistics'(apareceria com valores), o que deverá ocorrer nesta condicional.
                    frame_advanced_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
                    frame_advanced_statistics_false.place(x=135, y=420, height=110, width=330)

                    criterions(age_citizen)#apenas soma os valores, não "gerando-os" em nenhum dos quadros estatísticos.

                elif not_appear_ask_again.get() == "off" and advanced_or_simple_statistics.get() == "on" and ask_again == 'no':

                    #'frame_statistics_false'(aparecerá sem valores) → para sobrepor 'frame_statistics'(apareceria com valores), o que deverá ocorrer nesta condicional.
                    frame_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
                    frame_statistics_false.place(x=135, y=340, height=80, width=330)

                    #'frame_advanced_statistics'(aparecerá com valores) → para sobrepor 'frame_advanced_statistics_false'(apareceria sem valores), o que deverá ocorrer nesta condicional.
                    frame_advanced_statistics = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff")
                    frame_advanced_statistics.place(x=135, y=420, height=110, width=330)

                    forr_advanced_statistics()#soma os valores e "gera-os" apenas no quadro de 'advanced_statistics'.
                
                else:
                    if not_appear_ask_again.get() == "off" and advanced_or_simple_statistics.get() == "on" and ask_again == 'yes':

                        #'frame_statistics_false'(aparecerá sem valores) → para sobrepor 'frame_statistics'(apareceria com valores), o que deverá ocorrer nesta condicional.
                        frame_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
                        frame_statistics_false.place(x=135, y=340, height=80, width=330)
                        
                        #'frame_advanced_statistics_false'(aparecerá sem valores) → para sobrepor 'frame_advanced_statistics'(apareceria com valores), o que deverá ocorrer nesta condicional.
                        frame_advanced_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff")
                        frame_advanced_statistics_false.place(x=135, y=420, height=110, width=330)

                        criterions(age_citizen)#apenas soma os valores, não "gerando-os" em nenhum dos quadros estatísticos.
                    
            else:#(se not_appear_ask_again.get() == "on":)
                if not_appear_ask_again.get() == "on" and advanced_or_simple_statistics.get() == "off":

                    #'frame_statistics'(aparecerá com valores) → para sobrepor 'frame_statistics_false'(apareceria sem valores), o que deverá ocorrer nesta condicional.
                    frame_statistics = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff")
                    frame_statistics.place(x=135, y=340, height=80, width=330)
                    
                    #'frame_advanced_statistics_false'(aparecerá sem valores) → para sobrepor 'frame_advanced_statistics'(apareceria com valores), o que deverá ocorrer nesta condicional.
                    frame_advanced_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
                    frame_advanced_statistics_false.place(x=135, y=420, height=110, width=330)

                    forr_simple_statistics()#soma os valores e "gera-os" apenas no quadro de 'simple_statistics'.

                else:
                    if not_appear_ask_again.get() == "on" and advanced_or_simple_statistics.get() == "on":

                        #'frame_statistics_false'(aparecerá sem valores) → para sobrepor 'frame_statistics'(apareceria com valores), o que deverá ocorrer nesta condicional.
                        frame_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
                        frame_statistics_false.place(x=135, y=340, height=80, width=330)
                        
                        #'frame_advanced_statistics_false'(aparecerá sem valores) → para sobrepor 'frame_advanced_statistics'(apareceria com valores), o que deverá ocorrer nesta condicional.
                        frame_advanced_statistics = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff")
                        frame_advanced_statistics.place(x=135, y=420, height=110, width=330)
                        
                        forr_advanced_statistics()#soma os valores e "gera-os" apenas no quadro de 'advanced_statistics'.

            #BUTTON-SAVE e BUTTON-RESET
            if int(compulsory_votes) or int(optional_votes) or int(not_voter) != 0:
                #RESETAR DADOS-------------------------------------
                def reset_everything():
                    global check_criterions_and_retur_total_citizens
                    check_criterions_and_retur_total_citizens = 0

                    global compulsory_votes
                    compulsory_votes = 0
       
                    global optional_votes
                    optional_votes = 0
  
                    global not_voter
                    not_voter = 0

                    frame_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff")
                    frame_statistics_false.place(x=135, y=340, height=80, width=330)
                    advanced_or_simple_statistics.set("off")
                    frame_advanced_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
                    frame_advanced_statistics_false.place(x=135, y=420, height=110, width=330)
                    not_appear_ask_again.set("off")

                    save_data_base()

                button_reset = Button(new_register, text='Resetar', font="arial 7 bold", fg="#e7e7e7", height=1, width=6, bg="#000000", command=reset_everything)
                button_reset.place(x=540, y=10)

                button_save = Button(new_register, text='Salvar', font="arial 7 bold", fg="#e7e7e7", bg="#000000", height=1, width=6, command=save_data_base)
                button_save.place(x=490, y=10)

    def criterions(age_citizen):
        global compulsory_votes
        global optional_votes
        global not_voter
        if age_citizen >= 18 and age_citizen <= 69:
            compulsory_votes = compulsory_votes + 1
        elif age_citizen == 16 or age_citizen == 17 or age_citizen >= 70:
            optional_votes = optional_votes + 1
        else: #('if' age_citizen < 16):
            not_voter = not_voter + 1 
        total_citizens = compulsory_votes + optional_votes + not_voter
        return(int(total_citizens))

#-------------------(em 'main_function()') → frame-2(sem bordas com label'Adicionar a idade de...')
    frame_age_info = Frame(new_register, borderwidth=1, relief="flat",background="#e7e7e7")
    frame_age_info.place(x=250, y=191,height=23, width=100)

    label_age_info = Label(frame_age_info, text="Adicione a idade", font="arial 9 bold", fg="#005dff", bg="#e7e7e7", padx=0, pady=5)
    label_age_info.pack(side='top')

#-------------------(em 'main_function()') → frame-3(contendo entrada do usuário, caixa-entry, label"idade", Button'ok' e CheckBurron'Adicionar sem perguntar' )
    frame_entry = Frame(new_register, borderwidth=1, relief="sunke",background="#e7e7e7") #relief=flat,raised,sunke,solid(tipo de borda)
    frame_entry.place(x=170, y=214,height=100, width=260)

    label_age = Label(frame_entry, text="Idade:", font="arial 8 italic", fg="#000000", bg="#e7e7e7")
    label_age.place(x=78, y=30)

    entry_age = Entry(frame_entry, font="arial 8 bold", fg="#000000", bg="#e7e7e7", width=3) #'width' largura em caracteres da caixa de texto
    entry_age.place(x=117, y=30)
    
    but_adc = Button(frame_entry, text='Ok', font="arial 6 bold", fg="#515151", bg="#e7e7e7", height=1, width=5, command=button_adc_age)
    but_adc.place(x=110, y=50)

    not_appear_ask_again = StringVar()#Modelo do tipo Variável-String
    not_appear_ask_again.set("off")#valor "off" inserido no modelo
    box_button = Checkbutton(frame_entry, text="Adicionar sem perguntar e mostrar estatísticas", font="arial 7", onvalue="on", offvalue="off", background="#e7e7e7", variable=not_appear_ask_again)
    box_button.place(x=20, y=72)

#-------------------(em 'main_function()') → janela-adicionar-quantidade(contém todas as dunções, frames e botão da janela)
    def forr_section():
        section = Tk()
        section.title("Adicionar por quantidade")
        section.geometry('300x100+500+291')#posicionar sobrepondo o botão e tirar as opçoes de nome, minimizar, maximizar e fechar da janela....
        section.configure(background="#e7e7e7", padx=10, pady=16)

        entry_age_section = Entry(section, font="arial 8 bold", fg="#000000", bg="#e7e7e7", width=3) #'width' largura em caracteres da caixa de texto
        entry_age_section.place(x=145, y=25)

        entry_amount_section = Entry(section, font="arial 8 bold", fg="#000000", bg="#e7e7e7", width=8) #'width' largura em caracteres da caixa de texto
        entry_amount_section.place(x=145, y=0)

        label_entry_age_section = Label(section, text="Idade:", font="arial 8 italic", fg="#000000", bg="#e7e7e7")
        label_entry_age_section.place(x=106, y=25)

        label_entry_amount_section = Label(section, text="Quantidade:", font="arial 8 italic", fg="#000000", bg="#e7e7e7")
        label_entry_amount_section.place(x=76, y=0)

        def button_adc_agexsection():
            advanced_or_simple_statistics.set("off")

            #é preciso definir o botão 'salvar' dentro da sub-rotina 'for-section()' para e ele apareça caso a primeira ação feita pelo usuário seja adicionar em quantidade
            button_save = Button(new_register, text='Salvar', font="arial 7 bold", fg="#e7e7e7", bg="#000000", height=1, width=6, command=save_data_base)
            button_save.place(x=490, y=10)

            #RESETAR DADOS(necessário declarar novamente pois está em outra tk..)-------------------------------------
            def forr_section_reset_everything():
                global check_criterions_and_retur_total_citizens
                check_criterions_and_retur_total_citizens = 0

                global compulsory_votes
                compulsory_votes = 0
    
                global optional_votes
                optional_votes = 0
  
                global not_voter
                not_voter = 0

                frame_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff")
                frame_statistics_false.place(x=135, y=340, height=80, width=330)
                advanced_or_simple_statistics.set("off")
                frame_advanced_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
                frame_advanced_statistics_false.place(x=135, y=420, height=110, width=330)
                not_appear_ask_again.set("off")

                save_data_base()

            #assim como o botão 'salvar', o botão 'resetar' deve ser aqui definido.
            button_reset = Button(new_register, text='Resetar', font="arial 7 bold", fg="#e7e7e7", height=1, width=6, bg="#000000", command=forr_section_reset_everything)
            button_reset.place(x=540, y=10)

            age_section = int(entry_age_section.get())
            amount_section = int(entry_amount_section.get())

            global compulsory_votes
            global optional_votes
            global not_voter
            if age_section >= 18 and age_section <= 69:
                compulsory_votes = compulsory_votes + amount_section
            elif age_section == 16 or age_section == 17 or age_section >= 70:
                optional_votes = optional_votes + amount_section
            else: #('if' age_citizen < 16):
                not_voter = not_voter + amount_section 
            total_citizens = compulsory_votes + optional_votes + not_voter

            frame_statistics = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff")
            frame_statistics.place(x=135, y=340, height=80, width=330)
                        
            frame_advanced_statistics_false = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
            frame_advanced_statistics_false.place(x=135, y=420, height=110, width=330)

            label_msg = Label(frame_statistics,                                            
                                  text="▪ População do município de Curitiba:   \n▪ Cidadãos no qual o voto é obrigatório:\n▪ Cidadãos no qual o voto é facultativo:  \n▪ Cidadãos no qual não são eleitores:   ", fg="#000000", font="arial 9", bg="#ffffff")
            label_msg.place(x=2, y=8)
            
            forr_label_total_citizens = StringVar()
            forr_label_total_citizens.set(total_citizens)
            label_total_citizens = Label(frame_statistics, textvariable= forr_label_total_citizens, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
            label_total_citizens.place(x=218, y=9)

            forr_label_compulsory_votes = StringVar()
            forr_label_compulsory_votes.set(compulsory_votes)
            label_compulsory_votes = Label(frame_statistics, textvariable=forr_label_compulsory_votes, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
            label_compulsory_votes.place(x=218, y=24)

            forr_label_optional_votes = StringVar()
            forr_label_optional_votes.set(optional_votes)
            label_optional_votes = Label(frame_statistics, textvariable=forr_label_optional_votes, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
            label_optional_votes.place(x=218, y=39)

            forr_label_not_voter = StringVar()
            forr_label_not_voter.set(not_voter)
            label_not_voter = Label(frame_statistics, textvariable=forr_label_not_voter, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
            label_not_voter.place(x=218, y=54)
                        
            section.destroy()
            return(int(total_citizens))

        but_adc_section = Button(section, text='Cadastrar', font="arial 6 bold", fg="#515151", bg="#e7e7e7", height=1, width=8, command=button_adc_agexsection)
        but_adc_section.place(x=120, y=50)

    label_adc_section = Label(frame_main, text="Adicione quantidades\ncom a mesma idade", font="arial 7", fg="#000000", bg="#e7e7e7")
    label_adc_section.place(x=27, y=54)
    but_adc_section = Button(frame_main, text='Novo', font="arial 6 bold", fg="#515151", bg="#e7e7e7", height=1, width=8, command=forr_section)
    but_adc_section.place(x=50, y=82)


#-------------------(em 'main_function()') → frame-4(sem bordas com label"Estatísticas")
    frame_statistics_info = Frame(new_register, borderwidth=1, relief="flat",background="#e7e7e7")
    frame_statistics_info.place(x=135, y=317, height=23, width=330)

    label_statistics_info = Label(frame_statistics_info, text="Estatísticas", font="arial 9 bold", fg="#005dff", bg="#e7e7e7", padx=1, pady=5) #padx(X)para expansão laterais de preenchimento(p além de width),  pady(Y)para expansão superior e inferior de preenchimento(p além de height)
    label_statistics_info.pack(side='top')

#-------------------(em 'main_function()') → frame-5 e frame-6(contendo os retornos estetísticos e rádio-botões com seus modelos)
    frame_statistics = Frame(new_register, borderwidth=1, relief="sunke", background="#ffffff")
    frame_statistics.place(x=135, y=340, height=80, width=330)

    advanced_or_simple_statistics = StringVar()#Modelo do tipo Variável-String
    advanced_or_simple_statistics.set("off")#valor "off" inserido no modelo

    Off_radio_button_advanced_statistics = Radiobutton(frame_main, text="Simples", font="arial 7", variable=advanced_or_simple_statistics, value="off", background="#e7e7e7")
    Off_radio_button_advanced_statistics.place(x=20, y=185)
    on_radio_button_advanced_statistics = Radiobutton(frame_main, text="Avançado", font="arial 7", variable=advanced_or_simple_statistics, value="on", background="#e7e7e7")
    on_radio_button_advanced_statistics.place(x=20, y=274)
        
    frame_advanced_statistics = Frame(new_register, borderwidth=1, relief="sunke", background="#e7e7e7")
    frame_advanced_statistics.place(x=135, y=420, height=110, width=330)

    new_register.mainloop()

if response == True: #(botão 'Sim') 'True' é o valor lógico que é retornado ao clicar no botão 'Sim'
    main_function()
else:
    if response == False: #(botão 'Não') 'False' é o valor lógico que é retornado ao clicar no botão 'Não'
        statistic_analysis = Tk()
        statistic_analysis.title("PIC-BCC ATIVIDADE 2")
        statistic_analysis.geometry('580x400+350+70') 
        statistic_analysis.configure(background="#e7e7e7", padx=1, pady=1)

#------------------------(em 'if response == False') → imagens-topo  
        photo1 = PhotoImage(file='img1.png')
        label_photo = Label(statistic_analysis, bg="#e7e7e7", image=photo1, compound='bottom')
        label_photo.place(x=180, y=18)

        photo2 = PhotoImage(file='img2.png')
        label_photo = Label(statistic_analysis, bg="#e7e7e7", image=photo2, compound='bottom')
        label_photo.place(x=318, y=63)

#------------------------(em 'if response == False') → frame-principal
        frame_label_main = Frame(statistic_analysis, borderwidth=1, relief="flat",background="#e7e7e7")
        frame_label_main.place(x=40, y=140, width=500)

        label_main = Label(frame_label_main, text="Controle de eleitores do município de Curitiba, PR.", font="arial 15 bold italic", fg="#000000", bg="#e7e7e7", padx=1, pady=3)
        label_main.pack(side='top')

        frame_main = Frame(statistic_analysis, borderwidth=1, relief="sunke",background="#e7e7e7") 
        frame_main.place(x=40, y=186,height=150, width=500)

#------------------------(em 'if response == False') → frame-statisticas-simples

        total = compulsory_votes + optional_votes + not_voter

        frame_statistics = Frame(statistic_analysis, borderwidth=1, relief="sunke", background="#ffffff")
        frame_statistics.place(x=135, y=220, height=80, width=330)

        label_msg = Label(frame_statistics, text="▪ População do município de Curitiba:   \n▪ Cidadãos no qual o voto é obrigatório:\n▪ Cidadãos no qual o voto é facultativo:  \n▪ Cidadãos no qual não são eleitores:   ", font="arial 9", fg="#000000", bg="#ffffff")
        label_msg.place(x=2, y=8)

        forr_label_total_citizens = StringVar()
        forr_label_total_citizens.set(total)
        label_total_citizens = Label(frame_statistics, textvariable=forr_label_total_citizens, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
        label_total_citizens.place(x=218, y=9)

        forr_label_compulsory_votes = StringVar()
        forr_label_compulsory_votes.set(compulsory_votes)
        label_compulsory_votes = Label(frame_statistics, textvariable=forr_label_compulsory_votes, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
        label_compulsory_votes.place(x=218, y=24)

        forr_label_optional_votes = StringVar()
        forr_label_optional_votes.set(optional_votes)
        label_optional_votes = Label(frame_statistics, textvariable=forr_label_optional_votes, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
        label_optional_votes.place(x=218, y=39)

        forr_label_not_voter = StringVar()
        forr_label_not_voter.set(not_voter)
        label_not_voter = Label(frame_statistics, textvariable=forr_label_not_voter, fg="#000000", font="arial 8 italic", bg="#ffffff", width=9)
        label_not_voter.place(x=218, y=54)

        def retur_to_initial_question():
            response = tkinter.messagebox.askyesnocancel(title=None, message="Deseja cadastrar novos cidadãos?\n\n\n'Sim' para novos cadastros e análise de estatísticas.\n'Cancelar' para sair.")
            if response == True:
                statistic_analysis.destroy()
                main_function()
            if response == None:
                statistic_analysis.destroy()

        button_adc_new = Button(statistic_analysis, text='Adicionar Novos', font="arial 7 bold", fg="#e7e7e7", height=1, width=12, bg="#000000", command=retur_to_initial_question)
        button_adc_new.place(x=254, y=340)

        def reset_everything():
            global total
            total = 0

            global compulsory_votes
            compulsory_votes = 0
       
            global optional_votes
            optional_votes = 0
  
            global not_voter
            not_voter = 0

            frame_statistics_false = Frame(statistic_analysis, borderwidth=1, relief="sunke", background="#ffffff")
            frame_statistics_false.place(x=135, y=220, height=80, width=330)
            
            #______mesmas funções da sub-rotina'save_data_base()' pois é necessário salvar os valores zerados após resetar______
            #deletar e salvar no documento "data_base_compulsory_votes.txt"
            forr_delete_data_base_compulsory_votes = open("data_base_compulsory_votes.txt")
            forr_delete_data_base_compulsory_votes.close
            forr_delete_data_base_compulsory_votes = forr_delete_data_base_compulsory_votes.read()
            forr_delete_data_base_compulsory_votes = int(forr_delete_data_base_compulsory_votes)

            forr_delete_data_base_compulsory_votes = open("data_base_compulsory_votes.txt", "w")#"W" limpa o contreúdo do arquivo
            forr_delete_data_base_compulsory_votes.close

            for_new_data_base_compulsory_votes = open("data_base_compulsory_votes.txt", "a")
            for_new_data_base_compulsory_votes.write("%d" % (compulsory_votes))
            for_new_data_base_compulsory_votes.close

            #deletar e salvar no documento "data_base_optional_votes.txt"
            forr_delete_data_base_optional_votes = open("data_base_optional_votes.txt")
            forr_delete_data_base_optional_votes.close
            forr_delete_data_base_optional_votes = forr_delete_data_base_optional_votes.read()
            forr_delete_data_base_optional_votes = int(forr_delete_data_base_optional_votes)

            forr_delete_data_base_optional_votes = open("data_base_optional_votes.txt", "w")
            forr_delete_data_base_optional_votes.close

            for_new_data_base_optional_votes = open("data_base_optional_votes.txt", "a")
            for_new_data_base_optional_votes.write("%d" % (optional_votes))
            for_new_data_base_optional_votes.close

            #deletar e salvar no documento "data_base_not_voter.txt"
            forr_delete_data_base_not_voter = open("data_base_not_voter.txt")
            forr_delete_data_base_not_voter.close
            forr_delete_data_base_not_voter = forr_delete_data_base_not_voter.read()
            forr_delete_data_base_not_voter = int(forr_delete_data_base_not_voter)

            forr_delete_data_base_not_voter = open("data_base_not_voter.txt", "w")
            forr_delete_data_base_not_voter.close

            for_new_data_base_not_voter = open("data_base_not_voter.txt", "a")
            for_new_data_base_not_voter.write("%d" % (not_voter))
            for_new_data_base_not_voter.close
            
        button_reset = Button(statistic_analysis, text='Resetar', font="arial 7 bold", fg="#e7e7e7", height=1, width=6, bg="#000000", command=reset_everything)
        button_reset.place(x=520, y=10)

        mainloop()

    #else: 
    #    if resposer == None:  (botão 'Cancelar') → ('None' é o valor lógico que é retornado ao clicar no botão 'Cancelar')
    #    tk.destroy() já foi definido, portanto, caso o botão 'cancelar' seja clicado, será fechada a janela tk e finalizado o programa. 