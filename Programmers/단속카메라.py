def solution(routes):
    routes.sort(key= lambda x: x[1])
    cameras = []
    for r in routes:
        s = r[0]
        e = r[1]
        detected = False
        for c in cameras:
            if s <= c <= e:
                detected = True
        if not detected:
            cameras.append(e)
        
    return len(cameras)
