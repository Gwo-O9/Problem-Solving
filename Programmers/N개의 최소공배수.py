def solution(arr):
    now = arr[-1]
    while True:
        is_end = True
        for a in arr:
            if now % a != 0:
                is_end = False
        if is_end:
            return now
        else:
            now += arr[-1]
