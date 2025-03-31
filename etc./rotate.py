def rotate90(arr): # -270
    n = len(arr)
    ret = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            ret[j][n-1-i] = arr[i][j]

    return ret

def rotate180(arr):
    n = len(arr)
    ret = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            ret[n-1-i][n-1-j] = arr[i][j]

    return ret

def rotate270(arr):
    n = len(arr)
    ret = [[0 for _ in range(n)] for _ in range(n)]

    # 0,0 -> 2,0 / 0,1 -> 1,0
    for i in range(n):
        for j in range(n):
            ret[n-1-j][i] = arr[i][j]

    return ret

test = [[1,2,3], [4,5,6], [7,8,9]]

print(rotate90(test))
print(rotate180(test))
print(rotate270(test))