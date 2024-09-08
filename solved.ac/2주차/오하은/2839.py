import sys

inputf = sys.stdin.readline
N=int(inputf())
ans = []
for i in range(N//5 + 1):
    for j in range(N//3 + 1):
        if N == 5*i + 3*j:
            ans.append(i+j)
if ans:
    print(min(ans))
else:
    print(-1)