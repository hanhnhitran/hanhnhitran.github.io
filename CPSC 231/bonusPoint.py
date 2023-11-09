n = int(input())
a = input().split()
b = []
for i in range(n): 
    b.append(int(a[i]))
b.sort()
board = []
len = 2 * b[n - 1] - 1
for i in range(len):
    temp = []
    for j in range(len):
        if(abs(i - b[n - 1] + 1) + abs(j - b[n - 1] + 1) >= b[n - 1]): temp.append(' ')
        else: temp.append(' ')
    board.append(temp)

for i in range(n):
    for j in range(b[i]):
        board[b[n - 1] - j - 1][b[n - 1] - b[i] + j] = '*'
        board[b[n - 1] - j - 1][b[n - 1] + b[i] - j - 2] = '*'
        board[b[n - 1] + j - 1][b[n - 1] - b[i] + j] = '*'
        board[b[n - 1] + j - 1][b[n - 1] + b[i] - j - 2] = '*'
	    
for i in range(len):
    temp = ""
    for j in range(len): 
        temp += board[i][j]
    print(temp)
