import sys
from itertools import combinations
from collections import deque
import copy

input = sys.stdin.readline
N, M = map(int, input().split())
Map = [list(map(int, input().split())) for _ in range(N)]

zero = [(i, j) for i in range(N) for j in range(M) if Map[i][j] == 0]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(arr):
    q = deque()
    visited = [[0] * M for _ in range(N)]
    
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 2:
                q.append((i, j))
                visited[i][j] = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 0 and not visited[nx][ny]:
                visited[nx][ny] = 1
                arr[nx][ny] = 2
                q.append((nx, ny))

ans = 0
for walls in combinations(zero, 3):
    newMap = copy.deepcopy(Map)
    for x, y in walls:
        newMap[x][y] = 1
    bfs(newMap)
    
    safe_count = sum(row.count(0) for row in newMap)
    ans = max(ans, safe_count)

print(ans)