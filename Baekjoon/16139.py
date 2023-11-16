import sys

input = sys.stdin.readline
sentence = input().strip()
n = int(input())
frequency = [[0]*26 for _ in range(len(sentence))]
i = 0
for alphabet in sentence:
    if i > 0:
        frequency[i][ord(alphabet)-97] += 1
        for j in range(26):
            frequency[i][j] += frequency[i - 1][j]
    else:
        frequency[i][ord(alphabet)-97] += 1
    i += 1

for i in range(n):
    a, b, c = input().split()
    ans = frequency[int(c)][ord(a)-97] - frequency[int(b)-1][ord(a)-97] if int(b) > 0 else frequency[int(c)][ord(a)-97]
    print(ans)
