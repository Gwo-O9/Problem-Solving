N = int(input())

a, b, c, d, e, f = map(int, input().split())

T, P = map(int, input().split())

ans = (a//T) + (b//T) + (c//T) + (d//T) + (e//T) + (f//T)
if a%T > 0:
    ans += 1
if b%T > 0:
    ans += 1
if c%T > 0:
    ans += 1
if d%T > 0:
    ans += 1
if e%T > 0:
    ans += 1
if f%T > 0:
    ans += 1

print(ans)
print(N//P, end=" ")
print(N%P)