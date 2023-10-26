n, k = map(int, input().split())
arr = sorted(list(map(int, input().split())))
ans = []
check = []

def dfs():
    if len(ans) == k:
        new_ans = ' '.join(map(str, ans))
        if ans == sorted(ans) and new_ans not in check:
            print(new_ans)
            check.append(new_ans)
        return
    for i in range(n):
        ans.append(arr[i])
        dfs()
        ans.pop()

dfs()
