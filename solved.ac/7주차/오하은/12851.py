import sys
from collections import deque
inputf = sys.stdin.readline

N,K = map(int,inputf().split())
dp = [float('inf') for _ in range(100001)]
q = deque([N])
dp[N] = 0 # 걸린 최소 시간 dp 배열로 저장
ans = 0 # 방문 횟수
while q:
    m = q.popleft()
    if m == K:
        ans += 1 
    for n in [m+1, m-1, m*2]:
        if 0<=n<=100000:            
            if dp[n] > dp[m] :
                q.append(n)
                dp[n] = dp[m]+1
print(dp[K])            
print(ans)