mod_val = 1000000007


def matrix_mul(a, b):
    c = [[0] * 2 for _ in range(2)]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                c[i][j] += a[i][k] * b[k][j] % mod_val
    return c


def power(a, n):
    if n == 1:
        return a
    elif n % 2 == 1:
        tmp = power(a, n // 2)
        return matrix_mul(matrix_mul(tmp, tmp), a)
    else:
        tmp = power(a, n // 2)
        return matrix_mul(tmp, tmp)


n = int(input())
print(power(([[1, 1], [1, 0]]), n)[0][1] % mod_val) if n > 0 else print(0)
