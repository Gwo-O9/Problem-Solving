def solution(clothes):
    clothes_dict = {}
    clothes_list = []
    for c in clothes:
        clothes_dict[c[1]] = 0
        
    for c in clothes:
        clothes_dict[c[1]] += 1
    
    for c in clothes_dict:
        clothes_list.append(clothes_dict[c])
    
    sum = 1
    for i in clothes_list:
        sum *= (i+1)
        
    return sum-1
