import sys

input = sys.stdin.readline
n = int(input())
BW = [list(map(int, input().rstrip())) for _ in range(n)]
ans = ""


def quad_tree(pic):
    global ans
    length = len(pic)
    if length == 1:
        ans += str(pic[0][0])
        return

    all_zero = all(pic[i][j] == 0 for i in range(length) for j in range(length))
    all_one = all(pic[i][j] == 1 for i in range(length) for j in range(length))

    if all_zero:
        ans += "0"
        return
    elif all_one:
        ans += "1"
        return

    mid = length // 2
    top_left = [row[:mid] for row in pic[:mid]]
    top_right = [row[mid:] for row in pic[:mid]]
    bottom_left = [row[:mid] for row in pic[mid:]]
    bottom_right = [row[mid:] for row in pic[mid:]]
    ans += "("
    quad_tree(top_left)
    quad_tree(top_right)
    quad_tree(bottom_left)
    quad_tree(bottom_right)
    ans += ")"


quad_tree(BW)
print(ans)
