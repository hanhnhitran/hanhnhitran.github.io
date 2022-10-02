print('== Registration ==\n')
print('Username: ', end='')
username = input()
password = None
while True:

  print('\nPassword: ', end='')
  password = input()
  
  has_letter = False
  has_digits = False
  for ch in password:
    if (ch > 'a' and ch < 'z') or (ch > 'A' and ch < 'Z'):  
      has_letter = True
    if ch > '0' and ch < '9':  
      has_digits = True
  
  if has_letter and has_digits and len(password) >= 8:
    break
  else:
    print('Invalid password. ', end='')

# email = none
while True:
    print('\emial:', end = '')
    email = input()

    if('.' in email) and ('@' in email):
        break
    else:
        print('invalid email', end = '')

print('\n registered succesfully')

