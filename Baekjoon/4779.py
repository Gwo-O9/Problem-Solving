def recursion(n):
    if n == 0:
        return "-"
    else:
        return recursion(n-1) + " "*len(recursion(n-1)) + recursion(n-1)

while True:
    try:
        n = int(input())
        print(recursion(n))
    except EOFError:
        break
