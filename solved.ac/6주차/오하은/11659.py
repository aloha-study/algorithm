import sys

inputf = sys.stdin.readline

N,M=map(int,inputf().split())
arr = list(map(int,inputf().split()))

sum_arr = [0]
total = 0
for i in range(N):
    total += arr[i]
    sum_arr.append(total)

for _ in range(M):
    i,j = map(int,inputf().split())
    print(sum_arr[j]-sum_arr[i-1])