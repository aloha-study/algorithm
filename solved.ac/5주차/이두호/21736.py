import sys
from collections import deque

n, m = map(int, sys.stdin.readline().rstrip().split())
maps = []
visited = [[False] * m for _ in range(n)]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

for _ in range(n):
    maps.append(list(sys.stdin.readline().rstrip()))

queue = deque([])

for i in range(n):
    for j in range(m):
        if maps[i][j] == 'I':
            queue.append((i, j))
            break

number = 0

while queue:
    x, y = queue.popleft()

    if maps[x][y] == 'P':
        number += 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if not (0 <= nx < n and 0 <= ny < m):
            continue

        if visited[nx][ny] or maps[nx][ny] == 'X':
            continue

        visited[nx][ny] = True
        queue.append((nx, ny))

print(number if number else 'TT')
