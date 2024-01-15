candidates = []
def solution(citations):
    citations.sort(reverse=True)
    h_index = 0
    for i, c in enumerate(citations):
        if i < c:
            h_index += 1
        else:
            break
    return h_index
        
