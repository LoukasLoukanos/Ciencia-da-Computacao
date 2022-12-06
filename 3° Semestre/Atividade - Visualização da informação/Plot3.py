from cProfile import label
import matplotlib.pyplot as plt

ordered = [230, 174, 247, 208, 199, 245, 297, 272, 291, 344, 298, 317]
months_ = ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez']

fig, ax = plt.subplots(figsize=(8, 4))
ax.plot(months_, ordered)

ax.set_ylabel('Solicitações')
ax.set_title(pad=10, label='Solicitações de registros de programas de computadores no Brasil em 2020')

plt.show()
