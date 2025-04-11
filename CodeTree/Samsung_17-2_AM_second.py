N, L = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]
cnt = 0

def can_pass(line):
    global N
    installed = [False for _ in range(N)]
    for i in range(N-1):
        if line[i] == line[i+1]:
            continue
        elif line[i] + 1 == line[i+1]: # 오르막길 -> 왔던 길에 경사 설치해야 함
            for j in range(i, i-L, -1):
                if j < 0 or line[j] != line[i] or installed[j] is True:
                    return False
                installed[j] = True
        elif line[i] - 1 == line[i+1]: # 내리막길 -> 앞으로 갈 길에 경사 설치해야 함
            for j in range(i+1, i+L+1, 1):
                if j >= N or line[j] != line[i+1] or installed[j] is True:
                    return False
                installed[j] = True
        else:
            return False
    return True

for i in range(N):
    if can_pass(graph[i]):
        cnt +=1
    if can_pass([graph[j][i] for j in range(N)]):
        cnt +=1
print(cnt)