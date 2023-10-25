n = int(input())

def star(n):
    if n == 3:
        return ['***', '* *', '***']
    stars = star(n//3)
    ans = []
    for i in stars:
        ans.append(i*3)
    for i in stars:
        ans.append(i+" "*(n//3)+i)
    for i in stars:
        ans.append(i*3)
    return ans

tmp = star(n)


for i in range(n):
    for j in range(n):
        print(tmp[i][j], end="")
    print()
