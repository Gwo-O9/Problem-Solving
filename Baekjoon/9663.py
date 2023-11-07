n = int(input())
visited = [False]*n
occupied = [-1]*n
result = 0


def check(i):
    for j in range(i):
        if occupied[i] == occupied[j] or i-j == abs(occupied[i]-occupied[j]):
            return False
    return True


def dfs(i):
    global result, visited
    if i == n: # n개의 퀸이 모두 자리를 차지한 경우의 수
        result += 1
        return

    for j in range(n):
        if not visited[j]:
            occupied[i] = j

            if check(i):
                visited[j] = True
                dfs(i+1)
                visited[j] = False


dfs(0)
print(result)
