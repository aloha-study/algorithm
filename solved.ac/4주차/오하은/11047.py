import sys
inputf = sys.stdin.readline

N,K = map(int,inputf().split())
p = []
ans = 0
for _ in range(N):
    p.append(int(inputf()))

for i in range(N-1,-1,-1):
    if K >= p[i]:
        n = K//p[i]
        K -= n*p[i]
        ans += n
print(ans)