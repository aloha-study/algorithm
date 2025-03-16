import sys
from collections import deque

inputf = sys.stdin.readline

N, M = map(int, inputf().split())
arr = [inputf().rstrip() for _ in range(N)]

# visited[y][x][broken] -> broken이 False(0)일 때와 True(1)일 때를 구분
visited = [[[0, 0] for _ in range(M)] for _ in range(N)]
visited[0][0][0] = 1  # 시작점 방문 처리 (벽을 부수지 않은 상태)

move = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def bfs():
    q = deque([(0, 0, 0)])  # (x, y, broken) -> broken: 0 (벽 안 부숨), 1 (벽 부숨)
    
    while q:
        x, y, broken = q.popleft()
        
        # 도착 지점 확인 (x가 M-1, y가 N-1일 때)
        if x == M-1 and y == N-1:
            return visited[y][x][broken]

        for dx, dy in move:
            nx, ny = x + dx, y + dy

            if 0 <= nx < M and 0 <= ny < N:
                # 벽이 없고, 방문하지 않은 경우
                if arr[ny][nx] == "0" and visited[ny][nx][broken] == 0:
                    visited[ny][nx][broken] = visited[y][x][broken] + 1
                    q.append((nx, ny, broken))

                # 벽이 있지만, 아직 벽을 부순 적이 없는 경우
                elif arr[ny][nx] == "1" and broken == 0:
                    visited[ny][nx][1] = visited[y][x][broken] + 1
                    q.append((nx, ny, 1))
    return -1

print(bfs())