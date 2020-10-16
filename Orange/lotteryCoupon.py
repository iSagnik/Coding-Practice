from collections import Counter

def lotteryCoupons(n):
    c = Counter()
    coupons = []
    for i in range(1, n+1):
        coupons.append(i)
    
    for i in coupons:
        l = "".join(str(i))
        ll = sum(list((map(int, l.split(" ")))))
        c[ll] += 1
    maxv = max(c.values())
    
    count = 0
    for i in c:
        if c[i] == maxv:
            count += 1
    return count