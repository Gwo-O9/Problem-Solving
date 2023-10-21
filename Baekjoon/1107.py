target = int(input())
n = int(input())
if n > 0:
    error_keys = list(map(int, input().split()))
else:
    error_keys = []
ans = abs(target - 100)

for i in range(1000001):
    str_i = str(i)
    use_broken = False

    for j in str_i:
        if int(j) in error_keys:
            use_broken = True
            break

    if not use_broken:
        ans = min(ans, abs(i - target) + len(str_i))

print(ans)
