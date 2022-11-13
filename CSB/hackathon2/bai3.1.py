arr = [5, 1, 8, 92, -1, 30]
print('input a number:', end = '')
num = int(input())

pos = None
for i, el in enumerate(arr):
    if el == num:
        pos = i
        break

if pos == None:
    print('Number not found')
else:
    print('Number found at position', pos+1)