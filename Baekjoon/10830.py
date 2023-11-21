import sys

input = sys.stdin.readline
n, b = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]


def multiply(arr1, arr2):
    A = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                A[i][j] += arr1[i][k] * arr2[k][j] % 1000
    return A


def square(index, arr):
    if index == 1:
        return arr
    tmp = square(index // 2, arr)
    if index % 2 == 0:
        return multiply(tmp, tmp)
    else:
        return multiply(multiply(tmp, tmp), matrix)


ans = square(b, matrix)
for i in range(n):
    for j in range(n):
        ans[i][j] %= 1000

for i in range(n):
    for j in range(n):
        print(ans[i][j], end=" ")
    print()
