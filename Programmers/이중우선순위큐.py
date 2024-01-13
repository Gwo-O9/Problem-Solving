def solution(operations):
    q = []
    for op in operations:
        if op[0] == "I":
            q.append(int(op[1:]))
        elif q:
            if len(op) == 3:
                q.remove(max(q))
            else:
                q.remove(min(q))
        print(q)
    return [max(q), min(q)] if q else [0,0]
