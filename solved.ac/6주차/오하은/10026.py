import sys
inputf = sys.stdin.readline

N=int(inputf())
p = []
for _ in range(N):
    p.append(list(inputf()))

ans = [0,0]
dx=[0,0,1,-1]
dy=[1,-1,0,0]

b_visited=[[0 for _ in range(N)] for _ in range(N)]
def b_bfs(x,y):
    q=[(x,y)]
    current_color = p[y][x]
    ans[1]+=1
    while q:
        x,y = q.pop(0)
        for i in range(4):
            nx,ny = x + dx[i], y + dy[i]
            if 0<=nx<N and 0<=ny<N and not b_visited[ny][nx]:
                if current_color in ["R","G"] and p[ny][nx] in ["R","G"]:
                    b_visited[ny][nx] = 1
                    q.append((nx,ny))
                elif current_color == p[ny][nx]:
                    b_visited[ny][nx] = 1
                    q.append((nx,ny))


nb_visited=[[0 for _ in range(N)] for _ in range(N)]
def nb_bfs(x,y):
    q=[(x,y)]
    current_color = p[y][x]
    ans[0]+=1
    while q:
        x,y = q.pop(0)
        for i in range(4):
            nx,ny = x + dx[i], y + dy[i]
            if 0<=nx<N and 0<=ny<N and not nb_visited[ny][nx]:
                if current_color == p[ny][nx]:
                    nb_visited[ny][nx] = 1
                    q.append((nx,ny))


for x in range(N):
    for y in range(N):
        if not nb_visited[y][x]:
            nb_bfs(x,y)
        if not b_visited[y][x]:
            b_bfs(x,y)

print(*ans)