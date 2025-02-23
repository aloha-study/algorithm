import sys

inputf = sys.stdin.readline

N= int(inputf())
arr = []
for _ in range(N):
    arr.append(list(map(int,inputf().split())))
max_arr =[[0] * i  for i in range(1,N+1)]
max_arr[0][0] = arr[0][0]
# 가장자리 먼저 구함
for i in range(N-1):
    max_arr[i+1][0] = max_arr[i][0]+arr[i+1][0]
    max_arr[i+1][-1] = max_arr[i][-1]+arr[i+1][-1]
# 가운데 dp
for i in range(2,N):
    for j in range(1,i):
        max_arr[i][j] = max(max_arr[i-1][j-1],max_arr[i-1][j]) + arr[i][j]

print(max(max_arr[N-1]))