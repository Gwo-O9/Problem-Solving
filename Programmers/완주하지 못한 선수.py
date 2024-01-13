def solution(participant, completion):
    for p in participant:
        if p not in completion:
            return p
        else:
            completion.remove(p)
