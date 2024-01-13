from collections import deque

def solution(priorities, location):
    processes = deque()
    for i in range(len(priorities)):
        processes.append((priorities[i], i))
    count = 0
    while True:
        process, pri_of_process = processes.popleft()
        is_executed = True
        for p in processes:
            if p[0] > process:
                is_executed = False
                processes.append((process,pri_of_process))
                break
        if is_executed and pri_of_process == location:
            return count + 1
        elif is_executed:
            count +=1
                
    return count
