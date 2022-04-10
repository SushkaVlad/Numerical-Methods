import sympy as sp
import numpy as np
import matplotlib.pyplot as plt
from sympy import Symbol


x = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
y = [5, 6, 8, 10, 12, 13, 12, 10, 8, 10, 8, 11, 7, 9, 11, 10, 9, 12, 11, 6]

a = Symbol('a')
b = Symbol('b')
c = Symbol('c')
d = Symbol('d')
e = Symbol('e')
f = Symbol('f')
g = Symbol('g')
h = Symbol('h')
i = Symbol('i')
j = Symbol('j')

eq1 = 0
for l in range(len(x)):
    eq1 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l]) * x[l] ** 9

eq2 = 0
for l in range(len(x)):
    eq2 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l]) * x[l] ** 8

eq3 = 0
for l in range(len(x)):
    eq3 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l]) * x[l] ** 7

eq4 = 0
for l in range(len(x)):
    eq4 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l]) * x[l] ** 6

eq5 = 0
for l in range(len(x)):
    eq5 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l]) * x[l] ** 5

eq6 = 0
for l in range(len(x)):
    eq6 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l]) * x[l] ** 4

eq7 = 0
for l in range(len(x)):
    eq7 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l]) * x[l] ** 3

eq8 = 0
for l in range(len(x)):
    eq8 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l]) * x[l] ** 2

eq9 = 0
for l in range(len(x)):
    eq9 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l]) * x[l]

eq10 = 0
for l in range(len(x)):
    eq10 += (a * x[l] ** 9 + b * x[l] ** 8 + c * x[l] ** 7 + d * x[l] ** 6 + e * x[l] ** 5 + f * x[l] ** 4 + g * x[
        l] ** 3 + h * x[l] ** 2 + i * x[l] + j - y[l])


solution = sp.solve((eq1, eq2, eq3, eq4, eq5, eq6, eq7, eq8, eq9, eq10), (a, b, c, d, e, f, g, h, i, j))

x_approx = np.linspace(1, 20, 20)
y_approx = (solution[a]*x_approx**9 + solution[b]*x_approx**8 + solution[c]*x_approx**7 + solution[d]*x_approx**6 + solution[e]*x_approx**5 +
            solution[f]*x_approx**4 + solution[g]*x_approx**3 + solution[h]*x_approx**2 + solution[i]*x_approx + solution[j])


plt.plot(x, y, x_approx, y_approx, '-r')
plt.grid(True)
plt.show()
print(y_approx)
eps = np.sum((y-y_approx)**2)
print('Суммарное квадратичное отклонение:', eps)