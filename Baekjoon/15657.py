n, k = map(int, input().split())
arr = sorted(list(map(int, input().split())))
ans = []

def dfs():
    if len(ans) == k:
        if ans != sorted(ans):
            return
        for i in range(k):
            print(ans[i], end=" ")
        print()
        return
    for i in arr:
        ans.append(i)
        dfs()
        ans.pop()

dfs()
