from collections import defaultdict

N, M, K = map(int, input().split())
directions = [[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]]
atoms = [list(map(int, input().split())) for _ in range(M)]
# 0-base로 위치 조정
for atom in atoms:
    atom[0] -= 1
    atom[1] -= 1


def move_and_merge():
    atom_dict = defaultdict(list)
    new_atoms = []
    for atom in atoms:
        x, y, m, s, d = atom
        nx, ny = (x + directions[d][0] * s) % N, (y + directions[d][1] * s) % N
        atom_dict[(nx, ny)].append((m, s, d))

    for (x, y), ad in atom_dict.items():
        sum_m = 0
        sum_s = 0
        all_straight = True
        all_cross = True
        if len(ad) == 1:
            new_atoms.append((x, y, ad[0][0], ad[0][1], ad[0][2]))
        else:
            for a in ad:
                sum_m += a[0]
                sum_s += a[1]
                if a[2] % 2 == 0:
                    all_cross = False
                else:
                    all_straight = False
            if all_cross or all_straight:
                nd = 0
            else:
                nd = 1
            if sum_m // 5 > 0:
                for _ in range(4):
                    new_atoms.append((x, y, sum_m // 5, sum_s // len(ad), nd))
                    nd += 2
    return new_atoms

for _ in range(K):
    atoms = move_and_merge()

total = sum(m for _, _, m, _, _ in atoms)
print(total)
