"""
[문제]
M, N 의 킉가 주어지고 K개의 직사각형의 좌표가 주어질 때 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지 / 영역의 넓이가 얼마인지  구하시오

[문제 유형]
DP

[문제풀이]
1. 영역을 갈 수 없는 칸으로 변경
2. 모든 영역을 이동하며 DFS 진행
3. 각 영역의 넓이를 구하여 오름차순으로 정렬

[예시]
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
"""
import sys
from collections import Counter

sys.setrecursionlimit(130000)

m, n, k = map(int, sys.stdin.readline().rstrip().split())
maps = [[0] * n for _ in range(m)]
visitied = [[0] * n for _ in range(m)]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

for _ in range(k):
    y1, x1, y2, x2 = map(int, sys.stdin.readline().rstrip().split())

    for y in range(y1, y2):
        for x in range(x1, x2):
            maps[x][y] = 1


def dfs(x, y, number):
    visitied[x][y] = number

    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y

        if not (0 <= nx < m and 0 <= ny < n):
            continue

        if not visitied[nx][ny] and not maps[nx][ny]:
            dfs(nx, ny, number)


number = 0

for x in range(m):
    for y in range(n):
        if not maps[x][y] and not visitied[x][y]:
            number += 1
            dfs(x, y, number)

count = Counter([col for row in visitied for col in row])
result = sorted(count.items(), key=lambda x: x[1])

print(number)

for k, v in result:
    if k:
        print(v, end=" ")
print()
