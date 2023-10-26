n, k = map(int, input().split())
arr = sorted(list(map(int, input().split())))
ans = []
check = []
visited = [0]*n

def dfs():
    if len(ans) == k:
        if ans not in check:
            new_ans = ' '.join(map(str, ans))
            if new_ans not in check:
                print(new_ans, end=" ")
                check.append(new_ans)
                print()
        return
    for i in range(n):
        if visited[i] == 0:
            ans.append(arr[i])
            visited[i] = 1
            dfs()
            ans.pop()
            visited[i] = 0

dfs()
