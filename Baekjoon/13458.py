N = int(input())
mans = list(map(int, input().split()))
B, C = map(int, input().split())

cnt = 0

for man in mans:
    cnt += 1
    if man - B > 0:
        cnt += (man - B) // C
        if (man -B) % C > 0:
            cnt +=1

print(cnt)
