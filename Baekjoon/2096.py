n = int(input())
arr = list(map(int, input().split()))
min_arr = arr
max_arr = arr

for _ in range(n-1):
    arr = list(map(int, input().split()))
    max_arr = [arr[0] + max(max_arr[0], max_arr[1]), arr[1] + max(max_arr[0], max_arr[1], max_arr[2]), arr[2] + max(max_arr[1], max_arr[2])]
    min_arr = [arr[0] + min(min_arr[0], min_arr[1]), arr[1] + min(min_arr[0], min_arr[1], min_arr[2]), arr[2] + min(min_arr[1], min_arr[2])]

print(max(max_arr), min(min_arr))

