"""
15 15
2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
"""
import sys
from collections import deque

n, m = map(int, sys.stdin.readline().rstrip().split())
maps = []
visited = [[False] * m for _ in range(n)]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

for _ in range(n):
    maps.append(list(map(int, sys.stdin.readline().rstrip().split())))
    
queue = deque([])

for i in range(n):
    for j in range(m):
        if maps[i][j] == 2:
            queue.append((i, j))
            maps[i][j] = 0
            visited[i][j] = True
            break

while queue:
    x, y = queue.popleft()

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if not (0 <= nx < n and 0 <= ny < m):
            continue
        
        if visited[nx][ny]:
            continue

        if not maps[nx][ny]:
            visited[nx][ny] = True
            continue


        visited[nx][ny] = True
        maps[nx][ny] = maps[x][y] + 1
        queue.append((nx, ny))


for i in range(n):
    for j in range(m):
        if visited[i][j]:
            print(maps[i][j], end=" ")
        elif maps[i][j]:
            print(-1, end=" ")
        else:
            print(maps[i][j], end=" ")
    print()
