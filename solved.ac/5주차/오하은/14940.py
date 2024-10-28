import sys
inputf = sys.stdin.readline
from collections import deque

n,m = map(int,inputf().split())
arr = []
l = ()
for i in range(n):
    row = list(map(int,inputf().split()))
    arr.append(row)
    if not l and 2 in row:
        l = (row.index(2),i)

visited = [[0 for _ in range(m)] for _ in range(n)]
answer = [[0 for _ in range(m)] for _ in range(n)]
d =[(1,0),(-1,0),(0,1),(0,-1)]
def bfs(l):
    tx,ty = l
    q=deque([(tx,ty,0)])
    visited[ty][tx] = 1
    while q:
        x,y,cnt = q.popleft()
        for dx,dy in d:
            nx,ny = x+dx,y+dy
            if 0<=nx<m and 0<=ny<n and not visited[ny][nx]:
                visited[ny][nx] = 1
                if arr[ny][nx]==1:
                    answer[ny][nx] = max(answer[ny][nx],cnt+1)
                    q.append((nx,ny,cnt+1))

bfs(l)

for i in range(n):
    for j in range(m):
        if not visited[i][j] and arr[i][j] == 1:
            answer[i][j] = -1
    print(*answer[i])