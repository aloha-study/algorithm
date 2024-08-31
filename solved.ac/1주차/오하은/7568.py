import sys
input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
ans = []
for i in range(N):
    rank = 1 
    for j in range(N):
        if i != j:  
            if arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
                rank += 1
    ans.append(rank)
print(*ans)