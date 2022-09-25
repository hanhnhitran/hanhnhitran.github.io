print('== Registration ==\n')
print('Username: ', end='')
username = input()

print('\nPassword: ', end='')
password = input()
while True:
  print('Repeat password: ', end='')
  if input() == password:
    break
  else:
    print('Passwords do not match. Please input again.')
print('\nEmail: ', end='')
email = input()

print('\nRegistered successfully.')
