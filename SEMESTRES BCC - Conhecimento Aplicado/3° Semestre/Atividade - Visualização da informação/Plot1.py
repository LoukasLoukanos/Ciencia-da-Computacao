import matplotlib.pyplot as plt
import numpy as np

technology = ['C++', 'MYSQL', 'C#', 'JAVA', 'PYTHON', 'CSS', 'PHP', 'SQL', 'HTML', 'JS']
quantity = [210, 250, 346, 448, 458, 486, 583, 588, 647, 1059]

x = np.arange(len(technology))
width = 0.45

fig, ax = plt.subplots(figsize=(9, 4))

rects1 = ax.bar(x, quantity, width, color=['#001dff', '#ff5d00', '#6e00ff', '#ff0f0f', '#1dff00',
                '#00a9ff', '#c700ff', '#00ff55', '#ffbb00', '#e0f400'], edgecolor='#f0f0f0')

ax.set_ylabel('Quantidade de uso')
ax.set_title(pad=10, label='Dez linguagens/tecnologias em registros de programas de computadores no Brasil em 2020')
ax.set_xticks(x, technology)

colors_ = [ '#e0f400', '#ffbb00', '#00ff55', '#c700ff', '#00a9ff', 
            '#1dff00', '#ff0f0f', '#6e00ff', '#ff5d00', '#001dff' ]

ax.bar_label(rects1, padding=-12)

fig.tight_layout()

plt.show()
