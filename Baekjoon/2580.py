board = [list(map(int, input().split())) for _ in range(9)]
zeros = []
for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            zeros.append((i,j))

def checkY(y, target):
    for i in range(9):
        if board[i][y] == target:
            return False
    return True

def checkX(x, target):
    for i in range(9):
        if board[x][i] == target:
            return False
    return True

def checkXY(x, y, target):
    x = x//3 * 3
    y = y//3 * 3
    for i in range(3):
        for j in range(3):
            if board[x+i][y+j] == target:
                return False
    return True

def print_board():
    for i in range(9):
        for j in range(9):
            print(board[i][j], end=" ")
        print()

def dfs(i):
    if i == len(zeros):
        print_board()
        exit(0)

    for target in range(1,10):
        x,y = zeros[i][0], zeros[i][1]
        if checkX(x, target) and checkY(y, target) and checkXY(x, y, target):
            board[x][y] = target
            dfs(i+1)
            board[x][y] = 0

dfs(0)


