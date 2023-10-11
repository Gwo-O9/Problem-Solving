import math

room = int(input())
students = list(map(int, input().split()))
B, C = map(int, input().split())
cnt = room

for student in students:
    student -= B
    if student < 1:
        continue
    cnt += math.ceil(student/C)

print(cnt)
