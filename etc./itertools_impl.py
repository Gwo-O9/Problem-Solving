output = []
output2 = []
def combinations(arr, n, included, start):
    global output
    if len(included) == n:
        output.append(included[:])
        return

    for i in range(start, len(arr)):
        included.append(arr[i])
        combinations(arr, n, included, i + 1)
        included.pop()

combinations([1,2,3], 2, [], 0)
print(output)

def permutations(arr, n, included):
    global output2
    if len(included) == n:
        output2.append(included[:])
        return

    for i in range(len(arr)):
        if arr[i] in included:
            continue
        included.append(arr[i])
        permutations(arr, n, included)
        included.pop()

permutations([1,2,3], 2, [])
print(output2)