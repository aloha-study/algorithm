import sys
from collections import deque

inputf=sys.stdin.readline

N = int(inputf())
M = int(inputf())
arr = [[] for _ in range(N+1)]
visited = [0 for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,inputf().split())
    arr[a].append(b)
    arr[b].append(a)

def bfs(n):
    cnt = 0
    q=deque([n])
    while q:
        i = q.popleft()
        if not visited[i]:
            cnt += 1
            visited[i] = 1
            for x in arr[i]:
                q.append(x)
    print(cnt-1)

bfs(1)