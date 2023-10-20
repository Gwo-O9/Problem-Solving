T = int(input())

for _ in range(1, T+1):
    n = int(input())
    people = list(map(str, input().split()))
    sum = 100000000
    if n > 32:
        print(0)
        continue
    for i in range(n-2):
        for j in range(i+1, n-1):
            for k in range(j+1, n):
                cnt = 0
                for t in range(4):
                    if people[i][t] != people[j][t]:
                        cnt += 1
                    if people[i][t] != people[k][t]:
                        cnt += 1
                    if people[j][t] != people[k][t]:
                        cnt += 1
                sum = min(cnt, sum)
    print(sum)

