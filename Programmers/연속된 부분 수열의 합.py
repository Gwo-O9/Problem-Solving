def solution(sequence, k):
    i = 0
    j = 0
    n = len(sequence)
    sum = sequence[i]
    ans = [10000000, 100000000, 100000000]
    while i < n and j < n:
        if sum < k:
            j += 1
            if j == n: break
            sum += sequence[j]
        else:
            if sum == k and ans[2] > j-i:
                ans = [i, j, j-i]
            sum -= sequence[i]
            i += 1
    return [ans[0], ans[1]]
            
            
