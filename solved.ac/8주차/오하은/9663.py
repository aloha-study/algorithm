import sys

inputf = sys.stdin.readline

N = int(inputf())
ans = 0
board = [[0 for _ in range(N)] for _ in range(N)]
movable_c = [False]*N
movable_pos = [False]*(2*(N-1)+1)
movable_neg = [False]*(2*(N-1)+1)

def dfs(y):
    global ans
    if y == N:
        ans +=1
        return
    
    for x in range(N):
        if not movable_c[x] and not movable_pos[x + y] and not movable_neg[(N-1) + y - x]:
            movable_c[x] = True
            movable_pos[x + y] = True
            movable_neg[(N-1) + y - x] = True
            dfs(y+1)
            movable_c[x] = False
            movable_pos[x + y] = False
            movable_neg[(N-1) + y - x] = False

dfs(0)
print(ans)