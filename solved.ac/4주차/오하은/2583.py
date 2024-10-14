import sys
inputf = sys.stdin.readline

M,N,K = map(int,inputf().split())
arr = [[0 for _ in range(N)] for _ in range(M)]
for _ in range(K):
    sx,sy,ex,ey = map(int, inputf().split())
    for i in range(sx,ex):
        for j in range(sy,ey):
            arr[j][i] = 1

visited = [[0 for _ in range(N)] for _ in range(M)]
dx=[0,0,1,-1]
dy=[1,-1,0,0]
def bfs(x,y):
    cnt=0
    q = [(x,y)]
    while q:
        cx,cy=q.pop(0)
        if not visited[cy][cx]:
            cnt+=1
            visited[cy][cx]=1
            for i in range(4):
                nx,ny = cx+dx[i],cy+dy[i]
                if 0<=nx<N and 0<=ny<M:
                    if not visited[ny][nx] and arr[ny][nx]==0:
                        q.append((nx,ny))      
    return cnt

ans = []
for i in range(N):
    for j in range(M):
        if not visited[j][i] and arr[j][i]==0:
            ans.append(bfs(i,j))
ans.sort()
print(len(ans))
print(*ans)