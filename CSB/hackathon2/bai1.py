colors = ['blue', 'green', 'teal']

print('color lists:')
for color in colors[:-1]:
    print(color, end=',')
print(color[-1])

print('Input a new color:', end = '')
color = input()
colors.append(color)

print('New color lists:')
for color in colors[:-1]:
    print(color, end='.')
print(color[-1])