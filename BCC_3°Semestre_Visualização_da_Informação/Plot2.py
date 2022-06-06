import numpy as np
import matplotlib.pyplot as plt

fig, ax = plt.subplots(figsize=(8, 5))

sectors = [ "1059 JAVASCRIPT", 
            "647 HTML", 
            "588 SQL", 
            "583 PHP", 
            "486 CSS", 
            "458 PYTHON", 
            "448 JAVA", 
            "346 C#", 
            "250 MYSQL", 
            "210 C++" ]

quantity = [float(x.split()[0]) for x in sectors]

technology = [x.split()[-1] for x in sectors]

def func(pct, allvals):
    absolute = int(np.round(pct/100.*np.sum(allvals)))
    return "{:.1f}%\n({:d})".format(pct, absolute)

colors_ = [ '#e0f400', '#ffbb00', '#00ff55', '#c700ff', '#00a9ff', 
            '#1dff00', '#ff0f0f', '#6e00ff', '#ff5d00', '#001dff' ]

wedges, texts, autotexts = ax.pie(quantity, autopct=lambda pct: func(pct, quantity), 
                                  colors=colors_, textprops=dict(color="black"), startangle=90)

ax.legend(wedges, technology, title="Linguagens/\nTecnologias", loc="center left", bbox_to_anchor=(1, 0, 0.5, 1))

plt.setp(autotexts, size=7)

ax.set_title("Dez linguagens/tecnologias em registros de programas de computadores no Brasil em 2020")

plt.show()
