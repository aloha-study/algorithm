# https://www.acmicpc.net/problem/2667
"""
[문제]
1은 집이 있는 곳 / 0은 집이 없는 곳
단지내 집의 수와 총 단지수 출력

[문제 유형]
그래프

[풀이 과정]
1) 모든 맵을 순회합니다.
2) 집이 있고, 방문하지 않은 곳만 탐색을 진행합니다.
3) 한 차례 탐색이 지나면, 숫자의 값을 1 올립니다.
4) 모든 집을 순회했다면, 총 단지수와 각 단지내의 집의 수를 오름차순으로 정렬하여 출력합니다.

[예시]
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
==
3
7
8
9
"""
import sys
from collections import Counter

n = int(sys.stdin.readline().rstrip())
houses = []
visited = [[0] * n for _ in range(n)]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

for _ in range(n):
    house = list(map(int, sys.stdin.readline().rstrip()))
    houses.append(house)


def dfs(x, y, number):
    visited[x][y] = number

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if not (0 <= nx < n and 0 <= ny < n):
            continue

        if not visited[nx][ny] and houses[nx][ny]:
            dfs(nx, ny, number)


number = 0

for i in range(n):
    for j in range(n):
        if not visited[i][j] and houses[i][j]:
            number += 1
            dfs(i, j, number)

count = Counter([col for row in visited for col in row])
result = sorted(count.items(), key=lambda x: x[1])

print(number)
for k, v in result:
    if k != 0:
        print(v, end="\n")
