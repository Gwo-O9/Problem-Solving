# n일, 기한 t, 수익 p
n = int(input())
works = []
for _ in range(n):
    t, p = map(int, input().split())
    works.append((t, p))
profit = 0


def pick_candidates(idx, cnt, now_time):
    global profit
    if idx == n or now_time == n:
        profit = max(profit, cnt)
        return

    if idx < now_time:
        idx = now_time
    pick_candidates(idx + 1, cnt, now_time + 1)
    if now_time + works[idx][0] <= n and now_time <= idx:
        pick_candidates(idx + 1, cnt + works[idx][1], now_time + works[idx][0])


pick_candidates(0, 0, 0)

print(profit)
