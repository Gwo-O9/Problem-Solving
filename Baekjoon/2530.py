import datetime
import sys

h, m, s = map(int, input().split(" "))
duration = int(input())


s += duration

if s >= 60:
    remain = s // 60
else:
    remain = 0
s %= 60

m += remain

if m >= 60:
    remain = m // 60
else:
    remain = 0
m %= 60

h += remain
h %= 24

print(h, m, s)
