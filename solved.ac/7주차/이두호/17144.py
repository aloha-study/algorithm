"""
항상 1번열에 설치
크기: 두 행

[1초 동안 진행되는 일]
- 미세먼지 학산
  네 방향으로 확산
  공기청정기가 있거나, 칸이 없으면 확산 X
  확산되는 양: A(r, c)/5
  (r, c)에 남은 미세먼지의 양 A(r, c) - [A(r, c) / 5] * 확산된 방향의 개수

- 공기청정기 작동
  [위쪽]         [아래쪽]
   ㄴ 반시계방향    ㄴ 시계방향
  미세먼지가 바람의 방향대로 한 칸씩 이동
  공기청정기로 들어간 미세먼지는 모두 정화
"""
import sys
from copy import deepcopy

r, c, t = map(int, sys.stdin.readline().rstrip().split())

origin_rooms = []

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

top = 0
bottom = 0


for i in range(r):
    values = list(map(int, sys.stdin.readline().rstrip().split()))
    # 공기청정기 위치
    if -1 in values:
        if top:
            bottom = i
        else:
            top = i

    origin_rooms.append(values)


def adjustment_dust_position():
    position = [[False] * c for _ in range(r)]

    for x in range(r):
        for y in range(c):
            if origin_rooms[x][y] > 0:
                position[x][y] = True

    return position


def diffuse(x, y):
    dust = origin_rooms[x][y] // 5

    # 미세먼지가 충분하지 않으면 패스
    if dust < 1:
        return
    
    # 미세먼지는 상하좌우로 퍼짐
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        # 범위를 벗어나는 경우 패스
        if not (0 <= nx < r and 0 <= ny < c):
            continue

        # 공기청정기인 경우 패스
        if origin_rooms[nx][ny] == -1:
            continue

        # 기존 미세먼지 위치가 아닌 경우 패스
        if not visited[x][y]:
            continue
        
        # 미세먼지 확산
        diffusion_rooms[nx][ny] += dust
        diffusion_rooms[x][y] -= dust


def move_air_up():
    # 우, 상, 좌, 하
    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]

    # 공기청정기 다음에 위치한 먼지
    cx, cy = top, 1
    current, direct = 0, 0
    
    while True:
        nx = cx + dx[direct]
        ny = cy + dy[direct]

        # 공기청정기인 경우 패스
        if cx == top and cy == 0:
            break

        # 범위를 벗어난 경우 방향 변경
        if not (0 <= nx < r and 0 <= ny < c):
            direct += 1
            continue

        # 먼지 이동
        diffusion_rooms[cx][cy], current = current, diffusion_rooms[cx][cy]
        cx, cy = nx, ny


def move_air_down():
    # 우, 하, 좌, 상
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    # 공기청정기 다음에 위치한 먼지
    cx, cy = bottom, 1
    current, direct = 0, 0
    
    while True:
        nx = cx + dx[direct]
        ny = cy + dy[direct]

        # 공기청정기인 경우 패스
        if cx == bottom and cy == 0:
            break

        # 범위를 벗어난 경우 방향 변경
        if not (0 <= nx < r and 0 <= ny < c):
            direct += 1
            continue

        # 먼지 이동
        diffusion_rooms[cx][cy], current = current, diffusion_rooms[cx][cy]
        cx, cy = nx, ny


for _ in range(t):
    diffusion_rooms = deepcopy(origin_rooms)
    visited = adjustment_dust_position()

    for x in range(r):
        for y in range(c):
            diffuse(x, y)
    move_air_up()
    move_air_down()

    origin_rooms = diffusion_rooms

sum = 0

for i in range(r):
    for j in range(c):
        if origin_rooms[i][j] > 0:
            sum += origin_rooms[i][j]

print(sum)
