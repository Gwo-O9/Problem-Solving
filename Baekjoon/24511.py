import sys

n = int(sys.stdin.readline())
data_structure = list(map(int, sys.stdin.readline().split()))
data = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
push_data = list(map(int, sys.stdin.readline().split()))
cnt = m

i = n-1
while i >= 0:
    if data_structure[i] == 0:
        print(data[i], end=" ")
        cnt -= 1
    if cnt <= 0:
        break
    i -= 1

for i in range(cnt):
    print(push_data[i], end=" ")
