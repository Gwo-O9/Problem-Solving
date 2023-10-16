# 치킨 집 M 개만 남았을 때 치킨 거리의 최소 값
# 치킨 집 M 개를 제외한 모두 삭제한 후 모든 경우의 수 계산 후 최소 값 구하기
def calculate_distance(x, y, nx, ny):
    dx = nx-x
    dy = ny-y
    distance = abs(dx) + abs(dy)
    return distance

def pick_stores_as_combination(arr, m):
    result = []

    if m > len(arr):
        return result

    if m == 1:
        for i in arr:
            result.append([i])

    elif m > 1:
        for i in range(len(arr) - m + 1):
            for j in pick_stores_as_combination(arr[i+1:], m-1):
                result.append([arr[i]] + j)
    return result

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
houses = []
stores = []
result = 1000000000

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            houses.append([i, j])
        elif graph[i][j] == 2:
            stores.append([i, j])

for store in pick_stores_as_combination(stores, m):
    total_chicken_distance = 0
    for house in houses:
        chicken_distance = 1000000000
        for i in range(m):
            chicken_distance = min(chicken_distance, calculate_distance(house[0],house[1],store[i][0],store[i][1]))
        total_chicken_distance += chicken_distance
    result = min(result, total_chicken_distance)

print(result)
