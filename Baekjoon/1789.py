n = int(input())
cnt = 0

i = 1
while i <= n:
    n -= i
    cnt += 1
    i += 1

print(cnt)
