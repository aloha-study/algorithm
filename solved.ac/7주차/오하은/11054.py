import sys

inputf = sys.stdin.readline
N = int(inputf())
arr = list(map(int,inputf().split()))
asc = [0 for _ in range(N)]
desc = [0 for _ in range(N)]
for i in range(1,N):
    for x in range(1,i+1):
        if arr[i-x] < arr[i]:
            asc[i] = max(asc[i],asc[i-x]+1)
for i in range(N-2,-1,-1):
    for x in range(1,N-i):
        if arr[i] > arr[i+x]:
            desc[i] = max(desc[i],desc[i+x]+1)

print(max([a+b for a,b in zip(asc,desc)])+1)