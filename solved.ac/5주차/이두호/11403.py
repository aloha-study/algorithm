import sys

INF = int(1e9)

n = int(sys.stdin.readline().rstrip())
graph = [[INF] * n for _ in range(n)]

for i in range(n):
    temp = list(map(int, sys.stdin.readline().rstrip().split()))
    for j in range(n):
        if temp[j]:
            graph[i][j] = temp[j]

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

result = [[0] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        if graph[i][j] < INF:
            result[i][j] = 1

for line in result:
    print(*line, sep=" ")
