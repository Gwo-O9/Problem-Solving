import math

def solution(fees, records):
    default_time = int(fees[0])
    default_fee = int(fees[1])
    unit_time = int(fees[2])
    unit_fee = int(fees[3])
    answer = []
    here = []
    duration_list = [0]*10001
    for record in records:
        time, car_number, cmd = record.split(' ')
        if cmd == "OUT":
            continue
        duration = cal_duration(time, find_out_time(car_number, records, time))
        if car_number not in here:
            here.append(car_number)
        duration_list[int(car_number)] += duration
    here.sort()
    for h in here:
        fee = default_fee + max(math.ceil((duration_list[int(h)]-default_time)/unit_time)*unit_fee, 0)
        answer.append(fee)
            
    return answer

def find_out_time(car_number, records, time):
    for record in records:
        diff_time, diff_car_number, cmd = record.split(' ')
        if diff_car_number == car_number and cmd == "OUT":
            if car_number == "0000":
            if int(diff_time[0:2]) > int(time[0:2]) or (int(diff_time[0:2]) == int(time[0:2]) and int(diff_time[3:5]) > int(time[3:5])):
                return diff_time
    return "23:59"

def cal_duration(time1, time2):
    h1, m1 = int(time1[0:2]), int(time1[3:5])
    h2, m2 = int(time2[0:2]), int(time2[3:5])
    duration_hours = h2 - h1
    duration_minutes = m2 - m1
    if duration_minutes < 0:
        duration_hours -= 1
        duration_minutes += 60
    return duration_hours * 60 + duration_minutes
