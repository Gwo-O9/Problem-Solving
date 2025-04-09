from collections import deque

n, k = map(int, input().split())
q = deque(list(map(int, input().split())))
people = deque([False for _ in range(2 * n)])
time = 0

while True:
    time += 1
    q.rotate(1)
    people.rotate(1)
    people[n - 1] = False

    for i in range(n - 2, -1, -1):
        if q[i + 1] > 0 and people[i] is True and people[i + 1] is False:
            people[i + 1] = people[i]
            people[i] = False
            q[i + 1] -= 1
    people[n - 1] = False

    if people[0] is False and q[0] > 0:
        people[0] = True
        q[0] -= 1

    if q.count(0) >= k:
        break

print(time)
