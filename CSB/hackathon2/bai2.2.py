colors = ['blue', 'teal', 'green']

print('Color list:')
for color in colors[:-1]:
  print(color, end=', ')
print(colors[-1])

print('Item to delete: ', end='')
inp = input()

if inp[0] >= '0' and inp[0] <= '9':  
  colors.pop(int(inp)-1) 
else:                               
  colors.remove(inp)      

print('New color list:')
for color in colors[:-1]:
  print(color, end=', ')
print(colors[-1])