import sys
inputf = sys.stdin.readline
from collections import defaultdict

N,M = map(int,inputf().split())
dic = defaultdict(int)
ans = []
for _ in range(N):
    dic[inputf().rstrip()] = 1
for _ in range(M):
    name = inputf().rstrip()
    if dic[name] == 1:
        ans.append(name)

ans.sort()
print(len(ans))
for a in ans:
    print(a)