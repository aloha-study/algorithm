import sys
inputf= sys.stdin.readline

N=int(inputf())
arr=list(map(int,inputf().split()))

arr.sort()
ans = 0
for i in range(1,N+1):
    ans += sum(arr[:i])

print(ans)