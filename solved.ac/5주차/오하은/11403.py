import sys

inputf = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(inputf())
check = []
arr=[]
for y in range(N):
    row = list(map(int,inputf().split()))
    arr.append(row)
    for x,n in enumerate(row):
        if n == 1:
            check.append((y,x))


visited = [[0 for _ in range(N)] for _ in range(N)]
def dfs(s,e):
    visited[s][e] = 1
    for x,n in enumerate(arr[e]):
        if n == 1 and not visited[s][x]:
            dfs(s,x)
    
for s,e in check:
    if not visited[s][e]:
        dfs(s,e)

for row in visited:
    print(*row)

# 0 -> 1
# 1 -> 2
# 2 -> 0