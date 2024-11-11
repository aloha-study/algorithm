import sys
from collections import deque
input = sys.stdin.readline

M, N, H = map(int,input().split())

matrix =[[list(map(int,input().split())) for _ in range(N)] for _ in range(H)]
visited = [[[False]*M for _ in range(N)] for _ in range(H)]

dx= [-1,1,0,0,0,0]
dy= [0,0,-1,1,0,0]
dz= [0,0,0,0,-1,1]

q = deque()
cnt = 0

def bfs():
    while q:
        x,y,z = q.popleft()

        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]

            if nx < 0 or nx >= H or ny < 0 or ny >= N or nz < 0 or nz >= M: 
                continue

            if matrix[nx][ny][nz] == 0 and visited[nx][ny][nz] == False:
                matrix[nx][ny][nz] = matrix[x][y][z] + 1 
                q.append((nx,ny,nz))
                visited[nx][ny][nz] = True

# 익은 토마토 좌표 queue에 넣은 다음 bfs 실행
for a in range(H):
    for b in range(N):
        for c in range(M):
            if matrix[a][b][c] == 1 and visited[a][b][c] == False:
                q.append((a,b,c))
                visited[a][b][c] = True
bfs()

for box in matrix:
    for row in box:
        for num in row:
            if num == 0:
                print(-1)
                exit(0)
        cnt = max(cnt, max(row))

print(cnt - 1)