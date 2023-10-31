n = int(input())

index = [[10], [1], [2, 4, 8, 6], [3, 9, 7, 1], [4, 6], [5], [6], [7, 9, 3, 1], [8, 4, 2, 6], [9, 1]]

for _ in range(n):
    a, b = map(int, input().split())
    c = a%10
    length = len(index[c])
    print(index[c][(b%length-1)])
