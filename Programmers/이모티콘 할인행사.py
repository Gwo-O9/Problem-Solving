discounts = [10, 20, 30, 40]

def solution(users, emoticons):
    discounts_set = [] 
    dfs(discounts_set, [], len(emoticons))
    answer = [0, 0]
    for discount in discounts_set:
        plus_user = 0
        total_earning = 0
        for user in users:
            prices = 0
            for i in range(len(discount)):
                if user[0] <= discount[i]:
                    prices += emoticons[i] * ((100-discount[i])/100)
            if prices >= user[1]:
                plus_user += 1
            else:
                total_earning += prices
        if plus_user > answer[0]:
            answer[0], answer[1] = plus_user, total_earning
        elif plus_user == answer[0]:
            answer[1] = max(total_earning, answer[1])
    return answer
            

def dfs(discounts_set, dis_list, n):
    if n == len(dis_list):
        discounts_set.append(dis_list[:])
        return
    else:
        for i in discounts:
            dis_list.append(i)
            dfs(discounts_set, dis_list, n)
            dis_list.pop()
        
    
