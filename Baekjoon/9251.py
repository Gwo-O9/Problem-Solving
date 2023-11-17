str1 = input()
str2 = input()
n, m = len(str1), len(str2)
dp = [[0] * (m + 1) for _ in range(n + 1)]

for i in range(n + 1):
    for j in range(m + 1):
        if i == 0 or j == 0:
            continue
        elif str1[i - 1] == str2[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])


print(dp[n][m])
