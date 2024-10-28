import sys

INF = int(1e9)

n, m = map(int, sys.stdin.readline().rstrip().split())
edges = [[INF] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    edges[x][y] = 1
    edges[y][x] = 1

for x in range(1, n + 1):
    for y in range(1, n + 1):
        if x == y:
            edges[x][y] = 0

for k in range(1, n + 1):
    for x in range(1, n + 1):
        for y in range(1, n + 1):
            edges[x][y] = min(edges[x][y], edges[x][k] + edges[k][y])

result = 0
kevin = INF * (n + 1)

for index, value in enumerate(edges):
    score = sum(value)

    if kevin > score:
        result = index
        kevin = score

print(result)
