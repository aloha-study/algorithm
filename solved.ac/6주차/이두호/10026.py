import sys
from  collections import deque

n = int(sys.stdin.readline().rstrip())
maps = []
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
rg = ['R', 'G']

for _ in range(n):
    maps.append(list(sys.stdin.readline().rstrip()))


def bfs(x, y, num, number, visited, is_blind):
    queue = deque([(x, y)])
    number[x][y] = num

    while queue:
        cx, cy = queue.popleft()

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            if not (0 <= nx < n and 0 <= ny < n):
                continue

            if visited[nx][ny]:
                continue

            if is_blind:
                if maps[cx][cy] == maps[nx][ny] == 'B':
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    number[nx][ny] = num

                if maps[cx][cy] in rg and maps[nx][ny] in rg:    
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    number[nx][ny] = num
            else:
                if maps[cx][cy] == maps[nx][ny]:
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    number[nx][ny] = num


def test(is_blind):
    num = 1
    visited = [[False] * n for _ in range(n)]
    number = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                bfs(i, j, num, number, visited, is_blind)
                num += 1

    return max(sum(number, []))


print(test(False), test(True))
