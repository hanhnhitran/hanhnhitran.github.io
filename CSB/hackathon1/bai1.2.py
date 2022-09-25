print('input:', end='')
inp = input()
print('Capitalized:', inp.upper())
print('Capitalized: ', end='')
distance = ord('A') - ord('a')  
for ch in inp:
  if ch > 'a' and ch < 'z':
    print(chr(ord(ch) + distance), end='')
  else:
    print(ch, end='')