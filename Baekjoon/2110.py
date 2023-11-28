import sys

input = sys.stdin.readline

n, c = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))
arr.sort()

start = 1
end = arr[n - 1] - arr[0]
ans = 0
while start <= end:
    mid = (start + end) // 2
    cur = arr[0]
    cnt = 1
    for i in range(1, n):
        if arr[i] >= cur + mid:
            cur = arr[i]
            cnt += 1
    if cnt >= c:
        start = mid + 1
        ans = mid
    else:
        end = mid - 1

print(ans)
