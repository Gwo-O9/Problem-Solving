def solution(bandage, health, attacks):
    # bandage: 기술의 시전 시간, 1초당 회복량, 추가 회복량
    # health: 최대 체력
    # attacks: 몬스터의 공격 시간과 피해량을 담은 2차원 정수 배열
    current_health = health
    time = 0
    success = 0
    last_attack_time = attacks[len(attacks)-1][0]
    while(True):
        time += 1
        success += 1
        attack_ok = False
        for attack in attacks:
            if attack[0] == time:
                current_health -= attack[1]
                attack_ok = True
                success = 0
        if time == last_attack_time or current_health < 1:
            break
        if attack_ok == False:
            if success >= bandage[0]:
                current_health = min(health, current_health + bandage[1] + bandage[2])
                success = 0
            else:
                current_health = min(health, current_health + bandage[1])
        print(current_health)
        
    answer = current_health if current_health > 0 else -1
    return answer
