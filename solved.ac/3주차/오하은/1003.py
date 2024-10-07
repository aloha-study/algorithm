import sys

inputf= sys.stdin.readline

T = int(inputf())
arr = [int(inputf()) for _ in range(T)]
ans =[(1,0),(0,1)]

# 40까지 누적해서 구하기
for i in range(2,41):
    ans.append((ans[i-1][0]+ans[i-2][0],ans[i-1][1]+ans[i-2][1]))

for n in arr:
    print(*ans[n])