n, k = map(int, input().split())
ans = []

def dfs():
    if len(ans) == k:
        for i in range(k):
            print(ans[i], end=" ")
        print()
        return
    for i in range(1, n+1):
        ans.append(i)
        dfs()
        ans.pop()

dfs()
