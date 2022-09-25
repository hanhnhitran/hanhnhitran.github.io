from turtle import *
print('Input number of edges: ', end='')
num = int(input())

angle = (num - 2) * 180 / num
shape('turtle')
for i in range(num):
  forward(100)
  right(180-angle)

mainloop()