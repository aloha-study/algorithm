"""
주사위: 1~6
크기: 10x10

1~100까지 적혀있음.
플레이어: i칸

조건
- 주사위 굴린 숫자만큼 이동 (ex. 주사위가 4인 경우, i + 4칸으로 이동)
- 100칸이 넘어가면 이동 불가
- 도착한 칸이 사다리면 사다리를 타고 위로 이동
- 뱀이 있는 칸에 도착하면 뱀을 따라서 아래로 이동

사다리의 수: N (X번 칸인 경우 -> Y번 칸으로 이동)
뱀의 수: M (U번 칸인 경우 -> V번 칸으로 이동)

1: 0 / 2: 1 / 3: 1 / 4: 1 / 5: 1 / 6: 1
7: 2 / 8: 2 / 9: 2

(0, 0) (1, 1) .. (1, 9)
(1, 0) (1, 1) .. (1, 9)
(2, 0) (2, 1) .. (2, 9)
     0   1   2   3   4   5   6   7   8   9
===========================================
0: [ 1,  2,  3,  4,  5,  6,  7,  8,  9, 10]
1: [11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
2: [21, 22, 23, 24, 25, 26, 27, 28, 29, 30]
3: [31, 32, 33, 34, 35, 36, 37, 38, 39, 40]
4: [41, 42, 43, 44, 45, 46, 47, 48, 49, 50]
5: [51, 52, 53, 54, 55, 56, 57, 58, 59, 60]
6: [61, 62, 63, 64, 65, 66, 67, 68, 69, 70]
7: [71, 72, 73, 74, 75, 76, 77, 78, 79, 80]
8: [81, 82, 83, 84, 85, 86, 87, 88, 89, 90]
9: [91, 92, 93, 94, 95, 96, 97, 98, 99, 100]

32 -> 62


DFS를 구현한다.
1. 주사위를 굴려 이동한다.
2. 사다리에 연결된 경우 이동한다.
3. 뱀에 연결된 경우 이동한다.
4. 현재 횟수 vs 새로운 횟수 비교하여 새로운 횟수가 더 적으면 이동

[반례]
1 1
5 88
94 90

1 5
2 92
94 3
95 4
96 5
97 6
98 7
4
"""
import sys
from collections import deque

INF = int(1e9)
SIZE = 10

n, m = map(int, sys.stdin.readline().rstrip().split())
maps = [[0] * SIZE for _ in range(SIZE)]
counts = [[INF] * SIZE for _ in range(SIZE)]
visited = [[False] * SIZE for _ in range(SIZE)]

num = 0
for i in range(SIZE):
    for j in range(SIZE):
        maps[i][j] = num
        num += 1

ladders = {}
snakes = {}

for _ in range(n):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    ladders[x - 1] = y - 1

for _ in range(m):
    u, v = map(int, sys.stdin.readline().rstrip().split())
    snakes[u - 1] = v - 1


queue = deque([(0, 0)])
number = 0
counts[0][0] = 0

while queue:
    x, y = queue.popleft()
    visited[x][y] = True

    for i in range(1, 7):
        next = maps[x][y] + i
        nx, ny = next // SIZE, next % SIZE

        if not (next < SIZE * SIZE):
            continue

        if visited[nx][ny]:
            continue

        # counts[nx][ny] = min(counts[nx][ny], counts[x][y] + 1)
        # visited[nx][ny] = True

        # if maps[nx][ny] in snakes.keys():
        #     next_value = snakes[maps[nx][ny]]
        #     snx, sny = next_value // SIZE, next_value % SIZE
        #     counts[snx][sny] = min(counts[snx][sny], counts[nx][ny])
        #     queue.append((snx, sny))
        #     visited[snx][sny] = True

        # if maps[nx][ny] in ladders.keys():
        #     next_value = ladders[maps[nx][ny]]
        #     lnx, lny = next_value // SIZE, next_value % SIZE
        #     counts[lnx][lny] = min(counts[lnx][lny], counts[nx][ny])
        #     visited[lnx][lny] = True
        #     queue.append((lnx, lny))

        # queue.append((nx, ny))


print(counts[SIZE - 1][SIZE - 1])
# print(*counts, sep="\n")
