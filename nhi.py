import math
def func(n):
    x = 10
    e_to_10 = 0
    for i in range(n):
        e_to_10 += x**i/math.factorial(i)
    return e_to_10

out = func(10)
print(out)
