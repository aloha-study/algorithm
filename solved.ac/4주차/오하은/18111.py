import sys
from collections import Counter
inputf = sys.stdin.readline

N,M,B = map(int,inputf().split())
arr = []
for _ in range(N):
    arr.extend(list(map(int,inputf().split())))
dic = dict(Counter(arr))

ans = []
for k in range(min(arr),max(arr)+1):
    cnt = 0
    b = B
    for ck,cv in dic.items():
        if ck < k :
            m = (k-ck)*cv
            cnt+=m
            b-=m
        elif ck > k:
            m = (ck-k)*cv*2
            cnt+=m
            b+=(ck-k)*cv
    if b >= 0:
        ans.append((cnt,k))

ans.sort(key=lambda x: (x[0],-x[1]))
print(*ans[0])