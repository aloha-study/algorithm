import sys

inputf = sys.stdin.readline

K, N = map(int, inputf().split())
arr = []
for _ in range(K):
    arr.append(int(inputf()))

s = 1
e = max(arr)
ans = 0
while s <= e:
    mid = (s + e)//2
    cnt = 0
    for a in arr:
        cnt += a//mid
    if cnt>=N:
        ans = mid 
        s = mid+1
    else:
        e = mid-1 

print(ans)