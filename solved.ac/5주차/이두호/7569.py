"""
[
  [
    [0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0]
  ],
  [
    [1, 0, 0, 0, 0],
    [0, 0, 1, 0, 0],
    [0, 0, 0, 0, 1]
  ]
]
"""
import sys
from collections import deque

m, n, h = map(int, sys.stdin.readline().rstrip().split())
boxes = [[] for _ in range(h)]
tomatos = deque([])

dz = [0, 0, 0, 0, -1, 1]
dy = [-1, 1, 0, 0, 0, 0]
dx = [0, 0, -1, 1, 0, 0]

for z in range(h):
    for _ in range(n):
        boxes[z].append(list(map(int, sys.stdin.readline().rstrip().split())))

for z in range(h):
    for y in range(n):
        for x in range(m):
            if boxes[z][y][x] == 1:
                tomatos.append((z, y, x))


while tomatos:
    cz, cy, cx = tomatos.popleft()

    for i in range(6):
        nz = cz + dz[i]
        ny = cy + dy[i]
        nx = cx + dx[i]

        if not (0 <= nz < h and 0 <= ny < n and 0 <= nx < m):
            continue

        if boxes[nz][ny][nx] == 0:
            boxes[nz][ny][nx] = boxes[cz][cy][cx] + 1
            tomatos.append((nz, ny, nx))


result = 0
unrlpe = False

for z in range(h):
    for y in range(n):
        for x in range(m):
            result = max(result, boxes[z][y][x] - 1)
            if boxes[z][y][x] == 0:
                unrlpe =  True

print(-1 if unrlpe else result)
