n, k = map(int, input().split())
ans = []
check = []

def dfs():
    if len(ans) == k:
        if sorted(ans) in check:
            return
        for i in range(k):
            print(ans[i], end=" ")
        check.append(sorted(ans))
        print()
        return
    for i in range(1, n+1):
        if i in ans:
            continue
        ans.append(i)
        dfs()
        ans.pop()

dfs()
