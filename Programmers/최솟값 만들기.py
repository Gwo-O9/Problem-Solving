def solution(A,B):
    A.sort()
    B.sort()
    s1 = 0
    s2 = 0
    n = len(A)-1
    for i in range(len(A)):
        s1 += A[i]*B[n-i]
        s2 += B[i]*A[n-i]
    return min(s1, s2)
