n = int(input())

nums = list(map(int, input().split()))

cmds = list(map(int, input().split()))  # + - x /

max_value = -100000000000
min_value = 100000000000

def dfs(i, now):
    global max_value, min_value, nums, cmds
    if i == n:
        max_value = max(max_value, now)
        min_value = min(min_value, now)
    if cmds[0] > 0:
        cmds[0] -= 1
        dfs(i+1, now + nums[i])
        cmds[0] += 1
    if cmds[1] > 0:
        cmds[1] -= 1
        dfs(i+1, now - nums[i])
        cmds[1] += 1
    if cmds[2] > 0:
        cmds[2] -= 1
        dfs(i+1, now * nums[i])
        cmds[2] += 1
    if cmds[3] > 0:
        cmds[3] -= 1
        dfs(i+1, int(now / nums[i]))
        cmds[3] += 1

dfs(1, nums[0])
print(max_value)
print(min_value)
