from functools import cmp_to_key

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=cmp_to_key(compare), reverse=True)
    answer = "".join(numbers)
    return answer if int(answer) > 0 else "0"

def compare(s1, s2):
    if s1 + s2 < s2 + s1:
        return -1
    elif s1 + s2 > s2 + s1:
        return 1
    else:
        return 0
