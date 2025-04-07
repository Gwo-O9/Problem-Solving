dices = list(map(int, input().split()))
base_root = [-1, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0]
ten_root = [-1, 13, 16, 19, 25, 30, 35, 40, 0]
twenty_root = [-1, 22, 24, 25, 30, 35, 40, 0]
thirty_root = [-1, 28, 27, 26, 25, 30, 35, 40, 0]

ans = 0

def simulation(indexes, dice_idx, score):
    global ans
    if dice_idx == 10:
        ans = max(ans, score)
        return

    for i, (index, root) in enumerate(indexes):
        if root is None:
            continue  # 이미 도착한 말은 움직일 수 없음
        current_value = root[index]

        if root is base_root and current_value in [10, 20, 30]:
            if current_value == 10:
                next_root = ten_root
            elif current_value == 20:
                next_root = twenty_root
            elif current_value == 30:
                next_root = thirty_root
            next_index = dices[dice_idx]
        else:
            next_root = root
            next_index = min(len(next_root)-1, index + dices[dice_idx])

        next_value = next_root[next_index]

        if next_value == 0:
            indexes[i] = (None, None)
            simulation(indexes, dice_idx + 1, score)
            indexes[i] = (index, root)
            continue

        collision = False
        for j, (tmp_index, tmp_root) in enumerate(indexes):
            if i == j or tmp_root is None:
                continue
            if next_value == tmp_root[tmp_index]:
                if next_value in [16, 22, 24, 26, 28, 30]:
                    if (tmp_root is base_root and next_root is base_root) or (
                            tmp_root is not base_root and next_root is not base_root):
                        collision = True
                else:
                    collision = True
        if collision:
            continue

        indexes[i] = (next_index, next_root)
        simulation(indexes, dice_idx + 1, score + next_value)
        indexes[i] = (index, root)


simulation([(0, base_root), (0, base_root), (0, base_root), (0, base_root)], 0, 0)
print(ans)