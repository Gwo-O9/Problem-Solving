def merge(A, p, q, r, tmp):
    i, j, t = p, q+1, p
    while i <= q and j <= r:
        if A[i] <= A[j]:
            tmp[t] = A[i]
            i += 1
        else:
            tmp[t] = A[j]
            j += 1
        if find_answer(k):
            print(tmp[t])
        t += 1
    while i <= q:
        tmp[t] = A[i]
        if find_answer(k):
            print(tmp[t])
        i += 1
        t += 1
    while j <= r:
        tmp[t] = A[j]
        if find_answer(k):
            print(tmp[t])
        j += 1
        t += 1
    for i in range(p, r+1):
        A[i] = tmp[i]

def merge_sort(A, p, q, tmp):
    if p < q:
        r = (p+q)//2
        merge_sort(A, p, r, tmp)
        merge_sort(A, r+1, q, tmp)
        merge(A, p, r, q, tmp)

def find_answer(k):
    global cnt
    cnt += 1
    return cnt == k

n, k = map(int, input().split())
A = list(map(int, input().split()))
cnt = 0
tmp = [0] * n
merge_sort(A, 0, len(A)-1, tmp)
if cnt < k:
    print(-1)
