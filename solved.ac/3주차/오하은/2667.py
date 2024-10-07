import sys

inputf = sys.stdin.readline

N = int(inputf())
visited = [[0 for _ in range(N)] for _ in range(N)]
arr = [list(inputf().rstrip()) for _ in range(N)]

def bfs(x,y):
    q = [(x,y)]
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    visited[y][x] = 1
    cnt = 0
    while q:
        x,y=q.pop(0)
        cnt +=1
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0<=nx<N and 0<=ny<N:
                if not visited[ny][nx] and arr[ny][nx] == '1':
                    q.append((nx,ny))
                    visited[ny][nx] = 1
    return cnt

ans = []
for i in range(N):
    for j in range(N):
        if not visited[j][i] and arr[j][i] =='1':
            ans.append(bfs(i,j))
ans.sort()
print(len(ans))
for a in ans:
    print(a)