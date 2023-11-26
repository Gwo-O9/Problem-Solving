def calculate(cmd, number):
    if cmd == "@":
        return number * 3
    if cmd == "%":
        return number + 5
    if cmd == "#":
        return number - 7
    return number


n = int(input())
for _ in range(n):
    cmds = list(map(str, input().split()))
    num = float(cmds[0])
    for cmd in cmds:
        num = calculate(cmd, num)
    print(format(num, ".2f"))
