import sys

input = sys.stdin.readline
an, am = map(int, input().split())
A = [[0]*am for _ in range(an)]
for i in range(an):
    A[i] = list(map(int, input().split()))
bn, bm = map(int, input().split())
B = [[0]*bm for _ in range(bn)]
for i in range(bn):
    B[i] = list(map(int, input().split()))
C = [[0]*bm for _ in range(an)]

for i in range(an):
    for j in range(bm):
        for k in range(am):
            C[i][j] += A[i][k] * B[k][j]

for i in range(an):
    for j in range(bm):
        print(C[i][j], end=' ')
    print()

