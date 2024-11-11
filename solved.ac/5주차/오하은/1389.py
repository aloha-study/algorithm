import sys

inputf = sys.stdin.readline

N,M = map(int,inputf().split())
connect = [[] for _ in range(N+1)]

for _ in range(M):
    a,b = map(int,inputf().split())
    connect[a].append(b)
    connect[b].append(a)

def visit(i):
    visited = [0 for _ in range(N+1)]
    q = [i]
    visited[i] = 0
    while q:
        p = q.pop(0)
        for f in connect[p]:
            if not visited[f]:
                visited[f] = visited[p]+1
                q.append(f)
    return sum(visited)

ans = 0
k = float("inf")
for i in range(1,N+1):
    n = visit(i)
    if n < k:
        ans = i
        k = n
print(ans)