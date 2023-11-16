n, k = map(int, input().split())
items = [[0]*2 for _ in range(n+1)]
dp = [[0]*(k+1) for _ in range(n+1)]
for i in range(n):
    items[i][0], items[i][1] = map(int, input().split())

for i in range(n+1):
    for w in range(k+1):
        if i == 0 or w == 0: # 들 수 있는 무게각 0이거나 아이템이 없는 경우 세팅
            dp[i][w] = 0
        # 아이템을 넣을 수 있는 경우 원래 가방에 들어 있던 값과 (새 아이템 + 그거 제외한 무게로 최대 값) 비교
        elif items[i-1][0] <= w:
            dp[i][w] = max(items[i-1][1] + dp[i-1][w-items[i-1][0]], dp[i-1][w])
        # 아이템 못 넣으면 이전 값 가져오기
        else:
            dp[i][w] = dp[i - 1][w]

print(dp[n][k])
