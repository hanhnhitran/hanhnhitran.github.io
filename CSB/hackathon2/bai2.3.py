from turtle import *

colors = ['red', 'orange', 'yellow', 'green', 'blue', 'violet']

shape('turtle')
pensize(3)
for color in colors:
  pencolor(color)   
  forward(30)
  pencolor('white')  
  forward(20)

mainloop()