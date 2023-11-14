n = int(input())
alcohols = [0]*(n+10)
dp = [0]*(n+10)
for i in range(n):
    alcohols[i] = int(input())
dp[0], dp[1] = alcohols[0], alcohols[0] + alcohols[1]
dp[2] = max(alcohols[0] + alcohols[1], alcohols[1] + alcohols[2], alcohols[0] + alcohols[2])
for i in range(3, n):
    dp[i] = max(dp[i-3] + alcohols[i] + alcohols[i-1], dp[i-1], dp[i-2] + alcohols[i])

print(max(dp))

# 1 2 3 4
# 1,2,3 선택 후 4에 왔을때 선택지 (뭐 고른지 모름)
# 1. 1까지 고른 거 + 3,4 선택
# 2. 건너 뛰기
# 3. 2까지 고른거 + 4 선택
