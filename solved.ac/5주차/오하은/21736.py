import sys
inputf = sys.stdin.readline
from collections import deque
N,M = map(int,inputf().split())
arr=[]
l = () # 도연이 위치 (x,y)
for i in range(N):
    row = list(inputf().rstrip())
    arr.append(row)
    if not l and "I" in row:
        l = (row.index("I"),i)

visited=[[0 for _ in range(M)] for _ in range(N)]
d =[(1,0),(-1,0),(0,1),(0,-1)]
def bfs(l):
    q =deque([l])
    visited[l[1]][l[0]] = 1
    cnt = 0
    while q:
        x, y = q.popleft()
        if arr[y][x] == "P":
            cnt += 1
        for dx, dy in d:
            nx, ny = x + dx, y + dy
            if 0 <= nx < M and 0 <= ny < N and not visited[ny][nx] and arr[ny][nx] != "X":
                visited[ny][nx] = 1 
                q.append((nx, ny))

    return cnt if cnt > 0 else "TT"

print(bfs(l))