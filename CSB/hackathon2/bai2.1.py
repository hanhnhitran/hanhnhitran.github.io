colors = ['blue', 'teal', 'green']

print('color list:')
for color in colors [:-1]:
    print(color, end=',')
print(color[-1])

print('Input position: ', end='')
pos = int(input())

# print result
print(f'Color at position {pos}: {colors[pos-1]}')