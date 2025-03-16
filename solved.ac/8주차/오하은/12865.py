import sys

inputf = sys.stdin.readline

N,K = map(int,inputf().split())
arr =[]
for _ in range(N):
    arr.append(list(map(int,inputf().split())))

dp = [0]*(K+1)
for w,v in arr:
    if w > K:
        continue
    for i in range(K,w-1,-1):
        dp[i] = max(dp[i],dp[i-w]+v)

print(max(dp))