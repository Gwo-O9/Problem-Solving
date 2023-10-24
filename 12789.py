from collections import deque

n = int(input())
line = list(map(int, input().split()))
q1 = deque() #원래 줄: 넣은 순서대로 빠짐
q2 = deque() #새 줄: 넣은 순서 역순으로 빠짐
count = 1

for i in range(n):
    q1.append(line[i])

while (q1 or q2) and count != n:
    found = False
    if q2 and q2[-1] == count:
        q2.pop()
        count += 1
        found = True
        continue
    while q1:
        if q1[0] == count:
            q1.popleft()
            count += 1
            found = True
            break
        else:
            q2.append(q1.popleft())
    if not found:
        break

print("Nice") if count == n else print("Sad")
