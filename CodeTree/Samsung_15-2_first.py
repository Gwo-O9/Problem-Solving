n = int(input())

clients = list(map(int, input().split()))

master, slave = map(int, input().split())

total = n

for client in clients:
    client -= master
    if client > 0:
        total += client // slave
        if client % slave > 0:
            total += 1

print(total)